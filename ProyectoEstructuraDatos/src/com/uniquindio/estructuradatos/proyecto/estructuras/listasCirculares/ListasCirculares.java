package com.uniquindio.estructuradatos.proyecto.estructuras.listasCirculares;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.uniquindio.estructuradatos.proyecto.estructuras.listasEnlazadas.Iterador;
import com.uniquindio.estructuradatos.proyecto.estructuras.listasEnlazadas.ListasEnlazadas;
import com.uniquindio.estructuradatos.proyecto.estructuras.listasEnlazadas.Nodo;

public class ListasCirculares<T> extends ListasEnlazadas<T> {

	/**
	 * Metodo el cual agrega un dato a una lista
	 * @param dato dato a ingresar
	 * @return retorna true si se pudo agregar satisfactoriamente
	 */
	public boolean add(T dato) {
		Nodo<T> aux = new Nodo<T>(dato);
		if (isEmpty()) {
			inicio = aux;
			fin = aux;
			inicio.setSiguiente(fin);
			fin.setSiguiente(inicio);
		} else {
			fin.setSiguiente(aux);
			aux.setSiguiente(inicio);
			fin = aux;
		}
		cantidad++;
		return true;
	}

	/**
	 * Metodo el cual borra un objecto de una lista
	  * @param dato objecto el cual se quiere borrar
	 * @return retorna true si se pudo borrar satisfactoriamente
	 */
	public boolean remove(Object dato) {
		Nodo<T> aux = inicio;
		Nodo<T> anterior = fin;
		boolean flag = true;
		while (flag) {
			if (aux.equals(anterior)) {
				flag = false;
			}
			if (aux.getDato().equals(dato)) {
				if (aux.equals(inicio)) {
					inicio = aux.getSiguiente();
					fin.setSiguiente(inicio);
					aux = null;

				} else {

					anterior.setSiguiente(aux.getSiguiente());
					if (aux.equals(fin)) {
						fin = anterior;
					}
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
	 * union entre colecciones. Esta lista queda con todo el contenido esta lista y
	 * la lista param
	 * @param param lista la cual se va a unir
	 * @return retorna true si el proceso se realizo satisfactoriamente
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

	/**
	 * Metodo el cual limpia la lista
	 */
	@Override
	public void clear() {
		inicio = null;
		cantidad = 0;
	}

	/**
	 * Metodo el cual busca si un objecto es contenido en la lista
	 * @param param objecto el cual se buscara si está contenido
	 * @return retorna true si el proceso se realizo satisfactoriamente
	 */
	@Override
	public boolean contains(Object param) {
		Nodo<T> aux = inicio;
		while (aux != null) {
			if (aux.getDato().equals(param)) {
				return true;
			}
			aux = aux.getSiguiente();
			if (aux.equals(inicio)) {
				return false;
			}
		}
		return false;
	}

	/**
	 * Verificar si se contienen todos los elementos de la coleccion que entra como
	 * parámetro
	 * @param param lista a comparar
	 * @return retorna true si contienen los mismos objectos, false de lo contrario
	 */
	@Override
	public boolean containsAll(Collection<?> param) {
		for (Object obj : param) {
			if (!(this.contains(obj))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Metodo el cual retorna un boolean si la lista esta vacia
	 * @return retorna true si esta vacia, false de lo contrario
	 * 
	 */
	@Override
	public boolean isEmpty() {

		return cantidad == 0;
	}

	/**
	 * Iterador de la lista el cual se necesita para recorrerse en el foreach
	 */
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterador(this);
	}

	/**
	 * Metodo el cual hace diferencia entre A y B. El contenido que entega B y A se borra en A
	 * @param param lista la cual se realizará la operacion
	 * @return retorna true si se realizo satisfactoriamente la operacion
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
	 * @param param lista la cual se realizará la operacion
	 * @return retorna true si se realizo satisfactoriamente la operacion
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

	/**
	 * Metodo el cual retorna el tamaño de la lista
	 * @return retorna tamaño de la lista
	 */
	@Override
	public int size() {
		return cantidad;
	}

	/**
	 * Metodo el cual genera un arreglo de objectos en los cuales se contienen los datos de los nodos de las listas
	 * @return retorna arreglo con los datos de la lista
	 */
	@Override
	public Object[] toArray() {
		Object[] array = new Object[cantidad];
		Nodo<T> aux = inicio;
		int pos = 0;
		boolean flag = true;
		while (flag) {
			if (aux.equals(fin)) {
				flag = false;
			}
			array[pos] = aux.getDato();
			aux = aux.getSiguiente();
			pos++;

		}
		return array;
	}
	/**
	 * Metodo el cual genera un arreglo de objectos en los cuales se contienen los datos de un arreglo enviado como 
	 * parametro
	 * @return retorna arreglo con los datos de la lista
	 */
	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] param) {

		Nodo<T> aux = (Nodo<T>) inicio;
		int pos = 0;
		boolean flag = true;
		while (flag) {
			if (aux.equals(fin)) {
				flag = false;
			}
			param[pos] = aux.getDato();
			aux = aux.getSiguiente();
			pos++;

		}
		return param;
	}

	/**
	 * Metodo el cual retorna una cadena de carecteres con informacion de la lista
	 * @return retorna una cadena de carecteres con informacion de la lista
	 */
	@Override
	public String toString() {
		String resultado = "[";
		String coma = "";
		Nodo<T> aux = inicio;
		boolean flag = true;
		while (flag) {
			if (aux.equals(fin)) {
				flag = false;
			}
			resultado += coma + aux.getDato();
			coma = ",";
			aux = aux.getSiguiente();
		}
		return resultado + "]";
	}

	/**
	 * Metodo el cual retorna un nodo dada una posicion
	 * @return retorna un nodo dada una posicion
	 */
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
	
	/**
	 * Metodo el cual agrega un nodo en una posicion indicada
	 * @param dato objecto el cual se va a almacenar
	 * @param index indice en el cual se pondrá el nodo 
	 * @return retorna true si la operacion se realizó
	 */
	public boolean agregar(T dato, int index) {
		if (index < 0 || index >= cantidad) {
			throw new IndexOutOfBoundsException(index + "");

		} else {
			Nodo<T> aux = new Nodo<T>(dato);
			Nodo<T> aux2 = getNodo(index);
			Nodo<T> anterior = null;
			if (index == 0) {
				anterior = getNodo(cantidad - 1);
				if (anterior != null) {
					anterior.setSiguiente(aux);
				}
				aux.setSiguiente(aux2);
				inicio = aux;
			} else {

				anterior = getNodo(index - 1);
				if (anterior != null) {
					anterior.setSiguiente(aux);

				}
				aux.setSiguiente(aux2);
				cantidad++;
			}

		}
		return true;
	}
	
	/**
	 * Metodo el cual encuentra en una lista ciruclar el entero mayor y el menor
	 * @return retorna un arrayList con informacion de cual es el mayor y el menor de la lista circular
	 */
	public ArrayList<String> contarMayorMenor() {

		int menor = (Integer) this.get(0);
		int mayor = 0;

		for (Object dato : this) {
			if ((Integer) dato > mayor) {
				mayor = (Integer) dato;
			}

			if ((Integer) dato < menor) {
				menor = (Integer) dato;
			}
		}

		ArrayList<String> result = new ArrayList<>();

		result.add(String.format("Mayor es: %s", mayor));
		result.add(String.format("Menor es: %s", menor));

		return result;
	}

	//main
	public static void main(String[] args) {
		ListasCirculares<Integer> lista = new ListasCirculares<Integer>();

		for (int i = 0; i < 7; i++) {
			lista.add(i);
		}
		System.out.println(lista);
		lista.agregar(8, 0);
		System.out.println(lista);

	}



}
