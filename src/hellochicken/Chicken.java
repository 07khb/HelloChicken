package hellochicken;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Chicken {
	private SimpleStringProperty menu;
	private SimpleIntegerProperty price;
	
	Chicken(String menu, int price) {
		this.menu = new SimpleStringProperty(menu);
		this.price = new SimpleIntegerProperty(price);	
}
	
}