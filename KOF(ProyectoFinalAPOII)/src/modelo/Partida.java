/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Icesi (Cali - Colombia)
 * Departamento TIC - Algoritmos y programaci�n II
 * Protecto final
 * Autor: Juli�n Andr�s Brito Escobar-Brayan Starlin Garcés
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
	
	private Jugador jugador1;
	private Jugador jugador2;
	private int numJugadores;
	private ArrayList<Jugador> mejoresPuntajes;
	private boolean gameOver;
	private int posP;
	
	public Partida() {
		this.jugador1=null;
		this.numJugadores = 0;
		this. mejoresPuntajes = new ArrayList<Jugador>();
	}
	
	public Jugador getJugadores() {
		return jugador1;
	}

	public void setJugadores(Jugador jugadores) {
		this.jugador1 = jugadores;
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
	 * si no es encontrado lanza la excepci�n  
	 * @param nickName : String = nombre del jugador a buscar
	 * pre: nombre != null , nombre != " "
	 * @return el jugador que ha sido buscado a traves del nombre
	 * @throws JugadorNoEncontradoException  
	 * */
	public Jugador buscarJugador(String nickName) throws JugadorNoEncontradoException{
		if(jugador1 == null)
			throw new JugadorNoEncontradoException(nickName);
		else
			return jugador1.buscar(nickName);
		
	}
	
	/**
	 * agregar(String nickName) : void 
	 * agrega un nuevo jugador al ABB de jugadores segun elo criterio de ordenamiento correspondiente 
	 * valida primero si el jugador exite en caso de que no lanza la Excepci�n JugadorExistenteException 
	 * @param nickName : String - representa el nombre del jugador del juagador que se quiere agregar.
	 * @throws JugadorNoEncontradoException 
	 * @throws JugadorExistenteException 
	 * */
	public void agregar(String nickName) throws JugadorNoEncontradoException, JugadorYaRegistradoException {
		
		if (!existe(nickName)) {
			Jugador nuevo = new Jugador (nickName, 0);
			if (jugador1 == null) {
				jugador1 = nuevo;
				numJugadores++;
			}
				
			else {
				if( jugador1.agregarJugador(nuevo) )
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
	 * Este m�todo permite buscar un jugador, con el puntaje como criterio<br>
	 * Este m�todo permite buscar un jugador, con el puntaje como criterio<br>
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
	
	public int posicionPersonaje(int pos) {
		posP = pos;
		return pos;
	}
	
	public Personaje escojerPersonajeP1(int index) {
		jugador1 = new Jugador("se", 0);
		jugador1.cargarPersonajesP1();
		return jugador1.get(index);	
	}
	
	public Personaje escojerPersonajeP2(int index) {
		jugador2 = new Jugador("se", 0);
		jugador2.cargarPersonajesP2();
		return jugador2.get(index);	
	}
	
	public void pegarse() {
		
	}
	
	public boolean gameOver() {
		gameOver = false;
		
		return gameOver;
	}

	public int getPosP() {
		return posP;
	}

	public void setPosP(int posP) {
		this.posP = posP;
	}

}
