package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import persistencia.Metodos;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroDocente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCedula;
	private JTextField textFieldName;

	public RegistroDocente() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setTitle("Registro de falta");
		setResizable(false);
		setBounds(350, 10, 950, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		// coloca la ventana centrada en la pantalla:
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnX = new JButton("X");
		btnX.setContentAreaFilled(false);
		btnX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnX.setFont(new Font("Arial", Font.PLAIN, 18));
		btnX.setBounds(904, 0, 46, 50);
		contentPane.add(btnX);

		JLabel lblNewLabel = new JLabel("Cedula Identidad");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(209, 145, 172, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(209, 217, 172, 30);
		contentPane.add(lblNombre);

		JLabel lblRegistroNuevoFuncionario = new JLabel("Registro nuevo Docente");
		lblRegistroNuevoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblRegistroNuevoFuncionario.setBounds(265, 45, 379, 50);
		contentPane.add(lblRegistroNuevoFuncionario);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// validacion incompleta
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
						if (Metodos.buscarCIDocente(textFieldCedula.getText()).getCi() == Integer
								.parseInt(textFieldCedula.getText())) {
							JOptionPane.showMessageDialog(null, "Error, el documento que ingreso ya se encuentra registrado...",
									"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
							textFieldCedula.requestFocus();
						}else {
							if(Metodos.insertDocente(textFieldCedula.getText(), textFieldName.getText())) {
								JOptionPane.showMessageDialog(null, "El registro de Docente se realizo con exito...",
										"Ingreso satisfactorio...", JOptionPane.DEFAULT_OPTION);
								textFieldCedula.requestFocus();
							}else {
								JOptionPane.showMessageDialog(null, "Error, hubo un error en el registro, reintente...",
										"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
								textFieldCedula.requestFocus();
							}
						}
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(288, 323, 293, 30);
		contentPane.add(btnNewButton);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu frame = new Menu();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVolver.setBounds(288, 380, 293, 30);
		contentPane.add(btnVolver);

		textFieldCedula = new JTextField();
		textFieldCedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCedula.setBounds(374, 133, 270, 42);
		contentPane.add(textFieldCedula);
		textFieldCedula.setColumns(10);

		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldName.setColumns(10);
		textFieldName.setBounds(374, 206, 270, 42);
		contentPane.add(textFieldName);
	}
}
