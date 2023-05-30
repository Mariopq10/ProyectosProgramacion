package interfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPrincipal extends JPanel {
	private JTextField userField;
	private Ventana ventana;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public PanelPrincipal(Ventana v) {
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 105, 40, 65, 65, 65, 60, 105, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 30, 30, 30, 30, 30, 0, 0, 96, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		BufferedImage imagen = null;
		try {
			imagen = ImageIO.read(new File(".\\fondo.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(imagen.getScaledInstance(150, 100, Image.SCALE_SMOOTH));

		JLabel tituloAnime = new JLabel("ONE PIECE");
		tituloAnime.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_tituloAnime = new GridBagConstraints();
		gbc_tituloAnime.insets = new Insets(0, 0, 5, 5);
		gbc_tituloAnime.gridx = 1;
		gbc_tituloAnime.gridy = 0;
		add(tituloAnime, gbc_tituloAnime);

		JLabel labelImagen = new JLabel("");
		labelImagen.setIcon(icon);
		GridBagConstraints gbc_labelImagen = new GridBagConstraints();
		gbc_labelImagen.insets = new Insets(0, 0, 5, 5);
		gbc_labelImagen.gridx = 1;
		gbc_labelImagen.gridy = 1;
		add(labelImagen, gbc_labelImagen);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(SegundaPantalla.class);
			}
		});
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.gridwidth = 3;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 3;
		gbc_labelNombre.gridy = 3;
		add(labelNombre, gbc_labelNombre);
		
		userField = new JTextField();
		GridBagConstraints gbc_userField = new GridBagConstraints();
		gbc_userField.gridwidth = 3;
		gbc_userField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userField.insets = new Insets(0, 0, 5, 5);
		gbc_userField.gridx = 3;
		gbc_userField.gridy = 4;
		add(userField, gbc_userField);
		userField.setColumns(10);
		
		JLabel labelGenero = new JLabel("Genero");
		labelGenero.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_labelGenero = new GridBagConstraints();
		gbc_labelGenero.gridwidth = 3;
		gbc_labelGenero.insets = new Insets(0, 0, 5, 5);
		gbc_labelGenero.gridx = 3;
		gbc_labelGenero.gridy = 5;
		add(labelGenero, gbc_labelGenero);
		
		JRadioButton buttonHombre = new JRadioButton("Hombre");
		buttonGroup.add(buttonHombre);
		GridBagConstraints gbc_buttonHombre = new GridBagConstraints();
		gbc_buttonHombre.insets = new Insets(0, 0, 5, 5);
		gbc_buttonHombre.gridx = 3;
		gbc_buttonHombre.gridy = 6;
		add(buttonHombre, gbc_buttonHombre);
		
		JRadioButton buttonMujer = new JRadioButton("Mujer");
		buttonGroup.add(buttonMujer);
		GridBagConstraints gbc_buttonMujer = new GridBagConstraints();
		gbc_buttonMujer.anchor = GridBagConstraints.WEST;
		gbc_buttonMujer.insets = new Insets(0, 0, 5, 5);
		gbc_buttonMujer.gridx = 4;
		gbc_buttonMujer.gridy = 6;
		add(buttonMujer, gbc_buttonMujer);
		
		JRadioButton buttonOtro = new JRadioButton("Otro");
		buttonGroup.add(buttonOtro);
		GridBagConstraints gbc_buttonOtro = new GridBagConstraints();
		gbc_buttonOtro.insets = new Insets(0, 0, 5, 5);
		gbc_buttonOtro.gridx = 5;
		gbc_buttonOtro.gridy = 6;
		add(buttonOtro, gbc_buttonOtro);
	}

}
