package com.uniquindio.estructuradatos.proyecto.estructuras.listasDoblementeEnlazadas;

import com.uniquindio.estructuradatos.proyecto.estructuras.listasEnlazadas.ListasEnlazadas;
import com.uniquindio.estructuradatos.proyecto.estructuras.listasEnlazadas.Nodo;

public class ListasDE<T> extends ListasEnlazadas<T> {

	public boolean add(T dato) {
		Nodo<T> aux = new Nodo<T>(dato);
		if (isEmpty()) {
			inicio = aux;
		} else {
			fin.setSiguiente(aux);
			aux.setAnterior(fin);
		}
		fin = aux;
		cantidad++;
		return true;
	}

	/**
	 * Metodo el cual dado un datoetro como dato, este lo almacena en una posicion
	 * especifica
	 * 
	 * @dato dato dato el cual se va a almacenar
	 * @dato index posicion en la cual se va a almacenar el dato
	 * @return true si se almaceno satisfatoriamente
	 */
	public boolean agregar(T dato, int index) {
		if (index < 0 || index >= cantidad) {
			throw new IndexOutOfBoundsException(index + "");

		} else {
			Nodo<T> aux = new Nodo<T>(dato);
			Nodo<T> aux2 = getNodo(index);

			if (index == 0) {
				aux.setSiguiente(aux2);
				inicio = aux;
				aux2.setAnterior(aux);
			} else {

				Nodo<T> anterior = getNodo(index - 1);
				if (anterior != null) {
					anterior.setSiguiente(aux);
					anterior.setAnterior(anterior);

				}
				aux.setSiguiente(aux2);
				aux2.setAnterior(aux);
				cantidad++;
			}
		}
		return true;

	}

	@SuppressWarnings("null")
	public boolean remove(Object dato) {
		Nodo<T> aux = inicio;
		Nodo<T> anterior = null;

		while (aux != null) {
			if (aux.getDato().equals(dato)) {
				if (anterior == null) {
					inicio = inicio.getSiguiente();
					inicio.setAnterior(null);
					aux = null;
				} else {
					anterior.setSiguiente(aux.getSiguiente());
					if (aux.getSiguiente() == null) {
						fin = anterior;
						aux = null;
					} else {
						aux.getSiguiente().setAnterior(anterior);
						aux = null;
					}

				}
				cantidad--;
				return true;
			}
			aux = anterior;
			aux = aux.getSiguiente();
		}
		return false;
	}

	public static void main(String[] args) {
		ListasDE<Integer> lista = new ListasDE<Integer>();

		for (int i = 0; i < 7; i++) {
			lista.add(i);
		}
		System.out.println(lista);
		lista.agregar(6, 6);
		System.out.println(lista);

	}

}
