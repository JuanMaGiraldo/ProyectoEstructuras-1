package com.uniquindio.estructuradatos.proyecto.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import com.uniquindio.estructuradatos.proyecto.ui.generic.NetButton;
import com.uniquindio.estructuradatos.proyecto.ui.generic.NetTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;

/**
 * @author DeveloperSC
 */
public class InputValueFrame extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NetButton okButton;
	private NetButton cancelButton;
	private int answer;
	private boolean exception;
	private NetTextField txtValue;

	/**
	 * Constructor de clase
	 * 
	 * @param frame
	 * @param modal
	 * @param message
	 */
	public InputValueFrame(JFrame frame, String message, Dimension dimension) {
		super(frame, true);
		exception = false;
		InputValueFrame.this.setPreferredSize(new Dimension(dimension));
		InputValueFrame.this.setUndecorated(true);
		GridBagConstraints gridBagConstraints;

		JPanel myPanel = new JPanel();
		myPanel.setPreferredSize(new Dimension(500, 200));
		myPanel.setBorder(BorderFactory.createLineBorder(new Color(119, 232, 228), 2));
		myPanel.setBackground(new Color(0, 0, 0));
		myPanel.setLayout(new GridBagLayout());

		InputValueFrame.this.getContentPane().add(myPanel);

		JLabel lbMsg = new JLabel(message);
		lbMsg.setForeground(new Color(255, 255, 255));
		lbMsg.setOpaque(false);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
		myPanel.add(lbMsg, gridBagConstraints);

		txtValue = new NetTextField();
		txtValue.setPreferredSize(new Dimension(200, 34));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		myPanel.add(txtValue, gridBagConstraints);

		okButton = new NetButton();
		okButton.setText("OK");
		okButton.setPreferredSize(new Dimension(80, 34));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
		myPanel.add(okButton, gridBagConstraints);

		cancelButton = new NetButton();
		cancelButton.setText("Cancel");
		cancelButton.setPreferredSize(new Dimension(80, 34));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
		myPanel.add(cancelButton, gridBagConstraints);

		// listener
		InputValueFrame.this.okButton.addActionListener(InputValueFrame.this);
		InputValueFrame.this.cancelButton.addActionListener(InputValueFrame.this);

		InputValueFrame.this.pack();
		InputValueFrame.this.setLocationRelativeTo(null);
		InputValueFrame.this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(okButton)) {

			try {
				answer = Integer.parseInt(txtValue.getText());
			} catch (Exception e2) {
				exception = true;
				answer = 0;
			}
			setVisible(false);
		}

		else if (e.getSource().equals(cancelButton)) {
			answer = 0;
			setVisible(false);
		}
	}

	public boolean getException() {
		return exception;
	}

	public int getAnswer() {
		return answer;
	}
}