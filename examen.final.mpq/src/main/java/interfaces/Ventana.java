package interfaces;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame {

	public Ventana() {
		this.setSize(600, 600);
		this.setTitle("Examen de Programacion 1 DAW");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(new PanelPrincipal(this));
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setVisible(true);
	}

	public void cambiarAPantalla(Class<?> clase) {
		this.getContentPane().setVisible(false);
		if (clase.equals(PanelPrincipal.class)) {
			this.setContentPane(new PanelPrincipal(this));
		}
		this.getContentPane().setVisible(true);
	}
	public void cambiarAPantalla(Class<?> clase,String titulo) {
		this.getContentPane().setVisible(false);
		if (clase.equals(PanelPrincipal.class)) {
			this.setContentPane(new PanelPrincipal(this));
		}if (clase.equals(PanelSecundario.class)) {
			this.setContentPane(new PanelSecundario(this,titulo));
		}
		this.getContentPane().setVisible(true);
	}
}
