package clases;

public class Comida extends CosaConNombre {
	private float precio;
	private boolean necesitaCalentarse;

	public Comida(String nombre, float precio, boolean necesitaCalentarse) {
		super(nombre);
		this.precio = precio;
		this.necesitaCalentarse = necesitaCalentarse;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public boolean isNecesitaCalentarse() {
		return necesitaCalentarse;
	}

	public void setNecesitaCalentarse(boolean necesitaCalentarse) {
		this.necesitaCalentarse = necesitaCalentarse;
	}

	@Override
	public String toString() {
		return "" + this.getNombre() + " con un precio de: " + precio + ", necesitaCalentarse?" + necesitaCalentarse
				+ "\n";
	}
}
