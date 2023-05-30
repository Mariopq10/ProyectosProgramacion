package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import Utils.DAO;
import excepciones.ClienteNoExisteException;
import excepciones.ContrasenaInvalidaException;

public class Cliente {
	private String email;
	private String nombre;
	private int telefono;

	public Cliente(String email, String nombre, int telefono, String contrasena) throws SQLException {
		super();
		HashMap<String, Object> cols = new HashMap<String, Object>();
		cols.put("email", this.email = email);
		cols.put("nombre", this.nombre = nombre);
		cols.put("telefono", this.telefono = telefono);
		cols.put("password", contrasena);
		DAO.insertar("cliente", cols);
	}

	public Cliente(String email, String nombre, int telefono) {
		this.email = email;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public Cliente(String email, String contrasena)
			throws ClienteNoExisteException, SQLException, ContrasenaInvalidaException {
		super();
		LinkedHashSet<String> columnasSelect = new LinkedHashSet();
		columnasSelect.add("nombre");
		columnasSelect.add("telefono");
		columnasSelect.add("email");
		columnasSelect.add("password");
		HashMap<String, Object> restricciones = new HashMap<>();
		restricciones.put("email", email);
		ArrayList<Object> consulta = DAO.consultar("cliente", columnasSelect, restricciones);
		if (consulta.isEmpty()) {
			throw new ClienteNoExisteException("No existe el cliente");
		} else if (!consulta.get(3).equals(contrasena)) {
			throw new ContrasenaInvalidaException("La contrasena es invalida");
		} else {
			this.nombre = (String) consulta.get(0);
			this.telefono = (int) consulta.get(1);
			this.email = (String) consulta.get(2);
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws SQLException {
		HashMap<String, Object> datosAModificar = new HashMap<>();
		HashMap<String, Object> restricciones = new HashMap<>();
		restricciones.put("email", this.email);
		datosAModificar.put("email", email);
		if (DAO.actualizar("cliente", datosAModificar, restricciones) == 1) {
			this.email = email;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws SQLException {
		HashMap<String, Object> datosAModificar = new HashMap<>();
		HashMap<String, Object> restricciones = new HashMap<>();
		restricciones.put("email", this.email);
		datosAModificar.put("nombre", nombre);
		if (DAO.actualizar("cliente", datosAModificar, restricciones) == 1) {
			this.nombre = nombre;
		}

	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) throws SQLException {
		HashMap<String, Object> datosAModificar = new HashMap<>();
		HashMap<String, Object> restricciones = new HashMap<>();
		restricciones.put("email", this.email);
		datosAModificar.put("telefono", telefono);
		if (DAO.actualizar("cliente", datosAModificar, restricciones) == 1) {
			this.telefono = telefono;
		}
	}

	@Override
	public String toString() {
		return "\n email=" + email + ", nombre=" + nombre + ", telefono=" + telefono;
	}

	public static ArrayList<Cliente> getTodos() throws SQLException {
		Cliente cliente;
		ArrayList<Cliente> clientes = new ArrayList<>();
		LinkedHashSet<String> columnasSelect = new LinkedHashSet<String>();
		HashMap<String, Object> restricciones = new HashMap<>();
		columnasSelect.add("email");
		columnasSelect.add("nombre");
		columnasSelect.add("telefono");

		ArrayList<Object> consulta = DAO.consultar("cliente", columnasSelect, restricciones);
		for (byte i = 0; i < consulta.size(); i += 3) {
			String email = (String) consulta.get(i);
			String nombre = (String) consulta.get(i + 1);
			int telefono = (Integer) consulta.get(i + 2);
			cliente = new Cliente(email, nombre, telefono);
			clientes.add(cliente);
		}
		return clientes;
	}

}
