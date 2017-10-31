package com.uniquindio.estructuradatos.proyecto.ui.generic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
/**
 * @author DeveloperSC
 */
public class NetButton extends JButton implements FocusListener, MouseListener{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Constructor de clase
     */
    public NetButton(){
        super();
        NetButton.this.setSize(new Dimension(100,42));
        NetButton.this.setForeground(new Color(162,183,188));
        NetButton.this.setBorderPainted(true);
        NetButton.this.setContentAreaFilled(false);
        NetButton.this.setOpaque(true);
        NetButton.this.setBackground( new Color(0,0,0));
        NetButton.this.setBorder(BorderFactory.createLineBorder(new Color(162,183,188),2));
        NetButton.this.setFocusPainted(false);
        NetButton.this.addFocusListener(NetButton.this);
        NetButton.this.addMouseListener(NetButton.this);
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
    public void mousePressed(MouseEvent e) {
        NetButton.this.setBackground( new Color(70,98,110));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        NetButton.this.setBackground( new Color(0,0,0));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        NetButton.this.setBackground( new Color(90,130,130));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        NetButton.this.setBackground( new Color(0,0,0));
    }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}    
    
}