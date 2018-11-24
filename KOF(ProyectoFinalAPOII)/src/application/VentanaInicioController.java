package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaInicioController {

	private Stage primaryStage;
	@FXML Button prueba;

	public void initialize() {
	action();
	}

	public void action() {
		
		prueba.setOnAction(f->{
			Main.mandarPantalla();
		});
	}


}
