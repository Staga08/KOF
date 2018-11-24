package application;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.IConstantes;

public class VentanaSelPersonajeController implements IConstantes{
	
	@FXML Button Iori;
	@FXML Button Terry;
	@FXML Button Ryo;

public void initialize() {
	
	cargarImagenes();
}

public void cargarImagenes() {
	File iori=new File(IORI_ICONO);
	File ryo= new File(RYO_ICONO);
	File terry=new File(TERRY_ICONO);
	
	Image image1= new Image(iori.toURI().toString());
	Image image2= new Image(ryo.toURI().toString());
	Image image3= new Image(terry.toURI().toString());
	
	ImageView imagen1 = new ImageView(image1);
	ImageView imagen2 = new ImageView(image2);
	ImageView imagen3 = new ImageView(image3);
	
	Iori.setGraphic(imagen1);
	Ryo.setGraphic(imagen2);
	Terry.setGraphic(imagen3);
	
	
	
	
}

}
