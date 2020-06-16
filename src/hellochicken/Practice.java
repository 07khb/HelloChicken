package hellochicken;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Practice extends Application{
	@FXML
	TextField txtId, txtName, address, phoneNumber;
	@FXML
	PasswordField password;
	@FXML
	Button btnJoin, btnOverlap;

	Connection conn;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void handlebtnJoinAction(ActionEvent e) {
	if (txtId.getText() == null || txtId.getText().equals("")) {
		System.out.println("ID를 입력하세요.");
	} else if (password.getText() == null || password.getText().equals("")) {
		System.out.println("비밀번호를 입력하세요.");
	} else if (txtName.getText() == null || txtName.getText().equals("")) {
		System.out.println("이름을 입력하세요.");
	} else if (address.getText() == null || address.getText().equals("")) {
		System.out.println("주소를 입력하세요.");
	} else if (phoneNumber.getText() == null || phoneNumber.getText().equals("")) {
		System.out.println("내용을 입력하세요.");
	} else {
		String sql = "insert into users(id, password, name, address, phonenum)" + "values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, txtId.getText());
			pstmt.setString(2, password.getText());
			pstmt.setString(3, txtName.getText());
			pstmt.setString(4, address.getText());
			pstmt.setString(5, phoneNumber.getText());
			pstmt.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		txtId.setText(null);
		password.setText(null);
		txtName.setText(null);
		address.setText(null);
		phoneNumber.setText(null);
	}
}
}
