package com.uniquindio.estructuradatos.proyecto.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.uniquindio.estructuradatos.proyecto.estructuras.InterfaceEstructuraDatos;
import com.uniquindio.estructuradatos.proyecto.estructuras.cola.Cola;
import com.uniquindio.estructuradatos.proyecto.estructuras.listasDoblementeEnlazadas.ListasDE;
import com.uniquindio.estructuradatos.proyecto.estructuras.listasEnlazadas.ListasEnlazadas;
import com.uniquindio.estructuradatos.proyecto.estructuras.pila.Pila;
import com.uniquindio.estructuradatos.proyecto.estructuras.vo.*;
import com.uniquindio.estructuradatos.proyecto.ui.generic.NetCustomDialog;
import com.uniquindio.estructuradatos.proyecto.ui.generic.NetFrame;
import com.uniquindio.estructuradatos.proyecto.ui.generic.NetToogleButton;

/**
 * Clase la cual se encarga de la interfaz grafica para la representacion de
 * estruturas de datos lineales y no lineales.
 * 
 * @author Juan Manuel
 * @author Sebastian Caro
 *
 */
public class GraphicInterface extends NetFrame implements MouseListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Toolkit t = Toolkit.getDefaultToolkit();
	static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static int radio = 20;
	private ArrayList<NodoPunto> listaCentros;
	private JRadioButton radio1, radio2;
	private JMenuBar menu;
	private JMenu item, nuevo, datosLineales, datosNoLineales, lista;
	private int ancho = 1000;
	private int alto = 700;
	private boolean random = false;
	private JMenuItem cola, pila, grafo, arbolBinario, listaEnlazada, listaDEnlazada, cerrar;
	private JPanel panelLeft;
	private NetToogleButton btnFirst, btnContains;
	private NetToogleButton btnAdd, btnRemove;
	private InterfaceEstructuraDatos objectoEstructura;
	private boolean isSelectedAdd;
	private boolean isSelectedRemove;
	private boolean areButtonsEnabled;

	/**
	 * Constructor de la clase GraphicInterface.
	 */
	public GraphicInterface() {
		areButtonsEnabled = false;
		isSelectedAdd = false;
		isSelectedRemove = false;
		listaCentros = new ArrayList<NodoPunto>();
		// this.setBounds((int) (screenSize.getWidth() - ancho) / 2, (int)
		// (screenSize.getHeight() - alto) / 2, ancho,
		// alto);
		// this.setLayout(null);
		// this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		crearComponentes();
	}

	/**
	 * Metodo el cual crea todas las componentes visuales a la hora de ejecutar la
	 * interfaz
	 */
	public void crearComponentes() {

		panelLeft = new JPanel();
		panelLeft.setBounds(0, 25, 200, alto);
		panelLeft.setBackground(new Color(0, 0, 0));
		panelLeft.setLayout(null);
		panelLeft.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3)));
		
		JPanel panelInferior = new JPanel();
		panelInferior.setLayout(null);
		panelInferior.setBackground(Color.WHITE);
		panelInferior.setBounds(panelLeft.getX() + 10,this.getHeight() - 200, panelLeft.getWidth() - 20, 120);
		
		ButtonGroup bg;
		bg = new ButtonGroup();

		radio1 = new JRadioButton("Ingreso de datos");
		radio1.setBounds(5, 20, 150, 30);
		radio1.setSelected(true);
		radio1.setBackground(Color.WHITE);
		
		bg.add(radio1);
		radio2 = new JRadioButton("Datos aleatorios");
		radio2.setBounds(5, 60, 150, 30);
		radio2.setBackground(Color.WHITE);
		
		bg.add(radio2);
		radio1.addActionListener(this);
		radio2.addActionListener(this);

		panelInferior.add(radio1);
		panelInferior.add(radio2);
		panelInferior.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2)));
		panelLeft.add(panelInferior);
		// Barra

		JPanel central = new JPanel();
		central.setBounds(panelLeft.getWidth() + 20, 40, this.getWidth() - 250, alto - 52);
		central.setBackground(Color.white);
		central.setLayout(null);
		Border bordejpanel = new TitledBorder(new EtchedBorder(), "Dibujar");
		central.setBorder(bordejpanel);

		menu = new JMenuBar();
		menu.setBounds(180, 39, 222, 222);
		item = new JMenu("Archivo");
		nuevo = new JMenu("Nuevo");
		cerrar = new JMenuItem("Cerrar");
		cerrar.addActionListener(this);
		datosLineales = new JMenu("Datos Lineales");
		datosNoLineales = new JMenu("Datos no Lineales");
		lista = new JMenu("Lista");
		lista.addActionListener(this);
		listaEnlazada = new JMenuItem("Lista Enlazada");
		listaEnlazada.addActionListener(this);
		listaDEnlazada = new JMenuItem("Lista Doblemente Enlazada");
		listaDEnlazada.addActionListener(this);
		lista.add(listaEnlazada);
		lista.add(listaDEnlazada);
		cola = new JMenuItem("Cola");
		cola.addActionListener(this);
		pila = new JMenuItem("Pila");
		pila.addActionListener(this);
		grafo = new JMenuItem("Grafo");
		grafo.addActionListener(this);
		arbolBinario = new JMenuItem("Arbol Binario");
		arbolBinario.addActionListener(this);

		datosLineales.add(lista);
		datosLineales.add(cola);
		datosLineales.add(pila);
		datosNoLineales.add(grafo);
		datosNoLineales.add(arbolBinario);
		menu.add(item);
		item.add(nuevo);
		item.add(cerrar);

		nuevo.add(datosLineales);
		nuevo.add(datosNoLineales);
		this.setJMenuBar(menu);

		this.addMouseListener(this);
		crearBotones();
		this.getContentPane().add(central);
		this.getContentPane().add(panelLeft);

	}

	/**
	 * Crea los botones en los cuales el usuario iterara para realizar operaciones
	 * con la estrucutra de datos
	 */
	public void crearBotones() {

		btnAdd = new NetToogleButton();
		btnAdd.setText("Add");
		btnAdd.setBounds(20, 50, 160, 50);
		btnAdd.addActionListener(this);

		btnRemove = new NetToogleButton();
		btnRemove.setText("Remove");
		btnRemove.setBounds(20, 130, 160, 50);
		btnRemove.addActionListener(this);

		btnFirst = new NetToogleButton();
		btnFirst.setText("First");
		btnFirst.addActionListener(this);
		btnFirst.setBounds(20, 210, 160, 50);

		btnContains = new NetToogleButton();
		btnContains.setText("Contains");
		btnContains.addActionListener(this);
		btnContains.setBounds(20, 290, 160, 50);

		panelLeft.add(btnAdd);
		panelLeft.add(btnRemove);
		panelLeft.add(btnFirst);
		panelLeft.add(btnContains);

		btnAdd.setVisible(false);
		btnRemove.setVisible(false);
		btnFirst.setVisible(false);
		btnContains.setVisible(false);

	}

	/**
	 * Crea los botones para iteractuar con la estructura de datos cola
	 */
	public void initButtonsCola() {
		limpiarGraphics();
		btnAdd.setText("Add");
		btnRemove.setText("Poll");
		btnFirst.setText("Peek");
		listaCentros = new ArrayList<>();
		objectoEstructura = new Cola();
	}

	/**
	 * Crea los botones para iteractuar con la estructura de datos pila
	 */
	public void initButtonsPila() {
		limpiarGraphics();
		btnFirst.setLocation(20, 210);
		btnContains.setLocation(20, 290);
		btnAdd.setText("Push");
		btnRemove.setText("Pop");
		btnFirst.setText("Top");
		listaCentros = new ArrayList<>();
		objectoEstructura = new Pila();
	}

	/**
	 * Crea los botones para iteractuar con la estructura de datos lista
	 */
	public void initButtonsLista(int tipoLista) {
		limpiarGraphics();
		btnAdd.setText("Add");
		btnRemove.setText("Remove");
		btnFirst.setText("First");
		listaCentros = new ArrayList<>();
		objectoEstructura = (tipoLista == 1) ? new ListasEnlazadas<>() : new ListasDE<>();
	}

	/**
	 * Metodo el cual muestra los botones de iteracion las estructuras de datos
	 */
	public void turnOnButtons() {
		btnAdd.setVisible(true);
		btnRemove.setVisible(true);
		btnFirst.setVisible(true);
		btnContains.setVisible(true);
		areButtonsEnabled = true;
	}

	/**
	 * Limpia el tablero y resetea los botones
	 */
	public void limpiarGraphics() {
		Graphics g = getGraphics();
		g.clearRect(panelLeft.getWidth() + 50, 80, ancho - 600, alto - 100);

		listaCentros = new ArrayList<NodoPunto>();
		btnAdd.setSelected(false);
		btnRemove.setSelected(false);
		isSelectedAdd = false;
		isSelectedRemove = false;

	}

	/**
	 * Metodo el cual recibe los eventos de click
	 */
	@Override
	public void mouseClicked(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();
		int nodo = indexNodoSeleccionado(x, y);

		if (event.getX() > 220 && event.getX() < ancho - 60) {
			if (event.getY() > 80 && event.getY() < alto - 30) {
				if (nodo == -1) { // click sobre un vacio
					if (isSelectedAdd) {
						agregarNodo(x, y);
					}
				} else {
					if (isSelectedRemove) {
						eliminarNodo(nodo); // click sobre un nodo y remove seleccionado
					}

					if (!isSelectedRemove) {
						seleccionarNodo(nodo); // el click fue dado en un lugar vac�o ( click sobre nodo)
												// y el remove no es seleccionado
					}
				}
			}
		}
		// System.out.println(((ListasEnlazadas) objectoEstructura).toString());
		actualizarInterfaz();
	}

	/**
	 * Metodo encargado de agregar un nodo dada sus pociosiones
	 * 
	 * @param x
	 *            posicion en x
	 * @param y
	 *            posicion en y
	 */
	public void agregarNodo(int x, int y) {

		int valor;
		if (random) {

			valor = (int) ((Math.random() * 400) + 1);
		} else {
			InputValueFrame frame = new InputValueFrame(this, "Ingresar valor del nodo", new Dimension(500, 100));
			valor = frame.getAnswer();
		}

		listaCentros.add(new NodoPunto(x, y, valor));

	}

	/**
	 * Metodo el cual elminina un nodo
	 * 
	 * @param nodo
	 *            index en el arreglo de nodos
	 */
	public void eliminarNodo(int nodo) {

		NodoPunto puntoABorrar = listaCentros.get(nodo);
		int posLista = puntoABorrar.getPosLista();
		if (posLista != -1) {

			if (objectoEstructura instanceof ListasEnlazadas) {
				ListasEnlazadas lista = ((ListasEnlazadas) objectoEstructura);
				int ultimoNodo = lista.size() - 1;
				if ((posLista == ultimoNodo && posLista > 0)) {
					listaCentros.get(indexLista(posLista - 1)).setEnlaceX(-1);
					listaCentros.get(indexLista(posLista - 1)).setEnlaceY(-1);
				}
				if (posLista > 0 && posLista < ultimoNodo) {
					cambiarRelacionMedios(posLista);
				}
				disminuirPosicion(posLista);

				lista.remove(puntoABorrar.getDato());
			}

		}
		listaCentros.remove(nodo);
	}

	/**
	 * Metodo el cual dado un nodo, lo selecciona agregando a la lista de nodos
	 * seleccionados y lo pinta de color verde para ser identificado en la interfaz
	 * 
	 * @param nodo
	 *            index del nodo en la lista de nodos
	 */
	public void seleccionarNodo(int nodo) {

		clickSobreNodo(nodo);
		if (nodosSeleccionados() == 2) {
			int index1 = -1;
			int index2 = -1;
			int c = 0;
			for (NodoPunto nodoPunto : listaCentros) {
				if (nodoPunto.isSelected()) {
					if (index1 == -1) {
						index1 = c;
					} else {
						index2 = c;
						break;
					}
				}
				c++;
			}
			if (objectoEstructura.size() > 0) {

				int relacion = existeRelacion(index1, index2);
				if (relacion != 0) {
					if (relacion == 1) {
						listaCentros.get(index2).setEnlaceX(listaCentros.get(index1).getX());
						listaCentros.get(index2).setEnlaceY(listaCentros.get(index1).getY());
						listaCentros.get(index1).setPosLista(objectoEstructura.size());
						((ListasEnlazadas) objectoEstructura).add(listaCentros.get(index1).getDato());
					} else {
						listaCentros.get(index1).setEnlaceX(listaCentros.get(index2).getX());
						listaCentros.get(index1).setEnlaceY(listaCentros.get(index2).getY());
						listaCentros.get(index2).setPosLista(objectoEstructura.size());
						((ListasEnlazadas) objectoEstructura).add(listaCentros.get(index2).getDato());
					}

				} else {
					new NetCustomDialog("No se pudo realizar la conexion", new Dimension(400, 50));
					// JOptionPane.showMessageDialog(null, "No se pudo realizar la conexion");
				}

			}

			else {
				new NetCustomDialog("Debe declarar el nodo inicial dando doble click sobre él.",
						new Dimension(600, 80));
				// JOptionPane.showMessageDialog(null, "Debe declarar el nodo inicial \ndando
				// doble click sobre �l.");
			}

			listaCentros.get(index1).setSelected(false);
			listaCentros.get(index2).setSelected(false);
			actualizarInterfaz();
		}

	}

	/**
	 * Metodo el cual retorna el numero de nodos seleccionados en el tablero
	 * 
	 * @return numero de nodos seleccionados
	 */
	public int nodosSeleccionados() {
		int c = 0;
		for (NodoPunto nodoPunto : listaCentros) {
			if (nodoPunto.isSelected()) {
				c++;
			}
		}
		return c;
	}

	/**
	 * Metodo el cual al borrar un nodo intermedio, este une el anterior a �l con el
	 * siguiente de �l
	 * 
	 * @param medio
	 *            index del nodo en el arreglo de estruturas
	 */
	public void cambiarRelacionMedios(int medio) {
		int anterior = -1;
		int siguiente = -1;
		int c = 0;
		for (int i = 0; i < listaCentros.size(); i++) {
			int pos = listaCentros.get(i).getPosLista();
			if (c != 2) {
				if (pos == (medio - 1)) {
					anterior = i;
					c++;
				}
				if (pos == (medio + 1)) {
					siguiente = i;
					c++;
				}
			} else {
				break;
			}
		}
		listaCentros.get(anterior).setEnlaceX(listaCentros.get(siguiente).getX());
		listaCentros.get(anterior).setEnlaceY(listaCentros.get(siguiente).getY());

	}

	/**
	 * Metodo el cual despues de borrar un nodo intermedio, pone los que sigue
	 * delante de �l un puesto atras
	 * 
	 * @param pivote
	 *            pivote en el cual empezar a disminuir la posicion y realizar
	 *            cambios de enlaces en la lista principal
	 */
	public void disminuirPosicion(int pivote) {

		for (int i = 0; i < listaCentros.size(); i++) {
			int pos = listaCentros.get(i).getPosLista();
			if (pos > pivote) {
				listaCentros.get(i).setPosLista(pos - 1);
			}
		}
	}

	/**
	 * Metodo el cual dado un index de la lista de enlazes, retorna la posicion en
	 * la cual se encuentra el nodo en la lista de centros
	 * 
	 * @return
	 */
	public int indexLista(int index) {
		int i = 0;
		for (; i < listaCentros.size(); i++) {
			if (listaCentros.get(i).getPosLista() == index) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Metodo el cual pinta los nodos y relaciones en el tablero
	 */
	public void actualizarInterfaz() {
		Graphics g = getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(panelLeft.getWidth() + 30, 80, this.getWidth() - 260, alto - 85);
		for (NodoPunto nodoPunto : listaCentros) {

			if (nodoPunto.getEnlaceX() != -1) {
				pintarLinea(nodoPunto.getX(), nodoPunto.getY(), nodoPunto.getEnlaceX(), nodoPunto.getEnlaceY());
			}
		}
		for (NodoPunto nodoPunto : listaCentros) {
			Color color;
			if (nodoPunto.isSelected()) {
				color = Color.green;
			} else {

				color = new Color(36, 80, 175);

			}
			pintarCirculoG(nodoPunto.getX(), nodoPunto.getY(), color);
			((Graphics2D) g).setColor(Color.BLACK);
			Font fuente = new Font("Monospaced", Font.BOLD, 16);
			g.setFont(fuente);
			String valor = "";
			int posicionNodo = nodoPunto.getPosLista();
			if (posicionNodo == 0) {
				valor = "inicio: ";
			}
			if (posicionNodo == (objectoEstructura.size() - 1) && posicionNodo != -1) {
				valor += "fin: ";
			}
			((Graphics2D) g).drawString(valor + nodoPunto.getDato() + "", nodoPunto.getX(), nodoPunto.getY());

		}

	}

	/**
	 * Metodo el cual comprueba si dos nodos seleccionados pueden realizar una
	 * conexion
	 * 
	 * @param index1
	 *            posicion del primer nodo seleccionado
	 * @param index2
	 *            posicion del segundo nodo seleccionado
	 * @return retorna 1 si la conexi�n se debe realizar con el nodo 1, 2 si se debe
	 *         realizar con el 2, � 0 si no se puede realizar la conexi�n con ning�n
	 *         nodo, esto puede ser debido a que ninguno de los dos estan en la
	 *         lista de relaciones siendo el ultimo � ambos lo esten
	 */
	public int existeRelacion(int index1, int index2) {

		int posLista1 = listaCentros.get(index1).getPosLista();
		int posLista2 = listaCentros.get(index2).getPosLista();
		if (posLista1 == (objectoEstructura.size() - 1)) {
			if (posLista2 == -1) {
				return 2;
			}
		}
		if (posLista2 == (objectoEstructura.size() - 1)) {
			if (posLista1 == -1) {
				return 1;
			}
		}
		return 0;

	}

	/**
	 * Metodo el cual retorna el index del nodo en el arreglo de puntos, si este
	 * punto no le da encima de ningun nodo, retorna -1;
	 * 
	 * @param x
	 *            pos x del evento
	 * @param y
	 *            pos y del evento
	 * @return retorna la posicion del nodo seleccionado, -1 si el evento no dio
	 *         click encima de un nodo existente
	 */
	public int indexNodoSeleccionado(int x, int y) {

		NodoPunto point = null;
		for (int i = 0; i < listaCentros.size(); i++) {
			point = listaCentros.get(i);

			if ((point.getX() - radio) <= x && x <= (point.getX() + radio * 2)) {
				if ((point.getY() - radio) <= y && y <= (point.getY() + radio * 2)) {

					return i;
				}
			}

		}

		return -1;
	}

	public int retornarPrimerDato() {
		int dato = 0;
		for (NodoPunto nodoPunto : listaCentros) {
			if (nodoPunto.getPosLista() == 0) {
				dato = nodoPunto.getDato();
				break;
			}
		}
		return dato;
	}

	/**
	 * Metodo el cual al dar click sobre el boton contains, este muestra una ventana
	 * la cual se ingresara el valor a buscar en el listado de relaciones
	 */
	public void clickButtonContains() {
		int valor = 0;
		int indexValorEnLista;

		InputValueFrame frame = new InputValueFrame(this,
				"<html><body>Ingrese el dato a buscar en la lista<br>de relaciones:</body></html>",
				new Dimension(500, 200));
		
		valor = frame.getAnswer();
		
		if (!frame.getException()) {
			indexValorEnLista = indexDatoRelacion(valor);
			if (indexValorEnLista != -1) {
				new NetCustomDialog(
						"<html><body>El dato esta contenido en la lista de relaciones<br>su posición es:</body></div>",
						new Dimension(500, 100));
				/*
				 * JOptionPane.showMessageDialog(null,
				 * "El dato esta contenido en la lista de relaciones\nsu posici�n es:   " +
				 * indexValorEnLista);
				 */
			} else {
				new NetCustomDialog(
						"<html><body>El dato no se encuentra contenido en la lista<br>de relaciones.</body></div>",
						new Dimension(500, 100));
				/*
				 * JOptionPane.showMessageDialog(null,
				 * "El dato no se encuentra contenido en la lista\nde relaciones.");
				 */
			}
		} else {
			new NetCustomDialog(
					"<html><body>El dato digitado no es de tipo entero,<br>por lo tanto no se realizá la busqueda.</body></div>",
					new Dimension(500, 100));
			/*
			 * JOptionPane.showMessageDialog(null,
			 * "El dato digitado no es de tipo entero,\npor lo tanto no se realiz� la busqueda."
			 * );
			 */
		}

	}

	public void clickButtonFirst() {
		if (objectoEstructura.size() == 0) {
			new NetCustomDialog("<html><body>No se ha definido el inicio de la estructura<br>de datos.</body></div>",
					new Dimension(500, 100));
			// JOptionPane.showMessageDialog(null, "No se ha definido el inicio de la
			// estructura\nde datos.");
		} else {
			int dato = retornarPrimerDato();
			new NetCustomDialog("<html><body>El primer dato de la estructura de datos es: " + dato + "</body></div>",
					new Dimension(500, 100));
			// JOptionPane.showMessageDialog(null, "El primer dato de la estructura de datos
			// es: " + dato);
		}
	}

	/**
	 * Metodo el cual busca si un dato de tipo int esta contenido en la lista de
	 * enlaces
	 * 
	 * @param dato
	 *            dato el cual se buscar� en la lista de enlaces
	 * @return retorna true si esta contenido en la lista de enlaces, false de lo
	 *         contrario.
	 */
	public int indexDatoRelacion(int dato) {

		for (NodoPunto nodoPunto : listaCentros) {
			int posicionNodo = nodoPunto.getPosLista();
			if (posicionNodo != -1) {
				if (nodoPunto.getDato() == dato) {
					return posicionNodo + 1;
				}
			}

		}
		return -1;
	}

	/**
	 * metodo paint
	 */
	public void paint(Graphics g) {
		super.paint(g);

	}

	/**
	 * Pinta una linea entre dos nodos seleccionados
	 * 
	 * @param x1
	 *            x inicial de la linea
	 * @param y1
	 *            y inicial de la linea
	 * @param x2
	 *            x final de la linea
	 * @param y2
	 *            y fianl de la linea
	 */
	public void pintarLinea(int x1, int y1, int x2, int y2) {
		Graphics g = getGraphics();
		g.drawLine(x1 + radio / 2, y1 + radio / 2, x2 + radio / 2, y2 + radio / 2);
		// las pinta desde el centro de cada nodo
	}

	/**
	 * Metodo el cual pinta un cirulo como nodo en el tablero Graphics
	 * 
	 * @param x
	 *            posicion en x donde se pintar� el circulo
	 * @param y
	 *            posicion en y donde se pintar� el circulo
	 * @param color
	 *            si es un nodo no seleccionado -> Color.blue; si es un nodo
	 *            seleccionado -> Color.green
	 */
	public void pintarCirculoG(int x, int y, Color color) {
		Graphics g = getGraphics();

		g.setColor(color);
		g.fillOval(x, y, radio, radio);

		((Graphics2D) g).setStroke(new BasicStroke(4));
		((Graphics2D) g).setColor(Color.BLACK);
		((Graphics2D) g).drawOval(x, y, radio, radio);

	}

	/**
	 * Metodo el cual decide que hq ssssssqw q ws qsacer cuando un nodo es clickeado
	 * 
	 * @param nodo
	 *            index del nodo en la lista de centros del tablero
	 * 
	 */
	public void clickSobreNodo(int nodo) {

		if (listaCentros.get(nodo).isSelected()) {
			// deseleccionar un nodo
			listaCentros.get(nodo).setSelected(false);
			// si no se ha definido el inicio, este queda definido como inicio al darle
			// doble click
			if (objectoEstructura.size() == 0) {

				if (objectoEstructura instanceof ListasEnlazadas) {
					ListasEnlazadas aux = (ListasEnlazadas) objectoEstructura;
					aux.add(listaCentros.get(nodo).getDato());
					listaCentros.get(nodo).setPosLista(0);
				}
			}
		} else {

			listaCentros.get(nodo).setSelected(true);
		}

	}

	/**
	 * Metodo el cual verifica si la lista esta bien creada, esto pasa si el arreglo
	 * es conexo, dado que ningun nodo queda sin conexi�n a la estructura
	 * 
	 * @return true si est� bien creada, false de lo contrario
	 */
	public boolean estaBienCreada() {

		return objectoEstructura.size() == listaCentros.size();
	}

	@Override
	/**
	 * Clase la cual recibe los eventos de click en el JFrame
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(cola)) {
			if (!areButtonsEnabled) {
				turnOnButtons();
			}
			objectoEstructura = new Cola();
			initButtonsCola();
		} else if (e.getSource().equals(pila)) {
			if (!areButtonsEnabled) {
				turnOnButtons();
			}
			objectoEstructura = new Pila();
			initButtonsPila();
		} else if (e.getSource().equals(listaEnlazada)) {
			if (!areButtonsEnabled) {
				turnOnButtons();
			}
			objectoEstructura = new ListasEnlazadas<Integer>();
			initButtonsLista(1);
		} else if (e.getSource().equals(listaDEnlazada)) {
			if (!areButtonsEnabled) {
				turnOnButtons();
			}
			objectoEstructura = new ListasDE<Integer>();
			initButtonsLista(2);
		} else if (e.getSource().equals(radio1)) {
			random = false; // Ingreso datos
		} else if (e.getSource().equals(radio2)) {
			random = true; // Modo datos aleatorios
		} else if (e.getSource().equals(cerrar)) {
			this.dispose();
		} else if (e.getSource() == btnAdd) {
			if (btnAdd.isSelected()) {
				isSelectedAdd = true;
				isSelectedRemove = false;
				btnRemove.setSelected(false);
			} else {
				isSelectedAdd = false;

			}
		} else if (e.getSource() == btnRemove) {
			if (btnRemove.isSelected()) {
				isSelectedRemove = true;
				isSelectedAdd = false;
				btnAdd.setSelected(false);
			} else {
				isSelectedRemove = false;
			}

		} else if (e.getSource() == btnFirst) {
			clickButtonFirst();
		} else if (e.getSource() == btnContains) {
			clickButtonContains();
		}
	}
}
