package com.uniquindio.estructuradatos.proyecto.ui.generic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
/**
 * @author DeveloperSC
 */
public class NetCustomDialog extends JFrame implements ActionListener {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NetButton okButton = null;    
    private boolean answer = false;
    
    /**
     * Constructor de clase
     * @param frame
     * @param modal
     * @param message
     */
    public NetCustomDialog(String message, Dimension dimension) {        
    	 super();
         NetCustomDialog.this.setPreferredSize(dimension);
         NetCustomDialog.this.setUndecorated(true);
         GridBagConstraints gridBagConstraints;
         
         JPanel myPanel = new JPanel();
         myPanel.setPreferredSize(new Dimension(dimension));
         myPanel.setBorder(BorderFactory.createLineBorder(new Color(119,232,228), 2));
         myPanel.setBackground(new Color(0,0,0));
         myPanel.setLayout(new GridBagLayout());
         
         NetCustomDialog.this.getContentPane().add(myPanel);        
         
         JLabel lbMsg = new JLabel(message);
         lbMsg.setForeground(new Color(255,255,255));
         lbMsg.setOpaque(false);
         gridBagConstraints = new GridBagConstraints();
         gridBagConstraints.gridx = 0;
         gridBagConstraints.gridy = 0;
         gridBagConstraints.anchor = GridBagConstraints.EAST;
         gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
         myPanel.add(lbMsg,gridBagConstraints);
         
         okButton = new NetButton();
         okButton.setText("OK");
         okButton.setPreferredSize(new Dimension(80,34));
         gridBagConstraints = new java.awt.GridBagConstraints();
         gridBagConstraints.gridx = 1;
         gridBagConstraints.gridy = 0;
         gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
         myPanel.add(okButton,gridBagConstraints);           
         
         //listener
         NetCustomDialog.this.okButton.addActionListener(NetCustomDialog.this);        
               
         NetCustomDialog.this.pack();
         NetCustomDialog.this.setLocationRelativeTo(null);
         NetCustomDialog.this.setVisible(true);
     }

     @Override
     public void actionPerformed(ActionEvent e) {
         if(okButton == e.getSource()) {
             answer = true;
             setVisible(false);
         }        
     }
     
     public boolean getAnswer() { return answer; }
}