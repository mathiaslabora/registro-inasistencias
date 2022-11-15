package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import modelo.Usuarios;
import persistencia.Metodos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JLabel lblUsuario;
	private Usuarios usuario;
	private JButton btnRegistrarDocente;
	private JButton btnConsultas;
	private JButton btnConsultarInasistenciaDocente;
	private JButton btnRegistrarPersona;
	private JLabel lblRol;
	
	public Menu() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setTitle("Registro de falta");
		setResizable(false);
		setBounds(350, 10, 700, 450);
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
		btnX.setBounds(652, 0, 46, 50);
		contentPane.add(btnX);
		
	
		
		
		JLabel lblRegistroNuevoFuncionario = new JLabel("Bienvenido/a:");
		lblRegistroNuevoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegistroNuevoFuncionario.setBounds(62, 89, 117, 37);
		contentPane.add(lblRegistroNuevoFuncionario);
		
		JButton btnNewButton = new JButton("Registrar inasistencia docente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroFalta registroFalta = new RegistroFalta();
				registroFalta.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(62, 200, 252, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblQueDeseaHacer = new JLabel("Seleccione la opcion que desee: ");
		lblQueDeseaHacer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQueDeseaHacer.setBounds(62, 137, 271, 37);
		contentPane.add(lblQueDeseaHacer);
		
		lblUsuario = new JLabel("...");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(189, 89, 252, 37);
		contentPane.add(lblUsuario);
		
		usuario = Login.getUsuario();
		lblUsuario.setText(usuario.getNombre());
		
		
		
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMenu.setBounds(199, 4, 89, 37);
		contentPane.add(lblMenu);
		
		btnConsultarInasistenciaDocente = new JButton("Consultar inasistencia docente");
		btnConsultarInasistenciaDocente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarInasistenciaDocente.setBounds(390, 200, 252, 30);
		contentPane.add(btnConsultarInasistenciaDocente);
		
		btnRegistrarDocente = new JButton("Registrar/Modificar Docente");
		btnRegistrarDocente.setEnabled(false);
		btnRegistrarDocente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroDocente frame = new RegistroDocente();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnRegistrarDocente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarDocente.setBounds(62, 256, 252, 30);
		contentPane.add(btnRegistrarDocente);
		
		btnConsultas = new JButton("Consultas");
		btnConsultas.setEnabled(false);
		btnConsultas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultas.setBounds(62, 316, 252, 30);
		contentPane.add(btnConsultas);
		
		btnRegistrarPersona = new JButton("Registrar/Modificar Usuario");
		btnRegistrarPersona.setEnabled(false);
		btnRegistrarPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarPersona.setBounds(390, 256, 252, 30);
		contentPane.add(btnRegistrarPersona);
		
		lblRol = new JLabel("...");
		lblRol.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRol.setBounds(310, 6, 143, 37);
		contentPane.add(lblRol);
		
		JLabel lblRegistroNuevoFuncionario_2 = new JLabel("-");
		lblRegistroNuevoFuncionario_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegistroNuevoFuncionario_2.setBounds(286, 6, 28, 37);
		contentPane.add(lblRegistroNuevoFuncionario_2);
		

		/*Roles
		 * 1 Director
		 * 2 Administrativo
		 * 3 Coordinadores
		 * 4 Adscriptos
		 */
		
		
		if(usuario.getRol()==1) {
			btnConsultas.setEnabled(true);
			btnRegistrarDocente.setEnabled(true);
			btnRegistrarPersona.setEnabled(true);
			lblRol.setText("Director");
		}else {
			if(usuario.getRol()==2) {
				btnConsultas.setEnabled(true);
				btnRegistrarDocente.setEnabled(true);
				lblRol.setText("Administrativo");
			}else {
				if(usuario.getRol()==3) {
					lblRol.setText("Coordinadores");
				}else {
					if(usuario.getRol()==4) {
						lblRol.setText("Adscriptos");
					}
				}
			}
		}
		
	}
}
