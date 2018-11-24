/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Icesi (Cali - Colombia)
 * Departamento TIC - Algoritmos y programaciï¿½n II
 * Protecto final
 * Autor: Juliï¿½n Andrï¿½s Brito Escobar-Brayan Starlin GarcÃ©s
 * Perido: 2018-2
 * Fecha: 26/11/2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package modelo;


import java.util.ArrayList;

import excepciones.JugadorNoEncontradoException;
import excepciones.JugadorYaRegistradoException;
import excepciones.PuntajeNoExisteException;

public class Partida {
	
	private Jugador jugadores;
	private Personaje personaje1;
	private Personaje personaje2;
	private int numJugadores;
	private ArrayList<Jugador> mejoresPuntajes;
	private boolean gameOver;
	
	public Partida() {
		this.numJugadores = 0;
		this. mejoresPuntajes = new ArrayList<Jugador>();
	}
	
	public Jugador getJugadores() {
		return jugadores;
	}

	public void setJugadores(Jugador jugadores) {
		this.jugadores = jugadores;
	}

	public Personaje getPersonaje1() {
		return personaje1;
	}

	public void setPersonaje1(Personaje personaje1) {
		this.personaje1 = personaje1;
	}

	public Personaje getPersonaje2() {
		return personaje2;
	}

	public void setPersonaje2(Personaje personaje2) {
		this.personaje2 = personaje2;
	}
	
	/**
	 * existe(String nickName) : boolean - busca un jugador deacuerdo a su nombre 
	 * @return true = si el jugador buscado por nombre existe 
	 * 		   false = si el jugador buscado por nombre NO existe
	 * */
	public boolean existe(String nickName) {
		boolean existe = false ;
		
		try {
			if (buscarJugador(nickName) != null) {
				existe = true;
			}
		}catch (JugadorNoEncontradoException e) {
			e.getMessage();
		}

		return existe;
		
	}
	
	/**
	 * buscarJugador(String nickName) : Jugador 
	 * busca un jugador con su nombre pasado por parametro
	 * si no es encontrado lanza la excepciï¿½n  
	 * @param nickName : String = nombre del jugador a buscar
	 * pre: nombre != null , nombre != " "
	 * @return el jugador que ha sido buscado a traves del nombre
	 * @throws JugadorNoEncontradoException  
	 * */
	public Jugador buscarJugador(String nickName) throws JugadorNoEncontradoException{
		if(jugadores == null)
			throw new JugadorNoEncontradoException(nickName);
		else
			return jugadores.buscar(nickName);
		
	}
	
	/**
	 * agregar(String nickName) : void 
	 * agrega un nuevo jugador al ABB de jugadores segun elo criterio de ordenamiento correspondiente 
	 * valida primero si el jugador exite en caso de que no lanza la Excepciï¿½n JugadorExistenteException 
	 * @param nickName : String - representa el nombre del jugador del juagador que se quiere agregar.
	 * @throws JugadorNoEncontradoException 
	 * @throws JugadorExistenteException 
	 * */
	public void agregar(String nickName) throws JugadorNoEncontradoException, JugadorYaRegistradoException {
		
		if (!existe(nickName)) {
			Jugador nuevo = new Jugador (nickName, 0);
			if (jugadores == null) {
				jugadores = nuevo;
				numJugadores++;
			}
				
			else {
				if( jugadores.agregarJugador(nuevo) )
					numJugadores++;
			} 	
		}// fin del if 
		else {
			try {
				Jugador encontrado = buscarJugador(nickName);
				encontrado.setPuntaje(encontrado.getPuntaje());				
			}catch (JugadorNoEncontradoException e) {
				e.getMessage();
			}
			
			throw new JugadorYaRegistradoException(nickName);

		}//fin del else
	
	}// fin del metodo
	
	/**
	 * Este método permite buscar un jugador, con el puntaje como criterio<br>
	 * Este mï¿½todo permite buscar un jugador, con el puntaje como criterio<br>
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
	
	public void inOrden(Jugador nodo) {
		
		if(nodo.getDer() != null)
			inOrden(nodo.getDer());
		mejoresPuntajes.add(nodo);
		if(nodo.getIzq() != null)
			inOrden(nodo.getIzq());
		
	}
	
	public void ordenarPuntagesPorBurbuja() {
		
		Jugador[] auxArreglo = new Jugador[mejoresPuntajes.size()];
		
		for (int i = 0; i < auxArreglo.length; i++) {
			auxArreglo[i] = mejoresPuntajes.get(i);
		}
				
		for (int i = 1; i < auxArreglo.length; i++) {
			for (int j = i; j > 0 && 
				(auxArreglo[j-1].getPuntaje() - (auxArreglo[j].getPuntaje()) > 0 ); j--) {
				
				Jugador tem = auxArreglo[j];
				auxArreglo[j] = auxArreglo[j-1];
				auxArreglo[j-1] = tem;
			}
		}
		
		mejoresPuntajes.removeAll(mejoresPuntajes);
		for (Jugador jugador : auxArreglo) {
			mejoresPuntajes.add(jugador);
		}
	}
	
	/**
	 * ordenarPuntagesPorSeleccion() : void
	 * este metodo ordena segun el criterio de seleccion.
	 * */
	public void ordenarPuntagesPorSeleccion() {
		
		Jugador[] auxArreglo = new Jugador[mejoresPuntajes.size()];
		
		for (int i = 0; i < auxArreglo.length; i++) {
			auxArreglo[i] = mejoresPuntajes.get(i);
		}
		
		for (int i = 0; i < auxArreglo.length-1; i++) {
			
			Jugador menor = auxArreglo[1];
			int cual = 1;
			
			for (int j = i + 1; j < auxArreglo.length; j++) {
				
				if(auxArreglo[j].getPuntaje() < menor.getPuntaje()) {
				
					menor = auxArreglo[j];
					cual = j;
				}
			}
			Jugador temp = auxArreglo[i];
			auxArreglo[i] = menor;
			auxArreglo[cual] = temp;
		}
		
		

		mejoresPuntajes.removeAll(mejoresPuntajes);
		for (Jugador jugador : auxArreglo) {
			mejoresPuntajes.add(jugador);
		}
	}
	
	public void ordenarPorInsercion() {
		
		Jugador[] auxArreglo = new Jugador[mejoresPuntajes.size()];
		
		for (int i = 0; i < auxArreglo.length; i++) {
			auxArreglo[i] = mejoresPuntajes.get(i);
		}
		
		for (int i = 1; i < auxArreglo.length; i++) {
			
			for (int j = i; j > 0 && 
				auxArreglo[j-1].getPuntaje() > auxArreglo[j].getPuntaje() ; j--) {
		
				Jugador temp = auxArreglo[j];
				auxArreglo[j] = auxArreglo[j-1];
				auxArreglo[j-1] = temp;	
			}	
		}
		mejoresPuntajes.removeAll(mejoresPuntajes);
		for (Jugador jugador : auxArreglo) {
			mejoresPuntajes.add(jugador);
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
	
	public void cargarPersonajes() {
		Personaje ioriP1 = new Personaje(50, 10, IConstantes.CANTIDADVIDA, IConstantes.IORI_MOV_DER, false);
		Personaje ryoP1 = new Personaje(50, 10,  IConstantes.CANTIDADVIDA, IConstantes.RYO_MOV_DER, false);
		Personaje terryP1 = new Personaje(50, 10,  IConstantes.CANTIDADVIDA, IConstantes.RYO_MOV_DER, false);
		
		Personaje ioriP2 = new Personaje(500, 10,  IConstantes.CANTIDADVIDA, IConstantes.IORI_MOV_IZQ, false);
		Personaje ryoP2 = new Personaje(500, 10,  IConstantes.CANTIDADVIDA, IConstantes.RYO_MOV_IZQ, false);
		Personaje terryP2 = new Personaje(500, 10,  IConstantes.CANTIDADVIDA, IConstantes.RYO_MOV_IZQ, false);
		
		crearListaP1(ioriP1);
		crearListaP1(ryoP1);
		crearListaP1(terryP1);
		
		crearListaP2(ioriP2);
		crearListaP2(ryoP2);
		crearListaP2(terryP2);
	}
	
	/**
	 * Este mï¿½todo permite dar el personaje en la posicion dada
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
	 * Este mï¿½todo permite dar el personaje en la posicion dada
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
	
	public void pegarse() {
		
	}
	
	public boolean gameOver() {
		gameOver = false;
		for (int i = 0; i < 2; i++) {
			if (getP1(i).isMuerto()||getP2(i).isMuerto()) {
				gameOver = true;
			}
		}
		return gameOver;
	}

}
