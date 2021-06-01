package alejandrofan2.bkmenu.components;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class BebidasFrame extends JFrame {
	
	// Colores personalizados
	private Color azul = new Color(20, 144, 236);
	private Color blanco = new Color(240, 240, 240);
	
	// Container
	private Container contentpane = getContentPane();
	
	// Panel
	private JPanel mainPanel = new JPanel();
	
	// Buttons
	static JRadioButton btnColaLight = new JRadioButton("Cola Light");
	static JRadioButton btnColaZero = new JRadioButton("Cola Zero");
	static JRadioButton btnColaZeroZero = new JRadioButton("Cola Zero Zero");
	static JRadioButton btnNaranjaZero = new JRadioButton("Naranja Zero");
	static JRadioButton btnLimonZero = new JRadioButton("Limon Zero");
	static JRadioButton btnNestea = new JRadioButton("Nestea");
	static JRadioButton btnNesteaSinAzucar = new JRadioButton("Nestea sin azucar");
	static JRadioButton btnAquariusZero = new JRadioButton("Aquarius Zero");
	static JRadioButton btnTrina = new JRadioButton("Trina");
	static JRadioButton btnCervezaSinAlcohol = new JRadioButton("Naranja Zero");
	static JRadioButton btnMonster = new JRadioButton("Limon Zero");
	
	public BebidasFrame() {
		setTitle("Extra bebida...");
		setVisible(false);
		setSize(370, 160);
		setLocationRelativeTo(null);
		setIconImage (new ImageIcon("bqueen.png").getImage());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setContentPane(contentpane);
		setResizable(false);
		
		// Definir panel
		mainPanel.add(btnAquariusZero);
		mainPanel.add(btnCervezaSinAlcohol);
		mainPanel.add(btnColaLight);
		mainPanel.add(btnColaZero);
		mainPanel.add(btnColaZeroZero);
		mainPanel.add(btnLimonZero);
		mainPanel.add(btnMonster);
		mainPanel.add(btnNaranjaZero);
		mainPanel.add(btnNestea);
		mainPanel.add(btnNesteaSinAzucar);
		mainPanel.add(btnTrina);
		mainPanel.setLayout(new FlowLayout());
		
		// Definir colores de fondo
		mainPanel.setBackground(azul);
		
		btnAquariusZero.setOpaque(false);
		btnCervezaSinAlcohol.setOpaque(false);
		btnColaLight.setOpaque(false);
		btnColaZero.setOpaque(false);
		btnColaZeroZero.setOpaque(false);
		btnLimonZero.setOpaque(false);
		btnMonster.setOpaque(false);
		btnNaranjaZero.setOpaque(false);
		btnNestea.setOpaque(false);
		btnNesteaSinAzucar.setOpaque(false);
		btnTrina.setOpaque(false);
		
		//Cambiar color de la fuente
		btnAquariusZero.setForeground(blanco);
		btnCervezaSinAlcohol.setForeground(blanco);
		btnColaLight.setForeground(blanco);
		btnColaZero.setForeground(blanco);
		btnColaZeroZero.setForeground(blanco);
		btnLimonZero.setForeground(blanco);
		btnMonster.setForeground(blanco);
		btnNaranjaZero.setForeground(blanco);
		btnNestea.setForeground(blanco);
		btnNesteaSinAzucar.setForeground(blanco);
		btnTrina.setForeground(blanco);
		
		// Anadir panel a contentpane
		contentpane.add(mainPanel);
	}}
