package examenTroll.mpq;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;

public class Main {

	public static void main(String[] args) {

		File carpeta = new File("./");
		if (carpeta.isDirectory()) {
			File[] hijos = carpeta.listFiles();
			for (short i = 0; i < hijos.length; i++) {
				File hijoActual = hijos[i];
				if (hijoActual.isDirectory()) {

				} else {
					System.out.println(hijoActual.getAbsolutePath() + " : " + hijoActual.length() + " : "
							+ LocalDateTime.ofEpochSecond(hijoActual.lastModified() / 1000, 0,
									ZoneOffset.systemDefault().getRules().getOffset(Instant.now())));
				}
			}
		}

		/*
		 * File archivo = new File("./noExisto.txt");
		 * System.out.println("Existe el archivo: " + archivo.exists()); try {
		 * System.out.println("Pude crear el archivo: " + archivo.createNewFile());
		 * System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
		 * System.out.println("Nombre: " + archivo.getName());
		 * System.out.println("Carpeta Madre: " + archivo.getParent());
		 * System.out.println("Es un directorio? " + archivo.isDirectory());
		 * System.out.println("Tamano del disco duro: " + archivo.getTotalSpace());
		 * System.out.println("Tamaño libre del disco duro: " + archivo.getFreeSpace());
		 * System.out.println("Tamano del archivo: " + archivo.length() / 1024f);
		 * System.out.println("Fecha de modificacion: " + archivo.lastModified());
		 * LocalDateTime ultimaMod =
		 * LocalDateTime.ofEpochSecond(archivo.lastModified()/1000, 0,
		 * ZoneOffset.systemDefault().getRules().getOffset(Instant.now()));
		 * System.out.println("Fecha ultima modificacion : " + ultimaMod);
		 * archivo.setLastModified(LocalDateTime.of(1907,1,10,20,54).getLong(ChronoField
		 * .INSTANT_SECONDS)); //System.out.println("Pude borrarlo? " +
		 * archivo.delete()); } catch (Exception e) { e.printStackTrace(); }
		 */

	}

	public static void recorridoRecursivo(File carpeta) {
		carpeta = new File("./");
		if (carpeta.isDirectory()) {
			File[] hijos = carpeta.listFiles();
			for (short i = 0; i < hijos.length; i++) {
				File hijoActual = hijos[i];
				if (hijoActual.isDirectory()) {
					recorridoRecursivo(hijoActual);
				} else {
					System.out.println(hijoActual.getAbsolutePath() + " : " + hijoActual.length() + " : "
							+ LocalDateTime.ofEpochSecond(hijoActual.lastModified() / 1000, 0,
									ZoneOffset.systemDefault().getRules().getOffset(Instant.now())));
				}
			}
		}
	}

}
