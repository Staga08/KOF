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
			try {
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(Main.class.getResource("VentanaJuego.fxml"));
				BorderPane root2 = loader.load();
				
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
		});
	}


}
