package controlador;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.Usuarios;
import persistencia.Metodos;

public class AdministracionUsuario {

	
	public static void eliminarUsuario(JTextField textFieldCIBorrU, JLabel lblNombreEliminarU, JButton btnEliminarU) {
		
		if (!textFieldCIBorrU.getText().isEmpty() && textFieldCIBorrU.getText().length() == 8) {
			Metodos.eliminarUsuario(Integer.parseInt(textFieldCIBorrU.getText()));
			lblNombreEliminarU.setText("");
			textFieldCIBorrU.setText("");
			textFieldCIBorrU.setEnabled(true);
			btnEliminarU.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Exito, usuario eliminado satisfactoriamente",
					"Eliminacion usuario...", JOptionPane.DEFAULT_OPTION);
		} else {
			JOptionPane.showMessageDialog(null, "Error, error eliminando el usuario", "Error de ingreso...",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public static void registrarUsuario(JComboBox comboBoxRolReg, JTextField textFieldCIReg, JTextField textFieldNomReg,
			JTextField textFieldPasswd) {
		
		
		int rol = 0;
		if (comboBoxRolReg.getSelectedItem().equals("Administrativo")) {
			rol = 2;
		} else {
			if (comboBoxRolReg.getSelectedItem().equals("Coordinador")) {
				rol = 3;
			} else {
				if (comboBoxRolReg.getSelectedItem().equals("Adscripto")) {
					rol = 4;
				}
			}
		}

		if (textFieldCIReg.getText().isEmpty() || textFieldCIReg.getText().length() > 8
				|| textFieldCIReg.getText().length() < 8) {
			JOptionPane.showMessageDialog(null, "Error, la cedula tiene que ser numerica de 8 digitos", "Error de ingreso...",
					JOptionPane.ERROR_MESSAGE);
			textFieldCIReg.requestFocus();
		} else {
			if (textFieldNomReg.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Error, no ingreso el Nombre", "Error de ingreso...",
						JOptionPane.ERROR_MESSAGE);
				textFieldNomReg.requestFocus();
			} else {
				if (textFieldPasswd.getText().isEmpty() || textFieldPasswd.getText().length() < 4) {
					JOptionPane.showMessageDialog(null,
							"Error, el password debe contener al menos 4 caracteres",
							"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
					textFieldPasswd.requestFocus();
				} else {
					if (rol != 2 && rol != 3 && rol != 4) {
						JOptionPane.showMessageDialog(null, "Error, no selecciono un tipo de usuario",
								"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
						comboBoxRolReg.requestFocus();
					} else {
						Usuarios user = new Usuarios();
						user.setCi(Integer.parseInt(textFieldCIReg.getText()));
						user.setNombre(textFieldNomReg.getText());
						user.setPass(textFieldPasswd.getText());
						user.setRol(rol);
						if (Metodos.insertUsuario(user)) {
							textFieldCIReg.setText("");
							textFieldNomReg.setText("");
							textFieldPasswd.setText("");
							comboBoxRolReg.setSelectedIndex(0);
							JOptionPane.showMessageDialog(null, "Usuario registrado con exito", "Registro...",
									JOptionPane.DEFAULT_OPTION);
						}
					}
				}

			}

		}
	}
	
	
	public static void modificarUsuario(JComboBox comboTipoFunc, JTextField textFieldCiMod, JTextField textFieldNomMod, 
			JPasswordField passwordFieldMod, JButton btnModificarModU) {
		
		
		int rol = 0;
		if (comboTipoFunc.getSelectedItem().equals("Administrativo")) {
			rol = 2;
		} else {
			if (comboTipoFunc.getSelectedItem().equals("Coordinador")) {
				rol = 3;
			} else {
				if (comboTipoFunc.getSelectedItem().equals("Adscripto")) {
					rol = 4;
				}
			}
		}

		if (textFieldCiMod.getText().isEmpty() || textFieldCiMod.getText().length() > 8
				|| textFieldCiMod.getText().length() < 8) {
			JOptionPane.showMessageDialog(null, "Error, no ingreso La Cedula", "Error de ingreso...",
					JOptionPane.ERROR_MESSAGE);
			textFieldCiMod.requestFocus();
		} else {
			if (textFieldNomMod.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Error, no ingreso el Nombre", "Error de ingreso...",
						JOptionPane.ERROR_MESSAGE);
				textFieldNomMod.requestFocus();
			} else {
				if (passwordFieldMod.getText().isEmpty() || passwordFieldMod.getText().length() < 4) {
					JOptionPane.showMessageDialog(null,
							"Error, no ingreso password y debe ser mayor o igual a 4 caracteres",
							"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
					passwordFieldMod.requestFocus();
				} else {
					if (rol != 2 && rol != 3 && rol != 4) {
						JOptionPane.showMessageDialog(null, "Error, no selecciono un tipo de usuario",
								"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
						comboTipoFunc.requestFocus();
					} else {
						Usuarios user = new Usuarios();
						user.setCi(Integer.parseInt(textFieldCiMod.getText()));
						user.setNombre(textFieldNomMod.getText());
						user.setPass(passwordFieldMod.getText());
						user.setRol(rol);
						if (Metodos.modificarUsuario(user)) {
							textFieldCiMod.setText("");
							textFieldCiMod.setEnabled(true);
							textFieldNomMod.setText("");
							textFieldNomMod.setEnabled(false);
							passwordFieldMod.setText("");
							passwordFieldMod.setEnabled(false);
							comboTipoFunc.setSelectedIndex(0);
							comboTipoFunc.setEnabled(false);
							btnModificarModU.setEnabled(false);
							JOptionPane.showMessageDialog(null, "Usuario modificado con exito",
									"Modificacion...", JOptionPane.DEFAULT_OPTION);
						}
					}
				}

			}

		}
		
	}
	
	
	
	
}
