package clases;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Capitulo {
	private String titulo;
	private String descripcion;
	private String rutaRelativa;
	
	
	public Capitulo(String titulo, String descripcion, String rutaRelativa) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.rutaRelativa = rutaRelativa;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getRutaRelativa() {
		return rutaRelativa;
	}


	public void setRutaRelativa(String rutaRelativa) {
		this.rutaRelativa = rutaRelativa;
	}


	public ImageIcon loadImage(String path) {
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
