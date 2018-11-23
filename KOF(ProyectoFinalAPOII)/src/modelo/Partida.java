package modelo;

import excepciones.PuntajeNoExisteException;

public class Partida {
	
	private Jugador jugadores;
	
	public Partida() {
		// TODO Auto-generated constructor stub
	}
	
	public void agregarUsuarios(Jugador actual, Jugador nuevo) {
		if (jugadores==null) {
			jugadores=nuevo;
		}else {
			if (nuevo.getPuntaje()<=actual.getPuntaje()) {
				if (actual.getIzq()==null) {
					actual.setIzq(nuevo);
				}else {
					agregarUsuarios(actual.getIzq(), nuevo);
				}
			
			}else {
				if (nuevo.getPuntaje()>=actual.getPuntaje()) {
					if (actual.getDer()==null) {
						actual.setDer(nuevo);
					}else {
						agregarUsuarios(actual.getDer(), nuevo);
					}
				}
			}
		}
	}
	
	public Jugador buscarPuntaje(Jugador actual, int puntaje) throws PuntajeNoExisteException {
		if(actual.getPuntaje()==puntaje) {
			return actual;
		}else {
			if(puntaje<actual.getPuntaje()) {
				if(actual.getIzq()!=null) {
					return buscarPuntaje(actual.getIzq(), puntaje);
				}else {
					throw new PuntajeNoExisteException(puntaje);
				}
			}else {
				if(actual.getDer()!=null) {
					return buscarPuntaje(actual.getDer(), puntaje);
				}else {
					throw new PuntajeNoExisteException(puntaje);
				}
			}
		}
	} 

}
