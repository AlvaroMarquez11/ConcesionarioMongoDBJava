package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Gestion;
import dao.VehiculosDAO;

public class VentanaMostrarTodos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtMostrarTodosLos;

	public VentanaMostrarTodos(Gestion g, VehiculosDAO vd) {
		setResizable(false);
		setBounds(100, 100, 497, 368);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(235, 235, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel labelTitulo = new JLabel("AUTOS.COM");
		labelTitulo.setBounds(0, 0, 481, 49);
		labelTitulo.setOpaque(true);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelTitulo.setBackground(new Color(255, 128, 0));
		contentPanel.add(labelTitulo);

		txtMostrarTodosLos = new JTextField();
		txtMostrarTodosLos.setBounds(0, 48, 481, 20);
		txtMostrarTodosLos.setEditable(false);
		txtMostrarTodosLos.setBorder(null);
		txtMostrarTodosLos.setForeground(new Color(255, 255, 255));
		txtMostrarTodosLos.setBackground(new Color(255, 128, 0));
		txtMostrarTodosLos.setHorizontalAlignment(SwingConstants.CENTER);
		txtMostrarTodosLos.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMostrarTodosLos.setText("MOSTRANDO TODOS LOS DATOS");
		contentPanel.add(txtMostrarTodosLos);
		txtMostrarTodosLos.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(0, 68, 10, 226);
		panel.setBackground(new Color(255, 128, 0));
		contentPanel.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 284, 471, 10);
		panel_1.setBackground(new Color(255, 128, 0));
		contentPanel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(471, 68, 10, 217);
		panel_2.setBackground(new Color(255, 128, 0));
		contentPanel.add(panel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 461, 216);
		contentPanel.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText(vd.findAllVehiculos(g).toString());
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(255, 128, 0));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton cancelButton = new JButton("SALIR");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancelButton.setBackground(new Color(220, 220, 220));
		cancelButton.setForeground(new Color(0, 0, 0));
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}
}
