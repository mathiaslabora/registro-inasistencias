package modelo;

public class Docente {
	private int ci;
	private String nombre;
	
	public Docente() {
		super();
	}
	
	public Docente(int ci, String nombre) {
		super();
		this.ci = ci;
		this.nombre = nombre;
	}
	
	public int getCi() {
		return ci;
	}
	public void setCi(int ci) {
		this.ci = ci;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
}
