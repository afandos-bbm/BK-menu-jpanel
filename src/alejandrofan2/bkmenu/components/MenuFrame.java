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

	/*
	 * Menu Basico 8€
	 */
	private static final long serialVersionUID = 8380899128310367879L;
	private Color cFondo = new Color(255, 144, 236);
	private Color cLetra = new Color(240, 240, 240);
	private Font font = new Font("Roboto", Font.BOLD, 24);
	private Container contentPane = getContentPane();
	private GridBagConstraints gbc;

	// Main Panel
	private JPanel mainPanel = new JPanel();
	private JLabel lblTitulo = new JLabel("Menu basico (8 €):");
	private ButtonGroup bgpRecogida = new ButtonGroup();
	private JRadioButton btnLlevar = new JRadioButton("Reparto a domicilio");
	private JRadioButton btnRecoger = new JRadioButton("Recogida en local (-21% dto.)");
	private JButton btnCalcular = new JButton("CALCULAR");
	private JButton btnMasBebidas = new JButton("Mas...");
	private JLabel lblPrecio = new JLabel("Precio:");
	private JLabel lblIVA = new JLabel("IVA (21%):");
	private JLabel lblPVP = new JLabel("P.V.P:");
	private JTextField txtPrecio = new JTextField();
	private JTextField txtIVA = new JTextField();
	private JTextField txtPVP = new JTextField();

	// Hamburgesa Panel
	private JPanel pnlHamburguesa = new JPanel();
	private TitledBorder bdrHamburguesa = new TitledBorder("Hamburguesa");
	private ButtonGroup bgpHamburguesa = new ButtonGroup();
	private JRadioButton btnPollo = new JRadioButton("Pollo");
	private JRadioButton btnCerdo = new JRadioButton("Cerdo");
	private JRadioButton btnTernera = new JRadioButton("Ternera (+1€)");
	private JRadioButton btnVegana = new JRadioButton("Vegana (+1€)");

	// Pan Panel
	private JPanel pnlPan = new JPanel();
	private TitledBorder bdrPan = new TitledBorder("Pan");
	private ButtonGroup bgpPan = new ButtonGroup();
	private JRadioButton btnNormal = new JRadioButton("Normal");
	private JRadioButton btnIntegral = new JRadioButton("Integral");
	private JRadioButton btnCenteno = new JRadioButton("Centeno");
	
	// Patatas Panel
	private JPanel pnlPatatas = new JPanel();
	private TitledBorder bdrPatatas = new TitledBorder("Patatas");
	private ButtonGroup bgpPatatas = new ButtonGroup();
	private JRadioButton btnFritas = new JRadioButton("Fritas");
	private JRadioButton btnGajo = new JRadioButton("Gajo");
	private JRadioButton btnCaseras = new JRadioButton("Caseras (+1€)");

	// Bebida Panel
	private JPanel pnlBebida = new JPanel();
	private TitledBorder bdrBebida = new TitledBorder("Bebida");
	private ButtonGroup bgpBebida = new ButtonGroup();
	private JRadioButton btnCola = new JRadioButton("Cola");
	private JRadioButton btnNaranja = new JRadioButton("Naranja");
	private JRadioButton btnLimon = new JRadioButton("Limon");
	private JRadioButton btnAgua = new JRadioButton("Agua");
	private JRadioButton btnCerveza = new JRadioButton("Cerveza");
	private BebidasFrame bebidasFrame = new BebidasFrame();
	AbstractButton absBebidas;
	
	// Extras Panel
	private JPanel pnlExtra = new JPanel();
	private TitledBorder bdrExtra = new TitledBorder("Opciones extra");
	private JCheckBox chkDoble = new JCheckBox("Hamburguesa doble (+2€)");
	private JCheckBox chkQueso = new JCheckBox("Extra de queso (+0,50€)");
	private JCheckBox chkPatatas = new JCheckBox("Extra de patatas (+1€)");
	
	// Salsas Panel
	private JPanel pnlSalsas = new JPanel();
	private TitledBorder bdrSalsas = new TitledBorder("Salsas (+0,50€ cada una)");
	private JLabel lblKetchup = new JLabel("Ketchup");
	private JLabel lblMostaza = new JLabel("Mostaza");
	private JLabel lblBBQ = new JLabel("Barbacoa");
	private JLabel lblThai = new JLabel("Thai");
	private JLabel lblQueso = new JLabel("Queso");
	private JLabel lblMayonesa = new JLabel("Mayonesa");
	private JSpinner spnKetchup = new JSpinner();
	private JSpinner spnMostaza = new JSpinner();
	private JSpinner spnBBQ = new JSpinner();
	private JSpinner spnThai = new JSpinner();
	private JSpinner spnQueso = new JSpinner();
	private JSpinner spnMayonesa = new JSpinner();

	// Variables
	private double precio = 0;
	private double IVA = 0;
	private double PVP = 0;
	private double ketchup = 0;
	private double mostaza = 0;
	private double bbq = 0;
	private double thai = 0;
	private double queso = 0;
	private double mayonesa = 0;

	public MenuFrame() {
		setTitle("BK <MENU>");
		setVisible(true);
		setSize(600, 720);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		setResizable(false);
		gbc = generarLayout();
		mainPanel();
		hamburgesaPanel();
		panPanel();
		patatasPanel();
		bebidaPanel();
		extraPanel();
		salsaPanel();
		contentPane.add(mainPanel);
	}

	private GridBagConstraints generarLayout() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.anchor = GridBagConstraints.WEST;
		return gbc;
	}


	private void mainPanel() {
		lblTitulo.setBounds(50, 0, 350, 70);
		lblTitulo.setFont(font);
		bgpRecogida.add(btnLlevar);
		bgpRecogida.add(btnRecoger);
		btnLlevar.setBounds(100, 500, 150, 30);
		btnRecoger.setBounds(300, 500, 250, 30);
		btnCalcular.setBounds(250, 550, 100, 30);
		lblPrecio.setBounds(120, 590, 100, 30);
		lblIVA.setBounds(240, 590, 100, 30);
		lblPVP.setBounds(360, 590, 100, 30);
		txtPrecio.setBounds(120, 620, 100, 30);
		txtIVA.setBounds(240, 620, 100, 30);
		txtPVP.setBounds(360, 620, 100, 30);
		
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
		
		btnRecoger.addActionListener(this);
		btnCalcular.addActionListener(this);
		
		mainPanel.setBackground(cFondo);
		txtPrecio.setBackground(cLetra);
		txtIVA.setBackground(cLetra);
		txtPVP.setBackground(cLetra);
		btnLlevar.setOpaque(false);
		btnRecoger.setOpaque(false);
		btnCalcular.setOpaque(false);
		btnCalcular.setForeground(new Color(15, 15, 15));
		btnLlevar.setForeground(cLetra);
		btnNormal.setForeground(cLetra);
		lblPrecio.setForeground(cLetra);
		lblTitulo.setForeground(cLetra);
		lblPVP.setForeground(cLetra);
		lblIVA.setForeground(cLetra);
		btnRecoger.setForeground(cLetra);

	}
	
	private void hamburgesaPanel() {
		bdrHamburguesa.setTitleColor(cLetra);
		bgpHamburguesa.add(btnPollo);
		bgpHamburguesa.add(btnCerdo);
		bgpHamburguesa.add(btnTernera);
		bgpHamburguesa.add(btnVegana);
		
		pnlHamburguesa.setLayout(new GridBagLayout());
		pnlHamburguesa.add(btnPollo, gbc);
		pnlHamburguesa.add(btnCerdo, gbc);
		pnlHamburguesa.add(btnTernera, gbc);
		pnlHamburguesa.add(btnVegana, gbc);
		pnlHamburguesa.setBorder(bdrHamburguesa);
		pnlHamburguesa.setBounds(50, 65, 150, 130);
		
		btnTernera.addActionListener(this);
		btnVegana.addActionListener(this);
		
		pnlHamburguesa.setBackground(cFondo);
		btnPollo.setOpaque(false);
		btnTernera.setOpaque(false);
		btnVegana.setOpaque(false);
		btnCerdo.setOpaque(false);
		btnCerdo.setForeground(cLetra);
		btnPollo.setForeground(cLetra);
		btnTernera.setForeground(cLetra);
		btnVegana.setForeground(cLetra);
	}
	
	private void panPanel() {
		bdrPan.setTitleColor(cLetra);
		bgpPan.add(btnNormal);
		bgpPan.add(btnIntegral);
		bgpPan.add(btnCenteno);

		pnlPan.setLayout(new GridBagLayout());
		pnlPan.add(btnNormal, gbc);
		pnlPan.add(btnIntegral, gbc);
		pnlPan.add(btnCenteno, gbc);
		pnlPan.setBorder(bdrPan);
		pnlPan.setBounds(220, 65, 150, 130);
		
		pnlPan.setBackground(cFondo);
		btnIntegral.setOpaque(false);
		btnCenteno.setForeground(cLetra);
		btnNormal.setOpaque(false);
		btnCenteno.setOpaque(false);
		btnIntegral.setForeground(cLetra);

	}
	
	private void patatasPanel() {
		bdrPatatas.setTitleColor(cLetra);
		bgpPatatas.add(btnFritas);
		bgpPatatas.add(btnGajo);
		bgpPatatas.add(btnCaseras);
		
		pnlPatatas.setLayout(new GridBagLayout());
		pnlPatatas.add(btnFritas, gbc);
		pnlPatatas.add(btnGajo, gbc);
		pnlPatatas.add(btnCaseras, gbc);
		pnlPatatas.setBorder(bdrPatatas);
		pnlPatatas.setBounds(390, 65, 150, 130);
		
		btnCaseras.addActionListener(this);
		
		pnlPatatas.setBackground(cFondo);
		btnCaseras.setOpaque(false);
		btnGajo.setOpaque(false);
		btnFritas.setOpaque(false);
		btnCaseras.setForeground(cLetra);
		btnFritas.setForeground(cLetra);
		btnGajo.setForeground(cLetra);
		
	}
	
	private void bebidaPanel() {
		bdrBebida.setTitleColor(cLetra);
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
		
		pnlBebida.setLayout(new FlowLayout());
		pnlBebida.add(btnCola);
		pnlBebida.add(btnNaranja);
		pnlBebida.add(btnLimon);
		pnlBebida.add(btnAgua);
		pnlBebida.add(btnCerveza);
		pnlBebida.add(btnMasBebidas);
		pnlBebida.setBorder(bdrBebida);
		pnlBebida.setBounds(50, 208, 490, 70);
		
		btnMasBebidas.addActionListener(this);
		
		pnlBebida.setBackground(cFondo);
		btnAgua.setOpaque(false);
		btnCerveza.setOpaque(false);
		btnCola.setOpaque(false);
		btnLimon.setOpaque(false);
		btnNaranja.setOpaque(false);
		btnAgua.setForeground(cLetra);
		btnCerveza.setForeground(cLetra);
		btnCola.setForeground(cLetra);
		btnLimon.setForeground(cLetra);
		btnNaranja.setForeground(cLetra);
	}
	
	private void extraPanel() {
		bdrExtra.setTitleColor(cLetra);
		
		pnlExtra.setLayout(new GridBagLayout());
		pnlExtra.add(chkDoble, gbc);
		pnlExtra.add(chkQueso, gbc);
		pnlExtra.add(chkPatatas, gbc);
		pnlExtra.setBorder(bdrExtra);
		pnlExtra.setBounds(50, 290, 200, 170);
		
  		pnlExtra.setBackground(cFondo);
		chkDoble.setOpaque(false);
		chkPatatas.setOpaque(false);
		chkQueso.setOpaque(false);
		chkDoble.setForeground(cLetra);
		chkPatatas.setForeground(cLetra);
		chkQueso.setForeground(cLetra);
	}
	
	private void salsaPanel() {
		bdrSalsas.setTitleColor(cLetra);
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
		
		pnlSalsas.setBackground(cFondo);
		lblBBQ.setForeground(cLetra);
		lblKetchup.setForeground(cLetra);
		lblMostaza.setForeground(cLetra);
		lblQueso.setForeground(cLetra);
		lblMayonesa.setForeground(cLetra);
		lblThai.setForeground(cLetra);
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

		if (e.getSource() == btnMasBebidas && !bebidasFrame.isVisible()) {
			bebidasFrame.setVisible(true);
		}
		for (Enumeration<AbstractButton> bebidas = bgpBebida.getElements(); bebidas.hasMoreElements();) {
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
	}
}