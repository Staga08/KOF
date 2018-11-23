package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import excepciones.JugadorYaRegistradoException;
import modelo.Jugador;
import modelo.Partida;

class PartidaTest {
	
	private Partida p;
	
	void escenario1() {
		p = new Partida();
	}
	
	@Test
	void agregarJugadoresTest() {
		escenario1();
		Jugador j1 = new Jugador("Matakito", 100);
		Jugador j2 = new Jugador("Jinx", 200);
		Jugador j3 = new Jugador("Ekko", 300);
		Jugador j4 = new Jugador("Ahri", 400);	
		p.agregarJugadores(p.getJugadores(), j1);
		p.agregarJugadores(p.getJugadores(), j2);
		p.agregarJugadores(p.getJugadores(), j3);
		p.agregarJugadores(p.getJugadores(), j4);
		assertEquals("Jinx", p.getJugadores().getDer().getNickName());
	}
// epa colombia

}
