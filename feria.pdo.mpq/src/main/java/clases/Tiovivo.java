package clases;

import java.util.ArrayList;

import interfaces.ContarNumeroPlazas;

public class Tiovivo extends CosaConNombre implements ContarNumeroPlazas {
	private ArrayList componentesDelTiovivo;

	public Tiovivo(String nombre, ArrayList componentes) {
		super(nombre);
		this.componentesDelTiovivo = componentes;
	}

	public ArrayList getComponentesDelTiovivo() {
		return componentesDelTiovivo;
	}

	public void setComponentesDelTiovivo(ArrayList componentesDelTiovivo) {
		this.componentesDelTiovivo = componentesDelTiovivo;
	}

	@Override
	public String toString() {
		return "\nEl tiovivo tiene todos estos cacharros con sus estadisticas \n " + componentesDelTiovivo;
	}

	public short numeroTotalPlazas() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * public short numeroTotalPlazas() { for(byte i=0;
	 * i<componentesDelTiovivo.size();i++) {
	 * componentesDelTiovivo.get(i)numeroTotalPlazas();
	 * 
	 * } return 0; }
	 */

}
