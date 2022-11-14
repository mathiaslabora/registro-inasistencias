package modelo;

public class Usuarios {
	private double ci;
	private String nombre;
	private int rol;
	private String pass;
	
	
	public Usuarios(double ci, String nombre, int rol, String pass) {
		super();
		this.ci = ci;
		this.nombre = nombre;
		this.rol = rol;
		this.pass = pass;
	}
	
	
	public double getCi() {
		return ci;
	}
	public void setCi(double ci) {
		this.ci = ci;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	
}
