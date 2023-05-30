package interfaces;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame {
	public Ventana() {
		this.setSize(1000, 800);
		this.setTitle("One Piece");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(new PanelPrincipal(this));
		this.setIconImage(new ImageIcon("./fondo.jpg").getImage());
		this.setVisible(true);
	}

	public void cambiarAPantalla(Class<?> clase) {
		this.getContentPane().setVisible(false);
		if (clase.equals(PanelPrincipal.class)) {
			this.setContentPane(new PanelPrincipal(this));
		}if (clase.equals(SegundaPantalla.class)) {
			this.setContentPane(new SegundaPantalla(this));
		}

		this.getContentPane().setVisible(true);
	}
}
