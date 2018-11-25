package application;

import java.io.File;
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
	
	public void initialize() {
		//Main.pantallaJuego();
		mapas();
		actions();
		
	}

	
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
				//stage.getIcons().add(new Image("data/pokeBall.png"));
				ButtonType butt = new ButtonType("aceptar");
				alert.getButtonTypes().setAll(butt);
				Optional<ButtonType>as=alert.showAndWait();
			}
			
		});
	
		preview.setOnAction(e->{
			String sel=mapa.getSelectionModel().getSelectedItem();
			if(sel.equals("Casa en llamas")) {
				imagensel.setImage(new Image(new File(IConstantes.CASA_EN_LLAMAS).toURI().toString()));
				Main.getPartida().setBack(IConstantes.CASA_EN_LLAMAS);
			}else if(sel.equals("Barco en ruinas")) {
				imagensel.setImage(new Image(new File(IConstantes.BARCO_EN_RUINAS).toURI().toString()));
				Main.getPartida().setBack(IConstantes.BARCO_EN_RUINAS);
			}else if(sel.equals("Afueras del templo")) {
				imagensel.setImage(new Image(new File(IConstantes.AFUERAS_DEL_TEMPLO).toURI().toString()));
				Main.getPartida().setBack(IConstantes.AFUERAS_DEL_TEMPLO);
			}else if(sel.equals("Afueras del templo(Nieve)")) {
				imagensel.setImage(new Image(new File(IConstantes.AFUERAS_TEMPLO_NIEVE).toURI().toString()));
				Main.getPartida().setBack(IConstantes.AFUERAS_TEMPLO_NIEVE);
			}else if(sel.equals("Black Apokalipsis")) {
				imagensel.setImage(new Image(new File(IConstantes.BLACK_APOKALIPSIS).toURI().toString()));
				Main.getPartida().setBack(IConstantes.BLACK_APOKALIPSIS);
			}else if(sel.equals("Templo en la cueva")) {
				imagensel.setImage(new Image(new File(IConstantes.TEMPLO_CUEVA).toURI().toString()));
				Main.getPartida().setBack(IConstantes.TEMPLO_CUEVA);
			}else if(sel.equals("Afueras de la choza")) {
				imagensel.setImage(new Image(new File(IConstantes.AFUERAS_CHOZA).toURI().toString()));
				Main.getPartida().setBack(IConstantes.AFUERAS_CHOZA);
			}
			
		});
		
	}
	
	
	
	
	
	
	
		
	
}
