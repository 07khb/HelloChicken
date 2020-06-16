package hellochicken;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PayController implements Initializable {

	@FXML
	Button btnorder, exit;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
	public void buttonOrderAction(MouseEvent event) {
		if (event.getSource() == btnorder) {
			try {
				Node node = (Node) event.getSource();
				Stage stage = (Stage) node.getScene().getWindow();
				stage.close();
				Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Exit.fxml")));
				stage.setScene(scene);
				stage.show();
			} catch (IOException ex) {
				System.err.println(ex.getMessage());
			}
		}
	}
	
	public void buttonExitAction(ActionEvent e) {
		Platform.exit();
	}
}
