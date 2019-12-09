package dad.javafx.conocimiento;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class ConocimientoController implements  Initializable {
	
	// VIEW
	//---------------------------------------------------------------------------------------
	@FXML
	private GridPane view;
	@FXML
	private TableView<String> conocimientoTable;
	@FXML
	private TableColumn<Conocimiento, String> denominacionColumn;
	private TableColumn<Conocimiento, String> nivelColumn;
	@FXML
	private Button añadirConocimientoButton,añadirIdiomaButton,eliminarButton;
	
	
	public ConocimientoController() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/conocimientoGUI.fxml"));
		loader.setController(this);
		loader.load();
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public GridPane getView() {
		
		return view;
	}
	

}
