package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import modelo.Docente;
import persistencia.Metodos;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class RegistroDocente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCedula;
	private JTextField textFieldName;
	private JTextField textFieldNameMod;

	public RegistroDocente() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setTitle("Registro de falta");
		setResizable(false);
		setBounds(350, 10, 950, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(185,217,194));
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
		lblNewLabel.setBounds(26, 225, 152, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(26, 308, 123, 30);
		contentPane.add(lblNombre);

		JLabel lblRegistroNuevoFuncionario = new JLabel("Registrar nuevo Docente");
		lblRegistroNuevoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblRegistroNuevoFuncionario.setBounds(58, 54, 341, 50);
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
		btnNewButton.setBounds(26, 410, 198, 30);
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
		btnVolver.setBounds(674, 527, 198, 30);
		contentPane.add(btnVolver);

		textFieldCedula = new JTextField();
		textFieldCedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCedula.setBounds(191, 213, 229, 42);
		contentPane.add(textFieldCedula);
		textFieldCedula.setColumns(10);

		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldName.setColumns(10);
		textFieldName.setBounds(191, 297, 229, 42);
		contentPane.add(textFieldName);
		
		JLabel lblRegistroNuevoFuncionario_1 = new JLabel("Modificar Docente");
		lblRegistroNuevoFuncionario_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblRegistroNuevoFuncionario_1.setBounds(547, 54, 256, 50);
		contentPane.add(lblRegistroNuevoFuncionario_1);
		
		textFieldNameMod = new JTextField();
		textFieldNameMod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNameMod.setColumns(10);
		textFieldNameMod.setBounds(643, 310, 229, 42);
		contentPane.add(textFieldNameMod);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre_1.setBounds(478, 321, 123, 30);
		contentPane.add(lblNombre_1);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnModificar.setBounds(478, 410, 198, 30);
		contentPane.add(btnModificar);
		
		JComboBox comboDocente = new JComboBox();
		comboDocente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
			
		});
		comboDocente.setBounds(643, 213, 229, 42);
		contentPane.add(comboDocente);
		ArrayList<Docente> docente = new ArrayList<>();
		docente = Metodos.obtenerDocentes();
		for (int i = 0; i < docente.size(); i++) {
			comboDocente.addItem(docente.get(i).getNombre()+"-"+docente.get(i).getCi());
		}
		
		JLabel lblNewLabel_1_1 = new JLabel("Docente");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(478, 228, 152, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(449, 109, 2, 462);
		contentPane.add(separator);
	}
}
