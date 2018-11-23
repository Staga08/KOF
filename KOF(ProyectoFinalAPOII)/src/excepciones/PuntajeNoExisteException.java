package excepciones;

public class PuntajeNoExisteException extends Exception{
	public PuntajeNoExisteException(int puntaje) {
		super("No se encuentra un puntaje de "+puntaje+" en el sistema");
	}
}
