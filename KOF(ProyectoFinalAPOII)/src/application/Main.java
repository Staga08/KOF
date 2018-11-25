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
//BLABKA

public class Main extends Application {
	private static Stage primaryStage;
	private static Partida partidilla = new Partida();
	Pane root;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("VentanaInicio.fxml"));
			primaryStage.getIcons().add(new Image(new File("imagenes/logo.png").toURI().toString()));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void pantallaPersonaje() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(Main.class.getResource("VentanaSelPersonaje.fxml"));
			Pane root2 = (Pane)loader.load();
			
			Stage stage2=new Stage();
			stage2.setTitle("King of Fighters");
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
	
	public static void pantallaMapas() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(Main.class.getResource("VentanaSelMapa.fxml"));
			Pane root2 = (Pane)loader.load();
			
			Stage stage2=new Stage();
			stage2.setTitle("King of Fighters");
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
	
	public static void pantallaJuego() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(Main.class.getResource("VentanaJuego.fxml"));
			BorderPane root2 = (BorderPane)loader.load();
			
			Stage stage2=new Stage();
			stage2.setTitle("King of Fighters");
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
	
	
	public static void pantallaPuntajes() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(Main.class.getResource("VentanaPuntajes.fxml"));
			Pane root2 = (Pane)loader.load();
			
			Stage stage2=new Stage();
			stage2.setTitle("King of Fighters");
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
