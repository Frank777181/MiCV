package dad.javafx.formacion;



import javafx.application.Platform;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FormacionDialog extends Dialog<Titulo> {
	
	private Button crearButton,cancelarButton;
	private Label denominacionLabel,organizadorLabel,desdeLabel,hastaLabel;
	private TextField denominacionText,organizadorText;
	private DatePicker desde,hasta;
	
	private ObservableList<Titulo> formacionList;
	private ListProperty<Titulo> formaciones;
	
	
	public FormacionDialog(ListProperty<Titulo> formaciones) {
		
		setTitle("Nueva formación");
		
		crearButton = new Button("Crear");
		cancelarButton = new Button("Cancelar");
		
		formacionList = formaciones.get();
		formaciones = new SimpleListProperty<Titulo>(formacionList);


		
		denominacionLabel = new Label("Denominación");
		organizadorLabel = new Label("Organizador");
		desdeLabel = new Label("Desde");
		hastaLabel = new Label("Hasta");
		
		denominacionText = new TextField();
		organizadorText = new TextField();
		
		desde = new DatePicker();
		hasta = new DatePicker();
		
		crearButton.setDefaultButton(true);
		
		HBox denominacionBox = new HBox(5,denominacionLabel,denominacionText);
		HBox organizadorBox = new HBox(5,organizadorLabel,organizadorText);
		HBox desdeBox = new HBox(5,desdeLabel,desde);
		HBox hastaBox = new HBox(5,hastaLabel,hasta);
		HBox botonesBox = new HBox(5,crearButton,cancelarButton);
		
		VBox root = new VBox(5,denominacionBox,organizadorBox,desdeBox,hastaBox,botonesBox);
		root.setPadding(new Insets(10));
		root.setFillWidth(false);
		
		this.formaciones.bindBidirectional(formaciones);
		
		getDialogPane().setContent(root);
		
		crearButton.setOnAction(event -> onCrearFormacionAction());
		cancelarButton.setOnAction(event -> onCancelarAction());
		
	}


	private void onCrearFormacionAction() {
		
		Titulo nuevaFormacion = new Titulo(desde.getValue(), hasta.getValue(), denominacionText.getText(), organizadorText.getText());
		
		formaciones.add(nuevaFormacion);
		
	}


	private void onCancelarAction() {
		
		Platform.exit();
		
	}
	
}
