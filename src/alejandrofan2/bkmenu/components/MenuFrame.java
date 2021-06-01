package alejandrofan2.bkmenu.components;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class MenuFrame extends JFrame implements ActionListener {

	// Colores y fuentes personalizadas
	private Color azul = new Color(20, 144, 236);
	private Color blanco = new Color(240, 240, 240);
	private Font font = new Font("Roboto", Font.BOLD, 24);

	// Containers
	private Container contentpane = getContentPane();

	// Panels
	private JPanel mainPanel = new JPanel();
	private JPanel pnlHamburguesa = new JPanel();
	private JPanel pnlPan = new JPanel();
	private JPanel pnlPatatas = new JPanel();
	private JPanel pnlBebida = new JPanel();
	private JPanel pnlExtra = new JPanel();
	private JPanel pnlSalsas = new JPanel();

	// Labels
	private JLabel lblTitulo = new JLabel("Menu basico (8 €):");
	private JLabel lblKetchup = new JLabel("Ketchup");
	private JLabel lblMostaza = new JLabel("Mostaza");
	private JLabel lblBBQ = new JLabel("Barbacoa");
	private JLabel lblThai = new JLabel("Thai");
	private JLabel lblQueso = new JLabel("Queso");
	private JLabel lblMayonesa = new JLabel("Mayonesa");
	private JLabel lblPrecio = new JLabel("Precio:");
	private JLabel lblIVA = new JLabel("IVA (21%):");
	private JLabel lblPVP = new JLabel("P.V.P:");

	// Borders
	private TitledBorder bdrHamburguesa = new TitledBorder("Hamburguesa");
	private TitledBorder bdrPan = new TitledBorder("Pan");
	private TitledBorder bdrPatatas = new TitledBorder("Patatas");
	private TitledBorder bdrBebida = new TitledBorder("Bebida");
	private TitledBorder bdrExtra = new TitledBorder("Opciones extra/adicionales");
	private TitledBorder bdrSalsas = new TitledBorder("Salsas (+0,50€ cada una)");

	// TextFields
	private JTextField txtPrecio = new JTextField();
	private JTextField txtIVA = new JTextField();
	private JTextField txtPVP = new JTextField();

	// Botones
	private JRadioButton btnPollo = new JRadioButton("Pollo");
	private JRadioButton btnCerdo = new JRadioButton("Cerdo");
	private JRadioButton btnTernera = new JRadioButton("Ternera (+1€)");
	private JRadioButton btnVegana = new JRadioButton("Vegana (+1€)");
	private ButtonGroup bgpHamburguesa = new ButtonGroup();
	private JRadioButton btnNormal = new JRadioButton("Normal");
	private JRadioButton btnIntegral = new JRadioButton("Integral");
	private JRadioButton btnCenteno = new JRadioButton("Centeno");
	private ButtonGroup bgpPan = new ButtonGroup();
	private JRadioButton btnFritas = new JRadioButton("Fritas");
	private JRadioButton btnGajo = new JRadioButton("Gajo");
	private JRadioButton btnCaseras = new JRadioButton("Caseras (+1€)");
	private ButtonGroup bgpPatatas = new ButtonGroup();
	private JRadioButton btnCola = new JRadioButton("Cola");
	private JRadioButton btnNaranja = new JRadioButton("Naranja");
	private JRadioButton btnLimon = new JRadioButton("Limon");
	private JRadioButton btnAgua = new JRadioButton("Agua");
	private JRadioButton btnCerveza = new JRadioButton("Cerveza");
	private ButtonGroup bgpBebida = new ButtonGroup();
	private JRadioButton btnLlevar = new JRadioButton("Reparto a domicilio");
	private JRadioButton btnRecoger = new JRadioButton("Recogida en local (-21% dto.)");
	private ButtonGroup bgpRecogida = new ButtonGroup();
	private JButton btnCalcular = new JButton("CALCULAR");
	private JButton btnMasBebidas = new JButton("Mas...");

	// Menu
	private JMenu menu;
	private JMenuBar bar;
	private JMenuItem noche, dia;

	// CheckBoxes
	private JCheckBox chkDoble = new JCheckBox("Hamburguesa doble (+2€)");
	private JCheckBox chkQueso = new JCheckBox("Extra de queso (+0,50€)");
	private JCheckBox chkPatatas = new JCheckBox("Extra de patatas (+1€)");

	// Spinners
	private JSpinner spnKetchup = new JSpinner();
	private JSpinner spnMostaza = new JSpinner();
	private JSpinner spnBBQ = new JSpinner();
	private JSpinner spnThai = new JSpinner();
	private JSpinner spnQueso = new JSpinner();
	private JSpinner spnMayonesa = new JSpinner();

	// Mas bebidas
	BebidasFrame masB = new BebidasFrame();

	// AbstractButton
	AbstractButton absBebidas;

	// Calculos
	double precio = 0;
	double IVA = 0;
	double PVP = 0;
	double ketchup = 0;
	double mostaza = 0;
	double bbq = 0;
	double thai = 0;
	double queso = 0;
	double mayonesa = 0;

	public MenuFrame() {

		/* Hago la ventana visible, defino el tamano, la posicion, el icono y la 
		 * operacion por defecto de la ventana al cerrarla.
		 */
		setTitle("Burger Queen APP");
		setVisible(true);
		setSize(600, 720);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("bqueen.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentpane);
		setResizable(false);

		borders();

		addButtons();

		parteInferior();

		GridBagConstraints gbc = layouts();

		panels(gbc);

		labelsAndSpinners();

		addActionListeners();

		// Anado el panel principal al container
		contentpane.add(mainPanel);

		coloresOpacidad();

	} // constructor

	private void coloresOpacidad() {
		// Definir colores de fondo
		mainPanel.setBackground(azul);
		pnlHamburguesa.setBackground(azul);
		pnlPan.setBackground(azul);
		pnlPatatas.setBackground(azul);
		pnlBebida.setBackground(azul);
		pnlExtra.setBackground(azul);
		pnlSalsas.setBackground(azul);
		txtPrecio.setBackground(blanco);
		txtIVA.setBackground(blanco);
		txtPVP.setBackground(blanco);

		btnAgua.setOpaque(false);
		btnCalcular.setOpaque(false);
		btnCaseras.setOpaque(false);
		btnCenteno.setOpaque(false);
		btnCerdo.setOpaque(false);
		btnCerveza.setOpaque(false);
		btnCola.setOpaque(false);
		btnFritas.setOpaque(false);
		btnGajo.setOpaque(false);
		btnIntegral.setOpaque(false);
		btnLimon.setOpaque(false);
		btnLlevar.setOpaque(false);
		btnNaranja.setOpaque(false);
		btnNormal.setOpaque(false);
		btnPollo.setOpaque(false);
		btnRecoger.setOpaque(false);
		btnTernera.setOpaque(false);
		btnVegana.setOpaque(false);
		chkDoble.setOpaque(false);
		chkPatatas.setOpaque(false);
		chkQueso.setOpaque(false);

		// Cambiar color de la fuente
		btnAgua.setForeground(blanco);
		btnCalcular.setForeground(new Color(15, 15, 15));
		btnCaseras.setForeground(blanco);
		btnCenteno.setForeground(blanco);
		btnCerdo.setForeground(blanco);
		btnCerveza.setForeground(blanco);
		btnCola.setForeground(blanco);
		btnFritas.setForeground(blanco);
		btnGajo.setForeground(blanco);
		btnIntegral.setForeground(blanco);
		btnLimon.setForeground(blanco);
		btnLlevar.setForeground(blanco);
		btnNaranja.setForeground(blanco);
		btnNormal.setForeground(blanco);
		btnPollo.setForeground(blanco);
		btnRecoger.setForeground(blanco);
		btnTernera.setForeground(blanco);
		btnVegana.setForeground(blanco);
		chkDoble.setForeground(blanco);
		chkPatatas.setForeground(blanco);
		chkQueso.setForeground(blanco);
		lblBBQ.setForeground(blanco);
		lblIVA.setForeground(blanco);
		lblKetchup.setForeground(blanco);
		lblMostaza.setForeground(blanco);
		lblPrecio.setForeground(blanco);
		lblQueso.setForeground(blanco);
		lblMayonesa.setForeground(blanco);
		lblPVP.setForeground(blanco);
		lblThai.setForeground(blanco);
		lblTitulo.setForeground(blanco);
	}

	private void addActionListeners() {
		// Anadir ActionListeners a todos los componentes
		btnCalcular.addActionListener(this);
		btnCaseras.addActionListener(this);
		btnRecoger.addActionListener(this);
		btnTernera.addActionListener(this);
		btnVegana.addActionListener(this);
		btnMasBebidas.addActionListener(this);
		BebidasFrame.btnAquariusZero.addActionListener(this);
		BebidasFrame.btnCervezaSinAlcohol.addActionListener(this);
		BebidasFrame.btnColaLight.addActionListener(this);
		BebidasFrame.btnColaZero.addActionListener(this);
		BebidasFrame.btnColaZeroZero.addActionListener(this);
		BebidasFrame.btnLimonZero.addActionListener(this);
		BebidasFrame.btnMonster.addActionListener(this);
		BebidasFrame.btnNaranjaZero.addActionListener(this);
		BebidasFrame.btnNestea.addActionListener(this);
		BebidasFrame.btnNesteaSinAzucar.addActionListener(this);
		BebidasFrame.btnTrina.addActionListener(this);
	}

	private void labelsAndSpinners() {
		// Definir labels y spinners
		lblTitulo.setBounds(50, 0, 350, 70);
		lblTitulo.setFont(font);
		lblKetchup.setBounds(20, 20, 100, 30);
		spnKetchup.setBounds(90, 25, 40, 25);
		lblMostaza.setBounds(150, 20, 100, 30);
		spnMostaza.setBounds(220, 25, 40, 25);
		lblBBQ.setBounds(20, 70, 100, 30);
		spnBBQ.setBounds(90, 75, 40, 25);
		lblThai.setBounds(150, 70, 100, 30);
		spnThai.setBounds(220, 75, 40, 25);
		lblQueso.setBounds(20, 120, 100, 30);
		spnQueso.setBounds(90, 125, 40, 25);
		lblMayonesa.setBounds(150, 120, 100, 30);
		spnMayonesa.setBounds(220, 125, 40, 25);
	}

	private GridBagConstraints layouts() {
		// Layout para los paneles
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.anchor = GridBagConstraints.WEST;
		return gbc;
	}

	private void panels(GridBagConstraints gbc) {
		// Defino los paneles y anado los botones dentro
		mainPanel.setLayout(null);
		mainPanel.add(pnlHamburguesa);
		mainPanel.add(pnlPan);
		mainPanel.add(pnlPatatas);
		mainPanel.add(pnlBebida);
		mainPanel.add(pnlExtra);
		mainPanel.add(pnlSalsas);
		mainPanel.add(btnLlevar);
		mainPanel.add(btnRecoger);
		mainPanel.add(btnCalcular);

		mainPanel.add(lblTitulo);
		mainPanel.add(lblPrecio);
		mainPanel.add(lblIVA);
		mainPanel.add(lblPVP);
		mainPanel.add(lblTitulo);

		mainPanel.add(txtPrecio);
		mainPanel.add(txtIVA);
		mainPanel.add(txtPVP);

		pnlHamburguesa.setLayout(new GridBagLayout());
		pnlHamburguesa.add(btnPollo, gbc);
		pnlHamburguesa.add(btnCerdo, gbc);
		pnlHamburguesa.add(btnTernera, gbc);
		pnlHamburguesa.add(btnVegana, gbc);
		pnlHamburguesa.setBorder(bdrHamburguesa);
		pnlHamburguesa.setBounds(50, 65, 150, 130);

		pnlPan.setLayout(new GridBagLayout());
		pnlPan.add(btnNormal, gbc);
		pnlPan.add(btnIntegral, gbc);
		pnlPan.add(btnCenteno, gbc);
		pnlPan.setBorder(bdrPan);
		pnlPan.setBounds(220, 65, 150, 130);

		pnlPatatas.setLayout(new GridBagLayout());
		pnlPatatas.add(btnFritas, gbc);
		pnlPatatas.add(btnGajo, gbc);
		pnlPatatas.add(btnCaseras, gbc);
		pnlPatatas.setBorder(bdrPatatas);
		pnlPatatas.setBounds(390, 65, 150, 130);

		pnlBebida.setLayout(new FlowLayout());
		pnlBebida.add(btnCola);
		pnlBebida.add(btnNaranja);
		pnlBebida.add(btnLimon);
		pnlBebida.add(btnAgua);
		pnlBebida.add(btnCerveza);
		pnlBebida.add(btnMasBebidas);
		pnlBebida.setBorder(bdrBebida);
		pnlBebida.setBounds(50, 208, 490, 70);

		pnlExtra.setLayout(new GridBagLayout());
		pnlExtra.add(chkDoble, gbc);
		pnlExtra.add(chkQueso, gbc);
		pnlExtra.add(chkPatatas, gbc);
		pnlExtra.setBorder(bdrExtra);
		pnlExtra.setBounds(50, 290, 200, 170);

		pnlSalsas.setLayout(null);
		pnlSalsas.add(spnKetchup);
		pnlSalsas.add(lblKetchup);
		pnlSalsas.add(spnMostaza);
		pnlSalsas.add(lblMostaza);
		pnlSalsas.add(spnBBQ);
		pnlSalsas.add(lblBBQ);
		pnlSalsas.add(spnThai);
		pnlSalsas.add(lblThai);
		pnlSalsas.add(spnQueso);
		pnlSalsas.add(lblQueso);
		pnlSalsas.add(spnMayonesa);
		pnlSalsas.add(lblMayonesa);
		pnlSalsas.setBorder(bdrSalsas);
		pnlSalsas.setBounds(270, 290, 270, 170);
	}

	private void parteInferior() {
		// Defino la parte inferior del programa
		btnLlevar.setBounds(100, 500, 150, 30);
		btnRecoger.setBounds(300, 500, 250, 30);
		bgpRecogida.add(btnLlevar);
		bgpRecogida.add(btnRecoger);
		btnCalcular.setBounds(250, 550, 100, 30);
		lblPrecio.setBounds(120, 590, 100, 30);
		lblIVA.setBounds(240, 590, 100, 30);
		lblPVP.setBounds(360, 590, 100, 30);
		txtPrecio.setBounds(120, 620, 100, 30);
		txtIVA.setBounds(240, 620, 100, 30);
		txtPVP.setBounds(360, 620, 100, 30);
	}

	private void addButtons() {
		// Defino los botones y los anado a sus grupos correspondientes
		bgpHamburguesa.add(btnPollo);
		bgpHamburguesa.add(btnCerdo);
		bgpHamburguesa.add(btnTernera);
		bgpHamburguesa.add(btnVegana);
		bgpPan.add(btnNormal);
		bgpPan.add(btnIntegral);
		bgpPan.add(btnCenteno);
		bgpPatatas.add(btnFritas);
		bgpPatatas.add(btnGajo);
		bgpPatatas.add(btnCaseras);
		bgpBebida.add(btnAgua);
		bgpBebida.add(btnCola);
		bgpBebida.add(btnNaranja);
		bgpBebida.add(btnLimon);
		bgpBebida.add(btnCerveza);
		bgpBebida.add(BebidasFrame.btnAquariusZero);
		bgpBebida.add(BebidasFrame.btnCervezaSinAlcohol);
		bgpBebida.add(BebidasFrame.btnColaLight);
		bgpBebida.add(BebidasFrame.btnColaZero);
		bgpBebida.add(BebidasFrame.btnColaZeroZero);
		bgpBebida.add(BebidasFrame.btnLimonZero);
		bgpBebida.add(BebidasFrame.btnMonster);
		bgpBebida.add(BebidasFrame.btnNaranjaZero);
		bgpBebida.add(BebidasFrame.btnNestea);
		bgpBebida.add(BebidasFrame.btnNesteaSinAzucar);
		bgpBebida.add(BebidasFrame.btnTrina);
	}

	private void borders() {
		// Definir borders
		bdrHamburguesa.setTitleColor(blanco);
		bdrBebida.setTitleColor(blanco);
		bdrExtra.setTitleColor(blanco);
		bdrPan.setTitleColor(blanco);
		bdrPatatas.setTitleColor(blanco);
		bdrSalsas.setTitleColor(blanco);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		precio = 8;
		if (btnTernera.isSelected())
			precio = precio + 1;

		if (btnVegana.isSelected())
			precio = precio + 1;

		if (btnCaseras.isSelected())
			precio = precio + 1;

		if (chkDoble.isSelected())
			precio = precio + 2;

		if (chkQueso.isSelected())
			precio = precio + 0.5;

		if (chkPatatas.isSelected())
			precio = precio + 1;

		if (e.getSource() == btnMasBebidas && !masB.isVisible()) {
			masB.setVisible(true);
		}
		for (Enumeration < AbstractButton > bebidas = bgpBebida.getElements(); bebidas.hasMoreElements();) {
			absBebidas = bebidas.nextElement();
			if (absBebidas.isSelected() 
				&& (btnPollo.isSelected() || btnCerdo.isSelected() || btnTernera.isSelected() || btnVegana.isSelected()) 
				&& (btnNormal.isSelected() || btnIntegral.isSelected() || btnCenteno.isSelected()) 
				&& (btnFritas.isSelected() || btnGajo.isSelected() || btnCaseras.isSelected())
				) {
				if (e.getSource() == btnCalcular) {
					ketchup = Double.parseDouble(spnKetchup.getValue().toString());
					mostaza = Double.parseDouble(spnMostaza.getValue().toString());
					bbq = Double.parseDouble(spnBBQ.getValue().toString());
					thai = Double.parseDouble(spnThai.getValue().toString());
					queso = Double.parseDouble(spnQueso.getValue().toString());
					mayonesa = Double.parseDouble(spnMayonesa.getValue().toString());
					precio = precio + (ketchup + mostaza + bbq + thai + queso + mayonesa) * 0.50;
					if (btnRecoger.isSelected())
						precio = precio * 0.79;
					precio = Math.round(precio * 100.0) / 100.0;
					IVA = Math.round(precio * 0.21) * 100.0 / 100.0;
					PVP = Math.round(precio + IVA) * 100.0 / 100.0;
					txtPrecio.setText("" + precio);
					txtIVA.setText("" + IVA);
					txtPVP.setText("" + PVP);
				}
			}
		}
	} // actionlistener

}