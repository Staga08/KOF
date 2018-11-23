package modelo;

import excepciones.PuntajeNoExisteException;

public class Partida {
	
	private Jugador jugadores;
	private Personaje personaje1;
	private Personaje personaje2;
	
	public Partida() {
		// TODO Auto-generated constructor stub
	}
	
	public void agregarJugadores(Jugador actual, Jugador nuevo) {
		if (jugadores==null) {
			jugadores=nuevo;
		}else {
			if (nuevo.getPuntaje()<=actual.getPuntaje()) {
				if (actual.getIzq()==null) {
					actual.setIzq(nuevo);
				}else {
					agregarJugadores(actual.getIzq(), nuevo);
				}
			
			}else {
				if (nuevo.getPuntaje()>=actual.getPuntaje()) {
					if (actual.getDer()==null) {
						actual.setDer(nuevo);
					}else {
						agregarJugadores(actual.getDer(), nuevo);
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
	

	public void crearListaP1(Personaje p1) {
		Personaje nuevo = p1;
		Personaje aux = personaje1;
        if (personaje1==null) {
        	personaje1 = nuevo;
        } else{    
        	
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            	aux.setSiguiente(nuevo);
        	}
	}
	
	public void crearListaP2(Personaje p2) {
		Personaje nuevo = p2;
		Personaje aux = personaje2;
        if (personaje2==null) {
        	personaje2 = nuevo;
        } else{    
        	
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            	aux.setSiguiente(nuevo);
        	}
	}
	
	public Personaje getP1(int index) {
		int c = 0;
		Personaje temp = personaje1;
		
			while (temp!=null && c<index) {
				
				temp=temp.getSiguiente();
				c++;
			}
		return temp;
	}
	
	public Personaje getP2(int index) {
		int c = 0;
		Personaje temp = personaje2;
		
			while (temp!=null && c<index) {
				
				temp=temp.getSiguiente();
				c++;
			}
		return temp;
	}

}
