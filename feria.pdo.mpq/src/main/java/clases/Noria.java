package clases;

import interfaces.ContarNumeroPlazas;

public class Noria extends CosaConPrecioFicha implements ContarNumeroPlazas {
	private short alturaMetros;
	private byte numeroCabinas;
	private byte asientosPorCabina;

	public Noria(String nombre, float precioFicha, short alturaMetros, byte numeroCabinas, byte asientosPorCabina) {
		super(nombre, precioFicha);
		this.alturaMetros = alturaMetros;
		this.numeroCabinas = numeroCabinas;
		this.asientosPorCabina = asientosPorCabina;
	}

	public short getAlturaMetros() {
		return alturaMetros;
	}

	public void setAlturaMetros(short alturaMetros) {
		this.alturaMetros = alturaMetros;
	}

	public byte getNumeroCabinas() {
		return numeroCabinas;
	}

	public void setNumeroCabinas(byte numeroCabinas) {
		this.numeroCabinas = numeroCabinas;
	}

	public byte getAsientosPorCabina() {
		return asientosPorCabina;
	}

	public void setAsientosPorCabina(byte asientosPorCabina) {
		this.asientosPorCabina = asientosPorCabina;
	}

	public interface ContarNumeroPlazas {
		public byte numeroTotalPlazas();

	}

	@Override
	public String toString() {
		return "\n\n  " + this.getNombre() + " tiene una altura de " + alturaMetros + ", con un numero de cabinas de: "
				+ numeroCabinas + ", y esta cantidad de asientos por cabina: " + asientosPorCabina
				+ " numero total de plazas: " + this.numeroTotalPlazas();
	}

	public short numeroTotalPlazas() {
		byte asientos;
		byte cabinas ;
		this.asientosPorCabina = asientosPorCabina;
		this.numeroCabinas = numeroCabinas;
		return (short) ((short)asientosPorCabina*numeroCabinas);
	}

}
