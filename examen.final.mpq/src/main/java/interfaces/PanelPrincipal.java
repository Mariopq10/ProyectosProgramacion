package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.color.ColorSpace;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPrincipal extends JPanel {
	private Ventana ventana;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	public PanelPrincipal(Ventana v) {
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Seleccionar Imagen");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 6;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		JRadioButton botonImagen1 = new JRadioButton("Imagen 1");
		buttonGroup.add(botonImagen1);
		GridBagConstraints gbc_botonImagen1 = new GridBagConstraints();
		gbc_botonImagen1.insets = new Insets(0, 0, 0, 5);
		gbc_botonImagen1.gridx = 1;
		gbc_botonImagen1.gridy = 2;
		add(botonImagen1, gbc_botonImagen1);

		JRadioButton botonImagen2 = new JRadioButton("Imagen 2");
		buttonGroup.add(botonImagen2);
		GridBagConstraints gbc_botonImagen2 = new GridBagConstraints();
		gbc_botonImagen2.insets = new Insets(0, 0, 0, 5);
		gbc_botonImagen2.gridx = 2;
		gbc_botonImagen2.gridy = 2;
		add(botonImagen2, gbc_botonImagen2);

		JRadioButton botonImagen3 = new JRadioButton("Imagen 3");
		buttonGroup.add(botonImagen3);
		GridBagConstraints gbc_botonImagen3 = new GridBagConstraints();
		gbc_botonImagen3.insets = new Insets(0, 0, 0, 5);
		gbc_botonImagen3.gridx = 3;
		gbc_botonImagen3.gridy = 2;
		add(botonImagen3, gbc_botonImagen3);

		JRadioButton botonImagen4 = new JRadioButton("Imagen 4");
		buttonGroup.add(botonImagen4);
		GridBagConstraints gbc_botonImagen4 = new GridBagConstraints();
		gbc_botonImagen4.insets = new Insets(0, 0, 0, 5);
		gbc_botonImagen4.gridx = 4;
		gbc_botonImagen4.gridy = 2;
		add(botonImagen4, gbc_botonImagen4);
		final JButton botonVerImagen = new JButton("Ver Imagen");
		botonVerImagen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JRadioButton botonSeleccionado = null;

				Enumeration<AbstractButton> buttons = buttonGroup.getElements();
				while (buttons.hasMoreElements()) {
					AbstractButton button = buttons.nextElement();
					if (button.isSelected()) {
						botonSeleccionado = (JRadioButton) button;
						break;
					}
				}
				if (buttonGroup.getSelection() == null) {
					JOptionPane.showMessageDialog(PanelPrincipal.this, "Error: Debes elegir una imagen", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					String ruta = botonSeleccionado.getText();
					ventana.cambiarAPantalla(PanelSecundario.class, ruta+".jpg");
				}
			}
		});

		GridBagConstraints gbc_botonVerImagen = new GridBagConstraints();
		gbc_botonVerImagen.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonVerImagen.gridwidth = 6;
		gbc_botonVerImagen.insets = new Insets(0, 0, 5, 0);
		gbc_botonVerImagen.gridx = 0;
		gbc_botonVerImagen.gridy = 1;
		add(botonVerImagen, gbc_botonVerImagen);

	}

	private ImageIcon verImagen(String rutaImagen) {
		BufferedImage imagen = null;
		try {
			imagen = ImageIO.read(new File(rutaImagen));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(imagen.getScaledInstance(600, 337, Image.SCALE_SMOOTH));
		return icon;

	}
}
