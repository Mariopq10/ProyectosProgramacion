package interfaces;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PanelSecundario extends JPanel {
	private Ventana ventana;
	private BufferedImage backgroundImage;

	public PanelSecundario(Ventana v) {
		this.ventana = v;

	public BackgroundPanel(String imagePath) {
		        try {
		            // Cargar la imagen de fondo
		            backgroundImage = ImageIO.read(new File(imagePath));
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

	

	

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // Dibujar la imagen de fondo
    if (backgroundImage != null) {
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
    }
}
