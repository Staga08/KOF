package application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import excepciones.EscenarioNoSeleccionadoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.IConstantes;

public class VentanaSelMapaController {
	@FXML 
	private ChoiceBox<String> mapa;
	@FXML
	private Button siguiente;
	@FXML
	private Button preview;
	@FXML
	private ImageView imagensel;
	
	String result;
	/**
	 * initialize(): void
	 * Este metodo permite que las instrucciones dentro de le se ejecuten en el momento 
	 * en que la nueva ventana es iniciañizada.
	 */
	public void initialize() {
		mapas();
		actions();
		
	}

	/**
	 * mapas(): void
	 * Este metodo permite agregar las elecciones disponibles al ChoiceBox de la ventana,
	 * para que asi este puede mostrar los escenarios disponibles.
	 */
	public void mapas() {
		List<String> lista=new ArrayList<String>();
		lista.add("Casa en llamas");
		lista.add("Barco en ruinas");
		lista.add("Afueras del templo");
		lista.add("Afueras del templo(Nieve)");
		lista.add("Black Apokalipsis");
		lista.add("Templo en la cueva");
		lista.add("Afueras de la choza");
		ObservableList<String> tip=FXCollections.observableList(lista);
		mapa.setItems(tip);
	}

	/**
	 * action(): void
	 * Este metodo permite escuchar los eventos que generan los botones, 
	 * y por tanto desplegar ciertas opciones, dependiendo del boton presionado.
	 */
	public void actions() {
		siguiente.setOnAction(e->{
			try {
				if(Main.getPartida().getBack()==null) {
					throw new EscenarioNoSeleccionadoException();
				}else {
					Main.pantallaJuego();
				}
			}catch(EscenarioNoSeleccionadoException f) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("King of Fighters");
				alert.setHeaderText(null);
				alert.setContentText(f.getMessage());
				Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
				ButtonType butt = new ButtonType("aceptar");
				alert.getButtonTypes().setAll(butt);
				Optional<ButtonType>as=alert.showAndWait();
			}
			
		});
	
		preview.setOnAction(e->{
			
			String sel=mapa.getSelectionModel().getSelectedItem();
			
			if(sel.equals("Casa en llamas")) {
				
				try {
					imagensel.setImage(new Image(new File(Main.getPartida().darEscenario(0)).toURI().toString()));
					Main.getPartida().setBack(Main.getPartida().darEscenario(0));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}else if(sel.equals("Barco en ruinas")) {
				
				try {
					imagensel.setImage(new Image(new File(Main.getPartida().darEscenario(1)).toURI().toString()));
					Main.getPartida().setBack(Main.getPartida().darEscenario(1));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}else if(sel.equals("Afueras del templo")) {
				
				try {
					imagensel.setImage(new Image(new File(Main.getPartida().darEscenario(2)).toURI().toString()));
					Main.getPartida().setBack(Main.getPartida().darEscenario(2));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}else if(sel.equals("Afueras del templo(Nieve)")) {
				
				try {
					imagensel.setImage(new Image(new File(Main.getPartida().darEscenario(3)).toURI().toString()));
					Main.getPartida().setBack(Main.getPartida().darEscenario(3));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}else if(sel.equals("Black Apokalipsis")) {
				
				try {
					imagensel.setImage(new Image(new File(Main.getPartida().darEscenario(4)).toURI().toString()));
					Main.getPartida().setBack(Main.getPartida().darEscenario(4));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}else if(sel.equals("Templo en la cueva")) {
				
				try {
					imagensel.setImage(new Image(new File(Main.getPartida().darEscenario(5)).toURI().toString()));
					Main.getPartida().setBack(Main.getPartida().darEscenario(5));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}else if(sel.equals("Afueras de la choza")) {
				
				try {
					imagensel.setImage(new Image(new File(Main.getPartida().darEscenario(6)).toURI().toString()));
					Main.getPartida().setBack(Main.getPartida().darEscenario(6));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
	}
	
	
	
	
	
	
	
		
	
}
