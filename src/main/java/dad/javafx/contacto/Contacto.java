package dad.javafx.contacto;

import java.util.ArrayList;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Contacto {
	
	ListProperty<Telefono> telefonosList = new SimpleListProperty<Telefono>(FXCollections.observableArrayList(new ArrayList<Telefono>()));
	ListProperty<Email> emailsList = new SimpleListProperty<Email>(FXCollections.observableArrayList(new ArrayList<Email>()));
	ListProperty<Web> websList = new SimpleListProperty<Web>(FXCollections.observableArrayList(new ArrayList<Web>()));
	
	
	public Contacto(ArrayList<Telefono> telefonosList, ArrayList<Email> emailsList,ArrayList<Web> websList) {
		
		this.telefonosList.addAll(telefonosList);
		this.emailsList.addAll(emailsList);
		this.websList.addAll(websList);
		
	}
	
	public Contacto() {
		
	}

	public final ListProperty<Telefono> telefonosListProperty() {
		return this.telefonosList;
	}
	

	public final ObservableList<Telefono> getTelefonosList() {
		return this.telefonosListProperty().get();
	}
	

	public final void setTelefonosList(final ObservableList<Telefono> telefonosList) {
		this.telefonosListProperty().set(telefonosList);
	}
	

	public final ListProperty<Email> emailsListProperty() {
		return this.emailsList;
	}
	

	public final ObservableList<Email> getEmailsList() {
		return this.emailsListProperty().get();
	}
	

	public final void setEmailsList(final ObservableList<Email> emailsList) {
		this.emailsListProperty().set(emailsList);
	}
	

	public final ListProperty<Web> websListProperty() {
		return this.websList;
	}
	

	public final ObservableList<Web> getWebsList() {
		return this.websListProperty().get();
	}
	

	public final void setWebsList(final ObservableList<Web> websList) {
		this.websListProperty().set(websList);
	}

}
