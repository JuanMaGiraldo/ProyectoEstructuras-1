package com.uniquindio.estructuradatos.proyecto.estructuras.pila;

public class Nodo<T> {

	private T dato;
	private Nodo<T> siguiente;
	private Nodo<T> anterior;

	public Nodo(T dato) {
		this.dato = dato;
		siguiente = null;
		anterior = null;
	}

	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}

	public Nodo<T> getSiguiente() {
		return siguiente;
	}

	public void setAnterior(Nodo<T> anterior) {
		this.anterior = anterior;
	}

	public Nodo<T> getAnterior() {
		return anterior;
	}

	public T getDato() {
		return dato;
	}

}
