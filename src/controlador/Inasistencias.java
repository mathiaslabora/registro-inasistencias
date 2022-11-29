package controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.toedter.calendar.JDateChooser;

import modelo.Inasistencia;
import persistencia.Metodos;
import vista.Login;

public class Inasistencias {
	
private static DateFormat dateFormatDB = new SimpleDateFormat("YYYY-MM-dd");
private static DateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");

	public static void registrarInasistencia(JTextField textFieldCIRegistro, JTextPane textPaneGrupos,
			JTextPane textPaneMotivo, JButton btnGuardarFalta, JLabel lblNombreDocente, JDateChooser dateDesde,
			JDateChooser dateHasta) {
		

		try {
			dateFormat.format(dateDesde.getDate());
			dateFormat.format(dateHasta.getDate());

			if (textFieldCIRegistro.getText().isEmpty() || textFieldCIRegistro.getText().length() > 8
					|| textFieldCIRegistro.getText().length() < 8) {
				JOptionPane.showMessageDialog(null, "Error, documento tiene que ser entero de 8 caracteres",
						"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
				dateDesde.requestFocus();
			} else {
				if (Integer.parseInt(dateFormat.format(dateDesde.getDate())) > Integer
						.parseInt(dateFormat.format(dateHasta.getDate()))) {
					JOptionPane.showMessageDialog(null, "Error, fecha de inicio es superior a la de fin",
							"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
					dateDesde.requestFocus();
				} else {
					Inasistencia inasistencia = new Inasistencia();
					inasistencia.setCiPersona(Login.getUsuario().getCi());
					inasistencia.setIdDocente(Integer.parseInt(textFieldCIRegistro.getText()));
					inasistencia.setGruposAfectados(textPaneGrupos.getText());
					inasistencia.setMotivoInasistencia(textPaneMotivo.getText());
					inasistencia.setFechaDesde(dateFormatDB.format(dateDesde.getDate()));
					inasistencia.setFechaHasta(dateFormatDB.format(dateHasta.getDate()));

					if (Metodos.insertInasistencias(inasistencia)) {
						JOptionPane.showMessageDialog(null, "Exito, Se registro la inasistencia satisfactoriamente",
								"Registro inasistencia...", JOptionPane.DEFAULT_OPTION);

						textFieldCIRegistro.setText("");
						textFieldCIRegistro.setEnabled(true);
						lblNombreDocente.setText("");
						btnGuardarFalta.setEnabled(false);
						textPaneGrupos.setText("");
						textPaneMotivo.setText("");
						dateDesde.setDate(null);
						dateHasta.setDate(null);

						Metodos.obtenerInasistenciasObjeto(2);

					} else {
						JOptionPane.showMessageDialog(null,
								"Error, ocurrio un error al intentar registrar la inasistencia",
								"Error de inasistencia...", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error, no ingreso fecha asistencia", "Error de ingreso...",
					JOptionPane.ERROR_MESSAGE);
			dateDesde.requestFocus();
		}

	}

}
