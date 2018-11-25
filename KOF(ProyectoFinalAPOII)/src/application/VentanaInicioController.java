package application;

import java.util.Optional;

import excepciones.JugadorNoEncontradoException;
import excepciones.JugadorYaRegistradoException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Jugador;

public class VentanaInicioController {

	private Stage primaryStage;
	
	@FXML 
	Button jugar;
	@FXML 
	Button puntajes;
	
	/**
	 * initialize(): void
	 * Este metodo permite que las instrucciones dentro de el, se ejecuten al momento en que
	 * se inicializa la nueva ventana.
	 */
	public void initialize() {
	
	action();
	
	}
	/**
	 * action(): void
	 * Este metodo permite escuchar los eventos que generan los botones, 
	 * y por tanto desplegar ciertas opciones, dependiendo del boton presionado.
	 */
	public void action() {
		
		jugar.setOnAction(f->{
			pedirNickname();
			Main.pantallaPersonaje();
		});
	
		puntajes.setOnAction(f->{
			Main.pantallaPuntajes();
		});
	
	
	}
	
	/**
	 * pedirNickname(): void
	 * Este metodo permite desplegar una ventana Pop-Up, que le pide a los usuarios sus nicknames.
	 */
	public void pedirNickname() {
		//Main.darGym().recuperarData();
		TextInputDialog dialog = new TextInputDialog("walter");
		dialog.setTitle("Usuario");
		dialog.setHeaderText(null);
		dialog.setContentText("Please enter your nickname:");
		Optional<String> result = dialog.showAndWait();
		result.ifPresent(name -> {
			try {
				Main.getPartida().agregar(dialog.getContentText());
			
			} catch (JugadorYaRegistradoException | JugadorNoEncontradoException e) {
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Pokemon Training");
				alert.setHeaderText(null);
				alert.setContentText(e.getMessage());
				Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
				stage.getIcons().add(new Image("data/pokeBall.png"));
				ButtonType butthole = new ButtonType("Suck my dick");
				alert.getButtonTypes().setAll(butthole);
				Optional<ButtonType>asshole=alert.showAndWait();
				asshole.ifPresent(f-> pedirNickname());
				
				
			}
		});
	}




}
