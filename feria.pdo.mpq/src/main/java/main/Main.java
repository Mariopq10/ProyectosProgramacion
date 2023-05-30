package main;

import java.util.ArrayList;

import clases.Caballo;
import clases.Cacharrito;
import clases.Comida;
import clases.Feria;
import clases.Noria;
import clases.PuestoComida;
import clases.Tiovivo;
import clases.Vehiculo;
import enums.TematicaVehiculo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Comida patatas = new Comida("patatas", 1, false);
		Comida cerveza = new Comida("Cerveza", 1, true);

		PuestoComida puesto = new PuestoComida("Venta", false);
		PuestoComida puestoBorracho = new PuestoComida("Cervecitas", true);

		puestoBorracho.getComidasEnVenta().add(cerveza);
		puesto.getComidasEnVenta().add(patatas);

		Caballo caballo = new Caballo((byte) 10, (byte) 2);
		Caballo caballo1 = new Caballo((byte) 10, (byte) 2);
		Caballo caballo2 = new Caballo((byte) 10, (byte) 2);
		Caballo caballo3 = new Caballo((byte) 10, (byte) 1);
		Caballo caballo4 = new Caballo((byte) 10, (byte) 1);
		Vehiculo coche1 = new Vehiculo((byte) 10, (byte) 4, false, TematicaVehiculo.AMBULANCIA);
		Vehiculo coche2 = new Vehiculo((byte) 12, (byte) 1, true, TematicaVehiculo.COCHE_BATMAN);
		Vehiculo coche3 = new Vehiculo((byte) 10, (byte) 6, false, TematicaVehiculo.COCHE_BOMBEROS);
		Vehiculo coche4 = new Vehiculo((byte) 10, (byte) 2, true, TematicaVehiculo.COHETE);
		Vehiculo coche5 = new Vehiculo((byte) 10, (byte) 1, false, TematicaVehiculo.SUPERMAN);
		ArrayList<Cacharrito> componentes = new ArrayList<Cacharrito>();
		componentes.add(coche5);
		componentes.add(coche4);
		componentes.add(coche3);
		componentes.add(coche2);
		componentes.add(coche1);
		componentes.add(caballo);
		componentes.add(caballo1);
		componentes.add(caballo2);
		componentes.add(caballo3);
		componentes.add(caballo4);
		Caballo burro = new Caballo((byte) 10, (byte) 2);
		Caballo burro2 = new Caballo((byte) 10, (byte) 2);
		Caballo burro3 = new Caballo((byte) 10, (byte) 2);
		Caballo burro4 = new Caballo((byte) 10, (byte) 1);
		Caballo burro5 = new Caballo((byte) 10, (byte) 1);
		Vehiculo cochecito1 = new Vehiculo((byte) 10, (byte) 4, false, TematicaVehiculo.AMBULANCIA);
		Vehiculo cochecito2 = new Vehiculo((byte) 12, (byte) 1, true, TematicaVehiculo.COCHE_BATMAN);
		Vehiculo cochecito3 = new Vehiculo((byte) 10, (byte) 2, false, TematicaVehiculo.COHETE);
		Vehiculo cochecito4 = new Vehiculo((byte) 10, (byte) 2, true, TematicaVehiculo.COHETE);
		Vehiculo cochecito5 = new Vehiculo((byte) 10, (byte) 1, false, TematicaVehiculo.COCHE_BOMBEROS);
		ArrayList<Cacharrito> componentes2 = new ArrayList<Cacharrito>();
		componentes2.add(cochecito1);
		componentes2.add(cochecito2);
		componentes2.add(cochecito3);
		componentes2.add(cochecito4);
		componentes2.add(cochecito5);
		componentes2.add(burro);
		componentes2.add(burro2);
		componentes2.add(burro3);
		componentes2.add(burro4);
		componentes2.add(burro5);

		Tiovivo tiovivo = new Tiovivo("tiovivo", componentes);
		Tiovivo tiovivoGrande = new Tiovivo("TiovivoGrande", componentes2);
		Noria noria = new Noria("Noria", 1, (short) 10, (byte) 10, (byte) 2);
		Noria noriaGrande = new Noria("NoriaGrande", 2, (short) 100, (byte) 20, (byte) 3);
		ArrayList actividades = new ArrayList();
		actividades.add(puesto);
		actividades.add(puestoBorracho);
		actividades.add(tiovivo);
		actividades.add(tiovivoGrande);
		actividades.add(noria);
		actividades.add(noriaGrande);
		Feria feria = new Feria(actividades);
		System.out.println(feria);
		

		
	}

}
