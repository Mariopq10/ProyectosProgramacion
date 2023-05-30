package prueba.base.de.datos.daw;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

import javax.imageio.ImageIO;

import Utils.DAO;
import interfaces.PantallaLogin;
import interfaces.Ventana;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Ventana v = new Ventana();
		

		/*
		 * try { BufferedImage imagen = ImageIO.read(new File("./fotoclase.jpg"));
		 * 
		 * 
		 * for (int i = 0; i < imagen.getWidth(); i++) { for (int j = 0; j <
		 * imagen.getHeight(); j++) { imagen.setRGB(i, j, ~imagen.getRGB(i,
		 * j)&Integer.parseInt("FF0000",16)); } } ImageIO.write(imagen, "JPG", new
		 * File("./resultado.jpg")); /* BufferedImage img = new BufferedImage(800, 600,
		 * BufferedImage.TYPE_INT_RGB); float contadorR = 0; float contadorG = 0; float
		 * contadorB = 0;
		 * 
		 * for (int i = 0; i < img.getWidth(); i++) {
		 * 
		 * for (int j = 0; j < img.getHeight(); j++) { String colorE =
		 * String.format("%02X", (int) contadorR); colorE += String.format("%02X", (int)
		 * contadorG); colorE += String.format("%02X", (int) contadorB); img.setRGB(i,
		 * j, Integer.parseInt(colorE, 16)); contadorR = (contadorR + (255f /
		 * img.getHeight())) % 255;
		 * 
		 * } contadorG = contadorG + (255f / img.getHeight()) % 255;
		 * 
		 * }
		 * 
		 * ImageIO.write(img, "JPG", new File("./fotoclase.jpg"));
		 */

		/*
		 * } catch (IOException e) {
		 * 
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */

	}
}
