package com.uniquindio.estructuradatos.proyecto.estructuras.listasEnlazadas;

import java.util.Iterator;

public class Iterador<E> implements Iterator<E> {

	private ListasEnlazadas<E> lista;
	private int contador = 0;

	public Iterador(ListasEnlazadas<E> lista) {
		this.lista = lista;
	}

	@Override
	public boolean hasNext() {
		return contador < lista.size();
	}

	@Override
	public E next() {
		E dato = lista.get(contador++);
		
		return dato;
	}

}
