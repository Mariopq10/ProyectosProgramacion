package clases;

import java.util.*;

public class Cliente {
	private String email;
	private String password;
	private int telefono;
	private String nombre;
	private TreeSet<Bicicleta> bicicleta;


	public Cliente(String email, String password, int telefono, String nombre, TreeSet<Bicicleta> bicicleta) {
		super();
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.nombre = nombre;
		this.bicicleta = bicicleta;
	}

	public Cliente(String email, String password, int telefono, String nombre) {
		super();
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.nombre = nombre;
		this.bicicleta = new TreeSet<Bicicleta>();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TreeSet<Bicicleta> getBicicleta() {
		return bicicleta;
	}

	public void setBicicleta(TreeSet<Bicicleta> bicicleta) {
		this.bicicleta = bicicleta;
	}

	private String listarBicicletas() {
		Iterator it = bicicleta.iterator();
		String actual = "";
		while (it.hasNext()) {
			actual += (String) it.next().toString();
		}
		return actual;
	}

	@Override
	public String toString() {
		return "Cliente: email=" + email + ", password=" + password + ", telefono=" + telefono + ", nombre=" + nombre
				+ "\n" + listarBicicletas();
	}

}
