package dad.javafx.personal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PersonalController implements Initializable {

	// VIEW
	// ---------------------------------------------------------------------------------------
	@FXML
	private GridPane view;
	@FXML
	private TextField dniText, nombreText, apellidosText, postalText, localidadText;
	@FXML
	private TextArea direccionText;
	@FXML
	private DatePicker fechaPicker;
	@FXML
	private ComboBox<String> paisCombo;
	@FXML
	private ListView<Nacionalidad> nacionalidadesList;
	@FXML
	private Button masButton, menosButton;
	// ---------------------------------------------------------------------------------------
	// MODEL
	// ---------------------------------------------------------------------------------------
	private ObjectProperty<Personal> personal = new SimpleObjectProperty<Personal>();
	// ---------------------------------------------------------------------------------------
	private ListProperty<String> paisesList = new SimpleListProperty<>(
			FXCollections.observableArrayList(new ArrayList<>()));
	// ---------------------------------------------------------------------------------------
	private ArrayList<String> nacionalidades = new ArrayList<>();
	// ---------------------------------------------------------------------------------------

	public PersonalController() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/personalGUI.fxml"));
		loader.setController(this);
		loader.load();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		paisCombo.itemsProperty().bind(paisesList);
		cargarNaciones();
		cargarPaises();
		
		personal.addListener((o, ol, nv) -> actualizarBindeos(ol, nv));
		personal.set(new Personal());

		masButton.setOnAction(event -> onMasButton());
		menosButton.setOnAction(event -> onMenosButton());
		menosButton.disableProperty().bind(nacionalidadesList.getSelectionModel().selectedItemProperty().isNull());

	}

	private void actualizarBindeos(Personal ol, Personal nv) {
		
		if (ol != null) {
			
			dniText.textProperty().unbindBidirectional(ol.dniProperty());
			nombreText.textProperty().unbindBidirectional(ol.nombreProperty());
			apellidosText.textProperty().unbindBidirectional(ol.apellidosProperty());
			postalText.textProperty().unbindBidirectional(ol.codigoPostalProperty());
			localidadText.textProperty().unbindBidirectional(ol.localidadProperty());
			direccionText.textProperty().unbindBidirectional(ol.direccionProperty());
			fechaPicker.valueProperty().unbindBidirectional(ol.fechaNacimientoProperty());
			
		}
		
		Bindings.bindBidirectional(dniText.textProperty(), nv.dniProperty());
		Bindings.bindBidirectional(nombreText.textProperty(), nv.nombreProperty());
		Bindings.bindBidirectional(apellidosText.textProperty(), nv.apellidosProperty());
		Bindings.bindBidirectional(postalText.textProperty(), nv.codigoPostalProperty());
		Bindings.bindBidirectional(localidadText.textProperty(), nv.localidadProperty());
		Bindings.bindBidirectional(direccionText.textProperty(), nv.direccionProperty());
		Bindings.bindBidirectional(fechaPicker.valueProperty(), nv.fechaNacimientoProperty());
		Bindings.bindBidirectional(paisCombo.valueProperty(), nv.paisProperty());
		
		nacionalidadesList.itemsProperty().bind(nv.nacionListProperty());
		
	}

	private void cargarPaises() {

		FileInputStream fichero = null;
		InputStreamReader entrada = null;
		BufferedReader lector = null;

		try {

			fichero = new FileInputStream("ficheros/paises.csv");
			entrada = new InputStreamReader(fichero, StandardCharsets.UTF_8);
			lector = new BufferedReader(entrada);

			String linea = null;

			while ((linea = lector.readLine()) != null) {

				paisesList.add(linea.trim());

			}

		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			try {
				if (lector != null) {
					lector.close();
				}

				if (entrada != null) {
					entrada.close();
				}

				if (fichero != null) {
					fichero.close();
				}

			} catch (IOException e) {
			}
		}

	}

	private void cargarNaciones() {

		FileInputStream file = null;
		InputStreamReader in = null;
		BufferedReader reader = null;

		try {

			file = new FileInputStream("ficheros/nacionalidades.csv");
			in = new InputStreamReader(file, StandardCharsets.UTF_8);
			reader = new BufferedReader(in);

			String line = null;

			while ((line = reader.readLine()) != null) {
				
				String aux = line.trim();
				aux = aux.substring(0, 1).toUpperCase() + aux.substring(1);
				nacionalidades.add(aux);
				
			}

		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			try {
				if (reader != null) {
					reader.close();
				}

				if (in != null) {
					in.close();
				}

				if (file != null) {
					file.close();
				}

			} catch (IOException e) {
			}
		}

	}

	private void onMasButton() {

		ChoiceDialog<String> dialog = new ChoiceDialog<>();
		dialog.setTitle("Nueva nacionalidad");
		dialog.setHeaderText("Añadir nacionalidad");
		dialog.setContentText("Seleccione una nacionalidad");
		dialog.getItems().addAll(nacionalidades);
		dialog.setSelectedItem(nacionalidades.get(0));
		
		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(getClass().getResource("/Imagenes/cv64x64.png").toString()));
		
		Optional<String> aux = dialog.showAndWait();
		
		if( aux.isPresent() && aux.get() != null ) {
			
			getPersonal().nacionListProperty().add(new Nacionalidad(aux.get()));
			
		}
		

	}

	private void onMenosButton() {
		
		Nacionalidad miNacionalidad = nacionalidadesList.getSelectionModel().getSelectedItem();
		
		if( miNacionalidad != null ) {
			
			getPersonal().getNacionList().remove(miNacionalidad);
			
		}

		

	}

	public GridPane getView() {

		return view;
	}

	public final ObjectProperty<Personal> personalProperty() {
		return this.personal;
	}
	

	public final Personal getPersonal() {
		return this.personalProperty().get();
	}
	

	public final void setPersonal(final Personal personal) {
		this.personalProperty().set(personal);
	}
	

}
