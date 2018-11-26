package application;

import java.io.File;
import java.security.SecureRandom;
import java.sql.Time;
import java.util.Currency;

import javax.management.timer.Timer;

import com.sun.javafx.geom.Point2D;
import com.sun.javafx.scene.paint.GradientUtils.Point;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import modelo.IConstantes;

public class VentanaJuegoController {
 
	@FXML private ImageView p1;
	@FXML private ImageView p2;
	@FXML private ImageView back;
	@FXML private Timeline animation1;
	@FXML private Timeline animation2;
	@FXML private Timeline animation3;
	@FXML private Timeline animation4;
	@FXML private Timeline animation5;
	@FXML private Timeline animation6;
	@FXML private Label gameOver;
	
	/**
	 * initialize(): void
	 * Este metodo permite que las instrucciones dentro de le se ejecuten en el momento 
	 * en que la nueva ventana es iniciañizada.
	 */
	public void initialize() {
		cargar();
		animacion();
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
	
	public void animacion() {
		animation1 = new Timeline(new KeyFrame(Duration.millis(30), f-> {
			if (p1.getLayoutX()==300) {
				animation1.stop();
				Main.getPartida().get(Main.getPartida().getPosP()).atacar();
				refreshP1();
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
			if (p2.getLayoutX()>700) {
				animation2.stop();
				animacion3();
			}
			Main.getPartida().get(Main.getPartida().getPosP()).avanzarP1(3);
			p1.setLayoutX(Main.getPartida().get(Main.getPartida().getPosP()).getPosX());
			Main.getPartida().get(Main.getPartida().getPosP2()).retrosederP2(4);;
			p2.setLayoutX(Main.getPartida().get(Main.getPartida().getPosP2()).getPosX());
		}));
		animation2.setCycleCount(Timeline.INDEFINITE);
		animation2.play();
	}
	
	public void animacion3() {
		Main.getPartida().get(Main.getPartida().getPosP()).dejarDeatacar();
		refreshP1();
		animation3 = new Timeline(new KeyFrame(Duration.millis(30), f-> {
			if (p1.getLayoutX()<350) {
				animation3.stop();
				animacion4();
			}
			Main.getPartida().get(Main.getPartida().getPosP()).retrocederP1(3);
			p1.setLayoutX(Main.getPartida().get(Main.getPartida().getPosP()).getPosX());
			Main.getPartida().get(Main.getPartida().getPosP2()).avanzarP2(4);
			p2.setLayoutX(Main.getPartida().get(Main.getPartida().getPosP2()).getPosX());
		}));
		animation3.setCycleCount(Timeline.INDEFINITE);
		animation3.play();
	}
	
	public void animacion4() {
		Main.getPartida().get(Main.getPartida().getPosP2()).atacar();
		refreshP2();
		animacion5();
	}
	
	public void animacion5() {
		Main.getPartida().get(Main.getPartida().getPosP()).atacar();
		refreshP1();
		 PauseTransition wait = new PauseTransition(Duration.seconds(4));
		    wait.setOnFinished((e) -> {
		       animacion6();
		        wait.playFromStart();
		        wait.stop();
		    });
		    wait.play();
		
	}
	
	public void animacion6() {
		Main.getPartida().get(Main.getPartida().getPosP()).dejarDeatacar();
		Main.getPartida().get(Main.getPartida().getPosP2()).dejarDeatacar();
		refreshP1();
		refreshP2();
		animation5 = new Timeline(new KeyFrame(Duration.millis(30), f-> {
			if (p1.getLayoutX()<90) {
				animation5.stop();
				animacion7();
			}
			Main.getPartida().get(Main.getPartida().getPosP()).retrocederP1(3);
			p1.setLayoutX(Main.getPartida().get(Main.getPartida().getPosP()).getPosX());
			Main.getPartida().get(Main.getPartida().getPosP2()).retrosederP2(3);
			p2.setLayoutX(Main.getPartida().get(Main.getPartida().getPosP2()).getPosX());
		}));
		animation5.setCycleCount(Timeline.INDEFINITE);
		animation5.play();
	}
	
	public void animacion7() {
		animation6 = new Timeline(new KeyFrame(Duration.millis(30), f-> {
			if (p1.getLayoutX()>535) {
				Main.getPartida().get(Main.getPartida().getPosP()).atacar();
				refreshP1();
				animation6.stop();	
				gameOver();
			}
			Main.getPartida().get(Main.getPartida().getPosP()).avanzarP1(6);
			p1.setLayoutX(Main.getPartida().get(Main.getPartida().getPosP()).getPosX());
			Main.getPartida().get(Main.getPartida().getPosP2()).avanzarP2(1);
			p2.setLayoutX(Main.getPartida().get(Main.getPartida().getPosP2()).getPosX());
		}));
		animation6.setCycleCount(Timeline.INDEFINITE);
		animation6.play();
	}
	
	public void gameOver() {
		
		gameOver.setText("GAME OVER");
		SecureRandom random = new SecureRandom();
		int puntaje = random.nextInt(1000)+100;
		Main.getPartida().inOrden(Main.getPartida().getJugadores());
		Main.getPartida().getMejoresPuntajes().get(Main.getPartida().
				getMejoresPuntajes().size()-1).setPuntaje(puntaje);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("GAME OVER");
		alert.setHeaderText(null);
		alert.setContentText("Tu puntaje es: "+Integer.toString(Main.getPartida().
				getMejoresPuntajes().get(Main.getPartida().getMejoresPuntajes().size()-1).getPuntaje()));
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(new File("imagenes/Icon.png").toURI().toString()));
		alert.show();
	}
	
	public void refreshP1() {
		p1.setImage(new Image(new File(Main.getPartida().get(Main.getPartida().getPosP()).getSkin()).toURI().toString()));
	}
	
	public void refreshP2() {
		p2.setImage(new Image(new File(Main.getPartida().get(Main.getPartida().getPosP2()).getSkin()).toURI().toString()));
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





