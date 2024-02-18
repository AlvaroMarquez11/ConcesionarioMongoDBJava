package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Gestion;
import dao.VehiculosDAO;
import hilos.MensajeVehiculoBorrado;

public class VentanaBorrarVehiculo extends JDialog {

	private static final long serialVersionUID = 1L;
	public final JPanel contentPanel = new JPanel();
	public static JComboBox<String> comboBoxMatriculas;

	public VentanaBorrarVehiculo(Gestion g, VehiculosDAO vd) {
		setBounds(100, 100, 500, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel labelTitulo = new JLabel("AUTOS.COM");
		labelTitulo.setOpaque(true);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelTitulo.setBackground(new Color(255, 128, 0));
		labelTitulo.setBounds(0, 0, 476, 49);
		contentPanel.add(labelTitulo);

		JLabel labelSeleccion = new JLabel("Selecciona un vehículo:");
		labelSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
		labelSeleccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelSeleccion.setBounds(151, 59, 172, 20);
		contentPanel.add(labelSeleccion);

		comboBoxMatriculas = new JComboBox<String>();
		comboBoxMatriculas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxMatriculas.setBounds(151, 89, 155, 21);
		contentPanel.add(comboBoxMatriculas);
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

		JLabel labelRespuesta = new JLabel("");
		labelRespuesta.setOpaque(true);
		labelRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
		labelRespuesta.setForeground(Color.GREEN);
		labelRespuesta.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelRespuesta.setBackground(new Color(255, 255, 255));
		labelRespuesta.setBounds(0, 340, 200, 20);
		contentPanel.add(labelTitulo);
		labelRespuesta.setVisible(false);

		JButton buttonBorrar = new JButton("Borrar vehículo");
		buttonBorrar.setForeground(Color.WHITE);
		buttonBorrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonBorrar.setBackground(new Color(255, 128, 0));
		buttonBorrar.setActionCommand("Cancel");
		buttonBorrar.setBounds(151, 194, 155, 25);
		contentPanel.add(buttonBorrar);
		buttonBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MensajeVehiculoBorrado mvb = new MensajeVehiculoBorrado(vd, g);
				mvb.start();
			}
		});
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			JButton buttonSalir = new JButton("Salir");
			buttonSalir.setForeground(Color.WHITE);
			buttonSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
			buttonSalir.setBackground(new Color(255, 128, 0));
			buttonSalir.setActionCommand("Cancel");
			buttonPane.add(buttonSalir);
			buttonSalir.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
				}
			});
		}
	}
}