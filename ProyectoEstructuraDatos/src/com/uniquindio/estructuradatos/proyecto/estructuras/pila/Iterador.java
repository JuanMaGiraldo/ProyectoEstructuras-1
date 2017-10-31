package com.uniquindio.estructuradatos.proyecto.estructuras.pila;

import java.util.Iterator;

public class Iterador<T> implements Iterator {

	private Pila<T> pilas;
	private Nodo<T> aux;

	public Iterador(Pila<T> pilas) {
		this.pilas = pilas;
		aux = pilas.getPrimero();
	}

	@Override
	public boolean hasNext() {

		return aux != null;
	}

	@Override
	public Object next() {
		T dato = aux.getDato();
		aux = aux.getSiguiente();
		return dato;
	}

}
