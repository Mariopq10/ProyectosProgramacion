package examenTroll.mpq;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.util.Scanner;

import clases.RecorridoTroll;
import excepciones.NoEsImagenException;

public class Main {

	public static void main(String[] args) {

		RecorridoTroll recorrido = new RecorridoTroll();
		File ruta = new File("./arbol1DAM");
		recorrido.recorridoTroll(ruta);
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce la ruta de la imagen:");
		String rutaImagen = scanner.nextLine();
		try {
			File imagen = new File(rutaImagen);
			recorrido.trastocarImagen(imagen);
		} catch (NoEsImagenException e) {
			System.out.println("La ruta especificada no es una imagen.");
		}
	}

}
