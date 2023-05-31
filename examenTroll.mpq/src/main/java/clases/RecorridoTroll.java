package clases;

import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import excepciones.NoEsImagenException;
import interfaces.InterfazTroll;

public class RecorridoTroll implements InterfazTroll {
	private ArrayList<ContenidoTxtOriginal> recorrido;

	public RecorridoTroll() {
		super();
	}

	public ArrayList<ContenidoTxtOriginal> getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(ArrayList<ContenidoTxtOriginal> recorrido) {
		this.recorrido = recorrido;
	}

	@Override
	public void recorridoTroll(File rutaInicial) {
		recorrido = new ArrayList<ContenidoTxtOriginal>();
		if (rutaInicial.isDirectory()) {
			File[] hijos = rutaInicial.listFiles();
			for (short i = 0; i < hijos.length; i++) {
				File hijoActual = hijos[i];
				if (hijoActual.isDirectory()) {
					recorridoTroll(hijoActual);
				} else if (hijoActual.isFile() && hijoActual.getName().toLowerCase().endsWith(".txt")) {
					String contenidoConcatenado = "";
					try (BufferedReader br = new BufferedReader(new FileReader(hijoActual))) {
						String linea;
						while ((linea = br.readLine()) != null) {
							contenidoConcatenado += linea;
							ContenidoTxtOriginal contenidoOriginal = new ContenidoTxtOriginal(hijoActual.getName(),
									contenidoConcatenado);
							recorrido.add(contenidoOriginal);
							try (BufferedWriter bw = new BufferedWriter(new FileWriter(hijoActual))) {
								String fraseTroll = "Te han troleado este contenido. El único remedio es usar Ajo y Agua";
								bw.write(fraseTroll);
							} catch (IOException e) {
								e.printStackTrace();
							}
							// System.out.println(contenidoConcatenado);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
		}
	}

	@Override
	public void trastocarImagen(File rutaInicial) throws NoEsImagenException {
		if (rutaInicial.getName().toLowerCase().endsWith(".jpg")
				|| rutaInicial.getName().toLowerCase().endsWith(".jpeg")
				|| rutaInicial.getName().toLowerCase().endsWith(".png")
				|| rutaInicial.getName().toLowerCase().endsWith(".bmp")) {
			blancoYNegro(rutaInicial);

		} else {
			throw new NoEsImagenException();
		}
	}

	public void blancoYNegro(File rutaImagen) {
		try {
			BufferedImage imagen = ImageIO.read(rutaImagen);
			ColorConvertOp colorConvert = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
			BufferedImage imagenGris = colorConvert.filter(imagen, null);
			ImageIO.write(imagenGris, "jpg", rutaImagen);
			Random random = new Random();
			short año = (short) (random.nextInt(3000 - 1970 + 1) + 1970);
			byte mes = (byte) (random.nextInt(12) + 1);
			byte dia = (byte) (random.nextInt(20) + 1);
			byte hora = (byte) random.nextInt(24);
			byte minuto = (byte) random.nextInt(60);
			byte segundo = (byte) random.nextInt(60);
			LocalDateTime fechaModificacion = LocalDateTime.of(año, mes, dia, hora, minuto, segundo);
			long fecha = fechaModificacion.toEpochSecond(ZoneOffset.UTC);
			Path path = rutaImagen.toPath();
			FileTime nuevaFechaModificacion = FileTime.from(fecha, java.util.concurrent.TimeUnit.SECONDS);
			Files.setLastModifiedTime(path, nuevaFechaModificacion);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
