package dad.javafx.utils;

import dad.javafx.contacto.Telefono;
import dad.javafx.contacto.Telefono.TipoTelefono;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelefonoDialog extends Dialog<Telefono> {

	public TelefonoDialog() {

		setTitle("Nuevo teléfono");
		setHeaderText("Introdusca un teléfono");

		Stage stage = (Stage) getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(getClass().getResource("Imagenes/cv64x64.png").toString()));

		GridPane dialog = new GridPane();
		Label numeroTelefonoLabel = new Label("Número: ");
		Label tipoTelefonoLabel = new Label("Tipo: ");
		TextField numeroTelefonoText = new TextField();
		ComboBox<TipoTelefono> tipoTelefonoCombo = new ComboBox<Telefono.TipoTelefono>();

		dialog.setHgap(5);
		dialog.setVgap(5);

		numeroTelefonoText.setPromptText("Introduzca numero de telefono");

		tipoTelefonoCombo.setPromptText("Seleccione un tipo de teléfono");
		tipoTelefonoCombo.getItems().addAll(Telefono.obtenerTipoTelefonos());

		dialog.addRow(0, numeroTelefonoLabel, numeroTelefonoText);
		dialog.addRow(1, tipoTelefonoLabel, tipoTelefonoCombo);

		getDialogPane().setContent(dialog);

		setResultConverter(button -> {

			if (button.getButtonData() == ButtonData.OK_DONE) {
				return new Telefono(numeroTelefonoText.getText(), tipoTelefonoCombo.getSelectionModel().getSelectedItem());
			}

			return null;
		});

	}

}
