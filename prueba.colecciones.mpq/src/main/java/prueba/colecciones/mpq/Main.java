package prueba.colecciones.mpq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

import clases.Bicicleta;
import clases.Cliente;

public class Main {

	public static void main(String[] args) {
		/*
		 * 1 - Crear un Cliente: Si se selecciona, se piden todos los datos del
		 * 
		 * cliente por teclado menos bici (nombre,email,tlf,contraseña) y
		 * 
		 * se crea un cliente que se inserta en el HashMap.
		 * 
		 * 2 - Modificar nombre de cliente: Si se selecciona, se pide el email
		 * 
		 * de un cliente a buscar en el hashmap. Si no lo encuentra, vuelve
		 * 
		 * otra vez al menú principal. Si lo encuentra, pide el
		 * 
		 * nuevo nombre a poner al cliente. Se modifica el cliente en el map.
		 * 
		 * 3 - Modificar email del cliente: Si se selecciona, se pide el email
		 * 
		 * de un cliente a buscar en el hashmap. Si no lo encuentra, vuelve
		 * 
		 * otra vez al menú principal. Si lo encuentra, pide por teclado el
		 * 
		 * nuevo email, saca del mapa el usuario con el email antiguo, modifica
		 * 
		 * su variable interna email, y lo devuelve al hashmap con su nueva
		 * 
		 * clave escrita.
		 * 
		 * 4 - Imprimir un cliente: Si se selecciona, se pide el email
		 * 
		 * de un cliente a buscar en el hashmap. Si no lo encuentra, imprime
		 * 
		 * la frase "email no encontrado". Si lo encuentra, imprime todos los
		 * 
		 * datos del cliente por teclado.
		 * 
		 * 
		 * 
		 * Si lo montas bien, no necesitas declarar ninguna variable de tipo cliente en
		 * todo el programa. Inicializar si que necesitarás inicializar.
		 */
		Scanner sc = new Scanner(System.in);
		byte opcion = -1;
		HashMap<String, Cliente> lista = new HashMap<String, Cliente>();

		while (opcion != 0) {
			System.out.println(
					"Dime una opcion\n\t1-Crearcliente\n\t2-ModificarNombreCliente\n\t3-ModificarEmail\n\t4-ImprimirCliente");
			opcion = Byte.parseByte(sc.nextLine());

			switch (opcion) {
			case 0:
				System.out.println("Has salido del programa");
				break;
			case 1:
				System.out.println("Dime el email, contrasena, telefono y nombre del nuevo cliente");
				String email = sc.nextLine();
				String contrasena = sc.nextLine();
				Integer telefono = Integer.parseInt(sc.nextLine());
				String nombre = sc.nextLine();
				lista.put(email, new Cliente(email, contrasena, telefono, nombre));
				break;
			case 2:
				System.out.println("Dime el email del cliente");
				String contieneEmail = sc.nextLine();
				if (lista.containsKey(contieneEmail)) {
					System.out.println("Dime el nuevo nombre");
					lista.get(contieneEmail).setNombre(sc.nextLine());
				} else {
					System.out.println("No hay usuarios con ese email");
					break;
				}
				break;
			case 3:
				System.out.println("Dime el email del cliente");
				String contieneEmail2 = sc.nextLine();
				if (lista.containsKey(contieneEmail2)) {
					System.out.println("Dime el nuevo email");
					String nuevoEmail = sc.nextLine();
					lista.get(contieneEmail2).setEmail(nuevoEmail);
					Cliente borrado = lista.remove(contieneEmail2);
					lista.put(nuevoEmail, borrado);
				} else {
					System.out.println("No hay usuarios con ese email");
					break;
				}
				break;
			case 4:
				System.out.println("Dime el email del cliente");
				String contieneEmail3 = sc.nextLine();
				if (lista.containsKey(contieneEmail3)) {
					System.out.println(lista.get(contieneEmail3));
				} else {
					System.out.println("No existe ese cliente");
					break;
				}
				break;
			}
		}

		/*
		 * while (iter.hasNext()) { HashMap.Entry<String, Cliente> entry = iter.next();
		 * if (entry.getKey().equals(cambio)) {
		 * System.out.print("Ingrese el nuevo nombre del cliente: "); String nuevoNombre
		 * = sc.next(); entry.getValue().setNombre(nuevoNombre);
		 * System.out.println("El nombre del cliente ha sido modificado correctamente."
		 * ); break;/*
		 * 
		 * 
		 * }
		 * 
		 * /* HashSet<String> ingredientes = new HashSet<String>();
		 * ingredientes.add("Cebolla"); ingredientes.add("Patata");
		 * ingredientes.add("Pimientos"); ingredientes.add("Sal");
		 * ingredientes.add("Huevo"); ingredientes.add("Panceta");
		 * ingredientes.add("Chorizo"); System.out.println(ingredientes.size());
		 * System.out.println(ingredientes.contains("Cebolla"));
		 * 
		 * Iterator it=ingredientes.iterator(); while(it.hasNext()) { String
		 * actual=(String) it.next(); System.out.println(actual); }
		 */
		/*
		 * Cliente mario = new Cliente("mario@mario", "1234", 617949930, "mario");
		 * Cliente ricardi = new Cliente("riki@rikon", "cuca", 61726633, "Ricardo");
		 * Cliente antonia = new Cliente("antonia@antonia", "a1s2d3", 629136575,
		 * "Antonia"); Cliente garrulo = new Cliente("garrulo@com", "garru", 952622075,
		 * "Garrulo"); Cliente pepe = new Cliente("pepe@com", "123545", 606509080,
		 * "Pepe");
		 * 
		 * HashMap<String, Cliente> porEmail = new HashMap<String, Cliente>();
		 * HashMap<Integer, Cliente> porNumero = new HashMap<Integer, Cliente>();
		 * 
		 * porEmail.put(mario.getEmail(), mario); porEmail.put(ricardi.getEmail(),
		 * ricardi); porEmail.put(antonia.getEmail(), antonia);
		 * porEmail.put(garrulo.getEmail(), garrulo); porEmail.put(pepe.getEmail(),
		 * pepe); porNumero.put(mario.getTelefono(), mario);
		 * porNumero.put(ricardi.getTelefono(), ricardi);
		 * porNumero.put(antonia.getTelefono(), antonia);
		 * porNumero.put(garrulo.getTelefono(), garrulo);
		 * porNumero.put(pepe.getTelefono(), pepe);
		 * 
		 * 
		 * Cliente personaEncontrada=porEmail.get("mario@mario");
		 * porNumero.remove(garrulo.getTelefono());
		 * 
		 * Iterator itm = porNumero.keySet().iterator(); while(itm.hasNext()) { int
		 * telefonoActual=(Integer) itm.next(); System.out.println(telefonoActual); }
		 * Iterator itm = porNumero.values().iterator(); while(itm.hasNext()) { Cliente
		 * clienteActual=(Cliente) itm.next(); System.out.println(clienteActual); }
		 * Iterator itma = porEmail.entrySet().iterator(); while(itm.hasNext()) { Entry
		 * actual=(Entry)itma.next(); String clave = (String)actual.getKey(); Cliente
		 * valor=(Cliente) actual.getValue(); System.out.println(clave+" "+valor); }
		 * 
		 * Bicicleta negra = new Bicicleta("Fox", "negro", mario); Bicicleta blanca =
		 * new Bicicleta("Fox", "blanca", mario); Bicicleta roja = new
		 * Bicicleta("Acerbis", "roja", ricardi); ArrayList<Bicicleta> bicis = new
		 * ArrayList<Bicicleta>(); // Meto las bicicletas dentro del ArrayList "bicis",
		 * se usa // .addAll(Arrays.asList("Objetos a insertar");
		 * bicis.addAll(Arrays.asList(negra, blanca, roja));
		 * mario.getBicicleta().add(negra); negra.setCliente(mario);
		 * mario.getBicicleta().add(roja); roja.setCliente(mario);
		 * ricardi.getBicicleta().add(blanca); blanca.setCliente(ricardi);
		 * 
		 * System.out.println(mario); System.out.println(ricardi);
		 * 
		 * Iterator it = bicis.iterator(); byte tiene = 0; for (byte i = 0; i <
		 * bicis.size(); i++) { if (bicis.get(i).getCliente().equals("mario")) {
		 * tiene++; } } if (tiene == 3) { System.out.println("Las 3 son suyas"); } else
		 * { System.out.println("Las 3 no pertenecen al mismo cliente"); }
		 */

	}
}
