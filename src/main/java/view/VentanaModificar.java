package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Gestion;
import dao.VehiculosDAO;
import eventos.ModifyEvent;
import eventos.UpdateEvent;

public class VentanaModificar extends JDialog {

	private static final long serialVersionUID = 1L;
	public JFrame frame;
	public static JTextField textFieldMarca;
	public static JTextField textFieldModelo;
	public static JTextField textFieldConsumo;
	public static JTextField textFieldLongitud;
	public static JTextField textFieldAltura;
	public static JTextField textFieldCapCarga;
	public static JTextField textFieldEjes;
	public static JTextField textFieldCilindros;
	private JLabel lblBallesta;
	private JLabel lblEstructura;
	private JLabel lblEjes;
	private JLabel lblCapCarga;
	private JLabel lblTipoDeCarga;
	private JLabel lblCilindros;
	private JLabel lblConsumo;
	private JLabel lblCombustible;
	public static JButton btnModificar;
	private JButton btnCancelar;
	public static JComboBox<String> comboBoxTipo;
	public static JComboBox<String> comboBoxEstructura;
	public static JComboBox<String> comboBoxBallestas;
	public static JComboBox<String> comboBoxTipoCarga;
	public static JComboBox<String> comboBoxCombustible;
	public static JComboBox<String> comboBoxMotor;
	public static JComboBox<String> comboBoxTraccion;
	public static JComboBox<String> comboBoxMatriculas;
	public static JComboBox<String> comboBoxAnyo;
	private JLabel labelTitulo;
	public static JPanel panel_2;
	public static JPanel panel_3;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	public static JTextField textFieldMatricula;
	private JLabel lblMatrcula;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton_1;

	public VentanaModificar(Gestion g, VehiculosDAO vd) {
		initialize(g, vd);
	}

	private void initialize(Gestion g, VehiculosDAO vd) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 240, 240));
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/view/Captura.PNG"));
		frame.setBounds(100, 100, 676, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		labelTitulo = new JLabel("AUTOS.COM");
		labelTitulo.setOpaque(true);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelTitulo.setBackground(new Color(255, 128, 0));
		labelTitulo.setBounds(10, 0, 641, 49);
		frame.getContentPane().add(labelTitulo);

		panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.setBounds(10, 60, 629, 418);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 276, 243);
		panel_2.add(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);

		comboBoxTipo = new JComboBox<String>();
		comboBoxTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxTipo.setForeground(new Color(0, 0, 0));
		comboBoxTipo.setBackground(new Color(255, 255, 255));
		comboBoxTipo.setBounds(136, 42, 103, 20);
		panel.add(comboBoxTipo);
		comboBoxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (comboBoxTipo.getSelectedIndex()) {
				case 0 -> {
					lblEstructura.setVisible(false);
					comboBoxEstructura.setVisible(false);
					lblEjes.setVisible(false);
					textFieldEjes.setVisible(false);
					lblBallesta.setVisible(false);
					comboBoxBallestas.setVisible(false);

					textFieldCapCarga.setVisible(true);
					lblCapCarga.setVisible(true);
				}
				case 1 -> {
					lblEstructura.setVisible(false);
					comboBoxEstructura.setVisible(false);
					lblEjes.setVisible(false);
					textFieldEjes.setVisible(false);
					lblBallesta.setVisible(false);
					comboBoxBallestas.setVisible(false);
					textFieldCapCarga.setVisible(false);
					lblCapCarga.setVisible(false);
				}
				case 2 -> {
					lblEstructura.setVisible(true);
					comboBoxEstructura.setVisible(true);
					lblEjes.setVisible(true);
					textFieldEjes.setVisible(true);
					textFieldCapCarga.setVisible(true);
					lblCapCarga.setVisible(true);

					lblBallesta.setVisible(false);
					comboBoxBallestas.setVisible(false);
				}
				case 3 -> {
					lblEstructura.setVisible(false);
					comboBoxEstructura.setVisible(false);
					lblEjes.setVisible(false);
					textFieldEjes.setVisible(false);

					lblBallesta.setVisible(true);
					comboBoxBallestas.setVisible(true);
					textFieldCapCarga.setVisible(true);
					lblCapCarga.setVisible(true);
				}
				}
			}
		});
		comboBoxTipo
				.setModel(new DefaultComboBoxModel<String>(new String[] { "Coche", "Moto", "Camión", "Furgoneta" }));

		textFieldMarca = new JTextField();
		textFieldMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldMarca.setBounds(136, 73, 102, 20);
		panel.add(textFieldMarca);
		textFieldMarca.setColumns(10);

		textFieldModelo = new JTextField();
		textFieldModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldModelo.setBounds(137, 104, 102, 20);
		panel.add(textFieldModelo);
		textFieldModelo.setColumns(10);

		comboBoxAnyo = new JComboBox<String>();
		comboBoxAnyo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxAnyo.setBounds(136, 135, 102, 22);
		panel.add(comboBoxAnyo);
		comboBoxAnyo.setModel(new DefaultComboBoxModel<String>(
				new String[] { "", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015",
						"2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003",
						"2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995" }));
		comboBoxAnyo.setSelectedIndex(-1);

		comboBoxMotor = new JComboBox<String>();
		comboBoxMotor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxMotor.setBounds(136, 168, 102, 22);
		panel.add(comboBoxMotor);
		comboBoxMotor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (comboBoxMotor.getSelectedIndex()) {
				case 1 -> {
					lblTipoDeCarga.setVisible(false);
					comboBoxTipoCarga.setVisible(false);

					lblCilindros.setVisible(true);
					textFieldCilindros.setVisible(true);
					textFieldConsumo.setVisible(true);
					lblConsumo.setVisible(true);
					comboBoxCombustible.setVisible(true);
					lblCombustible.setVisible(true);
				}
				case 2 -> {
					lblTipoDeCarga.setVisible(true);
					comboBoxTipoCarga.setVisible(true);

					lblCilindros.setVisible(true);
					textFieldCilindros.setVisible(true);
					textFieldConsumo.setVisible(true);
					lblConsumo.setVisible(true);
					comboBoxCombustible.setVisible(true);
					lblCombustible.setVisible(true);
				}
				case 3 -> {
					lblTipoDeCarga.setVisible(true);
					comboBoxTipoCarga.setVisible(true);

					lblCilindros.setVisible(false);
					textFieldCilindros.setVisible(false);
					textFieldConsumo.setVisible(false);
					lblConsumo.setVisible(false);
					comboBoxCombustible.setVisible(false);
					lblCombustible.setVisible(false);
				}
				}
			}
		});
		comboBoxMotor
				.setModel(new DefaultComboBoxModel<String>(new String[] {"", "combustion", "hibrido", "electrico"}));
		comboBoxMotor.setSelectedIndex(-1);

		comboBoxTraccion = new JComboBox<String>();
		comboBoxTraccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxTraccion.setBounds(136, 201, 102, 22);
		panel.add(comboBoxTraccion);
		comboBoxTraccion
				.setModel(new DefaultComboBoxModel<String>(new String[] {"", "delantera", "trasera", "total"}));
		comboBoxTraccion.setSelectedIndex(-1);

		JLabel lblTraccion = new JLabel("TRACCIÓN");
		lblTraccion.setForeground(new Color(255, 128, 0));
		lblTraccion.setBounds(20, 200, 80, 22);
		panel.add(lblTraccion);
		lblTraccion.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblMotor = new JLabel("MOTOR");
		lblMotor.setForeground(new Color(255, 128, 0));
		lblMotor.setBounds(20, 167, 80, 22);
		panel.add(lblMotor);
		lblMotor.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblAnyo = new JLabel("AÑO");
		lblAnyo.setForeground(new Color(255, 128, 0));
		lblAnyo.setBounds(20, 134, 80, 22);
		panel.add(lblAnyo);
		lblAnyo.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblModelo = new JLabel("MODELO");
		lblModelo.setForeground(new Color(255, 128, 0));
		lblModelo.setBounds(20, 102, 80, 22);
		panel.add(lblModelo);
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblMarca = new JLabel("MARCA");
		lblMarca.setForeground(new Color(255, 128, 0));
		lblMarca.setBackground(new Color(255, 255, 255));
		lblMarca.setBounds(20, 72, 54, 22);
		panel.add(lblMarca);
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblTipo = new JLabel("TIPO");
		lblTipo.setForeground(new Color(255, 128, 0));
		lblTipo.setBounds(20, 40, 80, 22);
		panel.add(lblTipo);
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(52, 29, 19, 41);
		panel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(73, 70, 19, 20);
		panel.add(lblNewLabel_3);

		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(136, 11, 103, 20);
		panel.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);

		lblMatrcula = new JLabel("MATRÍCULA");
		lblMatrcula.setForeground(new Color(255, 128, 0));
		lblMatrcula.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMatrcula.setBounds(20, 11, 80, 22);
		panel.add(lblMatrcula);

		lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(97, 11, 19, 23);
		panel.add(lblNewLabel_4);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(308, 11, 301, 346);
		panel_2.add(panel_1);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);

		JLabel lblLongitud = new JLabel("LONGITUD");
		lblLongitud.setForeground(new Color(255, 128, 0));
		lblLongitud.setBounds(51, 48, 96, 16);
		panel_1.add(lblLongitud);
		lblLongitud.setFont(new Font("Tahoma", Font.BOLD, 13));

		textFieldLongitud = new JTextField();
		textFieldLongitud.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldLongitud.setBounds(164, 46, 102, 20);
		panel_1.add(textFieldLongitud);
		textFieldLongitud.setColumns(10);

		textFieldAltura = new JTextField();
		textFieldAltura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldAltura.setBounds(164, 77, 102, 20);
		panel_1.add(textFieldAltura);
		textFieldAltura.setColumns(10);

		textFieldCapCarga = new JTextField();
		textFieldCapCarga.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldCapCarga.setBounds(164, 108, 102, 20);
		panel_1.add(textFieldCapCarga);
		textFieldCapCarga.setColumns(10);

		comboBoxCombustible = new JComboBox<String>();
		comboBoxCombustible.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxCombustible.setBounds(164, 139, 102, 22);
		panel_1.add(comboBoxCombustible);
		comboBoxCombustible.setVisible(false);
		comboBoxCombustible.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Gasolina", "Diesel"}));
		comboBoxCombustible.setSelectedIndex(-1);

		textFieldConsumo = new JTextField();
		textFieldConsumo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldConsumo.setBounds(164, 172, 102, 20);
		panel_1.add(textFieldConsumo);
		textFieldConsumo.setVisible(false);
		textFieldConsumo.setColumns(10);

		textFieldCilindros = new JTextField();
		textFieldCilindros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldCilindros.setBounds(164, 203, 102, 20);
		panel_1.add(textFieldCilindros);
		textFieldCilindros.setVisible(false);
		textFieldCilindros.setColumns(10);

		comboBoxTipoCarga = new JComboBox<String>();
		comboBoxTipoCarga.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxTipoCarga.setBounds(164, 234, 102, 22);
		panel_1.add(comboBoxTipoCarga);
		comboBoxTipoCarga.setVisible(false);
		comboBoxTipoCarga
				.setModel(new DefaultComboBoxModel<String>(new String[] {"", "rapida", "semi-rapida", "lenta"}));
		comboBoxTipoCarga.setSelectedIndex(-1);

		comboBoxBallestas = new JComboBox<String>();
		comboBoxBallestas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxBallestas.setBounds(164, 267, 102, 22);
		panel_1.add(comboBoxBallestas);
		comboBoxBallestas.setVisible(false);
		comboBoxBallestas.setModel(new DefaultComboBoxModel<String>(new String[] {"", "transversal", "parabolica", "eliptica", "semi-elíptica"}));
		comboBoxBallestas.setSelectedIndex(-1);

		comboBoxEstructura = new JComboBox<String>();
		comboBoxEstructura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxEstructura.setBounds(164, 300, 102, 22);
		panel_1.add(comboBoxEstructura);
		comboBoxEstructura.setVisible(false);
		comboBoxEstructura
				.setModel(new DefaultComboBoxModel<String>(new String[] {"", "frigorifico", "tanque", "lona"}));
		comboBoxEstructura.setSelectedIndex(-1);

		textFieldEjes = new JTextField();
		textFieldEjes.setBounds(164, 267, 102, 22);
		panel_1.add(textFieldEjes);
		textFieldEjes.setVisible(false);
		textFieldEjes.setColumns(10);

		lblEstructura = new JLabel("ESTRUCTURA");
		lblEstructura.setForeground(new Color(255, 128, 0));
		lblEstructura.setBounds(51, 302, 96, 16);
		panel_1.add(lblEstructura);
		lblEstructura.setVisible(false);
		lblEstructura.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblBallesta = new JLabel("BALLESTAS");
		lblBallesta.setForeground(new Color(255, 128, 0));
		lblBallesta.setBounds(51, 266, 80, 22);
		panel_1.add(lblBallesta);
		lblBallesta.setVisible(false);
		lblBallesta.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblEjes = new JLabel("EJES");
		lblEjes.setForeground(new Color(255, 128, 0));
		lblEjes.setBounds(51, 269, 96, 16);
		panel_1.add(lblEjes);
		lblEjes.setVisible(false);
		lblEjes.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblTipoDeCarga = new JLabel("TIPO DE CARGA");
		lblTipoDeCarga.setForeground(new Color(255, 128, 0));
		lblTipoDeCarga.setBounds(51, 233, 114, 22);
		panel_1.add(lblTipoDeCarga);
		lblTipoDeCarga.setVisible(false);
		lblTipoDeCarga.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblCilindros = new JLabel("Nº CILINDROS");
		lblCilindros.setForeground(new Color(255, 128, 0));
		lblCilindros.setBounds(51, 201, 102, 22);
		panel_1.add(lblCilindros);
		lblCilindros.setVisible(false);
		lblCilindros.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblConsumo = new JLabel("CONSUMO");
		lblConsumo.setForeground(new Color(255, 128, 0));
		lblConsumo.setBounds(51, 170, 102, 22);
		panel_1.add(lblConsumo);
		lblConsumo.setVisible(false);
		lblConsumo.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblCombustible = new JLabel("COMBUSTIBLE");
		lblCombustible.setForeground(new Color(255, 128, 0));
		lblCombustible.setBounds(51, 138, 102, 22);
		panel_1.add(lblCombustible);
		lblCombustible.setVisible(false);
		lblCombustible.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblCapCarga = new JLabel("CAP. CARGA");
		lblCapCarga.setForeground(new Color(255, 128, 0));
		lblCapCarga.setBounds(51, 106, 102, 22);
		panel_1.add(lblCapCarga);
		lblCapCarga.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblAltura = new JLabel("ALTURA");
		lblAltura.setForeground(new Color(255, 128, 0));
		lblAltura.setBounds(51, 79, 103, 16);
		panel_1.add(lblAltura);
		lblAltura.setFont(new Font("Tahoma", Font.BOLD, 13));

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldAltura.setText("");
				textFieldCapCarga.setText("");
				textFieldCilindros.setText("");
				textFieldConsumo.setText("");
				textFieldEjes.setText("");
				textFieldLongitud.setText("");
				textFieldMarca.setText("");
				textFieldMatricula.setText("");
				textFieldModelo.setText("");
				
				comboBoxAnyo.setSelectedIndex(0);
				comboBoxBallestas.setSelectedIndex(0);
				comboBoxCombustible.setSelectedIndex(0);
				comboBoxEstructura.setSelectedIndex(0);
				comboBoxMatriculas.setSelectedIndex(0);
				comboBoxMotor.setSelectedIndex(0);
				comboBoxTipoCarga.setSelectedIndex(0);
				comboBoxTraccion.setSelectedIndex(0);
				
				panel_2.setVisible(false);
				panel_3.setVisible(true);
			}
		});
		btnCancelar.setBounds(357, 371, 112, 36);
		panel_2.add(btnCancelar);
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBackground(new Color(255, 128, 0));

		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new UpdateEvent(g, vd, this));
		btnModificar.setBounds(479, 371, 130, 36);
		panel_2.add(btnModificar);
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificar.setBackground(new Color(255, 128, 0));

		panel_3 = new JPanel();
		panel_3.setBounds(10, 60, 641, 418);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		lblNewLabel_1 = new JLabel("ELEGIR VEHÍCULO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(20, 31, 115, 24);
		panel_3.add(lblNewLabel_1);

		comboBoxMatriculas = new JComboBox<String>();
		ArrayList<String> matriculas = vd.findMatriculas();
		ArrayList<String> m = new ArrayList<String>();
		String[] div = null;

		for (String ms : matriculas) {
			div = ms.split("\"");
			if (div.length > 1) {
				m.add(div[3]);
			}
		}

		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(m.toArray(new String[0]));
		comboBoxMatriculas.setModel(comboBoxModel);
		comboBoxMatriculas.setBounds(145, 33, 125, 22);
		panel_3.add(comboBoxMatriculas);
		
		btnNewButton_1 = new JButton("SALIR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 128, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(482, 357, 149, 50);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BUSCAR");
		btnNewButton_2.addActionListener(new ModifyEvent(vd));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(145, 79, 125, 31);
		panel_3.add(btnNewButton_2);
	}

	public static Icon escalarIcono(ImageIcon iconoOriginal, int ancho, int alto) {
		Image imagenOriginal = iconoOriginal.getImage();
		Image imagenEscalada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		return new ImageIcon(imagenEscalada);
	}
}