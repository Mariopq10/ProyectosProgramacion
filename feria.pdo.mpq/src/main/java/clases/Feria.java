package clases;

import java.util.ArrayList;

public class Feria {
	private ArrayList actividades;
	private float beneficio;

	public Feria(ArrayList actividades) {
		super();
		this.actividades = actividades;
		
	}
	public Feria(){
		super();
	}
	
	public ArrayList getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList actividades) {
		this.actividades = actividades;
	}

	@Override
	public String toString() {
		return "La feria contiene estas actividades " + actividades+"\n";
	}
}
