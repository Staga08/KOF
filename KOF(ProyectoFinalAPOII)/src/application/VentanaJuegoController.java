package application;

import java.io.File;

import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.IConstantes;

public class VentanaJuegoController {

	@FXML private ImageView p1;
	@FXML private ImageView p2;
	@FXML private ImageView back;
	@FXML private Timeline avanzar;

	public void initialize() {
		cargar();
	}  
	
	public void cargar() {
		back.setImage(new Image(new File(IConstantes.BLACK_APOKALIPSIS).toURI().toString()));
		p1.setImage(new Image(new File(IConstantes.IORI_MOV_DER).toURI().toString()));
		p2.setImage(new Image(new File(IConstantes.RYO_MOV_IZQ).toURI().toString()));
	}







}
