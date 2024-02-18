package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Gestion;
import dao.VehiculosDAO;

public class VentanaPrincipal extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JPanel panelConfirmación;
	public static JLabel lblConfirmacion;

	public VentanaPrincipal(Gestion g, VehiculosDAO vd) {
		setResizable(false);
		setBounds(100, 100, 500, 400);
		this.setTitle("HOME");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel labelTitulo = new JLabel("AUTOS.COM");
			labelTitulo.setOpaque(true);
			labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			labelTitulo.setForeground(Color.WHITE);
			labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
			labelTitulo.setBackground(new Color(255, 128, 0));
			labelTitulo.setBounds(0, 0, 486, 49);
			contentPanel.add(labelTitulo);
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(20, 60, 445, 260);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JButton buttonCrearVehiculo = new JButton("Crear vehículo");
		buttonCrearVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearVehiculo vcv = new VentanaCrearVehiculo(g, vd);
				vcv.frame.setVisible(true);
			}
		});
		buttonCrearVehiculo.setForeground(new Color(255, 255, 255));
		buttonCrearVehiculo.setBackground(new Color(255, 128, 0));
		buttonCrearVehiculo.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonCrearVehiculo.setBounds(27, 41, 179, 25);
		panel.add(buttonCrearVehiculo);
		
		JButton buttonBorrarVehiculo = new JButton("Borrar vehículo");
		buttonBorrarVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaBorrarVehiculo vb = new VentanaBorrarVehiculo(g, vd);
				vb.setVisible(true);
			}
		});
		buttonBorrarVehiculo.setForeground(Color.WHITE);
		buttonBorrarVehiculo.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonBorrarVehiculo.setBackground(new Color(255, 128, 0));
		buttonBorrarVehiculo.setBounds(27, 102, 179, 25);
		panel.add(buttonBorrarVehiculo);
		
		JButton buttonModificarVehiculo = new JButton("Modificar vehículo");
		buttonModificarVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaModificar vm = new VentanaModificar(g, vd);
				vm.frame.setVisible(true);
			}
		});
		buttonModificarVehiculo.setForeground(Color.WHITE);
		buttonModificarVehiculo.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonModificarVehiculo.setBackground(new Color(255, 128, 0));
		buttonModificarVehiculo.setBounds(27, 163, 179, 25);
		panel.add(buttonModificarVehiculo);
		
		JButton buttonMostrarVehiculos = new JButton("Mostrar vehículos");
		buttonMostrarVehiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMostrarTodos vmt = new VentanaMostrarTodos(g, vd);
				vmt.setVisible(true);
			}
		});
		buttonMostrarVehiculos.setForeground(Color.WHITE);
		buttonMostrarVehiculos.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonMostrarVehiculos.setBackground(new Color(255, 128, 0));
		buttonMostrarVehiculos.setBounds(228, 41, 179, 25);
		panel.add(buttonMostrarVehiculos);
		
		JButton buttonBuscarPorMatricula = new JButton("Buscar por matrícula");
		buttonBuscarPorMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaBuscarPorMatricula vbm = new VentanaBuscarPorMatricula(g, vd);
				vbm.setVisible(true);
			}
		});
		buttonBuscarPorMatricula.setForeground(Color.WHITE);
		buttonBuscarPorMatricula.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonBuscarPorMatricula.setBackground(new Color(255, 128, 0));
		buttonBuscarPorMatricula.setBounds(228, 102, 179, 25);
		panel.add(buttonBuscarPorMatricula);
		
		JButton buttonBuscarPorTipo = new JButton("Buscar por tipo");
		buttonBuscarPorTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaBuscarPorTipo vbt = new VentanaBuscarPorTipo(g, vd);
				vbt.setVisible(true);
			}
		});
		buttonBuscarPorTipo.setForeground(Color.WHITE);
		buttonBuscarPorTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonBuscarPorTipo.setBackground(new Color(255, 128, 0));
		buttonBuscarPorTipo.setBounds(228, 163, 179, 25);
		panel.add(buttonBuscarPorTipo);
		
		panelConfirmación = new JPanel();
		panelConfirmación.setForeground(new Color(255, 255, 255));
		panelConfirmación.setBackground(Color.green);
		panelConfirmación.setVisible(false);
		panelConfirmación.setBounds(0, 225, 445, 35);
		panel.add(panelConfirmación);
		panelConfirmación.setLayout(null);
		
		lblConfirmacion = new JLabel("");
		lblConfirmacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConfirmacion.setForeground(new Color(255, 255, 255));
		lblConfirmacion.setBounds(10, 11, 425, 14);
		panelConfirmación.add(lblConfirmacion);
		
		JButton buttonSalir = new JButton("Salir");
		buttonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonSalir.setBounds(379, 324, 86, 29);
		contentPanel.add(buttonSalir);
		buttonSalir.setForeground(Color.WHITE);
		buttonSalir.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonSalir.setBackground(new Color(255, 128, 0));
	}
}