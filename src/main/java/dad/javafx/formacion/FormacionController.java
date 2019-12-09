package dad.javafx.formacion;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class FormacionController implements Initializable {
	
	// VIEW
	//---------------------------------------------------------------------------------------
	@FXML
	private GridPane view;
	@FXML
	private TableView<Titulo> formacionTable;
	@FXML
	private TableColumn<Titulo, String> desdeColumn;
	private TableColumn<Titulo, String> hastaColumn;
	private TableColumn<Titulo, String> denominacionColumn;
	private TableColumn<Titulo, String> organizadorColumn;
	@FXML
	private Button añadirButton,eliminarButton;
	
	private ObservableList<Titulo> obsFomacionesList = FXCollections.observableArrayList(new ArrayList<Titulo>());
	private ListProperty<Titulo> formacionList =  new SimpleListProperty<>(obsFomacionesList);

	
	public FormacionController() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/formacionGUI.fxml"));
		loader.setController(this);
		loader.load();
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		formacionTable.itemsProperty().bind(formacionList);
		/*desdeColumn.setCellValueFactory(new PropertyValueFactory<>("desde"));
		hastaColumn.setCellValueFactory(new PropertyValueFactory<>("hasta"));
		denominacionColumn.setCellValueFactory(new PropertyValueFactory<>("denominacion"));
		organizadorColumn.setCellValueFactory(new PropertyValueFactory<>("organizador"));*/
		
		añadirButton.setOnAction(event -> onAñadirButton());
		eliminarButton.setOnAction(event -> onEliminarButton());
		
	}
	
	
	private void onAñadirButton() {
		
		FormacionDialog dialogo = new FormacionDialog(formacionListProperty());
		Optional<Titulo> aux = dialogo.showAndWait();
		
		
	}

	private void onEliminarButton() {
		
		
		
	}

	public GridPane getView() {
		
		return view;
	}

	public final ListProperty<Titulo> formacionListProperty() {
		return this.formacionList;
	}
	

	public final ObservableList<Titulo> getFormacionList() {
		return this.formacionListProperty().get();
	}
	

	public final void setFormacionList(final ObservableList<Titulo> formacionList) {
		this.formacionListProperty().set(formacionList);
	}

}
