package modelo;

public class Jugador {
	
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

}
