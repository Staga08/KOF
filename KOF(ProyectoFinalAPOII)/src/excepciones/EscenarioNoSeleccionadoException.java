package excepciones;

public class EscenarioNoSeleccionadoException extends Exception {
	public EscenarioNoSeleccionadoException() {
		super("Debes seleccionar un escenario");
	}
}
