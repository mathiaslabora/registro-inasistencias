package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

import modelo.Docente;
import modelo.Inasistencia;
import modelo.Usuarios;
import vista.Login;
import vista.Menu;

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
				} else {
					encontro = false;
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
				user.setPass(resultado.getString(4));
			}
			conectar.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return user;
	}

	public static Docente obtenerDocente(String cedula) {
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
	

	
	public static void obtenerInasistenciasObjeto(int opc) {
		Object filas[]=new Object[6];
		String columnas[]= {
				"Nombre", "C.I.", "Grupos", "Motivo", "Desde", "Hasta"
		};
		DefaultTableModel modeloInasistencias = new DefaultTableModel(null, columnas);
		//Object filas[] = Metodos.obtenerInasistenciasObjeto();
		
		String sentencia = "SELECT doc.nombre, ina.ci_docente, ina.observaciones, ina.motivo_inasistencia, ina.fecha_desde, ina.fecha_hasta "
				+ "FROM proyectoprogramacion.inasistencias_docente as ina, proyectoprogramacion.docente as doc"
				+ " WHERE ina.ci_docente = doc.ci_docente and ina.fecha_hasta >= curdate();";
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			resultado = sentenciaSQL.executeQuery(sentencia);
			while (resultado.next()) {
				for (int i = 0; i < filas.length; i++) {
					filas[i]=resultado.getObject(i+1);
				}
				modeloInasistencias.addRow(filas);
			}
			if(opc == 1) {
				Login.table.setModel(modeloInasistencias);
			}else {
				Menu.table.setModel(modeloInasistencias);
			}
			
			conectar.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	
	}
	
	public static boolean insertInasistencias(Inasistencia inasistencia) {
		// boolean insertar = false;
		String sentencia = "INSERT INTO `proyectoprogramacion`.`inasistencias_docente` (`ci_docente`, `observaciones`, `motivo_inasistencia`, `fecha_registrado`, `ci_persona`, `fecha_desde`, `fecha_hasta`) "
				+ "	VALUES ('"+inasistencia.getIdDocente()+"', '"+inasistencia.getGruposAfectados()+"', '"+inasistencia.getMotivoInasistencia()+"',"
						+ " current_timestamp(), '"+inasistencia.getCiPersona()+"', '"+inasistencia.getFechaDesde()+"', '"+inasistencia.getFechaHasta()+"');";
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			sentenciaSQL.executeUpdate(sentencia);
			conectar.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
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

	public static boolean insertUsuario(Usuarios user) {
		// boolean insertar = false;
		String sentencia = "INSERT INTO `proyectoprogramacion`.`personas` (`ci_persona`, `nombre`, `tipo`, `password`) VALUES ("
				+ user.getCi() + ", '" + user.getNombre() + "', " + user.getRol() + ", '" + user.getPass() + "');";
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			sentenciaSQL.executeUpdate(sentencia);
			conectar.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}
	
	public static boolean eliminarUsuario(int doc) {
		String sentencia = "DELETE FROM proyectoprogramacion.personas WHERE ( ci_persona="
				+ doc + ");";
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			sentenciaSQL.executeUpdate(sentencia);
			conectar.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean modificarUsuario(Usuarios user) {
		String sentencia = "UPDATE proyectoprogramacion.personas SET`ci_persona` = " + user.getCi() + ", `nombre` = '"
				+ user.getNombre() + "', `tipo` = " + user.getRol() + ", `password` = '" + user.getPass()
				+ "' WHERE ( ci_persona=" + user.getCi() + ");";
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			sentenciaSQL.executeUpdate(sentencia);
			conectar.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
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
	
	public static ArrayList<Docente> obtenerDocentesPorNombre(String nombre) {
		ArrayList<Docente> docentes = new ArrayList<>();
		String sentencia = "SELECT * FROM proyectoprogramacion.docente WHERE nombre like '%"+nombre+"%';";
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

		String sentencia = "INSERT INTO proyectoprogramacion.docente (`ci_docente`, `nombre`) VALUES ("
				+ Integer.parseInt(CI) + ", '" + name + "');";
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			sentenciaSQL.executeUpdate(sentencia);
			conectar.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean modificarDocente(String CI, String name) {
		String sentencia = "UPDATE `proyectoprogramacion`.`docente` SET `nombre` = '"+name+"' WHERE (`ci_docente` = '"+CI+"');";

		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			sentenciaSQL.executeUpdate(sentencia);
			conectar.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}

	public static boolean eliminarDocente(Docente doc) {
		String sentencia = "DELETE FROM proyectoprogramacion.docente WHERE ( ci_docente="
				+ doc.getCi() + ");";
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			sentenciaSQL.executeUpdate(sentencia);
			conectar.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	public static ArrayList<Inasistencia> obtenerInasistenciasDocentesFecha(String CI, String fIni, String fFin) {
		ArrayList<Inasistencia> inasistencias = new ArrayList<>();
		String sentencia = "SELECT * FROM proyectoprogramacion.inasistencias_docente as ina, proyectoprogramacion.docente as doc "
				+ "WHERE ina.ci_docente = doc.ci_docente and ina.ci_docente = "+CI+" and (( ina.fecha_desde >= '"+fIni+"' and ina.fecha_desde <= '"+fFin+"')||"
						+ "( ina.fecha_hasta >= '"+fIni+"' and ina.fecha_hasta <= '"+fFin+"'));";
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			resultado = sentenciaSQL.executeQuery(sentencia);
			while (resultado.next()) {
				Inasistencia inasistencia = new Inasistencia();
				inasistencia.setIdDocente(resultado.getInt("ci_docente"));
				inasistencia.setGruposAfectados(resultado.getString("observaciones"));
				inasistencia.setMotivoInasistencia(resultado.getString("motivo_inasistencia"));
				inasistencia.setFechaRegistro(resultado.getDate("fecha_registrado"));
				inasistencia.setFechaDesde(resultado.getString("fecha_desde"));
				inasistencia.setFechaHasta(resultado.getString("fecha_hasta"));

				inasistencias.add(inasistencia);
			}
			conectar.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return inasistencias;
	}

	public static ArrayList<Inasistencia> obtenerTodasInasistenciasFecha(String fIni, String fFin) {
		ArrayList<Inasistencia> inasistencias = new ArrayList<>();
		String sentencia = "SELECT * FROM proyectoprogramacion.inasistencias_docente as ina, proyectoprogramacion.docente as doc "
				+ "WHERE ina.ci_docente = doc.ci_docente and  (( ina.fecha_desde >= '"+fIni+"' and ina.fecha_desde <= '"+fFin+"')||"
				+ "( ina.fecha_hasta >= '"+fIni+"' and ina.fecha_hasta <= '"+fFin+"'));";
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			resultado = sentenciaSQL.executeQuery(sentencia);
			while (resultado.next()) {
				Inasistencia inasistencia = new Inasistencia();
				inasistencia.setIdDocente(resultado.getInt("ci_docente"));
				inasistencia.setGruposAfectados(resultado.getString("observaciones"));
				inasistencia.setMotivoInasistencia(resultado.getString("motivo_inasistencia"));
				inasistencia.setFechaRegistro(resultado.getDate("fecha_registrado"));
				inasistencia.setFechaDesde(resultado.getString("fecha_desde"));
				inasistencia.setFechaHasta(resultado.getString("fecha_hasta"));

				inasistencias.add(inasistencia);
			}
			conectar.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return inasistencias;
	}

	
	public static ArrayList<Inasistencia> obtenerInasistenciasPorUsuarioPorFecha(String CI, String fIni, String fFin) {
		ArrayList<Inasistencia> inasistencias = new ArrayList<>();
		String sentencia = "SELECT * FROM proyectoprogramacion.inasistencias_docente as ina, proyectoprogramacion.personas as per "
				+ "WHERE ina.ci_persona = per.ci_persona and ina.ci_persona= "+CI+" and (( ina.fecha_desde >= '"+fIni+"' and ina.fecha_desde <= '"+fFin+"')||"
						+ "( ina.fecha_hasta >= '"+fIni+"' and ina.fecha_hasta <= '"+fFin+"'));";
		try {
			conectar = DriverManager.getConnection(url, usuario, pass);
			sentenciaSQL = conectar.createStatement();
			resultado = sentenciaSQL.executeQuery(sentencia);
			while (resultado.next()) {
				Inasistencia inasistencia = new Inasistencia();
				inasistencia.setIdDocente(resultado.getInt("ci_docente"));
				inasistencia.setGruposAfectados(resultado.getString("observaciones"));
				inasistencia.setMotivoInasistencia(resultado.getString("motivo_inasistencia"));
				inasistencia.setFechaRegistro(resultado.getDate("fecha_registrado"));
				inasistencia.setFechaDesde(resultado.getString("fecha_desde"));
				inasistencia.setFechaHasta(resultado.getString("fecha_hasta"));

				inasistencias.add(inasistencia);
			}
			conectar.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return inasistencias;
	}
	
}
