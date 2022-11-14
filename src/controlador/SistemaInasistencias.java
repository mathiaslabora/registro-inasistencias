package controlador;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import persistencia.Metodos;
import vista.Login;

public class SistemaInasistencias {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				if (Metodos.loadDrivers()) {
					try {
						Login frame = new Login();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Error, Contacte administrador...", "Error...",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}


}
