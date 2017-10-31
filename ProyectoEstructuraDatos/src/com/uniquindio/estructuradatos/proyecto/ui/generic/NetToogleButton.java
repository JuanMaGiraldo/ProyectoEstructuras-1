package com.uniquindio.estructuradatos.proyecto.ui.generic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JToggleButton;
/**
 * @author DeveloperSC
 */
public class NetToogleButton extends JToggleButton implements FocusListener, MouseListener{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Constructor de clase
     */
    public NetToogleButton(){
        super();
        NetToogleButton.this.setSize(new Dimension(100,42));
        NetToogleButton.this.setForeground(new Color(162,183,188));
        NetToogleButton.this.setBorderPainted(true);
        NetToogleButton.this.setContentAreaFilled(false);
        NetToogleButton.this.setOpaque(true);
        NetToogleButton.this.setBackground( new Color(0,0,0));
        NetToogleButton.this.setBorder(BorderFactory.createLineBorder(new Color(162,183,188),2));
        NetToogleButton.this.setFocusPainted(false);
        NetToogleButton.this.addFocusListener(NetToogleButton.this);
        NetToogleButton.this.addMouseListener(NetToogleButton.this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        setBorder(BorderFactory.createLineBorder(new Color(248,110,1),2));
    }

    @Override
    public void focusLost(FocusEvent e) {
        setBorder(BorderFactory.createLineBorder(new Color(162,183,188),2));
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
    	NetToogleButton.this.setBackground( new Color(70,98,110));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    	NetToogleButton.this.setBackground( new Color(0,0,0));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    	NetToogleButton.this.setBackground( new Color(90,130,130));
    }

    @Override
    public void mouseExited(MouseEvent e) {
    	NetToogleButton.this.setBackground( new Color(0,0,0));
    }    
    
}