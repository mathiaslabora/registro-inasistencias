package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Usuarios;
import persistencia.Metodos;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistroPersonas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCIReg;
	private JTextField textFieldNomReg;
	private JTextField textFieldPasswd;
	private JTextField textFieldNomMod;
	private JTextField textFieldCiMod;
	private JComboBox comboUsuario;
	private ArrayList<Usuarios> usuarios = new ArrayList();
	private JComboBox comboTipoFunc;
	private JPasswordField passwordFieldMod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroPersonas frame = new RegistroPersonas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistroPersonas() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setTitle("Registro de falta");
		setResizable(false);
		setBounds(350, 10, 950, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(185, 217, 194));
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
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(24, 141, 172, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNombre.setBounds(24, 213, 172, 30);
		contentPane.add(lblNombre);

		JLabel lblTipoFuncionario = new JLabel("Tipo Funcionario");
		lblTipoFuncionario.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTipoFuncionario.setBounds(24, 294, 172, 30);
		contentPane.add(lblTipoFuncionario);

		JLabel lblNombre_2 = new JLabel("Password");
		lblNombre_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNombre_2.setBounds(24, 365, 172, 30);
		contentPane.add(lblNombre_2);

		JComboBox comboBoxRolReg = new JComboBox();
		comboBoxRolReg.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBoxRolReg.setModel(new DefaultComboBoxModel(new String[] { "-", "Administrativo", "Adscripto", "Coordinador" }));
		comboBoxRolReg.setBounds(192, 288, 244, 36);
		contentPane.add(comboBoxRolReg);

		JLabel lblRegistroNuevoFuncionario = new JLabel("Registro nuevo funcionario");
		lblRegistroNuevoFuncionario.setFont(new Font("Arial", Font.BOLD, 24));
		lblRegistroNuevoFuncionario.setBounds(69, 43, 341, 50);
		contentPane.add(lblRegistroNuevoFuncionario);

		JButton btnRegistar = new JButton("Registrar");
		btnRegistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int rol = 0;
				System.out.println(comboTipoFunc.getSelectedItem());
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

				if (textFieldCIReg.getText().isEmpty() || textFieldCIReg.getText().length() >8 || textFieldCIReg.getText().length()<8) {
					JOptionPane.showMessageDialog(null, "Error, no ingreso La Cedula", "Error de ingreso...",
							JOptionPane.ERROR_MESSAGE);
					textFieldCIReg.requestFocus();
				} else {
					if (textFieldNomReg.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Error, no ingreso el Nombre", "Error de ingreso...",
								JOptionPane.ERROR_MESSAGE);
						textFieldNomReg.requestFocus();
					} else {
						if (textFieldPasswd.getText().isEmpty()|| textFieldPasswd.getText().length()< 4 ) {
							JOptionPane.showMessageDialog(null, "Error, no ingreso password y debe ser mayor o igual a 4 caracteres", "Error de ingreso...",
									JOptionPane.ERROR_MESSAGE);
							textFieldPasswd.requestFocus();
						} else {
							if (rol != 2 && rol != 3 && rol != 4) {
								JOptionPane.showMessageDialog(null, "Error, no selecciono un tipo de usuario",
										"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
								comboBoxRolReg.requestFocus();
							}else {
//								System.out.println(
//										textFieldCiMod.getText() + "" + textFieldNomMod.getText() + rol + passwordFieldMod.getText());
	
								Metodos.insertUsuario(textFieldCIReg.getText(), textFieldNomReg.getText(), rol, textFieldPasswd.getText());
								textFieldCIReg.setText("");
								textFieldNomReg.setText("");
								textFieldPasswd.setText("");
								comboBoxRolReg.setSelectedIndex(0);
								JOptionPane.showMessageDialog(null, "Usuario registrado con exito",
										"Registro...", JOptionPane.DEFAULT_OPTION);
							}
						}

					}

				}
				
			}
		});
		btnRegistar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnRegistar.setBounds(24, 462, 178, 30);
		contentPane.add(btnRegistar);

		textFieldCIReg = new JTextField();
		textFieldCIReg.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldCIReg.setColumns(10);
		textFieldCIReg.setBounds(192, 141, 244, 36);
		contentPane.add(textFieldCIReg);

		textFieldNomReg = new JTextField();
		textFieldNomReg.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldNomReg.setColumns(10);
		textFieldNomReg.setBounds(192, 213, 244, 36);
		contentPane.add(textFieldNomReg);

		textFieldPasswd = new JTextField();
		textFieldPasswd.setText("     ");
		textFieldPasswd.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldPasswd.setColumns(10);
		textFieldPasswd.setBounds(192, 359, 244, 36);
		contentPane.add(textFieldPasswd);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				setVisible(false);
			}
		});
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
		btnVolver.setBounds(24, 530, 178, 30);
		contentPane.add(btnVolver);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rol = 0;
				System.out.println(comboTipoFunc.getSelectedItem());
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

				if (textFieldCiMod.getText().isEmpty() || textFieldCiMod.getText().length() >8 || textFieldCiMod.getText().length()<8) {
					JOptionPane.showMessageDialog(null, "Error, no ingreso La Cedula", "Error de ingreso...",
							JOptionPane.ERROR_MESSAGE);
					textFieldCiMod.requestFocus();
				} else {
					if (textFieldNomMod.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Error, no ingreso el Nombre", "Error de ingreso...",
								JOptionPane.ERROR_MESSAGE);
						textFieldNomMod.requestFocus();
					} else {
						if (passwordFieldMod.getText().isEmpty() || passwordFieldMod.getText().length()< 4 ) {
							JOptionPane.showMessageDialog(null, "Error, no ingreso password y debe ser mayor o igual a 4 caracteres", "Error de ingreso...",
									JOptionPane.ERROR_MESSAGE);
							passwordFieldMod.requestFocus();
						} else {
							if (rol != 2 && rol != 3 && rol != 4) {
								JOptionPane.showMessageDialog(null, "Error, no selecciono un tipo de usuario",
										"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
								comboTipoFunc.requestFocus();
							}else {
//								System.out.println(
//										textFieldCiMod.getText() + "" + textFieldNomMod.getText() + rol + passwordFieldMod.getText());
								 Metodos.modificarUsuario(textFieldCiMod.getText(), textFieldNomMod.getText(), rol, passwordFieldMod.getText());
							}
						}

					}

				}
				
				// hacer validaciones
				

				/*
				 * Roles 1 Director 2 Administrativo 3 Coordinadores 4 Adscriptos
				 */
			}
		});
		btnModificar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnModificar.setBounds(502, 462, 178, 30);
		contentPane.add(btnModificar);

		comboTipoFunc = new JComboBox();
		comboTipoFunc
				.setModel(new DefaultComboBoxModel(new String[] { "-", "Administrativo", "Adscripto", "Coordinador" }));
		comboTipoFunc.setFont(new Font("Arial", Font.PLAIN, 18));
		comboTipoFunc.setBounds(678, 333, 244, 36);
		contentPane.add(comboTipoFunc);

		JLabel lblTipoFuncionario_1 = new JLabel("Tipo Funcionario");
		lblTipoFuncionario_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTipoFuncionario_1.setBounds(508, 339, 172, 30);
		contentPane.add(lblTipoFuncionario_1);

		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNombre_1.setBounds(508, 268, 172, 30);
		contentPane.add(lblNombre_1);

		textFieldNomMod = new JTextField();
		textFieldNomMod.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldNomMod.setColumns(10);
		textFieldNomMod.setBounds(678, 268, 244, 36);
		contentPane.add(textFieldNomMod);

		textFieldCiMod = new JTextField();
		textFieldCiMod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (!(Character.isDigit(caracter))) {
					java.awt.Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
			}
		});
		textFieldCiMod.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldCiMod.setColumns(10);
		textFieldCiMod.setBounds(678, 207, 244, 36);
		contentPane.add(textFieldCiMod);

		passwordFieldMod = new JPasswordField();
		passwordFieldMod.setEchoChar('*');
		passwordFieldMod.setBounds(678, 393, 244, 36);
		contentPane.add(passwordFieldMod);

		JLabel lblNewLabel_1 = new JLabel("Cedula Identidad");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(508, 207, 172, 30);
		contentPane.add(lblNewLabel_1);

		JLabel lblTipoFuncionario_1_1 = new JLabel("Usuario");
		lblTipoFuncionario_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTipoFuncionario_1_1.setBounds(508, 147, 172, 30);
		contentPane.add(lblTipoFuncionario_1_1);

		comboUsuario = new JComboBox();

		comboUsuario.setFont(new Font("Arial", Font.PLAIN, 18));
		comboUsuario.setBounds(678, 141, 244, 36);
		contentPane.add(comboUsuario);

		usuarios = Metodos.obtenerUsuarios();

		for (int i = 0; i < usuarios.size(); i++) {
			comboUsuario.addItem(usuarios.get(i).getNombre() + "-" + usuarios.get(i).getCi());
		}

		comboUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboUsuario.getSelectedIndex());
				int indice = comboUsuario.getSelectedIndex();
				textFieldCiMod.setText(usuarios.get(indice).getCi() + "");
				textFieldNomMod.setText(usuarios.get(indice).getNombre());
				passwordFieldMod.setText(usuarios.get(indice).getPass());
			}
		});

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(472, 72, 2, 503);
		contentPane.add(separator);

		JLabel lblModificarFuncionario = new JLabel("Modificar funcionario");
		lblModificarFuncionario.setFont(new Font("Arial", Font.BOLD, 24));
		lblModificarFuncionario.setBounds(565, 43, 301, 50);
		contentPane.add(lblModificarFuncionario);

		JLabel lblNombre_2_1 = new JLabel("Password");
		lblNombre_2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNombre_2_1.setBounds(508, 393, 172, 30);
		contentPane.add(lblNombre_2_1);

	}
}
