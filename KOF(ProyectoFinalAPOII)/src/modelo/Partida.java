/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Icesi (Cali - Colombia)
 * Departamento TIC - Algoritmos y programación II
 * Protecto final
 * Autor: Julián Andrés Brito Escobar-Brayan Starlin Garcéz
 * Perido: 2018-2
 * Fecha: 26/11/2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package modelo;

import excepciones.JugadorYaRegistradoException;
import excepciones.PuntajeNoExisteException;

public class Partida {
	
	private Jugador jugadores;
	private Personaje personaje1;
	private Personaje personaje2;
	
	public Partida() {
		// TODO Auto-generated constructor stub
	}
	
	/**
     * Agrega los jugadores en un ABB 
     * @param actual : Jugador - el jugador actual
     * @param nuevo : Jugador - el jugador que se va agregar
     */
	public void agregarJugadores(Jugador actual, Jugador nuevo) throws JugadorYaRegistradoException{
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
	
	/**
	 * Este método permite buscar un jugador, con el puntaje como criterio<br>
	 * <b>pre:</b> actual !=null
	 * @param actual de tipo Jugador - el jugador actual
	 * @param puntaje de tipo int - el puntaje del jugador que se desea buscar
	 * @return el jugador buscado
	 */
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
	
	/**
     * Crea una lista para agregar los pesonajes que van al lado izquierdo
     * @param p1 : Personaje - nuevo personaje1
     */
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
	
	/**
     * Crea una lista para agregar los personajes quen van al lado derecho
     * @param p2 : Personaje - nuevo personaje2
     */
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
	
	/**
	 * Este método permite dar el personaje en la posicion dada
	 * @param index de tipo int - la posicion en la lista personaje1
	 * @return el jugador en esa posicion
	 */
	public Personaje getP1(int index) {
		int c = 0;
		Personaje temp = personaje1;
		
			while (temp!=null && c<index) {
				
				temp=temp.getSiguiente();
				c++;
			}
		return temp;
	}
	
	/**
	 * Este método permite dar el personaje en la posicion dada
	 * @param index de tipo int - la posicion en la lista personaje2
	 * @return el jugador en esa posicion
	 */
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
