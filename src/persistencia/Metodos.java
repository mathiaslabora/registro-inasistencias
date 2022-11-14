package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Docente;

public class Metodos {

	private static Connection conectar = null;
	private static Statement sentenciaSQL = null;
	private static ResultSet resultado = null;

	private static String nombreDB = "proyectoprogramacion";
	private static String usuario = "root";
	private static String pass = "root";

	private static String url = "jdbc:mysql://127.0.0.1:3306/" + nombreDB; // conexion a DB Mysql

	public static boolean loadDrivers() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	
	public static boolean login(String documento, String password) {
		
		boolean encontro = false;
		
		String sentencia = "SELECT * FROM proyectoprogramacion.personas where ci_persona=" + documento + ";";
		
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			resultado = sentenciaSQL.executeQuery(sentencia);
		
			if (resultado.next()) {
				String ps = resultado.getString(4);
				if (ps.equals(password)) {
					encontro = true;
				}else {
					encontro=false;
				}
			}
			sentenciaSQL.close();
			resultado.close();
			conectar.close();
		} catch (SQLException e) {
			encontro = false;
		}
		return encontro;
	}
	
	
public static Docente buscarCIDocente(String cedula) {
		Docente docente = new Docente();
		String sentencia = "SELECT * FROM proyectoprogramacion.docente where ci_docente=" + cedula + ";";
		
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			resultado = sentenciaSQL.executeQuery(sentencia);
		
			if (resultado.next()) {
				docente.setCi(resultado.getInt(1));
				docente.setNombre(resultado.getString(2));
//					ArrayList<Docente> docente = new ArrayList<>();
//					docente.add(51111111, "jorge");
			}
			conectar.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return docente;
	}
	
public static ArrayList<Docente> obtenerDocentes(){
	ArrayList<Docente> docentes = new ArrayList<>();	
	String sentencia = "SELECT * FROM proyectoprogramacion.docente;";
	try {
		conectar = DriverManager.getConnection(url, usuario, pass);
		sentenciaSQL = conectar.createStatement();
		resultado = sentenciaSQL.executeQuery(sentencia);
	
		while (resultado.next()) {
			Docente docente = new Docente();
			docente.setCi(resultado.getInt(1));
			docente.setNombre(resultado.getString(2));
			docentes.add(docente);
		}
		conectar.close();
	} catch (SQLException e) {
		System.out.println(e);
	}
	return docentes;
}

public static boolean insertDocente(String CI, String name) {
	
	boolean insertar = false;
	boolean res;
	//INSERT INTO `proyectoprogramacion`.`docente` (`ci_docente`, `nombre`) VALUES ('12312312', 'roberto casanova');
	//ArrayList<Docente> docentes = new ArrayList<>();	
	String sentencia = "INSERT INTO proyectoprogramacion.docente (`ci_docente`, `nombre`) VALUES ("+Integer.parseInt(CI)+", '"+name+"');";
	try {
		conectar = DriverManager.getConnection(url, usuario, pass);
		sentenciaSQL = conectar.createStatement();
		res = sentenciaSQL.execute(sentencia);
		insertar = true;
		//System.out.println(resultado.getString(1));
//		if (resultado.next()) {
//			Docente docente = new Docente();
//			docente.setCi(resultado.getInt(1));
//			docente.setNombre(resultado.getString(2));
//			docentes.add(docente);
//		}
		conectar.close();
	} catch (SQLException e) {
		System.out.println(e);
	}
	return insertar;
	
}




}
