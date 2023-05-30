package clases;

public class ContenidoTxtOriginal {
	private String nombre;
	private String contenidoOriginal;
	
	public ContenidoTxtOriginal(String nombre, String contenidoOriginal) {
		super();
		this.nombre = nombre;
		this.contenidoOriginal = contenidoOriginal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContenidoOriginal() {
		return contenidoOriginal;
	}

	public void setContenidoOriginal(String contenidoOriginal) {
		this.contenidoOriginal = contenidoOriginal;
	}

	@Override
	public String toString() {
		return "ContenidoTxtOriginal [nombre=" + nombre + ", contenidoOriginal=" + contenidoOriginal + "]";
	}
	
}
