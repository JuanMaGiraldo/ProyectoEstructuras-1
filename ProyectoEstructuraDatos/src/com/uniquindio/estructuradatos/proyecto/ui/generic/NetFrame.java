package com.uniquindio.estructuradatos.proyecto.ui.generic;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @web http://www-jc-mouse.net/
 * @author mouse
 */
public class NetFrame extends JFrame implements MouseListener, MouseMotionListener {

	private int x, y;
	private static final long serialVersionUID = 1L;
	private NetButton minimizar;
	private NetButton cerrar;
	private JLabel label;

	public NetFrame() {
		this.setResizable(false);
		this.setUndecorated(true);
		this.setBounds(0, 0, 1000, 700);
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		this.setLocationRelativeTo(null);
		getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(162, 183, 188)));

		initComponents();
	}

	public void initComponents() {

		label = new JLabel();
		label.setBounds(0, 0, this.getWidth(), 30);
		label.setBackground(Color.GRAY);
		label.setOpaque(true);
		label.addMouseListener(this);
		label.addMouseMotionListener(this);

		minimizar = new NetButton();
		minimizar.setBounds(this.getWidth() - 69, 0, 30, 30);
		minimizar.setText("-");
		minimizar.setFocusable(false);
		minimizar.addMouseListener(this);
		minimizar.addMouseMotionListener(this);

		cerrar = new NetButton();
		cerrar.setFocusable(false);
		cerrar.setBounds(this.getWidth() - 39, 0, 30, 30);
		cerrar.setText("X");
		cerrar.addMouseListener(this);
		cerrar.addMouseMotionListener(this);

		this.getContentPane().add(minimizar);
		this.getContentPane().add(cerrar);
		this.getContentPane().add(label);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource().equals(label)) {
			x = e.getX();
			y = e.getY();
		}
		if (e.getSource().equals(cerrar)) {
			System.exit(0);
		} else if (e.getSource().equals(minimizar)) {
			setExtendedState(ICONIFIED);
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point point = MouseInfo.getPointerInfo().getLocation();
		setLocation(point.x - x, point.y - y);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
}
