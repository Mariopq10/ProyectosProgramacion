package interfaces;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import clases.Cliente;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class PantallaRegistro extends JPanel {
	private Ventana ventana;
	private JTextField campoEmail;
	private JTextField campoNombre;
	private JTextField campoTelefono;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField passwordField;

	public PantallaRegistro(Ventana v) {
		this.ventana = v;

		setForeground(Color.BLACK);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBackground(new Color(192, 192, 192));
		this.setSize(600, 500);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 16, 90, 0, 101, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 40, 40, 40, 40, 30, 30, 40, 0, 0, -24, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel tituloRegistrate = new JLabel("Registrate");
		tituloRegistrate.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		GridBagConstraints gbc_tituloRegistrate = new GridBagConstraints();
		gbc_tituloRegistrate.gridwidth = 3;
		gbc_tituloRegistrate.insets = new Insets(0, 0, 5, 5);
		gbc_tituloRegistrate.gridx = 1;
		gbc_tituloRegistrate.gridy = 0;
		add(tituloRegistrate, gbc_tituloRegistrate);

		JLabel tituloEmail = new JLabel("Email");
		GridBagConstraints gbc_tituloEmail = new GridBagConstraints();
		gbc_tituloEmail.insets = new Insets(0, 0, 5, 5);
		gbc_tituloEmail.gridx = 1;
		gbc_tituloEmail.gridy = 1;
		add(tituloEmail, gbc_tituloEmail);

		campoEmail = new JTextField();
		campoEmail.setColumns(10);
		GridBagConstraints gbc_campoEmail = new GridBagConstraints();
		gbc_campoEmail.gridwidth = 2;
		gbc_campoEmail.insets = new Insets(0, 0, 5, 5);
		gbc_campoEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoEmail.gridx = 2;
		gbc_campoEmail.gridy = 1;
		add(campoEmail, gbc_campoEmail);

		JLabel tituloNombre = new JLabel("Nombre");
		GridBagConstraints gbc_tituloNombre = new GridBagConstraints();
		gbc_tituloNombre.insets = new Insets(0, 0, 5, 5);
		gbc_tituloNombre.gridx = 1;
		gbc_tituloNombre.gridy = 2;
		add(tituloNombre, gbc_tituloNombre);

		campoNombre = new JTextField();
		campoNombre.setColumns(10);
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.gridwidth = 2;
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 2;
		gbc_campoNombre.gridy = 2;
		add(campoNombre, gbc_campoNombre);

		JLabel tituloTelefono = new JLabel("Telefono");
		GridBagConstraints gbc_tituloTelefono = new GridBagConstraints();
		gbc_tituloTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_tituloTelefono.gridx = 1;
		gbc_tituloTelefono.gridy = 3;
		add(tituloTelefono, gbc_tituloTelefono);

		campoTelefono = new JTextField();
		campoTelefono.setColumns(10);
		GridBagConstraints gbc_campoTelefono = new GridBagConstraints();
		gbc_campoTelefono.gridwidth = 2;
		gbc_campoTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_campoTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoTelefono.gridx = 2;
		gbc_campoTelefono.gridy = 3;
		add(campoTelefono, gbc_campoTelefono);

		JLabel tituloContrasena = new JLabel("Contraseña");
		GridBagConstraints gbc_tituloContrasena = new GridBagConstraints();
		gbc_tituloContrasena.anchor = GridBagConstraints.EAST;
		gbc_tituloContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_tituloContrasena.gridx = 1;
		gbc_tituloContrasena.gridy = 4;
		add(tituloContrasena, gbc_tituloContrasena);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 4;
		add(passwordField, gbc_passwordField);

		JLabel lblNewLabel = new JLabel("Genero");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 5;
		add(lblNewLabel, gbc_lblNewLabel);

		JRadioButton radioHombre = new JRadioButton("Hombre");
		buttonGroup.add(radioHombre);
		GridBagConstraints gbc_radioHombre = new GridBagConstraints();
		gbc_radioHombre.insets = new Insets(0, 0, 5, 5);
		gbc_radioHombre.gridx = 1;
		gbc_radioHombre.gridy = 6;
		add(radioHombre, gbc_radioHombre);

		JRadioButton radioMujer = new JRadioButton("Mujer");
		buttonGroup.add(radioMujer);
		GridBagConstraints gbc_radioMujer = new GridBagConstraints();
		gbc_radioMujer.insets = new Insets(0, 0, 5, 5);
		gbc_radioMujer.gridx = 2;
		gbc_radioMujer.gridy = 6;
		add(radioMujer, gbc_radioMujer);

		JRadioButton radioOtro = new JRadioButton("Otro");
		buttonGroup.add(radioOtro);
		GridBagConstraints gbc_radioOtro = new GridBagConstraints();
		gbc_radioOtro.insets = new Insets(0, 0, 5, 5);
		gbc_radioOtro.gridx = 3;
		gbc_radioOtro.gridy = 6;
		add(radioOtro, gbc_radioOtro);

		JButton botonRegistro = new JButton("Registro");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					String nombre = campoNombre.getText();
					String contrasena = new String(passwordField.getPassword());
					int telefono = Integer.parseInt(campoTelefono.getText());
					String email = campoEmail.getText();
					new Cliente(nombre, email, telefono, contrasena);
					JOptionPane.showMessageDialog(ventana, "Registrado correctamente", "Exito",
							JOptionPane.INFORMATION_MESSAGE);
					ventana.cambiarAPantalla(PantallaLogin.class);
				} catch (SQLIntegrityConstraintViolationException e3) {
					JOptionPane.showMessageDialog(ventana, "El email ya exite", "No se pudo registrar",
							JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, "Conexion incorrecta", "No se puede conectar a la BD",
							JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(ventana, "Tienes que poner solo numeros",
							"Numero de telefono incorrecto", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botonRegistro.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		botonRegistro.setBackground(new Color(0, 128, 255));
		GridBagConstraints gbc_botonRegistro = new GridBagConstraints();
		gbc_botonRegistro.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_botonRegistro.gridx = 2;
		gbc_botonRegistro.gridy = 7;
		add(botonRegistro, gbc_botonRegistro);

		JButton botonLimpiarCampos = new JButton("Limpiar campos");
		botonLimpiarCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				campoNombre.setText("");
				campoEmail.setText("");
				passwordField.setText("");
				campoTelefono.setText("");
				buttonGroup.clearSelection();
			}
		});
		botonLimpiarCampos.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		botonLimpiarCampos.setBackground(new Color(250, 188, 189));
		GridBagConstraints gbc_botonLimpiarCampos = new GridBagConstraints();
		gbc_botonLimpiarCampos.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonLimpiarCampos.insets = new Insets(0, 0, 5, 5);
		gbc_botonLimpiarCampos.gridx = 2;
		gbc_botonLimpiarCampos.gridy = 9;
		add(botonLimpiarCampos, gbc_botonLimpiarCampos);

		JButton botonAtras = new JButton("Atrás");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaLogin.class);

			}
		});
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.anchor = GridBagConstraints.WEST;
		gbc_botonAtras.fill = GridBagConstraints.VERTICAL;
		gbc_botonAtras.insets = new Insets(0, 0, 0, 5);
		gbc_botonAtras.gridx = 0;
		gbc_botonAtras.gridy = 11;
		add(botonAtras, gbc_botonAtras);
		this.setVisible(true);

	}
}
