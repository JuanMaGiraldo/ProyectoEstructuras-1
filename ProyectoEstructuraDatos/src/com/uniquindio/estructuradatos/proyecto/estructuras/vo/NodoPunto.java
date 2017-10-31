package com.uniquindio.estructuradatos.proyecto.estructuras.vo;

public class NodoPunto {

	private int x;
	private int y;
	private int dato;
	private int enlaceX;
	private int enlaceY;
	private boolean isSelected;
	private int posLista;

	public NodoPunto(int x, int y, int dato) {
		posLista = -1;
		this.x = x;
		this.y = y;
		this.dato = dato;
		enlaceX = -1;
		enlaceY = -1;
		isSelected = false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public int getEnlaceX() {
		return enlaceX;
	}

	public void setEnlaceX(int enlaceX) {
		this.enlaceX = enlaceX;
	}

	public int getEnlaceY() {
		return enlaceY;
	}

	public void setEnlaceY(int enlaceY) {
		this.enlaceY = enlaceY;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public int getPosLista() {
		return posLista;
	}

	public void setPosLista(int posLista) {
		this.posLista = posLista;
	}
}
