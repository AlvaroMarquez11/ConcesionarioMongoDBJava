package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Gestion;
import dao.VehiculosDAO;
import eventos.FindByMatriculaEvent;

public class VentanaBuscarPorMatricula extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JComboBox<Object> comboBoxMatriculas;
	public static JButton buttonBuscar;
	public static JTextArea textAreaResultado;

	public VentanaBuscarPorMatricula(Gestion g, VehiculosDAO vd) {
		setResizable(false);
		setTitle("BÚSQUEDA POR MATRICULA");
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel labelTitulo = new JLabel("AUTOS.COM");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setForeground(new Color(255, 255, 255));
		labelTitulo.setOpaque(true);
		labelTitulo.setBackground(new Color(255, 128, 0));
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelTitulo.setBounds(0, 0, 586, 49);
		contentPanel.add(labelTitulo);

		JLabel labelBusqueda = new JLabel("Búsqueda por Matricula:");
		labelBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		labelBusqueda.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelBusqueda.setBounds(10, 59, 182, 20);
		contentPanel.add(labelBusqueda);

		buttonBuscar = new JButton("BUSCAR");
		buttonBuscar.setForeground(new Color(255, 255, 255));
		buttonBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonBuscar.setBackground(new Color(255, 128, 0));
		buttonBuscar.addActionListener(new FindByMatriculaEvent(vd));	
		buttonBuscar.setBounds(10, 138, 172, 21);
		contentPanel.add(buttonBuscar);

		comboBoxMatriculas = new JComboBox<Object>();
		comboBoxMatriculas.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxMatriculas.setBounds(10, 89, 172, 21);
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

		ComboBoxModel<Object> comboBoxModel = new DefaultComboBoxModel<>(m.toArray(new String[0]));
		comboBoxMatriculas.setModel(comboBoxModel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(212, 60, 362, 255);
		contentPanel.add(scrollPane);
		
		textAreaResultado = new JTextArea();
		textAreaResultado.setText("[]");
		scrollPane.setViewportView(textAreaResultado);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(255, 128, 0));
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}