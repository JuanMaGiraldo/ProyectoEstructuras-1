package com.uniquindio.estructuradatos.proyecto.estructuras.pila;

import java.util.Iterator;

import com.uniquindio.estructuradatos.proyecto.estructuras.InterfaceEstructuraDatos;

/**
 * Clase encargada en la implementacion de pilas
 * 
 * @author Juan Manuel
 * @author Sebastian Caro
 *
 * @param <T>
 */
// conteins , clear, add, to string, iterador.
@SuppressWarnings("rawtypes")
public class Pila<T> implements Iterable, InterfaceEstructuraDatos {

	protected int cantidad;
	protected Nodo<T> primero;

	/**
	 * Constructor clase Pilas
	 */
	public Pila() {
		cantidad = 0;
	}

	/**
	 * Metodo el cual agrega un nodo a la pila
	 * 
	 * @param dato
	 *            dato el cual se agregara al nodo
	 */
	public void push(T dato) {
		Nodo<T> aux = new Nodo<T>(dato);
		if (isEmpty()) {
			primero = aux;
		} else {
			aux.setSiguiente(primero);
			primero = aux;
		}
		cantidad++;
	}

	/**
	 * Metodo el cual retorna el dato del primer nodo en la pila y lo elimina
	 * 
	 * @return retorna el dato del primer nodo de la pila
	 */
	public T pop() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		} else {
			T dato = primero.getDato();
			primero = primero.getSiguiente();
			cantidad--;
			return dato;
		}
	}

	/**
	 * Metodo el cual retorna el dato del primer nodo en la pila
	 * 
	 * @return retorna el dato del primer nodo de la pila
	 */
	public T top() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		} else {
			return primero.getDato();
		}
	}

	/**
	 * Metodo el cual retorna el tamaño de la pila
	 * 
	 * @return retorna tamaño de la pila
	 */
	public int size() {
		return cantidad;
	}

	/**
	 * Metodo el cual evalua si la pila esta vacia
	 * 
	 * @return retorna true si esta vacia, false de lo contrario
	 */
	public boolean isEmpty() {
		return cantidad == 0;
	}

	public Nodo<T> getPrimero() {
		return primero;
	}

	@Override
	public String toString() {
		String resultado = "[";
		String coma = "";
		Nodo<T> aux = primero;
		while (aux != null) {
			resultado += coma + aux.getDato();
			coma = ",";
			aux = aux.getSiguiente();
		}
		return resultado + "]";
	}

	@Override
	public Iterator iterator() {

		return new Iterador(this);
	}

}
