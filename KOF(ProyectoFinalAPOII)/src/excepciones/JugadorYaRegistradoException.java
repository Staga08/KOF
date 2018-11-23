package excepciones;

public class JugadorYaRegistradoException extends Exception  {
	public JugadorYaRegistradoException(String nombre) {
		super("Lo siento, el nombre de usuario: "+nombre+" ya se encuentra registrado");
	}
}
