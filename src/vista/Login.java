package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Usuarios;
import persistencia.Metodos;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.DebugGraphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtDocumento;
	private JPasswordField passwordLogin;
	public static Usuarios usuario;
	
	public Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setTitle("Registro Inasistencias");
		setResizable(false);
		setBounds(350, 10, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(185,217,194));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		//coloca la ventana centrada en la pantalla:
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
		btnX.setBounds(554, 0, 46, 50);
		contentPane.add(btnX);
		
		
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Metodos.login(txtDocumento.getText(), passwordLogin.getText())) {
					usuario = Metodos.obtenerUsuario(txtDocumento.getText());
					Menu menu= new Menu();
					menu.setVisible(true);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Documento o contraseña incorrectos, reintente...");
				}
				
				
			}
		});
		btnIngresar.setFont(new Font("Georgia", Font.PLAIN, 20));
		btnIngresar.setBounds(217, 472, 163, 50);
		contentPane.add(btnIngresar);
		
		txtDocumento = new JTextField();
		txtDocumento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (!(Character.isDigit(caracter))) {
					java.awt.Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
			}
		});
		txtDocumento.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtDocumento.setBounds(137, 277, 310, 50);
		contentPane.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE FALTAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 24));
		lblNewLabel.setBounds(149, 73, 282, 40);
		contentPane.add(lblNewLabel);
		
		JLabel its = new JLabel("ITS");
		its.setHorizontalAlignment(SwingConstants.CENTER);
		its.setFont(new Font("Georgia", Font.PLAIN, 24));
		its.setBounds(179, 118, 226, 40);
		contentPane.add(its);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDocumento.setFont(new Font("Georgia", Font.PLAIN, 15));
		lblDocumento.setBounds(137, 245, 129, 31);
		contentPane.add(lblDocumento);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasea.setFont(new Font("Georgia", Font.PLAIN, 15));
		lblContrasea.setBounds(137, 347, 129, 31);
		contentPane.add(lblContrasea);
		
		passwordLogin = new JPasswordField();
		passwordLogin.setBounds(137, 377, 310, 50);
		contentPane.add(passwordLogin);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(100, 229, 404, 5);
		contentPane.add(separator);
	}

	public static Usuarios getUsuario() {
		return usuario;
	}
}
