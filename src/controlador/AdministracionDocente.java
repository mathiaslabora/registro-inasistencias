package controlador;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Docente;
import persistencia.Metodos;

public class AdministracionDocente {

	public static void registrarDocente(JTextField textFieldCedula, JTextField textFieldName) {

		if (textFieldCedula.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error, no ingreso La Cedula", "Error de ingreso...",
					JOptionPane.ERROR_MESSAGE);
			textFieldCedula.requestFocus();
		} else {
			if (textFieldCedula.getText().length() < 8 || textFieldCedula.getText().length() > 8) {
				JOptionPane.showMessageDialog(null, "Error, la cedula debe de 8 digitos", "Error de ingreso...",
						JOptionPane.ERROR_MESSAGE);
				textFieldCedula.requestFocus();

			} else {
				if (Metodos.obtenerDocente(textFieldCedula.getText()).getCi() == Integer
						.parseInt(textFieldCedula.getText())) {
					JOptionPane.showMessageDialog(null, "Error, el documento que ingreso ya se encuentra registrado...",
							"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
					textFieldCedula.requestFocus();
				} else {
					if (textFieldName.getText().isEmpty() || textFieldName.getText().length() < 4) {
						JOptionPane.showMessageDialog(null, "El nombre debe contener 4 caracteres o mas...",
								"Error ingreso...", JOptionPane.DEFAULT_OPTION);
						textFieldName.requestFocus();

					} else {
						if (Metodos.insertDocente(textFieldCedula.getText(), textFieldName.getText())) {
							JOptionPane.showMessageDialog(null, "El registro de Docente se realizo con exito...",
									"Ingreso satisfactorio...", JOptionPane.DEFAULT_OPTION);
							textFieldCedula.requestFocus();
							textFieldCedula.setText("");
							textFieldName.setText("");

						} else {
							JOptionPane.showMessageDialog(null, "Error, hubo un error en el registro, reintente...",
									"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
							textFieldCedula.requestFocus();
						}
					}
				}
			}
		}
	}

	public static void buscarDocente(JTextField textFieldCIModDoc, JButton btnModificarDoc,
			JTextField textFieldNomModDoc) {
		// textFieldCIModDoc
		// textFieldNomModDoc

		if (textFieldCIModDoc.getText().isEmpty() || textFieldCIModDoc.getText().length() < 8
				|| textFieldCIModDoc.getText().length() > 8) {
			JOptionPane.showMessageDialog(null, "Error, no se encuentra el documento ingresado", "Error de ingreso...",
					JOptionPane.ERROR_MESSAGE);
		} else {
			Docente docenteBuscar = Metodos.obtenerDocente(textFieldCIModDoc.getText());
			if (docenteBuscar.getCi() == Integer.parseInt(textFieldCIModDoc.getText())) {
				textFieldCIModDoc.setEnabled(false);
				btnModificarDoc.setEnabled(true);
				textFieldNomModDoc.setText("" + docenteBuscar.getNombre());
			} else {
				JOptionPane.showMessageDialog(null, "Error, no se encuentra el documento ingresado",
						"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void limpiarDocenteMod(JTextField ci, JButton btn, JTextField name) {
		ci.setEnabled(true);
		ci.setText("");
		btn.setEnabled(false);
		name.setText("");
	}

	public static void modificarDocente(JTextField textFieldCIModDoc, JButton btnModificarDoc,
			JTextField textFieldNomModDoc) {

		if (textFieldCIModDoc.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error, no ingreso La Cedula", "Error de ingreso...",
					JOptionPane.ERROR_MESSAGE);
			textFieldCIModDoc.requestFocus();
		} else {
			if (textFieldCIModDoc.getText().length() < 8 || textFieldCIModDoc.getText().length() > 8) {
				JOptionPane.showMessageDialog(null, "Error, la cedula debe de 8 digitos", "Error de ingreso...",
						JOptionPane.ERROR_MESSAGE);
				textFieldCIModDoc.requestFocus();

			} else {
				if (textFieldNomModDoc.getText().isEmpty() || textFieldNomModDoc.getText().length() < 4) {
					JOptionPane.showMessageDialog(null, "El nombre debe contener 4 caracteres o mas...",
							"Error ingreso...", JOptionPane.DEFAULT_OPTION);
					textFieldNomModDoc.requestFocus();

				} else {
					if (Metodos.modificarDocente(textFieldCIModDoc.getText(), textFieldNomModDoc.getText())) {
						JOptionPane.showMessageDialog(null, "La modificacion de Docente se realizo con exito...",
								"Ingreso satisfactorio...", JOptionPane.DEFAULT_OPTION);
						textFieldCIModDoc.setEnabled(true);
						textFieldCIModDoc.setText("");
						btnModificarDoc.setEnabled(false);
						textFieldNomModDoc.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Error, hubo un error en el registro, reintente...",
								"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
						textFieldCIModDoc.requestFocus();
					}
				}
			}
		}
	}
	
	public static void eliminarDocente( JTextField textFieldCIBorrDoc, JButton btnEliminarDoc,
			JTextField textFieldNombDocElim ) {
		Docente doc = new Docente();
		doc.setCi(Integer.parseInt(textFieldCIBorrDoc.getText()));
		doc.setNombre(textFieldNombDocElim.getText());
		
		if(Metodos.eliminarDocente(doc)) {
			textFieldCIBorrDoc.setEnabled(true);
			textFieldCIBorrDoc.setText("");
			btnEliminarDoc.setEnabled(false);
			textFieldNombDocElim.setText("");
			JOptionPane.showMessageDialog(null, "El Docente se elimino con exito...",
					"Eliminacion satisfactoria...", JOptionPane.DEFAULT_OPTION);
		}
	}

}
