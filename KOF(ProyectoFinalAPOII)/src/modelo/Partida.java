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


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import application.Main;
import excepciones.JugadorNoEncontradoException;
import excepciones.JugadorYaRegistradoException;
import excepciones.PuntajeNoExisteException;

public class Partida {
	
	private Jugador jugadores;
	private int numJugadores;
	private ArrayList<Jugador> mejoresPuntajes;
	private boolean gameOver;
	private int posP;
	private int posP2;
	private String back;
	private Personaje personaje;
	
	public Partida() {
		this.jugadores=null;
		this.numJugadores = 0;
		this. mejoresPuntajes = new ArrayList<Jugador>();
	}
	
	/**
	 * Este metodo permite obtener la posicion del personaje del lado izquierdo
	 */
	public int getPosP() {
		return posP;
	}
	
	/**
	 * Este metodo permite establecer la posicion del personaje del lado izquierdo
	 */
	public void setPosP(int posP) {
		this.posP = posP;
	}
	
	/**
	 * Este metodo permite obtener la posicion del personaje del lado derecho
	 */
	public int getPosP2() {
		return posP2;
	}
	
	/**
	 * Este metodo permite saber cual personaje escojio el jugador del lado derecho
	 */
	public void setPosP2(int posP2) {
		this.posP2 = posP2;
	}

	/**
	 * Este metodo permite obtener la ruta de la imagen del background
	 */
	public String getBack() {
		return back;
	}
	
	/**
	 * Este metodo permite establecer la ruta de la imagen del background
	 */
	public void setBack(String back) {
		this.back = back;
	}
	
	public ArrayList<Jugador> getMejoresPuntajes() {
		return mejoresPuntajes;
	}
	
	
	public void setMejoresPuntajes(ArrayList<Jugador> mejoresPuntajes) {
		this.mejoresPuntajes = mejoresPuntajes;
	}
	
	public Jugador getJugadores() {
		return jugadores;
	}

	public void setJugadores(Jugador jugadores) {
		this.jugadores = jugadores;
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
		if(jugadores == null)
			throw new JugadorNoEncontradoException(nickName);
		else
			return jugadores.buscar(nickName);
		
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
				auxArreglo[j-1].compareTo(auxArreglo[j])>0 ; j--) {
		
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
	public void crearLista(Personaje p1) {
		Personaje nuevo = p1;
		Personaje aux = personaje;
        if (personaje==null) {
        	personaje = nuevo;
        } else{    
        	
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            	aux.setSiguiente(nuevo);
        	}
	}
	
	/**
	 * Este metodo permite cargar los Personajes del juego y agregarlos a la lista
	 */
	public void cargarPersonajes() {
		Personaje ioriP1 = new Personaje(50, 10, IConstantes.CANTIDADVIDA, IConstantes.IORI_MOV_DER);
		Personaje ryoP1 = new Personaje(50, 10,  IConstantes.CANTIDADVIDA, IConstantes.RYO_MOV_DER);
		Personaje terryP1 = new Personaje(50, 10,  IConstantes.CANTIDADVIDA, IConstantes.TERRY_MOV_DER);
		Personaje ioriP2 = new Personaje(500, 10, IConstantes.CANTIDADVIDA, IConstantes.IORI_MOV_IZQ);
		Personaje ryoP2 = new Personaje(500, 10,  IConstantes.CANTIDADVIDA, IConstantes.RYO_MOV_IZQ);
		Personaje terryP2 = new Personaje(500, 10,  IConstantes.CANTIDADVIDA, IConstantes.TERRY_MOV_IZQ);
		
		crearLista(ioriP1);
		crearLista(ryoP1);
		crearLista(terryP1);
		crearLista(ioriP2);
		crearLista(ryoP2);
		crearLista(terryP2);
	}
		
	/**
	 * Este m�todo permite dar el personaje en la posicion dada
	 * @param index de tipo int - la posicion en la lista personaje1
	 * @return el jugador en esa posicion
	 */
	public Personaje get(int index) {
		int c = 0;
		Personaje temp = personaje;
		
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
		
		return gameOver;
	}
	

	
	/**
	 * listarEscenarios(): String
	 * Este metodo permite retornar una cadena de strings que continene las rutas
	 * de los escenarios, separadas por un caracter("-").
	 * <b>pre:</b> debe tener la ruta de un archivo plano existente.
	 * @return la cadena de String con las rutas de los escenarios.
	 * @throws IOException
	 */
	public String listarEscenarios() throws IOException {
		String listado="";
		String cadena;
		FileReader f = new FileReader("data/escenarios.txt");
	    BufferedReader b = new BufferedReader(f);
	      while((cadena = b.readLine())!=null) {
	          listado+=cadena+"-";
	      }
	      b.close();
	return listado;
	}
	/**
	 * darEscenario(int): String.
	 * Este metodo permite retornar el escenario deseado(los escenarios se encuentran 
	 * almacenados en un arreglo tipo String).
	 * <b>pre:</b> el metodo listarEscenarios, debe tener la ruta de un archivo plano existente.
	 * @param index de tipo int - la posicion del escenario que desea recuperar.
	 * @return La ruta del escenario deseado.
	 * @throws IOException
	 */
	public String darEscenario(int index) throws IOException {
		
			String result= listarEscenarios();
			String[] epa=result.split("-");
			return epa[index];
	}

	
	public void guardar() {
		FileOutputStream fS = null;
		ObjectOutputStream oS = null;
		try {
			fS = new FileOutputStream("data/puntajes.txt");
			oS = new ObjectOutputStream(fS);
			oS.writeObject(jugadores);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				if (jugadores != null) {
					fS.close();
				}
				if (oS != null) {
					oS.close();
				}
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
	public void recuperarData() {
		FileInputStream fS = null;
		ObjectInputStream oS = null;
//		ArrayList<Jugador> users = null;
		try {
			fS = new FileInputStream("data/puntajes.txt");
			oS = new ObjectInputStream(fS);
//			Jugador nuevaRaiz = (Jugador)ois.readObject();
//			raiz = nuevaRaiz;
			Jugador users = (Jugador)oS.readObject();
			jugadores = users;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				if (fS != null) {
					fS.close();
				}
				if (oS != null) {
					oS.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	


}
