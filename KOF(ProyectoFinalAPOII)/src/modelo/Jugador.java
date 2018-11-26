package modelo;

import java.io.Serializable;

import excepciones.JugadorNoEncontradoException;

public class Jugador  implements Serializable , Comparable<Jugador>{
	
	private String nickName; 
	private int puntaje;
	private Jugador izq;
	private Jugador der;
	
	
	public Jugador(String nickname, int puntaje) {
		this.nickName=nickname;
		this.puntaje=puntaje;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public Jugador getIzq() {
		return izq;
	}

	public void setIzq(Jugador izq) {
		this.izq = izq;
	}

	public Jugador getDer() {
		return der;
	}

	public void setDer(Jugador der) {
		this.der = der;
	}
		
	/**
	 * agregarJugador(Jugador nuevo):void = agrega un  nuevo jugador al ABB segun el 
	 * criterio de ordenamiento
	 * @param nuevo : Jugador
	 * @return retorna si el juegador ha sido agregado o no
	 * */
	public boolean agregarJugador(Jugador nuevo) {
		if(this.compareTo(nuevo) > 0) {
			if(izq == null) {
				izq = nuevo;
				return true;
			}
				
			else {
				izq.agregarJugador(nuevo);
				return false;
			}
				
		}
		else
			if(der == null) {
				der = nuevo;
				return true;
			} 
				
			else {
				der.agregarJugador(nuevo);
				return false ;
			}
				 
		}
	
	/**
	 * buscar(String nickName) : Jugador  
	 * busca y retorna al jugador a travez de su nnombre 
	 * @param nickname : String - nombre del jugador pasado por parametro 
	 * @return el jugador que se esta buscdando 
	 * @throws JugadorNoEncontradoException : se lanza esta excepcion cuando el jugador 
	 * que se esta buscando no existe 
	 * */
	public Jugador buscar(String nickname) throws JugadorNoEncontradoException {
		
		if( nickName.compareToIgnoreCase(nickname) == 0)  {
			return this;
		}
		else if (nickName.compareToIgnoreCase(nickname) > 0 ) {
			if(izq == null)
				throw new JugadorNoEncontradoException(nickname);
			else
				return izq.buscar(nickname);
		}
		else {
			if(der == null)
				throw new JugadorNoEncontradoException(nickname);
			else
				return der.buscar(nickname);
		}
		
	}
	
	/**
	 * compareTo(Jugador jugador): m�todo implementado de la interfaz Compareble
	 * compara dos jugadores y dice quien es "mayor" a travez del criterio lexico
	 * @param jugador : Jugador que llega por parametro y sera comparado con aquel que llama al m�todo
	 * @return 0 = si los jugadores son iguales 
	 * 		  -1 = si el jugador que llega por parametro es mayor 
	 * 		   1 = si el jugador que llega por parametro es menor.
	 * */
	@Override
	public int compareTo(Jugador jugador) {
		return nickName.compareToIgnoreCase(jugador.getNickName());
	}
	
	/**
	 * toString : String metodo sobreescrito de la clase Odject  
	 * @return String con la infomacion basica del jugador
	 * */
	@Override
	public String toString() {
		return nickName+"  "+puntaje; 
	}
	


}
