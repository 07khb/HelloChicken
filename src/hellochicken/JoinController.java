package hellochicken;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class JoinController implements Initializable{
	
	@FXML TextField txtId, txtName, phoneNum;
	@FXML TextArea txtAddress;
	@FXML Button btnConfirm, btnJoin;
	@FXML PasswordField password;
	
	Connection conn;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void handleBtnJoinAction(ActionEvent e) {
		if (txtId.getText() == null || txtId.getText().equals("")) {
			messagePopup("아이디를 입력하세요.");
		} else if (password.getText() == null || password.getText().equals("")) {
			messagePopup("비밀번호를 입력하세요.");
		} else if (txtName.getText() == null || txtName.getText().equals("")) {
			messagePopup("이름을 입력하세요.");
		} else if (txtAddress.getText() == null || txtAddress.getText().equals("")) {
			messagePopup("주소를 입력하세요.");
		} else if (phoneNum.getText() == null || phoneNum.getText().equals("")) {
			messagePopup("전화번호를 입력하세요.");
		} else if(e.getSource() == btnJoin) {
			String sql = "insert into join(id,password,name,address,phonenum)" + "values(?, ?, ?, ?, ?)";
				try {
					Node node = (Node) e.getSource();
					Stage stage = (Stage) node.getScene().getWindow();
					stage.close();
					Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Login.fxml")));
					stage.setScene(scene);
					stage.show();
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, txtId.getText());
					pstmt.setString(2, password.getText());
					pstmt.setString(3, txtName.getText());
					pstmt.setString(4, txtAddress.getText());
					pstmt.setString(5, phoneNum.getText());
					pstmt.executeUpdate();
				} catch(Exception e1) {
					System.err.println(e1.getMessage());
					e1.printStackTrace();
				}
			}
		}
	
	public void messagePopup(String message) {
		HBox hbox = new HBox();
		hbox.setStyle("-fx-background-color: gray; -fx-background-radius: 30;");
		hbox.setAlignment(Pos.CENTER);
		Label label = new Label();
		HBox.setMargin(label, new Insets(0, 5, 0, 5));
		label.setText(message);
		label.setStyle("-fx-text-fill: white; ");
		hbox.getChildren().add(label);
		Popup popup = new Popup();
		popup.getContent().add(hbox);
		popup.setAutoHide(true);
		popup.show(btnJoin.getScene().getWindow());
	}

}
