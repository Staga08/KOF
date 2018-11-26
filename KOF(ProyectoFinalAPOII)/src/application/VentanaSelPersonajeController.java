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
	private int i;
	
	public VentanaSelPersonajeController() {
		this.i=0;
	}
	
	/**
	 * initialize(): void
	 * Este metodo permite que las instrucciones dentro de el, se ejecuten al momento en que
	 * se inicializa la nueva ventana.
	 */
	public void initialize() {
		cargarImagenes();
		escojerPersonaje();
	}
	
	/**
	 * cargarImagenes(): void
	 * Este metodo permite cargar las imagenes de los personajes seleccionables, a modo de iconos,
	 * para que asi el usuario puede decidir mejor que personaje quiere escoger.
	 */
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
	
		imagen1.setFitHeight(TAMANHO_ICONOS);
		imagen1.setFitWidth(TAMANHO_ICONOS);
	
		imagen2.setFitHeight(TAMANHO_ICONOS);
		imagen2.setFitWidth(TAMANHO_ICONOS);
	
		imagen3.setFitHeight(TAMANHO_ICONOS);
		imagen3.setFitWidth(TAMANHO_ICONOS);
	
		Iori.setGraphic(imagen1);
		Ryo.setGraphic(imagen2);
		Terry.setGraphic(imagen3);
	}
	
	/**
	 * escogerPersonaje():void. 
	 * Este metodo le permite al usuario escoger su personaje y que esta eleccion se guarde,
	 * para asi ser mostrada mas adelante como el personaje jugable que el jugador escogio.
	 */
	public void escojerPersonaje() {
		Iori.setOnMouseClicked(e ->{
			Main.getPartida().setPosP(0);;
			escojerPersonaje2();
		});
		Ryo.setOnMouseClicked(e ->{
			Main.getPartida().setPosP(1);
			escojerPersonaje2();
		});
		Terry.setOnMouseClicked(e ->{
			Main.getPartida().setPosP(2);
			escojerPersonaje2();
		});
	}
	
	/**
	 * escogerPersonaje2():void. 
	 * Este metodo le permite al usuario#2 escoger su personaje y que esta eleccion se guarde,
	 * para asi ser mostrada mas adelante como el personaje jugable que el jugador escogio.
	 */
	public void escojerPersonaje2() {
	
		Iori.setOnMouseClicked(e ->{
			Main.getPartida().setPosP2(3);
			Main.pantallaMapas();
		});
		Ryo.setOnMouseClicked(e ->{
			Main.getPartida().setPosP2(4);
			Main.pantallaMapas();
		});
		Terry.setOnMouseClicked(e ->{
			Main.getPartida().setPosP2(5);
			Main.pantallaMapas();
		});
	}

}
