package hellochicken;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller implements Initializable {
	@FXML Button btnl, btnm;
	@FXML TextField txtid;
	@FXML PasswordField paswF;
	
	
	Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	public LoginController() {
		con = ConnectionUtil.conDB();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	public void handleButtonAction(MouseEvent event) {

		System.out.println(event.getSource());

		if (event.getSource() == btnl) {
			if (logIn().equals("Success")) {
				try {
					Node node = (Node) event.getSource();
					Stage stage = (Stage) node.getScene().getWindow();
					stage.close();
					Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/OnBoard.fxml")));
					stage.setScene(scene);
					stage.show();

				} catch (IOException ex) {
					System.err.println(ex.getMessage());
				}

			}

		} else if (event.getSource() == btnm) {
			System.out.println("signup");
			if (signUp().equals("Success")) {
				setLblError(Color.DARKRED, "new User Created.");

			} else {
				setLblError(Color.DARKRED, "error.");

			}
		}
		
		
		private String signUp() {
			String status = "Success";
			String email = txtid.getText();
			String password = paswF.getText();
			if (email.isEmpty() || password.isEmpty()) {
				setLblError(Color.TOMATO, "Empty credentials");
				status = "Error";
			} else {
				String sql = "insert into users values(?, ?, ?, ?, ?)";
				try {
					preparedStatement = con.prepareStatement(sql);
					preparedStatement.setString(1, id);
					preparedStatement.setString(2, password);
					preparedStatement.setString(3, name);
					preparedStatement.setString(4, address);
					preparedStatement.setString(5, phonenum);
					int r = preparedStatement.executeUpdate();
					if (r == 0) {
						setLblError(Color.TOMATO, "DB error");
						status = "Error";
					} else {
						setLblError(Color.GREEN, "admin user created.");
					}
				} catch (SQLException ex) {
					System.err.println(ex.getMessage());
					status = "Exception";
				}
			}

			return status;
		}
		
	}// handlebuttonaction
	
	
	
}
