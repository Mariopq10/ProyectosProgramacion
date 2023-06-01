package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelSecundario extends JPanel {
	private Ventana ventana;
	private String tituloImagen;

	public PanelSecundario(Ventana v, String imagen) {
		this.ventana = v;
		this.tituloImagen = imagen;

		setLayout(new BorderLayout());

		JLabel labelImagen = new JLabel();
		final ImageIcon imagenFondo = new ImageIcon(imagen);
		labelImagen.setIcon(imagenFondo);
		add(labelImagen, BorderLayout.CENTER);

		JButton verNegativoButton = new JButton("Ver Negativo");
		JPanel buttonPanel = new JPanel();
		verNegativoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane ventanaEmergente = new JOptionPane();
				ImageIcon fondo = convertirANegativo(tituloImagen);
				JLabel backgroundLabel = new JLabel(fondo);
				JPanel panel = new JPanel();
				JLabel titleLabel = new JLabel(tituloImagen);
				panel.add(backgroundLabel);
				panel.add(titleLabel);
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				ventanaEmergente.showMessageDialog(null, panel, "Imagen", JOptionPane.PLAIN_MESSAGE);
				ventanaEmergente.setSize(500, 400);
				ventanaEmergente.setVisible(true);
			}
		});
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(verNegativoButton, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	private ImageIcon convertirANegativo(String tituloImagen) {
		BufferedImage imagen = null;
		try {
			imagen = ImageIO.read(new File(tituloImagen));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ColorConvertOp colorConvert = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
		BufferedImage imagenGris = colorConvert.filter(imagen, null);
		ImageIcon icon = new ImageIcon(imagenGris.getScaledInstance(600, 337, Image.SCALE_SMOOTH));
		return icon;

	}

}