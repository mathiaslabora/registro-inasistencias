package sistemaInasistencias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JLocaleChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;

public class RegistroFalta extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCedula;
	private JLabel lblUsuarioActual;
	private JComboBox cmbxDocente;
	private JDateChooser dateHasta;
	private JDateChooser dateDesde;
	private JTextPane textPaneMotivo;
	private JTextPane textPaneGrupos;
	
	//formateador de fecha
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroFalta frame = new RegistroFalta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RegistroFalta() {
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

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(66, 173, 813, 1);
		contentPane.add(separator);
		
		JLabel lblMotivo = new JLabel("Motivo:");
		lblMotivo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMotivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMotivo.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMotivo.setBounds(85, 279, 78, 38);
		contentPane.add(lblMotivo);
		
		textPaneMotivo = new JTextPane();
		textPaneMotivo.setFont(new Font("Arial", Font.PLAIN, 18));
		textPaneMotivo.setBounds(173, 297, 610, 96);
		contentPane.add(textPaneMotivo);
		
		dateDesde =  new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		dateDesde.setBounds(173, 208, 220, 38);
		contentPane.add(dateDesde);
		
		dateHasta = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		dateHasta.setBounds(565, 208, 220, 38);
		contentPane.add(dateHasta);
		
		JLabel lblDesde = new JLabel("Desde:");
		lblDesde.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDesde.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDesde.setBounds(85, 208, 78, 38);
		contentPane.add(lblDesde);
		
		JLabel lblHasta = new JLabel("Hasta:");
		lblHasta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHasta.setFont(new Font("Arial", Font.PLAIN, 18));
		lblHasta.setBounds(477, 208, 78, 38);
		contentPane.add(lblHasta);
		
		textPaneGrupos = new JTextPane();
		textPaneGrupos.setFont(new Font("Arial", Font.PLAIN, 18));
		textPaneGrupos.setBounds(173, 431, 610, 38);
		contentPane.add(textPaneGrupos);
		
		JLabel lblGrupos = new JLabel("Grupos:");
		lblGrupos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrupos.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGrupos.setBounds(85, 431, 78, 38);
		contentPane.add(lblGrupos);
		
		JLabel lblUsr = new JLabel("Usuario:");
		lblUsr.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUsr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsr.setFont(new Font("Arial", Font.PLAIN, 18));
		lblUsr.setBounds(85, 500, 78, 38);
		contentPane.add(lblUsr);
		
		lblUsuarioActual = new JLabel("...");
		lblUsuarioActual.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUsuarioActual.setFont(new Font("Arial", Font.PLAIN, 18));
		lblUsuarioActual.setBounds(173, 500, 304, 38);
		contentPane.add(lblUsuarioActual);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("REGISTRO DE INASISTENCIA DOCENTE");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(288, 6, 359, 38);
		contentPane.add(lblNewLabel_1_1_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.setBackground(SystemColor.activeCaption);
		menuBar.setBounds(0, 0, 59, 31);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu.setBackground(SystemColor.activeCaption);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Volver a Inicio");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cerrar Sesi\u00F3n");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(66, 268, 813, 1);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(66, 407, 813, 1);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(66, 491, 813, 1);
		contentPane.add(separator_3);
		
		JButton btnGuardarFalta = new JButton("Guardar");
		btnGuardarFalta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("cedula: "+ textFieldCedula.getText());
				System.out.println("motivo: "+ textPaneMotivo.getText());
				System.out.println("grupos: "+ textPaneGrupos.getText());
				System.out.println("desde: "+ dateFormat.format(dateDesde.getDate()));
				System.out.println("hasta: "+ dateFormat.format(dateHasta.getDate()));
				
			}
		});
		btnGuardarFalta.setFont(new Font("Arial", Font.PLAIN, 18));
		btnGuardarFalta.setBounds(625, 508, 158, 38);
		contentPane.add(btnGuardarFalta);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.activeCaption);
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 10));
		tabbedPane.setBounds(403, 54, 379, 102);
		contentPane.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		tabbedPane.addTab("Buscar por Nombre", null, panel_2, null);
		panel_2.setLayout(null);
		
		cmbxDocente = new JComboBox();
		cmbxDocente.setBounds(120, 21, 220, 35);
		panel_2.add(cmbxDocente);
		
		JLabel lblDocente = new JLabel("Nombre:");
		lblDocente.setBounds(21, 25, 78, 27);
		panel_2.add(lblDocente);
		lblDocente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDocente.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(SystemColor.activeCaption);
		tabbedPane.addTab("Buscar por Cedula", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cedula:");
		lblNewLabel.setBounds(10, 27, 62, 22);
		panel_1.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		textFieldCedula = new JTextField();
		textFieldCedula.setBounds(82, 19, 184, 38);
		panel_1.add(textFieldCedula);
		textFieldCedula.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldCedula.setColumns(10);
		
		JButton btnBuscarCedula = new JButton("Buscar");
		btnBuscarCedula.setFont(new Font("Arial", Font.PLAIN, 16));
		btnBuscarCedula.setBounds(276, 19, 88, 38);
		panel_1.add(btnBuscarCedula);
		
		JLabel lblUsuarioActual_1 = new JLabel("...");
		lblUsuarioActual_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUsuarioActual_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblUsuarioActual_1.setBounds(106, 125, 266, 38);
		contentPane.add(lblUsuarioActual_1);
		
		JLabel lblDocente_1 = new JLabel("Docente seleccionado:");
		lblDocente_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDocente_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDocente_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDocente_1.setBounds(106, 84, 220, 38);
		contentPane.add(lblDocente_1);
	}
}
