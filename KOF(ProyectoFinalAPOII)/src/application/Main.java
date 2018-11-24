package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Partida;


public class Main extends Application {
	private static Stage primaryStage;
	private static Partida partidilla;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("VentanaInicio.fxml"));
			primaryStage.getIcons().add(new Image(new File("").toURI().toString()));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void mandarPantalla() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(Main.class.getResource("Tablero.fxml"));
			BorderPane root2 = loader.load();
			
			Stage stage2=new Stage();
			stage2.setTitle("Buscaminas");
			stage2.initModality(Modality.WINDOW_MODAL);
			stage2.initOwner(primaryStage);
			
			Scene scene2=new Scene(root2);
			stage2.setScene(scene2);
			stage2.showAndWait();
			primaryStage.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static Partida getPartida() {
		return partidilla;
	}


}
