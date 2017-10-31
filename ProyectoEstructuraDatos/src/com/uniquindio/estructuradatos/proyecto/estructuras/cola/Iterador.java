package com.uniquindio.estructuradatos.proyecto.estructuras.cola;

import java.util.Iterator;

public class Iterador<T> implements Iterator {

	private Cola<T> cola;
	private Nodo<T> aux;

	public Iterador(Cola<T> cola) {
		this.cola = cola;
		aux = cola.getPrimero();
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
