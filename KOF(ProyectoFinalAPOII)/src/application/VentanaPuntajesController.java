package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import excepciones.JugadorNoEncontradoException;
import excepciones.JugadorYaRegistradoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.Personaje;

public class VentanaPuntajesController {

	@FXML private Button puntaje;
	@FXML private Button nick;
	@FXML private ListView<String> lista;

	
	public void initialize() {
		 mostrar();
		 actions();
	}
	
	public void mostrar() {
		Main.getPartida().inOrden(Main.getPartida().getJugadores());
		ArrayList a= Main.getPartida().getMejoresPuntajes();
		List<String> list=new ArrayList<String>();
		for (int i = 0; i < a.size(); i++) {
			Jugador per=  (Jugador) a.get(i);
			System.out.println(per.getNickName()+"huh");
			list.add(per.getNickName());
			
		}
		ObservableList<String> nickLista=FXCollections.observableList(list);
		lista.setItems(nickLista);
	
	
	}
	
	public void actions() {
		nick.setOnAction(e->{
			TextInputDialog dialog = new TextInputDialog("walter");
			dialog.setTitle("Usuario");
			dialog.setHeaderText(null);
			dialog.setContentText("Que nombre estas buscando?");
			Optional<String> result = dialog.showAndWait();
			result.ifPresent(name -> {
				
					try {
						Jugador a=Main.getPartida().buscarJugador(result.get());
						System.out.println(a.getNickName());
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("King of Fighters");
						alert.setHeaderText(null);
						alert.setContentText("El jugador "+ a.getNickName()+ " se ha encontrado, este tiene una puntuacion de "+a.getPuntaje());
						Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
						ButtonType butt = new ButtonType("aceptar");
						alert.getButtonTypes().setAll(butt);
						Optional<ButtonType>as=alert.showAndWait();
					} catch (JugadorNoEncontradoException f) {
						// TODO Auto-generated catch block
						f.printStackTrace();
					}
				
			});
			
		});
	}

}
