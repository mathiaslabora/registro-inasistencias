package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Docente;
import modelo.Inasistencia;
import modelo.Usuarios;

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

	public static Usuarios obtenerUsuario(String documento) {

		Usuarios user = new Usuarios();
		String sentencia = "SELECT * FROM proyectoprogramacion.personas where ci_persona=" + documento + ";";
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			resultado = sentenciaSQL.executeQuery(sentencia);
			if (resultado.next()) {
				user.setCi(resultado.getInt(1));
				user.setNombre(resultado.getString(2));
				user.setRol(resultado.getInt(3));
			}
			conectar.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return user;
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

	public static ArrayList<Usuarios> obtenerUsuarios() {
		ArrayList<Usuarios> users = new ArrayList<>();
		String sentencia = "SELECT * FROM proyectoprogramacion.personas;";
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			resultado = sentenciaSQL.executeQuery(sentencia);
			while (resultado.next()) {
				Usuarios user = new Usuarios();
				user.setCi(resultado.getInt(1));
				user.setNombre(resultado.getString(2));
				user.setRol(resultado.getInt(3));
				user.setPass(resultado.getString(4));
				users.add(user);
			}
			conectar.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return users;
	}
	
	public static boolean insertUsuario(String CI, String name, int rol, String contrasena) {
		boolean insertar = false;
		boolean res;
		String sentencia = "INSERT INTO `proyectoprogramacion`.`personas` (`ci_persona`, `nombre`, `tipo`, `password`) VALUES ("+CI+", '"+name+"', "+rol+", '"+contrasena+"');";
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			res = sentenciaSQL.execute(sentencia);
			insertar = true;
			conectar.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return insertar;
	}
	//UPDATE `proyectoprogramacion`.`personas` SET `ci_persona` = '43214331', `nombre` = 'loena', `tipo` = '2', `password` = '1234' WHERE (`ci_persona` = '43214321');
	public static boolean modificarUsuario(String CI, String name, int rol, String contrasena) {
		boolean insertar = false;
		boolean res;
		String sentencia = "UPDATE proyectoprogramacion.personas SET`ci_persona` = "+CI+", `nombre` = '"+name+"', `tipo` = "+rol+", `password` = '"+contrasena+"' WHERE ( ci_persona="+ Integer.parseInt(CI) +");";
		//UPDATE `proyectoprogramacion`.`personas` SET `nombre` = 'pablo rodriguez' WHERE (`ci_persona` = '43214321');
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			res = sentenciaSQL.execute(sentencia);
			insertar = true;
			conectar.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return insertar;
	}
	
	
	public static ArrayList<Docente> obtenerDocentes() {
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
		String sentencia = "INSERT INTO proyectoprogramacion.docente (`ci_docente`, `nombre`) VALUES ("
				+ Integer.parseInt(CI) + ", '" + name + "');";
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			res = sentenciaSQL.execute(sentencia);
			insertar = true;
			conectar.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return insertar;
	}

	public static boolean modificarDocente(String CI, String name) {
		boolean insertar = false;
		boolean res;
		String sentencia = "UPDATE proyectoprogramacion.docente SET `nombre` = "+name+" WHERE ( ci_persona="+ Integer.parseInt(CI) +");";
		//UPDATE `proyectoprogramacion`.`personas` SET `nombre` = 'pablo rodriguez' WHERE (`ci_persona` = '43214321');
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			res = sentenciaSQL.execute(sentencia);
			insertar = true;
			conectar.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return insertar;
	}
	
	public static ArrayList<Inasistencia> obtenerInasistenciasDocentes(String CIdocente) {
		ArrayList<Inasistencia> inasistencias = new ArrayList<>();
		String sentencia = "SELECT * FROM proyectoprogramacion.inasistencias_docente WHERE id_docente=" + CIdocente
				+ ";";
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			resultado = sentenciaSQL.executeQuery(sentencia);
			while (resultado.next()) {
				Inasistencia inasistencia = new Inasistencia();
				inasistencia.setIdInasistencia(resultado.getInt(1));
				inasistencia.setIdDocente(resultado.getInt(2));
				inasistencia.setGruposAfectados(resultado.getString(3));
				inasistencia.setMotivoInasistencia(resultado.getString(4));
				inasistencia.setFechaRegistro(resultado.getDate(5));
				inasistencia.setCiPersona(resultado.getInt(6));

				inasistencias.add(inasistencia);
			}
			conectar.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return inasistencias;
	}

	public static ArrayList<Inasistencia> obtenerTodasInasistencias() {
		ArrayList<Inasistencia> inasistencias = new ArrayList<>();
		String sentencia = "SELECT * FROM proyectoprogramacion.inasistencias_docente;";
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			resultado = sentenciaSQL.executeQuery(sentencia);
			while (resultado.next()) {
				Inasistencia inasistencia = new Inasistencia();
				inasistencia.setIdInasistencia(resultado.getInt(1));
				inasistencia.setIdDocente(resultado.getInt(2));
				inasistencia.setGruposAfectados(resultado.getString(3));
				inasistencia.setMotivoInasistencia(resultado.getString(4));
				inasistencia.setFechaRegistro(resultado.getDate(5));
				inasistencia.setCiPersona(resultado.getInt(6));

				inasistencias.add(inasistencia);
			}
			conectar.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return inasistencias;
	}

}
