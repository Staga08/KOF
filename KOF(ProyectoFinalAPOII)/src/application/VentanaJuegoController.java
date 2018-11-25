package application;

import java.io.File;

import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modelo.IConstantes;

public class VentanaJuegoController {

	@FXML private ImageView p1;
	@FXML private ImageView p2;
	@FXML private ImageView back;
	@FXML private Timeline avanzar;
	
	/**
	 * initialize(): void
	 * Este metodo permite que las instrucciones dentro de le se ejecuten en el momento 
	 * en que la nueva ventana es iniciañizada.
	 */
	public void initialize() {
		cargar();
		
		
	}  
	
	/**
	 * cargar(): void
	 * Este metodo permite cargar las imagenes de las selecciones que los jugadores hicieron anteriormente
	 * para mostrarlas en la ventana principal de juego
	 */
	public void cargar() {
		back.setImage(new Image(new File(Main.getPartida().getBack()).toURI().toString()));
		p1.setImage(new Image(new File(Main.getPartida().escojerPersonajeP1(Main.getPartida().getPosP()).getSkin()).toURI().toString()));
		p2.setImage(new Image(new File(Main.getPartida().escojerPersonajeP2(Main.getPartida().getPosP2()).getSkin()).toURI().toString()));
		
	}

	
	private void moveOnkeyPressed() {
		p1.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent e) {
				//System.out.println(Main.getPosy());
				switch(e.getCode()) {
				 case UP:   System.out.println("Arriba");
				 	break;
		          case RIGHT: System.out.println("Derecha"); 
		          	break;
		          case DOWN:  System.out.println("Abajo");
		          	break;
		          case LEFT: System.out.println("Izquierda");
		          	break;
				}
			}
		});
		
		
	}




}
