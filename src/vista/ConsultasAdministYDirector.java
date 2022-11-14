package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultasAdministYDirector extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultasAdministYDirector frame = new ConsultasAdministYDirector();
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
	public ConsultasAdministYDirector() {
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
		
		JLabel lblNewLabel = new JLabel("C.I.:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(88, 129, 39, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblRegistroNuevoFuncionario = new JLabel("Consultas");
		lblRegistroNuevoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblRegistroNuevoFuncionario.setBounds(394, 0, 131, 50);
		contentPane.add(lblRegistroNuevoFuncionario);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(687, 488, 200, 30);
		contentPane.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				setVisible(false);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVolver.setBounds(687, 543, 200, 30);
		contentPane.add(btnVolver);
		
		JLabel lblConsultaInasistenciasDocentes = new JLabel("Consulta inasistencias docentes:");
		lblConsultaInasistenciasDocentes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsultaInasistenciasDocentes.setBounds(88, 89, 283, 30);
		contentPane.add(lblConsultaInasistenciasDocentes);
		
		textField = new JTextField();
		textField.setBounds(128, 132, 210, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(471, 110, 416, 353);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton.setBounds(45, 89, 29, 33);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton_1.setBounds(45, 190, 29, 33);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblConsultaListaDe = new JLabel("Consulta lista de docentes");
		lblConsultaListaDe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsultaListaDe.setBounds(88, 190, 283, 30);
		contentPane.add(lblConsultaListaDe);
	}
}
