package interfaces;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JCheckBox;

public class Pantalla2 extends JPanel {
	private Ventana ventana;
	private JTextField userFieldRegistro;
	private JPasswordField passwordFieldRegistro;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public Pantalla2(Ventana v) {
		this.ventana = v;

		setForeground(Color.BLACK);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		this.setSize(600, 500);

		final JComboBox selectorProvincia = new JComboBox();
		selectorProvincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Posición" + selectorProvincia.getSelectedIndex());
				System.out.println("Contenido" + selectorProvincia.getSelectedItem());
			}
		});
		selectorProvincia.addKeyListener(new KeyAdapter() {

		});
		selectorProvincia.addMouseListener(new MouseAdapter() {

		});
		selectorProvincia.setBackground(new Color(219, 213, 200));
		selectorProvincia.setModel(new DefaultComboBoxModel(
				new String[] { "Almería", "Cádiz", "Córdoba", "Granada", "Huelva", "Jaén", "Málaga", "Sevilla" }));
		selectorProvincia.setBounds(34, 210, 149, 21);
		add(selectorProvincia);

		JLabel labelProvincia = new JLabel("Selecciona provincia");
		labelProvincia.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		labelProvincia.setForeground(new Color(128, 113, 85));
		labelProvincia.setBounds(34, 184, 149, 19);
		add(labelProvincia);

		userFieldRegistro = new JTextField();
		userFieldRegistro.setBackground(new Color(219, 213, 200));
		userFieldRegistro.setForeground(Color.BLACK);
		userFieldRegistro.setColumns(10);
		userFieldRegistro.setBounds(444, 211, 104, 20);
		add(userFieldRegistro);

		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setBackground(new Color(255, 255, 255));
		labelUsuario.setForeground(new Color(128, 113, 85));
		labelUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		labelUsuario.setBounds(444, 183, 93, 23);
		add(labelUsuario);

		JLabel labelContrasena = new JLabel("Contrasena");
		labelContrasena.setForeground(new Color(128, 113, 85));
		labelContrasena.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		labelContrasena.setBounds(444, 250, 79, 14);
		add(labelContrasena);

		passwordFieldRegistro = new JPasswordField();
		passwordFieldRegistro.setBackground(new Color(219, 213, 200));
		passwordFieldRegistro.setBounds(444, 275, 104, 20);
		add(passwordFieldRegistro);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(45, 312, 126, 117);
		add(scrollPane_1);

		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Mujer");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Mujer");
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton.setBounds(34, 247, 109, 23);
		add(rdbtnNewRadioButton);

		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hombre");
			}
		});
		buttonGroup.add(rdbtnHombre);
		rdbtnHombre.setForeground(new Color(255, 255, 255));
		rdbtnHombre.setBackground(new Color(0, 0, 0));
		rdbtnHombre.setBounds(34, 274, 109, 23);
		add(rdbtnHombre);

		ButtonModel informatica = rdbtnNewRadioButton.getModel();
		ButtonModel tecnologia = rdbtnHombre.getModel();
		if (buttonGroup.getSelection() != null) {

			if (buttonGroup.getSelection().equals(rdbtnNewRadioButton))
				System.out.println("Mujer");
			if (buttonGroup.getSelection().equals(rdbtnHombre))
				System.out.println("Hombre");
		}

		JButton btnInsertarDatos = new JButton("Insertar datos");
		btnInsertarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Usuario Tecleado: " + userFieldRegistro.getText());
				String contrasena = new String(passwordFieldRegistro.getPassword());
				System.out.println("Contraseña tecleada: " + contrasena);
			}
		});
		btnInsertarDatos.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnInsertarDatos.setBounds(447, 418, 126, 52);
		add(btnInsertarDatos);

		JButton btnLimpiarDatos = new JButton("Limpiar datos");
		btnLimpiarDatos.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnLimpiarDatos.setBounds(300, 418, 119, 52);
		add(btnLimpiarDatos);
		btnLimpiarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userFieldRegistro.setText("");
				passwordFieldRegistro.setText("");
			}
		});

		JCheckBox chckbxNewCheckBox = new JCheckBox("Check");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Has clicado el check");
			}
		});
		chckbxNewCheckBox.setForeground(new Color(255, 255, 255));
		chckbxNewCheckBox.setBackground(new Color(0, 0, 0));
		chckbxNewCheckBox.setBounds(451, 324, 97, 23);
		add(chckbxNewCheckBox);

		JLabel fondoRegistro = new JLabel("New label");
		fondoRegistro.setIcon(new ImageIcon("C:\\Users\\1DAM&&1DAW\\Downloads\\useclogo.png"));
		fondoRegistro.setBounds(0, 0, 600, 500);
		add(fondoRegistro);
		this.setVisible(true);
	}
}