package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class Pantalla extends JPanel {
	private JTextField userField;
	private JPasswordField passwordField;
	private Ventana ventana;

	public Pantalla(Ventana v) {
		this.ventana = v;

		setForeground(Color.BLACK);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		this.setSize(600, 500);

		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setForeground(new Color(128, 113, 85));
		labelUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		labelUsuario.setBounds(31, 213, 93, 23);
		add(labelUsuario);

		userField = new JTextField();
		userField.setBounds(31, 251, 104, 20);
		add(userField);
		userField.setColumns(10);

		JLabel labelContrasena = new JLabel("Contrasena");
		labelContrasena.setForeground(new Color(128, 113, 85));
		labelContrasena.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		labelContrasena.setBounds(31, 298, 79, 14);
		add(labelContrasena);

		passwordField = new JPasswordField();
		passwordField.setBounds(31, 323, 104, 20);
		add(passwordField);

		JButton botonLogin = new JButton("Login");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String usuario = userField.getText();
				String contrasena = new String(passwordField.getPassword());
				System.out.println(usuario + " : " + contrasena);
			}
		});
		botonLogin.setToolTipText("Pincha para iniciar");
		botonLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		botonLogin.setBackground(new Color(192, 192, 192));
		botonLogin.setBounds(29, 408, 120, 61);
		add(botonLogin);

		JButton botonRegistro = new JButton("Registro");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(Pantalla2.class);
			}
		});
		botonRegistro.setToolTipText("Pincha para registrarte");
		botonRegistro.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		botonRegistro.setBackground(Color.LIGHT_GRAY);
		botonRegistro.setBounds(459, 408, 104, 61);
		add(botonRegistro);

		JButton btnInsertarDatos = new JButton("Insertar datos");
		btnInsertarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Usuario Tecleado: " + userField.getText());
				String contrasena = new String(passwordField.getPassword());
				System.out.println("Contraseña tecleada: " + contrasena);
			}
		});
		btnInsertarDatos.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnInsertarDatos.setBounds(314, 409, 120, 61);
		add(btnInsertarDatos);

		JButton btnLimpiarDatos = new JButton("Limpiar datos");
		btnLimpiarDatos.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnLimpiarDatos.setBounds(171, 408, 120, 61);
		add(btnLimpiarDatos);
		btnLimpiarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userField.setText("");
				passwordField.setText("");
			}
		});

		JLabel fondoLogin = new JLabel("New label");
		fondoLogin.setIcon(new ImageIcon("C:\\Users\\1DAM&&1DAW\\Downloads\\useclogo.png"));
		fondoLogin.setBounds(0, 0, 600, 500);
		add(fondoLogin);
		this.setVisible(true);
	}
}
