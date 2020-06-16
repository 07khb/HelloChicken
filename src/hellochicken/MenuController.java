package hellochicken;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController implements Initializable {
	@FXML
	CheckBox hu, yang, gan, set1, set2, set3, co500, co125, sa500, sa125;
	@FXML
	Button ju;
	@FXML
	ToggleGroup group3, group, groups;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

//		if (set2.isSelected()) {
//			System.out.println(set2.getUserData());
//		}
//		group3.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
//			@Override
//			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle chi) {
//				System.out.println(chi.getUserData());
//			}
//		});
//
//		
//		
//		
//		if (co500.isSelected()) {
//			System.out.println(co500.getUserData());
//		}
//		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
//			@Override
//			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle coke) {
//				System.out.println(coke.getUserData());
//			}
//		});
//
//		
//		
//		
//		if (sa500.isSelected()) {
//			System.out.println(sa500.getUserData());
//		}
//		groups.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
//			@Override
//			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle sa) {
//				System.out.println(sa.getUserData());
//			}
//		});

		ju.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage addStage = new Stage(StageStyle.UTILITY);
				addStage.initModality(Modality.WINDOW_MODAL);
				addStage.initOwner(ju.getScene().getWindow());
				try {
					Parent parent = FXMLLoader.load(getClass().getResource("Pay.fxml"));
					Scene scene = new Scene(parent);
					int sum = 0;
					String stri1 = "";
					String stri2 = "";
					String stri3 = "";
					String stri4 = "";
					String stri5 = "";
					String stri6 = "";
					String stri7 = "";
					String stri8 = "";
					String stri9 = "";
					String stri10 = "";
					if (hu.isSelected()) {
						sum += 10000;
						stri1 = "후라이드 " + " 10000원 " + "\n";
					}
					if (yang.isSelected()) {
						sum += 11000;
						stri2 = "양념 " + " 11000원 " + "\n";
					}
					if (gan.isSelected()) {
						sum += 11000;
						stri3 = "간장 " + " 11000원 " + "\n";
					}
					if (set1.isSelected()) {
						sum += 12000;
						stri4 = "후라이드 + 간장 12000원 " + "\n";
					}
					if (set2.isSelected()) {
						sum += 12000;
						stri5 = "후라이드 + 양념 12000원 " + "\n";
					}
					if (set3.isSelected()) {
						sum += 13000;
						stri6 = "양념 + 간장 13000원 " + "\n";
					}
					if (co500.isSelected()) {
						sum += 1000;
						stri7 = "콜라 500ml 1000원 " + "\n";
					}
					if (co125.isSelected()) {
						sum += 2000;
						stri8 = "콜라 1.25L 2000원 " + "\n";
					}
					if (sa500.isSelected()) {
						sum += 1000;
						stri9 = "사이다 500ml 1000원 " + "\n";
					}
					if (sa125.isSelected()) {
						sum += 2000;
						stri10 = "사이다 1.25L 2000원 " + "\n";
					}
					String str1 = String.valueOf(stri1);
					String str2 = String.valueOf(stri2);
					String str3 = String.valueOf(stri3);
					String str4 = String.valueOf(stri4);
					String str5 = String.valueOf(stri5);
					String str6 = String.valueOf(stri6);
					String str7 = String.valueOf(stri7);
					String str8 = String.valueOf(stri8);
					String str9 = String.valueOf(stri9);
					String str10 = String.valueOf(stri10);
					String str = "총 " + String.valueOf(sum) + "원 ";
					TextArea area = (TextArea) parent.lookup("#list");
					area.setText(str1 + str2 + str3 + str4 + str5 + str6 + str7 + str8 + str9 + str10 + "\n" + str);
					addStage.setScene(scene);
					addStage.setResizable(false);
					addStage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
	}

	public void handleChkAction(ActionEvent e) {
		if (hu.isSelected()) {
		}
		if (yang.isSelected()) {
		}
		if (gan.isSelected()) {
		}
	}
}