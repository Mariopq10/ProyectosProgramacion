package interfaces;

import javax.swing.JPanel;
import javax.swing.RootPaneContainer;

import clases.Capitulo;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.color.ColorSpace;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ElementoLista extends JPanel {
	private Ventana ventana;

	public ElementoLista(Ventana v, final Capitulo capitulo) {
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 40, 0, 0, 0, 40, 64, 30, 0 };
		gridBagLayout.rowHeights = new int[] { 19, 50, 50, 50, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel labelTitulo = new JLabel("" + capitulo.getTitulo());
		labelTitulo.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 1;
		gbc_labelEmail.gridy = 1;
		add(labelTitulo, gbc_labelEmail);

		JLabel labelUsuario = new JLabel("" + capitulo.getDescripcion());
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelUsuario.gridx = 1;
		gbc_labelUsuario.gridy = 2;
		add(labelUsuario, gbc_labelUsuario);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(capitulo.loadImage(capitulo.getRutaRelativa()));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		JButton buttonDescripcion = new JButton("Descripción");
		buttonDescripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane ventanaEmergente = new JOptionPane();
				ImageIcon fondo = convertirAGris(capitulo.getRutaRelativa());
				JLabel backgroundLabel = new JLabel(fondo);
				JPanel panel = new JPanel();
				panel.add(backgroundLabel);
				JLabel titleLabel = new JLabel(capitulo.getTitulo() + ".");
				JLabel descriptionLabel = new JLabel(capitulo.getDescripcion());
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				panel.add(titleLabel);
				panel.add(descriptionLabel);
				ventanaEmergente.showMessageDialog(null, panel, capitulo.getTitulo(), JOptionPane.PLAIN_MESSAGE);
				ventanaEmergente.setSize(500, 400);
				ventanaEmergente.setVisible(true);
			}
		});
		GridBagConstraints gbc_buttonDescripcion = new GridBagConstraints();
		gbc_buttonDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_buttonDescripcion.gridx = 5;
		gbc_buttonDescripcion.gridy = 2;
		add(buttonDescripcion, gbc_buttonDescripcion);
	}

	private ImageIcon convertirAGris(String rutaImagen) {
		BufferedImage imagen = null;
		try {
			imagen = ImageIO.read(new File(rutaImagen));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ColorConvertOp colorConvert = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
		// Aplica la conversión a escala de grises a la imagen
		BufferedImage grayscaleImage = colorConvert.filter(imagen, null);
		ImageIcon icon = new ImageIcon(grayscaleImage.getScaledInstance(600, 337, Image.SCALE_SMOOTH));
		return icon;

	}

}
