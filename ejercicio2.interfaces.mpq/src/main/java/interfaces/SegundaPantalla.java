package interfaces;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SegundaPantalla extends JPanel {
	private Ventana ventana;
	private ArrayList<String> nombresCapitulos;
	private ArrayList<String> descripcionesCapitulos;
	private ArrayList<String> rutaImagen;

	public SegundaPantalla(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		JScrollPane lista = new JScrollPane();
		add(lista, BorderLayout.CENTER);

		JPanel contenedorElemento = new JPanel();
		lista.setViewportView(contenedorElemento);
		contenedorElemento.setLayout(new BoxLayout(contenedorElemento, BoxLayout.Y_AXIS));

		nombresCapitulos = new ArrayList<>(
				Arrays.asList("La partida de Luffy", "El encuentro con Zoro", "El cocinero valiente",
						"La navegante del océano", "La isla misteriosa", "El enfrentemiento con Baroque", "Water Seven",
						"Marineford", "La isla de los gigantes", "Reencuentro de los Piratas del Sombrero de Paja"));
		descripcionesCapitulos = new ArrayList<>(
				Arrays.asList("La búsqueda del One Piece comienza mientras forma su tripulación pirata",
						"Luffy se enfrenta a un poderoso espadachín en su camino hacia Grand Line",
						"Sanji se une a la tripulación y demuestra su habilidad culinaria en una crisis",
						"Nami lucha contra su pasado y se une como la navegante del barco",
						"La tripulación se encuentra con extrañas criaturas en una isla llena de secretos",
						"Luffy y su equipo se enfrentan a un grupo de cazadores de recompensas",
						"La tripulación se enfrenta a peligrosos piratas mientras busca un nuevo barco",
						"Luffy desata todo su poder para salvar a su hermano Ace en una batalla épica",
						"La tripulación se enfrenta a enormes criaturas y descubre la verdad detrás de ellas",
						"Luffy y su tripulación se reúnen después de 2 años tras el suceso de Sabaody"));
		rutaImagen = new ArrayList<>(Arrays.asList(".\\foto1.jpg", ".\\foto2.jpg", ".\\foto3.jpg", ".\\foto4.jpg",
				".\\foto5.jpg", ".\\foto6.jpg", ".\\foto7.jpg", ".\\foto8.jpg", ".\\foto9.jpg", ".\\foto10.jpg"));

		for (byte i = 0; i < 10; i++) {
			contenedorElemento.add(new ElementoLista(v, nombresCapitulos.get(i), descripcionesCapitulos.get(i),
					loadImage(rutaImagen.get(i)), rutaImagen.get(i)));
		}
	}

	private ImageIcon loadImage(String path) {
		BufferedImage imagen = null;
		try {
			imagen = ImageIO.read(new File(path));
		} catch (IOException e) {

			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(imagen.getScaledInstance(150, 100, Image.SCALE_SMOOTH));
		return icon;
	}

}
