package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import excepciones.JugadorYaRegistradoException;
import modelo.Jugador;
import modelo.Partida;

class PartidaTest {
	
	private Partida p;
	private Jugador j1;
	private Jugador j2;
	private Jugador j3;
	private Jugador j4;
	
	
	void escenario1() {
		p = new Partida();
	}
	
	void escenario2() {
		escenario1();
		 j1 = new Jugador("Matakito", 100);
		 j2 = new Jugador("Jinx", 200);
		 j3 = new Jugador("Ekko", 300);
		 j4 = new Jugador("Ahri", 400);
		
	}
	
	@Test
	void agregarJugadoresTest() {
		escenario2();
			
		p.agregarJugadores(p.getJugadores(), j1);
		p.agregarJugadores(p.getJugadores(), j2);
		p.agregarJugadores(p.getJugadores(), j3);
		p.agregarJugadores(p.getJugadores(), j4);
		assertEquals("Jinx", p.getJugadores().getDer().getNickName());
	}
// epa colombia

}
