package excepciones;

public class JugadorNoEncontradoException extends Exception {
	public JugadorNoEncontradoException(String nombre) {
		super("El jugador con el nombre: "+ nombre+ " no se encuentra registrado");
	}
}
