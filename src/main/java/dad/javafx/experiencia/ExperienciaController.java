package dad.javafx.experiencia;

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

public class ExperienciaController implements Initializable {
	
	// VIEW
	//---------------------------------------------------------------------------------------
	@FXML
	private GridPane view;
	@FXML
	private TableView<String> experienciaTable;
	@FXML
	private TableColumn<Experiencia, String> desdeColumn;
	private TableColumn<Experiencia, String> hastaColumn;
	private TableColumn<Experiencia, String> denomicacionColumn;
	private TableColumn<Experiencia, String> empleadorColumn;
	@FXML
	private Button añadirButton,eliminarButton;
	
	public ExperienciaController() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/experienciaGUI.fxml"));
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
