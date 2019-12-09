package dad.javafx.Main;

import dad.javafx.app.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class APP extends Application {
	
	private MainController mainController;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		mainController = new MainController();
		
		Scene scene = new Scene(mainController.getView());
		primaryStage.setTitle("MiCV");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
