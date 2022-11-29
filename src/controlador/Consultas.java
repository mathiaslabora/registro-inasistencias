package controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import modelo.Docente;
import modelo.Inasistencia;
import modelo.Usuarios;
import persistencia.Metodos;
import vista.Login;

public class Consultas {
	private static DateFormat dateFormatDB = new SimpleDateFormat("YYYY-MM-dd");
	private static DateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");

	public static void consultaInasistenciasDocenteFecha(JTextField textFieldCIconsIna, JTextArea textAreaConsultas,
			JDateChooser dateDesdeInaDoc, JDateChooser dateHastaInaDoc, JLabel lblConsulta) {

		try {
			dateFormat.format(dateDesdeInaDoc.getDate());
			dateFormat.format(dateHastaInaDoc.getDate());

			if (textFieldCIconsIna.getText().isEmpty() || textFieldCIconsIna.getText().length() > 8
					|| textFieldCIconsIna.getText().length() < 8) {
				JOptionPane.showMessageDialog(null, "Error, documento tiene que ser entero de 8 caracteres",
						"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
				dateDesdeInaDoc.requestFocus();
			} else {
				if (Integer.parseInt(dateFormat.format(dateDesdeInaDoc.getDate())) > Integer
						.parseInt(dateFormat.format(dateHastaInaDoc.getDate()))) {
					JOptionPane.showMessageDialog(null, "Error, fecha de inicio es superior a la de fin",
							"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
					dateDesdeInaDoc.requestFocus();
				} else {
					textAreaConsultas.setText("");
					if (Metodos.obtenerInasistenciasDocentesFecha(textFieldCIconsIna.getText(),
							dateFormatDB.format(dateDesdeInaDoc.getDate()),
							dateFormatDB.format(dateHastaInaDoc.getDate())).size() > 0) {
						lblConsulta.setText("Inasistencias docente por fecha");
						ArrayList<Inasistencia> inasistencias = Metodos.obtenerInasistenciasDocentesFecha(
								textFieldCIconsIna.getText(), dateFormatDB.format(dateDesdeInaDoc.getDate()),
								dateFormatDB.format(dateHastaInaDoc.getDate()));

						for (int i = 0; i < inasistencias.size(); i++) {
							textAreaConsultas.append("CI: " + inasistencias.get(i).getIdDocente()
									+ "\nFecha registrado: " + inasistencias.get(i).getFechaRegistro()
									+ "\nFalta Desde: " + inasistencias.get(i).getFechaDesde() + "\nFalta Hasta: "
									+ inasistencias.get(i).getFechaHasta() + "\nMotivo: "
									+ inasistencias.get(i).getMotivoInasistencia() + "\nGrupos afectados: "
									+ inasistencias.get(i).getGruposAfectados() + "\n"
									+ "\n-------------------------------\n" + "\n");
						}
						textAreaConsultas.append("\n\nCantidad: " + inasistencias.size());
					} else {

						textAreaConsultas.append("No se encontraron Inasistencias para esa fecha y docente");
					}
				}
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error, falta ingreso fecha", "Error de ingreso...",
					JOptionPane.ERROR_MESSAGE);
			dateDesdeInaDoc.requestFocus();
		}

	}

	public static void consultaInasistenciasFecha(JTextArea textAreaConsultas, JDateChooser dateDesdeInaDoc,
			JDateChooser dateHastaInaDoc, JLabel lblConsulta) {

		try {
			dateFormat.format(dateDesdeInaDoc.getDate());
			dateFormat.format(dateHastaInaDoc.getDate());

			if (Integer.parseInt(dateFormat.format(dateDesdeInaDoc.getDate())) > Integer
					.parseInt(dateFormat.format(dateHastaInaDoc.getDate()))) {
				JOptionPane.showMessageDialog(null, "Error, fecha de inicio es superior a la de fin",
						"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
				dateDesdeInaDoc.requestFocus();
			} else {
				textAreaConsultas.setText("");
				if (Metodos.obtenerTodasInasistenciasFecha(dateFormatDB.format(dateDesdeInaDoc.getDate()),
						dateFormatDB.format(dateHastaInaDoc.getDate())).size() > 0) {
					lblConsulta.setText("Inasistencias por fecha");
					ArrayList<Inasistencia> inasistencias = Metodos.obtenerTodasInasistenciasFecha(
							dateFormatDB.format(dateDesdeInaDoc.getDate()),
							dateFormatDB.format(dateHastaInaDoc.getDate()));

					for (int i = 0; i < inasistencias.size(); i++) {
						textAreaConsultas.append("CI: " + inasistencias.get(i).getIdDocente() + "\nFecha registrado: "
								+ inasistencias.get(i).getFechaRegistro() + "\nFalta Desde: "
								+ inasistencias.get(i).getFechaDesde() + "\nFalta Hasta: "
								+ inasistencias.get(i).getFechaHasta() + "\nMotivo: "
								+ inasistencias.get(i).getMotivoInasistencia() + "\nGrupos afectados: "
								+ inasistencias.get(i).getGruposAfectados() + "\n"
								+ "\n-------------------------------\n" + "\n");
					}
					textAreaConsultas.append("\n\nCantidad: " + inasistencias.size());
				} else {

					textAreaConsultas.setText("No se encontraron Inasistencias para esa fecha");
				}
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error, falta ingreso fecha", "Error de ingreso...",
					JOptionPane.ERROR_MESSAGE);
			dateDesdeInaDoc.requestFocus();
		}

	}

	public static void consultaInasistenciasPorUsuarioFecha(JTextField textFieldConsRegUsu, JTextArea textAreaConsultas,
			JDateChooser dateDesdeRegUsuFech, JDateChooser dateHastaRegUsuFecha, JLabel lblConsulta) {

		try {
			dateFormat.format(dateDesdeRegUsuFech.getDate());
			dateFormat.format(dateHastaRegUsuFecha.getDate());

			if (textFieldConsRegUsu.getText().isEmpty() || textFieldConsRegUsu.getText().length() > 8
					|| textFieldConsRegUsu.getText().length() < 8) {
				JOptionPane.showMessageDialog(null, "Error, documento tiene que ser entero de 8 caracteres",
						"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
				dateDesdeRegUsuFech.requestFocus();
			} else {
				if (Integer.parseInt(dateFormat.format(dateDesdeRegUsuFech.getDate())) > Integer
						.parseInt(dateFormat.format(dateHastaRegUsuFecha.getDate()))) {
					JOptionPane.showMessageDialog(null, "Error, fecha de inicio es superior a la de fin",
							"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
					dateDesdeRegUsuFech.requestFocus();
				} else {
					textAreaConsultas.setText("");
					if (Metodos.obtenerInasistenciasPorUsuarioPorFecha(textFieldConsRegUsu.getText(),
							dateFormatDB.format(dateDesdeRegUsuFech.getDate()),
							dateFormatDB.format(dateHastaRegUsuFecha.getDate())).size() > 0) {
						lblConsulta.setText("Inasistencias por usuario por fecha");
						ArrayList<Inasistencia> inasistencias = Metodos.obtenerInasistenciasPorUsuarioPorFecha(
								textFieldConsRegUsu.getText(), dateFormatDB.format(dateDesdeRegUsuFech.getDate()),
								dateFormatDB.format(dateHastaRegUsuFecha.getDate()));

						for (int i = 0; i < inasistencias.size(); i++) {
							textAreaConsultas.append("CI: " + inasistencias.get(i).getIdDocente()
									+ "\nFecha registrado: " + inasistencias.get(i).getFechaRegistro()
									+ "\nFalta Desde: " + inasistencias.get(i).getFechaDesde() + "\nFalta Hasta: "
									+ inasistencias.get(i).getFechaHasta() + "\nMotivo: "
									+ inasistencias.get(i).getMotivoInasistencia() + "\nGrupos afectados: "
									+ inasistencias.get(i).getGruposAfectados() + "\n"
									+ "\n-------------------------------\n" + "\n");
						}
						textAreaConsultas.append("\n\nCantidad: " + inasistencias.size());
					} else {

						textAreaConsultas.setText("No se encontraron Inasistencias para esa fecha y usuario");
					}
				}
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error, falta ingreso fecha", "Error de ingreso...",
					JOptionPane.ERROR_MESSAGE);
			dateDesdeRegUsuFech.requestFocus();
		}

	}

	public static void consultaTodosDocentes(JTextArea textAreaConsultas, JLabel lblConsulta) {
		// obtenerDocentes
		textAreaConsultas.setText("");
		if (Metodos.obtenerDocentes().size() > 0) {
			ArrayList<Docente> docentes = Metodos.obtenerDocentes();

			for (int i = 0; i < docentes.size(); i++) {
				textAreaConsultas.append("Nombre: " + docentes.get(i).getNombre() + "\nCedula: "
						+ docentes.get(i).getCi() + "\n----------------------------\n");
			}
			lblConsulta.setText("Listado Docentes");
			textAreaConsultas.append("\n\nCantidad: " + docentes.size());
		} else {
			textAreaConsultas.setText("Error");
		}

	}

	/*
	 * Roles 1 Director, 2 Administrativo, 3 Coordinadores, 4 Adscriptos
	 */

	public static void consultaTodosUsuarios(JTextArea textAreaConsultas, JLabel lblConsulta) {
		// obtenerDocentes
		textAreaConsultas.setText("");
		String rol[] = { "", "Director", "Administrativo", "Coordinador", "Adscripto" };
		if (Metodos.obtenerUsuarios().size() > 0) {
			ArrayList<Usuarios> usuarios = Metodos.obtenerUsuarios();

			for (int i = 0; i < usuarios.size(); i++) {

				textAreaConsultas
						.append("Nombre: " + usuarios.get(i).getNombre() + "\nCedula: " + usuarios.get(i).getCi()
								+ "\nRol: " + rol[usuarios.get(i).getRol()] + "\n----------------------------\n");
			}
			lblConsulta.setText("Listado Usuarios");
			textAreaConsultas.append("\n\nCantidad: " + usuarios.size());
		} else {
			textAreaConsultas.setText("Error");
		}

	}

	public static void consultaNombreDocentePorCI(JTextField textFieldCedulaBus, JTextArea textAreaConsultas,
			JLabel lblConsulta) {
		textAreaConsultas.setText("");
		if (textFieldCedulaBus.getText().isEmpty() || textFieldCedulaBus.getText().length() > 8
				|| textFieldCedulaBus.getText().length() < 8) {
			JOptionPane.showMessageDialog(null, "Error, documento tiene que ser entero de 8 caracteres",
					"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
		} else {
			Docente doc = Metodos.obtenerDocente(textFieldCedulaBus.getText());
			if (doc.getCi() == Integer.parseInt(textFieldCedulaBus.getText())) {

				textAreaConsultas.append(
						"\nEl docente encontrado es: \nCI: " + doc.getCi() + "\nNombre: " + doc.getNombre() + "\n");
				lblConsulta.setText("Busqueda de docente por C.I.");
			}else {
				textAreaConsultas.setText("No se encontraron coincidencias con ese documento");
			}
		}
	}
	
	public static void consultaNombreDocentePorNombre(JTextField textFieldNombreBus, JTextArea textAreaConsultas,
			JLabel lblConsulta) {
		textAreaConsultas.setText("");
		if (textFieldNombreBus.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error, campo nombre vacio",
					"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
		}else {
			
			if ( Metodos.obtenerDocentesPorNombre(textFieldNombreBus.getText()).size() > 0) {
				ArrayList<Docente> doc = Metodos.obtenerDocentesPorNombre(textFieldNombreBus.getText());
				textAreaConsultas.setText("Docentes con coincidencias: \n\n");
				for (int i = 0; i < doc.size(); i++) {
					
				textAreaConsultas.append(
						"CI: " + doc.get(i).getCi() + "\nNombre: " + doc.get(i).getNombre() + "\n------------------------------\n");
				}
				lblConsulta.setText("Busqueda de docente por nombre");
			}else {
				textAreaConsultas.setText("No se encontraron coincidencias");
			}
		}
	}
}
