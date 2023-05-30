package clases;

public class CosaConPrecioFicha extends CosaConNombre{
	private float precioFicha;

	public CosaConPrecioFicha(String nombre, float precioFicha) {
		super(nombre);
		this.precioFicha = precioFicha;
	}

	public float getPrecioFicha() {
		return precioFicha;
	}

	public void setPrecioFicha(float precioFicha) {
		this.precioFicha = precioFicha;
	}

	@Override
	public String toString() {
		return "CosaConPrecioFicha precioFicha=" + precioFicha + "";
	}
}
