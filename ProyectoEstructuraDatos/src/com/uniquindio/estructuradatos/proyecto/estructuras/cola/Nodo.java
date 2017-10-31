package com.uniquindio.estructuradatos.proyecto.estructuras.cola;

public class Nodo<T> {
	private T dato;
	private Nodo<T> siguiente;
	
	public Nodo(T dato) {
		this.dato = dato;
		siguiente = null;
	}
	
	public void setSiguiente(Nodo<T>siguiente) {
		this.siguiente = siguiente;
	}
	
	public Nodo<T> getSiguiente(){
		return siguiente;
	}

	public T getDato() {
		return dato;
	}
	
	public void setDato(T dato) {
		this.dato = dato;
	}

}
