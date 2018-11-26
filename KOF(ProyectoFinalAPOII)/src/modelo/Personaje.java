package modelo;

public class Personaje {
	
	private int posX;
	private int posY;
	private int areaX;
	private int areaY;
	private int vida;
	private boolean muerto;
	private boolean attack;
	private String skin;
	private Personaje siguiente;
	
	public Personaje(int posX, int posY, int vida, String skin) {
		this.posX = posX;
		this.posY = posY;
		this.vida = vida;
		this.skin=skin;
		this.muerto=false;
		this.attack=false;
	}
	/** 
	 * Metodos getters and setters de los atributos de la clase
	 * */
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
	
	public boolean isAttack() {
		return attack;
	}
	public void setAttack(boolean attack) {
		this.attack = attack;
	}
	
	/** 
	 * avanzar(int velocidad): este metodo permite cambiar la posicion del personaje, manipulado por el jugador 2, simulando el movimiento del mismo
	 * @param velocidad: int con la velocidad a la que se desplazara el personaje.
	 * */
	public void avanzarP2(int velocidad) {
		setPosX(posX-=velocidad);
	}
	
	/** 
	 * retroseder(int velocidad): este metodo permite cambiar la posicion del personaje,manipulado por el jugador 2, simulando el movimiento del mismo
	 * @param velocidad: int con la velocidad a la que se desplazara el personaje.
	 * */
	public void retrosederP2(int velocidad) {
		setPosX(posX+=velocidad);
	}
	
	/** 
	 * avanzar(int velocidad): este metodo permite cambiar la posicion del personaje, manipulado por el jugador 1, simulando el movimiento del mismo
	 * @param velocidad: int con la velocidad a la que se desplazara el personaje.
	 * */
	public void avanzarP1(int velocidad) {
		setPosX(posX+=velocidad);
	}
	
	
	/** 
	 * retroseder(int velocidad): este metodo permite cambiar la posicion del personaje,manipulado por el jugador 1, simulando el movimiento del mismo
	 * @param velocidad: int con la velocidad a la que se desplazara el personaje.
	 * */
	public void retrocederP1(int velocidad) {
		setPosX(posX-=velocidad);
	}
	
	
	/** 
	 * atacar():void 
	 * Este metodo permite que el personaje ataque, haciendo que la imagen se cambie 
	 * por la de una imagen en una postura de ataque
	 *
	 * */
	public void atacar() {
		if (isAttack()==false) {
			if (skin.equals(IConstantes.IORI_MOV_DER)) {
				setSkin(IConstantes.IORI_ATAQ_DER);
			}
			if (skin.equals(IConstantes.RYO_MOV_DER)) {
				setSkin(IConstantes.RYO_ATAQ_DER);
			}
			if (skin.equals(IConstantes.TERRY_MOV_DER)) {
				setSkin(IConstantes.TERRY_ATAQ_DER);
			}
			if (skin.equals(IConstantes.IORI_MOV_IZQ)) {
				setSkin(IConstantes.IORI_ATAQ_IZQ);
			}
			if (skin.equals(IConstantes.RYO_MOV_IZQ)) {
				setSkin(IConstantes.RYO_ATAQ_IZQ);
			}
			if (skin.equals(IConstantes.TERRY_MOV_IZQ)) {
				setSkin(IConstantes.TERRY_ATAQ_IZQ);
			}
			setAttack(true);
		}
	}
	
	/** 
	 * dejarDeatacar():void 
	 * Este metodo permite que el personaje deje de atacar, haciendo que la imagen se cambie 
	 * por la de una imagen en otra postura
	 *
	 * */
	public void dejarDeatacar() {
		if (skin.equals(IConstantes.IORI_ATAQ_DER)) {
			setSkin(IConstantes.IORI_MOV_DER);
		}
		if (skin.equals(IConstantes.RYO_ATAQ_DER)) {
			setSkin(IConstantes.RYO_MOV_DER);
		}
		if (skin.equals(IConstantes.TERRY_ATAQ_DER)) {
			setSkin(IConstantes.TERRY_MOV_DER);
		}
		if (skin.equals(IConstantes.IORI_ATAQ_IZQ)) {
			setSkin(IConstantes.IORI_MOV_IZQ);
		}
		if (skin.equals(IConstantes.RYO_ATAQ_IZQ)) {
			setSkin(IConstantes.RYO_MOV_IZQ);
		}
		if (skin.equals(IConstantes.TERRY_ATAQ_IZQ)) {
			setSkin(IConstantes.TERRY_MOV_IZQ);
		}
		setAttack(false);
	}
	
	
	public void muerte() {
		if (vida==0) {
			muerto=true;
		}
	}

}
