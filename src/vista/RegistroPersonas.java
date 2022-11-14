package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroPersonas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		
		JLabel lblTipoFuncionario = new JLabel("Tipo Funcionario");
		lblTipoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipoFuncionario.setBounds(209, 298, 172, 30);
		contentPane.add(lblTipoFuncionario);
		
		JLabel lblNombre_2 = new JLabel("Nombre");
		lblNombre_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre_2.setBounds(209, 369, 172, 30);
		contentPane.add(lblNombre_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-", "Administrativo", "Adscripto", "Coordinador"}));
		comboBox.setBounds(426, 292, 258, 36);
		contentPane.add(comboBox);
		
		JLabel lblRegistroNuevoFuncionario = new JLabel("Registro nuevo funcionario");
		lblRegistroNuevoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblRegistroNuevoFuncionario.setBounds(265, 45, 379, 50);
		contentPane.add(lblRegistroNuevoFuncionario);
		
		JButton btnRegistar = new JButton("Registrar");
		btnRegistar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegistar.setBounds(286, 459, 293, 30);
		contentPane.add(btnRegistar);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(426, 145, 258, 36);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(426, 217, 258, 36);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("     ");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(426, 363, 258, 36);
		contentPane.add(textField_2);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				setVisible(false);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVolver.setBounds(286, 513, 293, 30);
		contentPane.add(btnVolver);
	}
}
