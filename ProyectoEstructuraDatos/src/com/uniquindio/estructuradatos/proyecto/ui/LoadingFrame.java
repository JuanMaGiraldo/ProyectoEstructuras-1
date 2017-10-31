package com.uniquindio.estructuradatos.proyecto.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import com.uniquindio.estructuradatos.proyecto.ui.generic.NetFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class LoadingFrame extends NetFrame  implements ActionListener{
	
	private Timer timer;
	private static final long serialVersionUID = 1L;

	public LoadingFrame() {
		/*@SuppressWarnings("unused")
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();*/
		JLabel loader = new JLabel("");
		loader.setBounds(450,250, 150,150);
		ImageIcon img = new ImageIcon(getClass().getResource("/resources/loader.gif"));
		loader.setIcon(img);
		this.getContentPane().add(loader);
		loader();
	}
	
	public void loader()
	{
		timer = new Timer(5000, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(timer))
		{
			this.dispose();
			new GraphicInterface().setVisible(true);;
			timer.stop();
		}
	}
}
