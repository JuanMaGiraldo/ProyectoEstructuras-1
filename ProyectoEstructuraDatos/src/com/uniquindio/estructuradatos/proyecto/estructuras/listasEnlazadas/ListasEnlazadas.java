package com.uniquindio.estructuradatos.proyecto.estructuras.listasEnlazadas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.uniquindio.estructuradatos.proyecto.estructuras.InterfaceEstructuraDatos;

public class ListasEnlazadas<T> implements Collection<T>, InterfaceEstructuraDatos {

	protected Nodo<T> inicio;
	protected Nodo<T> fin;
	protected int cantidad;

	public ListasEnlazadas() {
		cantidad = 0;
	}

	@Override
	public boolean add(T param) {
		Nodo<T> aux = new Nodo<T>(param);
		if (isEmpty()) {
			inicio = aux;
		} else {
			fin.setSiguiente(aux);
		}
		fin = aux;
		cantidad++;
		return true;
	}

	/**
	 * union entre colecciones. Esta lista queda con todo el contenido esta lista y
	 * la lista param
	 */
	@Override
	public boolean addAll(Collection<? extends T> param) {
		for (T t : param) {
			if (!(this.contains(t))) {
				this.add(t);
			}
		}
		return false;
	}

	@Override
	public void clear() {
		inicio = null;
		cantidad = 0;
	}

	@Override
	public boolean contains(Object param) {
		Nodo<T> aux = inicio;
		while (aux != null) {
			if (aux.getDato().equals(param)) {
				return true;
			}
			aux = aux.getSiguiente();
		}
		return false;
	}

	/**
	 * Verificar si se contienen todos los elementos de la coleccion que entra como
	 * parámetro
	 */
	@Override
	public boolean containsAll(Collection<?> param) {
		for (T dato : this) {
			if (!(param.contains(dato))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty() {

		return cantidad == 0;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterador(this);
	}

	@Override
	public boolean remove(Object param) {
		Nodo<T> aux = inicio;
		Nodo<T> anterior = null;
		while (aux != null) {
			if (aux.getDato().equals(param)) {
				if (anterior == null) {

					inicio = aux.getSiguiente();
					aux = null;
				} else if (aux.getSiguiente() == null) {
					anterior.setSiguiente(null);
					fin = anterior;
					aux = null;
				} else {
					anterior.setSiguiente(aux.getSiguiente());
					aux = null;
				}
				cantidad--;
				return true;
			}
			anterior = aux;
			aux = aux.getSiguiente();

		}
		return false;

	}

	/**
	 * Diferencia entre A y B El contenido que entega B y A
	 */
	@Override
	public boolean removeAll(Collection<?> param) {

		for (Object object : param) {
			this.remove(object);

		}
		return true;
	}

	/**
	 * Interseccion entre conjuntos Lo que tenga en comun A y B se queda en A
	 */
	@Override
	public boolean retainAll(Collection<?> param) {

		ArrayList<Object> listaElementos = new ArrayList<Object>();

		for (T arg : this) {
			if (!(param.contains(arg))) {
				listaElementos.add(arg);
			}
		}
		this.removeAll(listaElementos);

		return true;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[cantidad];
		Nodo<T> aux = inicio;
		int pos = 0;
		while (aux != null) {
			array[pos] = aux.getDato();
			aux = aux.getSiguiente();
			pos++;
		}
		return array;
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] param) {

		Nodo<T> aux = (Nodo<T>) inicio;
		int pos = 0;
		while (aux != null) {
			param[pos] = aux.getDato();
			aux = aux.getSiguiente();
			pos++;
		}
		return param;
	}

	@Override
	public String toString() {
		String resultado = "[";
		String coma = "";
		Nodo<T> aux = inicio;
		while (aux != null) {
			resultado += coma + aux.getDato();
			coma = ",";
			aux = aux.getSiguiente();
		}
		return resultado + "]";
	}

	public T get(int index) {
		if (index < 0 || index >= cantidad) {
			throw new IndexOutOfBoundsException("out");
		}
		Nodo<T> aux = inicio;
		for (int i = 0; i < index; i++) {
			aux = aux.getSiguiente();
		}
		return aux.getDato();
	}

	public int contador(Collection<?> param, T dato) {
		int cont = 0;

		for (Object obj : param) {
			if (obj.equals(dato)) {
				cont++;
			}
		}

		return cont;
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
			} else {

				Nodo<T> anterior = getNodo(index - 1);
				if (anterior != null) {
					anterior.setSiguiente(aux);

				}
				aux.setSiguiente(aux2);
				cantidad++;
			}

		}
		return true;
	}

	public Nodo<T> getNodo(int index) {
		Nodo<T> aux = null;

		int pos = 0;
		aux = inicio;
		while (pos != index) {
			aux = aux.getSiguiente();
			pos++;
		}

		return aux;
	}

	public void eliminarRepetidos() {
		int cont;
		for (T dato : this) {
			cont = 0;
			for (T dato2 : this) {
				if (dato.equals(dato2)) {
					cont++;
				}
			}

			for (int i = 0; i < cont - 1; i++) {
				this.remove(dato);
			}

		}
	}

	public void generarAleatorios(int tam) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < tam; i++) {

			list.add((int) ((Math.random() * 100) + 1));
		}
	}

	public void generarAleatorios(Collection<?> lista, int tam) {
		for (int i = 0; i < tam; i++) {
			// lista.add((int) ((Math.random() * 100) + 1));
		}

	}

	public static void main(String[] args) {
		int j2;
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 1; j++) {
				for (j2 = 0; j2 < 6; j2++) {
					System.out.println(i + j + j2);
					break;
				}
				System.out.println(i + j + j2);
			}
		}
	}

	@Override
	public int size() {
		return cantidad;
	}

}
