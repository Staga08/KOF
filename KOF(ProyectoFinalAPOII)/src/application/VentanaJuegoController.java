package application;

import java.io.File;

import com.sun.javafx.geom.Point2D;
import com.sun.javafx.scene.paint.GradientUtils.Point;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import modelo.IConstantes;

public class VentanaJuegoController {
 
	@FXML private ImageView p1;
	@FXML private ImageView p2;
	@FXML private ImageView back;
	@FXML private Timeline animation1;
	@FXML private Timeline animation2;
	
	
	/**
	 * initialize(): void
	 * Este metodo permite que las instrucciones dentro de le se ejecuten en el momento 
	 * en que la nueva ventana es iniciañizada.
	 */
	public void initialize() {
		cargar();
		animacion1();
//		
	}  
	
	/**
	 * cargar(): void
	 * Este metodo permite cargar las imagenes de las selecciones que los jugadores hicieron anteriormente
	 * para mostrarlas en la ventana principal de juego
	 */
	public void cargar() {
		Main.getPartida().cargarPersonajes();
		back.setImage(new Image(new File(Main.getPartida().getBack()).toURI().toString()));
		p1.setImage(new Image(new File(Main.getPartida().get(Main.getPartida().getPosP()).getSkin()).toURI().toString()));
		p2.setImage(new Image(new File(Main.getPartida().get(Main.getPartida().getPosP2()).getSkin()).toURI().toString()));
		
	}
	
	public void animacion1() {
		animation1 = new Timeline(new KeyFrame(Duration.millis(30), f-> {
			if (p1.getLayoutX()==300) {
				animation1.stop();
				Main.getPartida().get(Main.getPartida().getPosP()).atacar();
				p1.setImage(new Image(new File(Main.getPartida().get(Main.getPartida().getPosP()).getSkin()).toURI().toString()));
				animacion2();
			}
			Main.getPartida().get(Main.getPartida().getPosP()).avanzarP1(5);
			p1.setLayoutX(Main.getPartida().get(Main.getPartida().getPosP()).getPosX());
			Main.getPartida().get(Main.getPartida().getPosP2()).avanzarP2(3);
			p2.setLayoutX(Main.getPartida().get(Main.getPartida().getPosP2()).getPosX());
			
		}));
		animation1.setCycleCount(Timeline.INDEFINITE);
		animation1.play();
	}
	
	public void animacion2() {
		animation2 = new Timeline(new KeyFrame(Duration.millis(30), f-> {
			Main.getPartida().get(Main.getPartida().getPosP()).dejarDeatacar();
			Main.getPartida().get(Main.getPartida().getPosP()).avanzarP1(3);
			p1.setLayoutX(Main.getPartida().get(Main.getPartida().getPosP()).getPosX());
			Main.getPartida().get(Main.getPartida().getPosP2()).retrosederP2(4);;
			p2.setLayoutX(Main.getPartida().get(Main.getPartida().getPosP2()).getPosX());
		}));
		animation2.setCycleCount(Timeline.INDEFINITE);
		animation2.play();
	}
	
	public void keyPressed(KeyEvent e) {
		
		
		if(e.getCode() == KeyCode.RIGHT) {
			System.out.println("RIGTH");
			System.out.println("Funciona");
		}
		if(e.getCode() == KeyCode.LEFT) {
			System.out.println("LEFT");
			System.out.println("Funciona");
		}
		if(e.getCode() == KeyCode.DOWN) {
			System.out.println("DOWN");
			System.out.println("Funciona");
		}
		if(e.getCode() == KeyCode.UP) {
			System.out.println("UP");
			System.out.println("Funciona");
		}
		
	}
	

}





