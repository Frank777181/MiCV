package dad.javafx.contacto;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Email {
	
	private StringProperty email = new SimpleStringProperty();
	
	public Email(String email) {
		
		setEmail(email);
		
	}

	public final StringProperty emailProperty() {
		return this.email;
	}
	

	public final String getEmail() {
		return this.emailProperty().get();
	}
	

	public final void setEmail(final String email) {
		this.emailProperty().set(email);
	}
	
	
	

}
