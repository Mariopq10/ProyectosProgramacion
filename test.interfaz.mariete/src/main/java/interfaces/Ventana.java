package interfaces;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	public Ventana() {
		this.setSize(600, 500);
		this.setTitle("Programita");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(new Pantalla(this));
		this.setVisible(true);
	}

	public void cambiarAPantalla(Class<?> clase) {
		this.getContentPane().setVisible(false);
		if (clase.equals(Pantalla.class)) {
			this.setContentPane(new Pantalla(this));
		}
		if (clase.equals(Pantalla2.class)) {
			this.setContentPane(new Pantalla2(this));
		}
		this.getContentPane().setVisible(true);
	}
}
