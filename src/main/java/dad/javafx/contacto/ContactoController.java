package dad.javafx.contacto;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.contacto.Telefono.TipoTelefono;
import dad.javafx.utils.TelefonoDialog;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ContactoController implements Initializable {

	// VIEW
	// ---------------------------------------------------------------------------------------
	@FXML
	private GridPane view;
	@FXML
	private TableView<Telefono> telefonosTable;
	private TableView<Email> emailsTable;
	private TableView<Web> websTable;
	@FXML
	private TableColumn<Telefono, String> numeroColumn;
	private TableColumn<Telefono, TipoTelefono> tipoColumn;
	private TableColumn<Email, String> emailsColumn;
	private TableColumn<Web, String> urlColumn;
	@FXML
	private Button añadirTelefonoButton, eliminarTelefonoButton;
	private Button añadirEmailButton, eliminarEmailButton;
	private Button añadirURLButton, eliminarURLButton;

	private ObjectProperty<Contacto> contacto = new SimpleObjectProperty<Contacto>();

	public ContactoController() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/contactoGUI.fxml"));
		loader.setController(this);
		loader.load();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		numeroColumn.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		tipoColumn.setCellFactory(ComboBoxTableCell.forTableColumn(Telefono.obtenerTipoTelefonos()));
		emailsColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		urlColumn.setCellValueFactory(new PropertyValueFactory<>("url"));


		añadirTelefonoButton.setOnAction(event -> onAñadirTelefonoButton());
		añadirEmailButton.setOnAction(event -> onAñadirEmailButton());
		añadirURLButton.setOnAction(event -> onAñadirWebButton());

		eliminarTelefonoButton.setOnAction(event -> onEliminarTelefonoButton(event));
		eliminarEmailButton.setOnAction(event -> onEliminarEmailButton(event));
		eliminarURLButton.setOnAction(event -> onEliminarURLButton(event));

		eliminarTelefonoButton.disableProperty()
				.bind(telefonosTable.getSelectionModel().selectedItemProperty().isNull());
		eliminarEmailButton.disableProperty().bind(emailsTable.getSelectionModel().selectedItemProperty().isNull());
		eliminarURLButton.disableProperty().bind(websTable.getSelectionModel().selectedItemProperty().isNull());

		contacto.addListener((o, ol, nv) -> actualizarBindeos(ol, nv));
		contacto.set(new Contacto());

	}

	private void actualizarBindeos(Contacto ol, Contacto nv) {

		if (ol != null) {

			telefonosTable.itemsProperty().unbindBidirectional(ol.telefonosListProperty());
			emailsTable.itemsProperty().unbindBidirectional(ol.emailsListProperty());
			websTable.itemsProperty().unbindBidirectional(ol.websListProperty());
		}

		Bindings.bindBidirectional(telefonosTable.itemsProperty(), nv.telefonosListProperty());
		Bindings.bindBidirectional(emailsTable.itemsProperty(), nv.emailsListProperty());
		Bindings.bindBidirectional(websTable.itemsProperty(), nv.websListProperty());

	}

	private void onAñadirTelefonoButton() {

		TelefonoDialog dialog = new TelefonoDialog();

		Optional<Telefono> telefono = dialog.showAndWait();

		if (telefono.isPresent() && telefono.get() != null) {

			getContacto().getTelefonosList().add(telefono.get());
		}

	}

	private void onAñadirEmailButton() {

		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Nuevo e-mail");
		dialog.setHeaderText("Nueva dirreción email");
		dialog.setContentText("E-mail:");

		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(getClass().getResource("/Imagenes/cv64x64.png").toString()));

		Optional<String> email = dialog.showAndWait();

		if (email.isPresent() && email.get() != null && !email.get().isBlank()) {
			getContacto().getEmailsList().add(new Email(email.get()));
		}

	}

	private void onAñadirWebButton() {

		TextInputDialog dialog = new TextInputDialog("http://");
		dialog.setTitle("Nueva web");
		dialog.setHeaderText("Nueva dirrecion web");
		dialog.setContentText("URL:");

		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(getClass().getResource("/images/cv64x64.png").toString()));

		Optional<String> web = dialog.showAndWait();

		if (web.isPresent() && web.get() != null && !web.get().isBlank()) {
			getContacto().getWebsList().add(new Web(web.get()));
		}

	}

	private void onEliminarTelefonoButton(ActionEvent event) {

		Telefono telefonos = telefonosTable.getSelectionModel().getSelectedItem();

		if (telefonos != null && alertaEliminar("Eliminar teléfono","¿Estas seguro de eliminar?")) {

			getContacto().getTelefonosList().remove(telefonos);

		}

	}

	private void onEliminarEmailButton(ActionEvent event) {
		
		Email email = emailsTable.getSelectionModel().getSelectedItem();
		
		if( email != null && alertaEliminar("Eliminar email", "¿Estas seguro de eliminar?")) {
			
			getContacto().getEmailsList().remove(email);
			
		}

	}

	private void onEliminarURLButton(ActionEvent event) {
		
		Web webItem = websTable.getSelectionModel().getSelectedItem();
		
		if( webItem != null && alertaEliminar("Eliminar Sitio Web", "¿Estas seguro de eliminar?") ) {
			
			getContacto().getWebsList().remove(webItem);
			
		}

	}

	private boolean alertaEliminar(String headerText, String contentText) {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);

		return (alert.showAndWait().get() == ButtonType.OK);
	}

	public GridPane getView() {

		return view;
	}

	public final ObjectProperty<Contacto> contactoProperty() {
		return this.contacto;
	}

	public final Contacto getContacto() {
		return this.contactoProperty().get();
	}

	public final void setContacto(final Contacto contacto) {
		this.contactoProperty().set(contacto);
	}

}
