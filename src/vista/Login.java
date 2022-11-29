package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Inasistencia;
import modelo.Usuarios;
import persistencia.Metodos;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.DebugGraphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class Login extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtDocumento;
	private JPasswordField passwordLogin;
	private static Usuarios usuario;
	public static JTable table;
	
	public Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setTitle("Registro Inasistencias");
		setResizable(false);
		setBounds(350, 10, 699, 795);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(128, 128, 255), 1, true));
		//coloca la ventana centrada en la pantalla:
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnX = new JButton("Salir");
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setBackground(new Color(128, 128, 255));
		btnX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnRefrescar = new JButton("Refrescar");
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodos.obtenerInasistenciasObjeto(1);
			}
		});
		
		btnRefrescar.setForeground(Color.WHITE);
		btnRefrescar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRefrescar.setBackground(new Color(128, 128, 255));
		btnRefrescar.setBounds(560, 96, 127, 22);
		contentPane.add(btnRefrescar);
		btnX.setFont(new Font("Arial", Font.PLAIN, 18));
		btnX.setBounds(254, 751, 191, 32);
		contentPane.add(btnX);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(255, 255, 255));
		tabbedPane.setFont(new Font("Arial", Font.BOLD, 15));
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(new Color(128, 128, 255));
		tabbedPane.setBounds(12, 102, 676, 637);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Inasistencias", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(0, 0, 671, 610);
		panel_1.add(scrollPane_1);
		
		JLabel nom=new JLabel("Nombre");
		nom.setForeground(new Color(0, 51, 204));
		nom.setFont(new Font("Tahoma", Font.BOLD, 20));
		JLabel tipo=new JLabel("Tipo de Funcionario");
		tipo.setForeground(new Color(0, 51, 204));
		tipo.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		table = new JTable();
		table.setEnabled(false);
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Nombre", "C.I.", "Grupos", "Motivo", "Desde", "Hasta"
			}
		));
//		table.getColumnModel().getColumn(0).setPreferredWidth(170);
//		table.getColumnModel().getColumn(1).setPreferredWidth(100);
//		table.getColumnModel().getColumn(2).setPreferredWidth(120);
//		table.getColumnModel().getColumn(3).setPreferredWidth(170);
//		table.getColumnModel().getColumn(4).setPreferredWidth(150);
//		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.setRowHeight(30);
		Metodos.obtenerInasistenciasObjeto(1);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Login", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE FALTAS");
		lblNewLabel.setForeground(new Color(128, 128, 255));
		lblNewLabel.setBounds(164, 91, 343, 40);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		
		JLabel its = new JLabel("ITS");
		its.setForeground(new Color(128, 128, 255));
		its.setBounds(178, 136, 315, 40);
		panel.add(its);
		its.setHorizontalAlignment(SwingConstants.CENTER);
		its.setFont(new Font("Arial", Font.PLAIN, 30));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(133, 247, 404, 5);
		panel.add(separator);
		separator.setBackground(new Color(128, 128, 255));
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setBounds(201, 264, 129, 31);
		panel.add(lblDocumento);
		lblDocumento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDocumento.setFont(new Font("Arial", Font.PLAIN, 15));
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(201, 295, 268, 40);
		panel.add(txtDocumento);
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
		txtDocumento.setFont(new Font("Arial", Font.PLAIN, 16));
		txtDocumento.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(201, 369, 129, 31);
		panel.add(lblContrasea);
		lblContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasea.setFont(new Font("Arial", Font.PLAIN, 15));
		
		passwordLogin = new JPasswordField();
		passwordLogin.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordLogin.setBounds(201, 395, 268, 40);
		panel.add(passwordLogin);
		
		
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBackground(new Color(128, 128, 255));
		btnIngresar.setBounds(254, 490, 163, 50);
		panel.add(btnIngresar);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Metodos.login(txtDocumento.getText(), passwordLogin.getText())) {
					usuario = Metodos.obtenerUsuario(txtDocumento.getText());
					Menu menu= new Menu(usuario);
					menu.setVisible(true);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Documento o contraseña incorrectos, reintente...");
				}
				
				
			}
		});
		btnIngresar.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Sistema Inasistencias");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(230, 18, 201, 32);
		contentPane.add(lblNewLabel_1);
	}

	public static Usuarios getUsuario() {
		return usuario;
	}
}
