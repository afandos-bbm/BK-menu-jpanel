package alejandrofan2.bkmenu.components;

import java.awt.Container;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuFrame extends JFrame {

	private static final long serialVersionUID = 8380899128310367879L;

	private Container contentPane = getContentPane();
	private GridBagConstraints gbc;

	private final Integer WEIGHT, HEIGHT;
	private final String NAME;

	/**
	 * He dejado el setResizable en TRUE por que normalmente ba bien pero a veces no
	 * lo ejecuta y tienes que maxearlo y volverlo a poner normal.
	 */
	private void init() {
		setTitle(NAME);
		setVisible(true);
		setSize(HEIGHT, WEIGHT);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		setResizable(true);

		gbc = generarLayout();
		JPanel panel = new Panels(gbc);
		contentPane.add(panel);
	}

	public MenuFrame(int height, int weight, String name) {
		this.HEIGHT = height;
		this.WEIGHT = weight;
		this.NAME = name;
		init();
	}

	private GridBagConstraints generarLayout() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.anchor = GridBagConstraints.WEST;
		return gbc;
	}
}
