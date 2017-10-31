package com.uniquindio.estructuradatos.proyecto.ui.generic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
/**
 * @author DeveloperSC
 */
public class NetTextField extends JTextField implements FocusListener{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color borderColor = new Color(162,183,188);
    
    /**
     * Constructor de clase
     */
    public NetTextField(){
        super();
        NetTextField.this.setText("");
        NetTextField.this.setForeground(new Color(162,183,188));
        NetTextField.this.setPreferredSize(new Dimension(200,36));
        NetTextField.this.setVisible(true);
        NetTextField.this.setFont(new Font("Agency FB", Font.PLAIN, 18 ));        
        NetTextField.this.setBorder(new EmptyBorder(0, 12, 0, 12));
        NetTextField.this.setCaretColor(new Color(248,110,1));
        NetTextField.this.setSelectionColor(new Color(248,110,1));
        NetTextField.this.setSelectedTextColor( new Color(162,183,188) );
        NetTextField.this.putClientProperty("caretWidth", 4);
        NetTextField.this.setOpaque(false);
        NetTextField.this.addFocusListener(NetTextField.this);
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        
        Graphics2D g2 =(Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);            
        
        Polygon fig = new Polygon();
        fig.addPoint( 0,0 );
        fig.addPoint( getWidth()-3,0 );
        fig.addPoint( getWidth()-3,getHeight()-18 );
        fig.addPoint( getWidth()-18,getHeight()-3 );
        fig.addPoint( 0,getHeight()-3 );
        
        g2.setColor( new Color(8,43,49,200) ); 
        g2.fill( fig );
        
        g2.setColor( borderColor );        
        g2.setStroke(new BasicStroke( 3 ));
        g2.draw( fig );
        
        super.paintComponent(g);
    }

    @Override
    public void focusGained(FocusEvent e) {
        borderColor = new Color(248,110,1);
        repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
        borderColor = new Color(162,183,188);
        repaint();
    }
    
}
