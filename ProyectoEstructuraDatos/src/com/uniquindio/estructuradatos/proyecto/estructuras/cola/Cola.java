package com.uniquindio.estructuradatos.proyecto.estructuras.cola;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

import com.uniquindio.estructuradatos.proyecto.estructuras.InterfaceEstructuraDatos;



public class Cola<T> implements  Iterable<T>,Queue<T>, InterfaceEstructuraDatos {
	private Nodo<T> primero;
	private Nodo<T> ultimo;
	private int cantidad;

	
	//NO USAMOS
	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override//NO USAMOS
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object dato) {
		Nodo<T> aux = primero;
		while(aux.getDato() !=(null)) {
			if(aux.getDato().equals(dato)) {
				return true;
			}
			aux = aux.getSiguiente();
		}
		return false;
	}

	@Override//NO USAMOS
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return cantidad == 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterador(this); 
	}

	@Override//NO USAMOS
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override//NO USAMOS
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override//NO USAMOS
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return cantidad;
	}

	@Override//NO USAMOS
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override//NO USAMOS
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(T dato) {
		Nodo<T> n = new Nodo<T>(dato);
		if (isEmpty()) {
			primero = n;
		} else {
			ultimo.setSiguiente(n);
		}
		ultimo = n;
		cantidad++;
		return true;

	}

	@Override//NO USAMOS
	public T element() {
		// TODO Auto-generated method stub
		return null;
	}
	//NO USAMOS
	@Override
	public boolean offer(T arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			return null;
		}
		return primero.getDato();
	}

	@Override
	public T poll() {
		if(isEmpty()) {
			return null;
		}
		else {
			T aux = primero.getDato();
			primero = primero.getSiguiente();
			cantidad --;
			return aux;			
		}
	}

	@Override//NO USAMOS
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public Nodo<T> getPrimero(){
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
	
	public static void main(String[] args) {
		Cola<Integer> c = new Cola<Integer>();
		c.add(1);
		c.add(2);
		c.add(3);
		c.add(4);
		c.add(5);
		for (Integer i: c) {
			System.out.println(i);
		}
	}
	
}
