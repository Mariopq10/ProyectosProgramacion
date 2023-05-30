package clases;

public class Bicicleta implements Comparable<Bicicleta> {
	private String marca;
	private String modelo;
	private String problema;
	private Cliente cliente;

	public Bicicleta(String marca, String modelo, String problema, Cliente cliente) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.problema = problema;
		this.cliente = cliente;
	}

	public Bicicleta(String marca, String modelo, Cliente cliente) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.problema = null;
		this.cliente = cliente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Bicicleta [marca=" + marca + ", modelo=" + modelo + ", problema=" + problema;
	}

	public int compareTo(Bicicleta o) {
		if (!this.marca.equals(o.marca)) {
			return this.marca.compareTo(o.marca);
		} else if (!this.modelo.equals(o.modelo)) {
			return this.modelo.compareTo(o.modelo);
		} else {
			return this.cliente.getEmail().compareTo(o.cliente.getEmail());
		}
	}

}
