package clases;

import java.util.ArrayList;

public class PuestoComida extends CosaConNombre {
	private boolean puedeVenderAlcohol;
	private ArrayList<Comida> comidasEnVenta;

	public PuestoComida(String nombre, boolean puedeVenderAlcohol, ArrayList<Comida> comidasEnVenta) {
		super(nombre);
		this.puedeVenderAlcohol = puedeVenderAlcohol;
		this.comidasEnVenta = comidasEnVenta;
	}

	public PuestoComida(String nombre, boolean puedeVenderAlcohol) {
		super(nombre);
		this.puedeVenderAlcohol = puedeVenderAlcohol;
		this.comidasEnVenta = new ArrayList<Comida>();
	}

	public boolean isPuedeVenderAlcohol() {
		return puedeVenderAlcohol;
	}

	public void setPuedeVenderAlcohol(boolean puedeVenderAlcohol) {
		this.puedeVenderAlcohol = puedeVenderAlcohol;
	}

	public ArrayList<Comida> getComidasEnVenta() {
		return comidasEnVenta;
	}

	public void setComidasEnVenta(ArrayList<Comida> comidasEnVenta) {
		this.comidasEnVenta = comidasEnVenta;
	}

	@Override
	public String toString() {
		return "PuestoComida llamado " + this.getNombre() + ". ¿Puede vender alcohol? " + puedeVenderAlcohol
				+ ", Y tiene estas comidas en venta " + comidasEnVenta + "\n";
	}

}
