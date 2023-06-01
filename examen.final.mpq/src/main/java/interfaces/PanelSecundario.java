package interfaces;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSecundario extends JPanel {
	private Ventana ventana;
	private String tituloImagen;


	public PanelSecundario(Ventana v,String imagen) {
		this.ventana = v;
        this.tituloImagen = imagen;
        setLayout(new BorderLayout());

        // Crear JLabel para la imagen de fondo
        JLabel labelImagen = new JLabel();
        ImageIcon imagenFondo = new ImageIcon(tituloImagen + ".jpg");
        labelImagen.setIcon(imagenFondo);
        labelImagen.setHorizontalAlignment(SwingConstants.CENTER);
        labelImagen.setVerticalAlignment(SwingConstants.CENTER);
        add(labelImagen, BorderLayout.CENTER);

        // Crear botón "Ver Negativo"
        JButton verNegativoButton = new JButton("Ver Negativo");

        // Agregar ActionListener al botón "Ver Negativo"


        // Crear panel para el botón "Ver Negativo" y ajustar su ancho al 100%
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(verNegativoButton, BorderLayout.CENTER);

        // Agregar panel del botón al fondo del contenido
        add(buttonPanel, BorderLayout.SOUTH);
    }
}