package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import excepciones.JugadorNoEncontradoException;
import excepciones.JugadorYaRegistradoException;
import excepciones.PuntajeNoExisteException;
import modelo.IConstantes;
import modelo.Jugador;
import modelo.Partida;
import modelo.Personaje;

class PartidaTest {
	
	private Partida p;
	private Jugador j1;
	private Jugador j2;
	private Jugador j3;
	private Jugador j4;
	
	/**
	 * escenario1(): void - crea una partida
	 * */
	void escenario1() {
		p = new Partida();
	}
	
	/**
	 * escenario2(): void - crea una partida con 7 jugadores
	 * */
	void escenario2() {
		p = new Partida();
		
		try {
			p.agregar("jugador15");
			p.agregar("jugador6");
			p.agregar("jugador10");
			p.agregar("jugador4");
			p.agregar("jugador20");
			p.agregar("jugador17");
			p.agregar("jugador22");
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	/**
	 *  escenario3() : void - costruye un arbol de jugadores
	 *  con tres jugadores
	 * */
	void escenario3() {		
		escenario1();
		try {
			p.agregar("1");
			p.agregar("0");
			p.agregar("5");
		}catch (Exception e) {
			fail("la prueba fallo");
		}
		
	}
	
	
	/**
	 * escenario4() : void - construye una partida con nueve jugadores 
	 * */
	void escenario4() {
		
		p = new Partida();
		try {
			p.agregar("jugador1");
			p.agregar("jugador3");
			p.agregar("jugador5");
			p.agregar("jugador6");
			p.agregar("jugador9");
			p.agregar("jugador7");
			p.agregar("jugador8");
			p.agregar("jugador0");
			p.agregar("jugador4");
		
		} catch (JugadorYaRegistradoException e) {
	
		} catch (JugadorNoEncontradoException e) {
			// TODO: handle exception
		}

	}
	
	/**
	 * escenario5() : construye una partida con un solo jugador. 
	 * */
	void escenario5() {
		escenario1();
		try {
			p.agregar("jugadorExistente");
		} catch (JugadorYaRegistradoException e) {
			
		} catch(JugadorNoEncontradoException e) {
			
		}
	}
	
	/**
	 * escenario() : construye una partida con un solo jugador. 
	 * */
	void escenario6() {
		escenario1();
		Jugador walter = new Jugador("Walter", 450);
		Jugador brayan = new Jugador("Brayan", 450);
		Jugador brito = new Jugador("Brito", 405);
		Jugador fabian = new Jugador("Fabian", 340);
		try {
			p.agregar(walter.getNickName());
			p.agregar(brayan.getNickName());
			p.agregar(brito.getNickName());
			p.agregar(fabian.getNickName());
		} catch (JugadorNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JugadorYaRegistradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Prueba la adición de jugadores. <br>
	 * <b> Métodos a probar: </b> 
	 * <br> agregar. <br>
	 * <b> Objetivo: </b>  <br>probar que el método agregar(),  agrega
	 * correctamente jugadores al ABB. </br>
	 * <b> Resultados esperados: </b> 
	 * <br> 1. Al agregar un jugador la partida sin jugadores este debe ser
	 * insertado sin errores. </br>
	 */
	@Test
	void testAgregar1() {
		try {
			escenario1();
			assertNull(p.getJugadores());
			p.agregar("1");
			assertNotNull(p.getJugadores());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * Prueba la adición de jugadores. <br>
	 * <b> Métodos a probar: </b> 
	 * <br> agregar. <br>
	 * <b> Objetivo: </b>  <br>probar que el método agregar(),  agrega
	 * correctamente jugadores al ABB. </br>
	 * <b> Resultados esperados: </b> 
	 * <br> Al agregar un jugador menor que la raiz este se agrega al subarbol 
	 * izquierdo sin errores. </br>
	 */
	@Test
	void testAgregar2() {
		escenario1();
		try {
			p.agregar("1");
			p.agregar("0");	
			assertEquals("0", p.getJugadores().getIzq().getNickName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	/**
	 * Prueba la adición de jugadores. <br>
	 * <b> Métodos a probar: </b> 
	 * <br> agregar. <br>
	 * <b> Objetivo: </b>  <br>probar que el método agregar(),  agrega
	 * correctamente jugadores al ABB. </br>
	 * <b> Resultados esperados: </b> 
	 * <br>  Al agregar un jugador mayor que la raiz a la partida este 
	 * se agrega al subarbol derecho sin errores. </br>
	 */
	@Test
	void testAgregar3() {
		try {
			escenario3();
			
			assertEquals("5", p.getJugadores().getDer().getNickName());
			assertEquals("0", p.getJugadores().getIzq().getNickName());
			assertEquals("1", p.getJugadores().getNickName());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	/**
	 * Prueba la adición de jugadores. <br>
	 * <b> Métodos a probar: </b> 
	 * <br> agregar. <br>
	 * <b> Objetivo: </b>  <br>probar que el método agregar(),  agrega
	 * correctamente jugadores al ABB. </br>
	 * <b> Resultados esperados: </b> 
	 * <br> el metodo agregar agrega a los jugadores segun el criterio de
	 * un ABB, los jugadores se agregan sin errores </br>
	 */
	@Test
	void testAgregar4() {
		escenario4();
		assertEquals("jugador1", p.getJugadores().getNickName());
		assertEquals("jugador0", p.getJugadores().getIzq().getNickName());
		assertEquals("jugador3", p.getJugadores().getDer().getNickName());
		assertEquals("jugador5", p.getJugadores().getDer().getDer().getNickName());
		assertEquals("jugador4", p.getJugadores().getDer().getDer().getIzq().getNickName());
		assertEquals("jugador6", p.getJugadores().getDer().getDer().getDer().getNickName());
		assertEquals("jugador7", p.getJugadores().getDer().getDer().getDer().getDer().getIzq().getNickName());
		assertEquals("jugador8", p.getJugadores().getDer().getDer().getDer().getDer().getIzq().getDer().getNickName());
		assertEquals("jugador9", p.getJugadores().getDer().getDer().getDer().getDer().getNickName());
		
	}
	
	/**
	 * Prueba la adición de jugadores. <br>
	 * <b> Métodos a probar: </b> 
	 * <br> agregar. <br>
	 * <b> Objetivo: </b> 
	 * <br> probar que el método agregar(), lanza una 
	 * excepcion llamada JugadorExistenteException y 
	 * solamente lanza esa. </br>
	 * <b> Resultados esperados: </b> 
	 * <br> el metodo agregar, lanza la exepcion esperada 
	 * el jugador no se agrega </br>
	 */
	@Test
	void testAgregar5() {
		escenario5();
		try {
			p.agregar("jugadorExistente");
		} catch (JugadorYaRegistradoException e) {
			assertTrue(true, "si esta excecion es lanzada entonces la prueba fue exitosa");
		} catch (JugadorNoEncontradoException e) {
			fail("la excepcion no deberia llegar hasta aca");
		}
		
	}
	
	/**
	 * Prueba la existencia de jugadores en el arbol. <br>
	 * <b> Métodos a probar: </b> 
	 * <br> existe <br>
	 * <b> Objetivo: </b> 
	 * <br> probar que el método existe(), retorna: -true = si el jugador existe
	 * 												existe en el arbol
	 * 												-false = de lo contrario </br>
	 * <b> Resultados esperados: </b> 
	 * <br> 1. el jugador : "jugadorExiste", es encontrado en el arbol, el metodo retorna true
	 * 2. el jugador : "jugadorNoExiste", NO es encontrado en el arbol, el metodo retorna false </br>
	 */
	@Test
	void testExiste() {
		escenario5();
		
		assertTrue(	p.existe("jugadorExistente") , "este jugador ya ha sido agregado en el arbol");
		
		assertFalse( p.existe("jugadorNoExiste"), "este jugador no esta en el arbol" );
	}
	
	/**
	 * Prueba la existencia de jugadores en el arbol. <br>
	 * <b> Métodos a probar: </b> 
	 * <br> existe <br>
	 * <b> Objetivo: </b> 
	 * <br> probar que el método existe(), retorna: -true = si el jugador existe
	 * 												existe en el arbol
	 * 												-false = de lo contrario </br>
	 * <b> Resultados esperados: </b> 
	 * <br> los jugadores : "jugador9", "jugador3", "jugador5", "jugador6", son 
	 * encontrados en el arbol, el metodo retorna true en cada caso. </br>
	 */
	@Test
	void testExiste2() {
		
		escenario4();
		assertTrue( p.existe("jugador9") );
		assertTrue( p.existe("jugador3") );
		assertTrue( p.existe("jugador5") );
		assertTrue( p.existe("jugador6") );
		
	}
	
	@Test
	void testCreaLista() {
		escenario1();
		Personaje personaje1 = new Personaje(50, 10, IConstantes.CANTIDADVIDA, IConstantes.IORI_MOV_DER);
		Personaje personaje2 = new Personaje(50, 10,  IConstantes.CANTIDADVIDA, IConstantes.RYO_MOV_DER);
		p.crearLista(personaje1);
		p.crearLista(personaje2);
		assertEquals(p.getPersonaje().getSkin(),IConstantes.IORI_MOV_DER);
		assertEquals(p.getPersonaje().getSiguiente().getSkin(),IConstantes.RYO_MOV_DER);
	}
	
	@Test
	void testCargarEnemigos() {
		escenario1();
		p.cargarPersonajes();
		assertEquals(IConstantes.IORI_MOV_DER, p.get(0).getSkin());
		assertEquals(IConstantes.RYO_MOV_DER, p.get(1).getSkin());
		assertEquals(IConstantes.TERRY_MOV_DER, p.get(2).getSkin());
		assertEquals(IConstantes.IORI_MOV_IZQ, p.get(3).getSkin());
		assertEquals(IConstantes.RYO_MOV_IZQ, p.get(4).getSkin());
		assertEquals(IConstantes.TERRY_MOV_IZQ, p.get(5).getSkin());
	}
	
	@Test
	void testBuscarPuntaje() {
		escenario6();
		try {
			Jugador buscado = p.buscarPuntaje(448);
			assertEquals("Brayan", buscado);
		} catch (PuntajeNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testOrdenarPorInserccion() {
		escenario6();
		p.inOrden(p.getJugadores());
		p.ordenarPorInsercion();
		assertEquals("Brayan", p.getMejoresPuntajes().get(0).getNickName());
		assertEquals("Walter", p.getMejoresPuntajes().get(p.getMejoresPuntajes().size()-1).getNickName());
	}

}
