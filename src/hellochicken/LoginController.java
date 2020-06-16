package hellochicken;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import hellochicken.ConnectionUtil;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	@FXML
	private Button btnl, btnm;
	@FXML
	private TextField txtid;
	@FXML
	private PasswordField paswF;
	@FXML
	private Label lblErrors;

	Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public LoginController() {
		con = ConnectionUtil.conDB();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (con == null) {
			lblErrors.setTextFill(Color.TOMATO);
			lblErrors.setText("다시 한번 확인 부탁드립니다.");
		} else {
			lblErrors.setTextFill(Color.GREEN);
			lblErrors.setText("아이디 & 패스워드 입력");
		}
	}

	public void handleBtnlAction(MouseEvent event) {

		if (event.getSource() == btnl) {
			if (logIn().equals("Success")) {
				try {
					Node node = (Node) event.getSource();
					Stage stage = (Stage) node.getScene().getWindow();
					stage.close();
					Scene scene = new Scene(FXMLLoader.load(getClass().getResource("menu.fxml")));
					stage.setScene(scene);
					stage.show();

				} catch (IOException ex) {
					System.err.println(ex.getMessage());
				}

			}
		}
	}

	public void handleButtonAction(MouseEvent e) {
		if (e.getSource() == btnm) {
			try {
				Node node = (Node) e.getSource();
				Stage stage = (Stage) node.getScene().getWindow();
				stage.close();
				Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Join.fxml")));
				stage.setScene(scene);
				stage.show();
			} catch (IOException ex) {
				System.err.println(ex.getMessage());
			}
 
		}
	}

	private String logIn() {
		String status = "Success";
		String id = txtid.getText();
		String password = paswF.getText();
		if (id.isEmpty() || password.isEmpty()) {
			setLblError(Color.TOMATO, "Empty credentials");
			status = "Error";
		} else {
			// query
			String sql = "SELECT * FROM join Where id = ? and password = ?";
			try {
				preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, id);
				preparedStatement.setString(2, password);
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					setLblError(Color.TOMATO, "회원가입을 클릭하세요.");
					status = "Error";
				} else {
					setLblError(Color.GREEN, "Login Successful..Redirecting..");
				}
			} catch (SQLException ex) {
				status = "Exception";
			}
		}

		return status;
	}

	private void setLblError(Color color, String text) {
		lblErrors.setTextFill(color);
		lblErrors.setText(text);
	}
	
	public void handleOutAction(MouseEvent e1) {
		Platform.exit();
	}

}
