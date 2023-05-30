package prueba.base.de.datos.daw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

import Utils.DAO;
import clases.Cliente;
import excepciones.ClienteNoExisteException;
import excepciones.ContrasenaInvalidaException;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Byte opcion;
		boolean clienteLogado = false;
		do {
			System.out.println("Dime qué quieres hacer:" + "\n\t0 - Salir" + "\n\t1 - Registro" + "\n\t2 - Login"
					+ "\n\t3 - Ver Log" + "\n\t4 - Recorrer Base de datos");
			opcion = Byte.parseByte(sc.nextLine());

			switch (opcion) {
			case 1:

				System.out.println("Dime tu email");
				String email = sc.nextLine();
				System.out.println("Dime tu nombre");
				String nombre = sc.nextLine();
				System.out.println("Dime tu contraseña");
				String contraseña = sc.nextLine();
				System.out.println("Dime tu telefono");
				int telefono = Integer.parseInt(sc.nextLine());
				try {
					Cliente cliente = new Cliente(email, nombre, telefono, contraseña);
				} catch (SQLException e1) {
					System.err.println("El cliente no ha podido ser creado");
					e1.printStackTrace();
				}
				System.out.println("Cliente registrado con exito.");
				try {
					FileWriter fw = new FileWriter("./clientes.log", true);
					fw.write("Cliente " + email + " registrado con éxito en: " + LocalDateTime.now().toString() + "\n");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				break;
			case 2:
				Cliente clienteLogin = null;
				while (clienteLogin == null) {
					System.out.println("Dime tu email");
					String emailLogin = sc.nextLine();
					System.out.println("Dime tu contraseña");
					String contraseñaLogin = sc.nextLine();
					try {
						clienteLogin = new Cliente(emailLogin, contraseñaLogin);
					} catch (ContrasenaInvalidaException | ClienteNoExisteException | SQLException e) {
						System.err.println("La contrasena o email contienen digitos especiales, prueba de nuevo");
					}
					try {
						FileWriter fw = new FileWriter("./clientes.log", true);
						fw.write("Cliente " + emailLogin + " logueado con éxito en: " + LocalDateTime.now().toString()
								+ "\n");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (!(clienteLogin == null)) {
					clienteLogado = true;
				}
				break;
			case 3:
				try {
					BufferedReader lector;
					lector = new BufferedReader(new FileReader("./clientes.log"));
					String linea = lector.readLine();
					String texto = "";
					while (linea != null) {
						texto += linea + "\n";
						linea = lector.readLine();
					}
					lector.close();
					System.out.println(texto);
				} catch (IOException e) {
					System.err.println("No se puede acceder al archivo clientes.log");
					e.printStackTrace();
				}
				break;
			case 4:
				ArrayList<Cliente> clientes = new ArrayList<>();
				if (clienteLogado) {
					try {
						clientes = Cliente.getTodos();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					System.out.println(clientes);
				} else {
					System.out.println("No hay cliente logueado");
				}
				break;
			}
		} while (opcion != 0);
	}
}
