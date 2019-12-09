package dad.javafx.app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.conocimiento.ConocimientoController;
import dad.javafx.contacto.ContactoController;
import dad.javafx.experiencia.ExperienciaController;
import dad.javafx.formacion.FormacionController;
import dad.javafx.personal.PersonalController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable {

	// VIEW
	//---------------------------------------------------------------------------------------
	@FXML
	private BorderPane view;
	@FXML
	private MenuItem nuevoMenu, abrirMenu, guardarMenu, guardarComoMenu, salirMenu, helpMenu;
	
	private TabPane tabPane;
	//---------------------------------------------------------------------------------------
	//CONTROLLERS
	//---------------------------------------------------------------------------------------
	private ConocimientoController conocimientoController = new ConocimientoController();
	private ContactoController contactoController = new ContactoController();
	private ExperienciaController experienciaController = new ExperienciaController();
	private FormacionController formacionController = new FormacionController();
	private PersonalController personalController = new PersonalController();
	//---------------------------------------------------------------------------------------
	

	public MainController() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/mainGUI.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		tabPane = new TabPane();
		Tab tab1 = new Tab("Personal");
		Tab tab2 = new Tab("Contacto");
		Tab tab3 = new Tab("Formación");
		Tab tab4 = new Tab("Experiencia");
		Tab tab5 = new Tab("Conocimientos");
		
		tab1.setContent(personalController.getView());
		tab2.setContent(contactoController.getView());
		tab3.setContent(formacionController.getView());
		tab4.setContent(experienciaController.getView());
		tab5.setContent(conocimientoController.getView());
		
		tabPane.getTabs().addAll(tab1,tab2,tab3,tab4,tab5);
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		view.setCenter(tabPane);
		
		nuevoMenu.setGraphic(new ImageView("file:nuevo.gif"));
		abrirMenu.setGraphic( new ImageView("file:abrir.gif"));
		guardarMenu.setGraphic(new ImageView("file:guardar.gif"));
		
		nuevoMenu.setOnAction(event -> onNuevoCVAction());
		abrirMenu.setOnAction(event -> onAbrirCVAction()); 
		guardarMenu.setOnAction(event -> onGuardarCVAction()); 
		guardarComoMenu.setOnAction(event -> onGuarComoCVAction()); 
		salirMenu.setOnAction(event -> onSalirCVAction());
		helpMenu.setOnAction(event -> onAyudaCVAction());
		
		
	}

	private void onNuevoCVAction() {
		
		
		
	}

	private void onAbrirCVAction() {
		
		
		
	}

	private void onGuardarCVAction() {
		
		
		
	}

	private void onGuarComoCVAction() {
		
			
		
	}

	private void onSalirCVAction() {
		
		
		
	}

	private void onAyudaCVAction() {
		
		
		
	}
	
	public BorderPane getView() {
		
		return view;
	}

}
