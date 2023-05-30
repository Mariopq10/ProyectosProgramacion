package clases;

import interfaces.ContarNumeroPlazas;

public class Cacharrito implements ContarNumeroPlazas{
	protected byte edadMinima;
	protected byte numeroPlazas;

	public Cacharrito(byte edadMinima, byte numeroPlazas) {
		super();
		this.edadMinima = edadMinima;
		this.numeroPlazas = numeroPlazas;
	}

	public byte getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(byte edadMinima) {
		this.edadMinima = edadMinima;
	}

	public byte getNumeroPlazas() {
		return numeroPlazas;
	}

	public void setNumeroPlazas(byte numeroPlazas) {
		this.numeroPlazas = numeroPlazas;
	}

	@Override
	public String toString() {
		return "Caballito con edadMinima: " + edadMinima + ", numeroPlazas=" + numeroPlazas + "\n";
	}

	public short numeroTotalPlazas() {
		
		this.numeroPlazas=numeroPlazas;
		return numeroPlazas;
	}

}
