package modelo;

public class Personaje {
	
	private int posX;
	private int posY;
	private int areaX;
	private int areaY;
	private int vida;
	private boolean muerto;
	private String skin;
	private Personaje siguiente;
	
	public Personaje() {
		// TODO Auto-generated constructor stub
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getAreaX() {
		return areaX;
	}

	public void setAreaX(int areaX) {
		this.areaX = areaX;
	}

	public int getAreaY() {
		return areaY;
	}

	public void setAreaY(int areaY) {
		this.areaY = areaY;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public boolean isMuerto() {
		return muerto;
	}

	public void setMuerto(boolean muerto) {
		this.muerto = muerto;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public Personaje getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Personaje siguiente) {
		this.siguiente = siguiente;
	}

}
