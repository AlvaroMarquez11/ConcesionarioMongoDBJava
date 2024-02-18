package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Gestion;
import dao.VehiculosDAO;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static VentanaLogin frame;

	public VentanaLogin(Gestion g, VehiculosDAO vd) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelTitulo = new JLabel("AUTOS.COM");
		labelTitulo.setOpaque(true);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelTitulo.setBackground(new Color(255, 128, 0));
		labelTitulo.setBounds(0, 0, 436, 49);
		contentPane.add(labelTitulo);

		JButton buttonEntrar = new JButton("ENTRAR");
		buttonEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal vp = new VentanaPrincipal(g, vd);
				vp.setVisible(true);
			}
		});
		buttonEntrar.setBackground(new Color(255, 128, 0));
		buttonEntrar.setForeground(new Color(255, 255, 255));
		buttonEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonEntrar.setBounds(252, 145, 108, 31);
		contentPane.add(buttonEntrar);

		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(new Color(255, 128, 0));
		panelLogo.setBounds(0, 47, 161, 216);
		contentPane.add(panelLogo);
		panelLogo.setLayout(null);

		String rutaIconoOriginal = "src/main/java/view/IconoCoche.png";
		Icon iconoReducido = escalarIcono(new ImageIcon(rutaIconoOriginal), 100, 100);

		JLabel labelIcono = new JLabel("");
		labelIcono.setIcon(iconoReducido);
		labelIcono.setBounds(10, 15, 141, 114);
		panelLogo.add(labelIcono);
		
		JLabel labelAchraf = new JLabel("Achraf Boujaanan");
		labelAchraf.setHorizontalAlignment(SwingConstants.LEFT);
		labelAchraf.setForeground(new Color(255, 255, 255));
		labelAchraf.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelAchraf.setBounds(10, 130, 141, 13);
		panelLogo.add(labelAchraf);
		
		JLabel labelAlvaro = new JLabel("Álvaro Márquez");
		labelAlvaro.setHorizontalAlignment(SwingConstants.LEFT);
		labelAlvaro.setForeground(Color.WHITE);
		labelAlvaro.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelAlvaro.setBounds(10, 150, 141, 13);
		panelLogo.add(labelAlvaro);
		
		JLabel labelContacto = new JLabel("cars@autos.com");
		labelContacto.setHorizontalAlignment(SwingConstants.LEFT);
		labelContacto.setForeground(Color.WHITE);
		labelContacto.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelContacto.setBounds(10, 170, 141, 13);
		panelLogo.add(labelContacto);
		
		JLabel labelContactoMovil = new JLabel("(+34) 999-999-999");
		labelContactoMovil.setHorizontalAlignment(SwingConstants.LEFT);
		labelContactoMovil.setForeground(Color.WHITE);
		labelContactoMovil.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelContactoMovil.setBounds(10, 190, 141, 13);
		panelLogo.add(labelContactoMovil);
		
		JLabel labelBienvenida = new JLabel("¡BIENVENIDO!");
		labelBienvenida.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelBienvenida.setForeground(new Color(255, 128, 0));
		labelBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		labelBienvenida.setBounds(186, 72, 240, 24);
		contentPane.add(labelBienvenida);

	}

	public static Icon escalarIcono(ImageIcon iconoOriginal, int ancho, int alto) {
		Image imagenOriginal = iconoOriginal.getImage();
		Image imagenEscalada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		return new ImageIcon(imagenEscalada);
	}

}