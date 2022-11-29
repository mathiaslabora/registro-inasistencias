package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import modelo.Docente;
import modelo.Usuarios;
import persistencia.Metodos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import controlador.AdministracionDocente;
import controlador.AdministracionUsuario;
import controlador.Consultas;
import controlador.Inasistencias;

import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSeparator;

public class Menu extends JFrame {

	/*
	 * Roles 1 Director, 2 Administrativo, 3 Coordinadores, 4 Adscriptos
	 */

	private JPanel contentPane;
	private Usuarios usuario;
	private JTextField textFieldCedula;
	private JTextField textFieldName;
	private JTextField textFieldNomModDoc;
	private JTextField textFieldCIReg;
	private JTextField textFieldNomReg;
	private JTextField textFieldPasswd;
	private JTextField textFieldCiMod;
	private JTextField textFieldNomMod;
	private JPasswordField passwordFieldMod;
	private JTextField textFieldCIBorrU;
	private JTextField textFieldCIBorrDoc;

	public static JTable table;
	private JTextField textFieldCIRegistro;
	private JLabel lblNombreEliminarU;
	private JButton btnEliminarU;
	private JLabel lblNombreDocReg;
	private JLabel lblNombreDocente;

	private JButton btnGuardarFalta;
	private JButton btnNuevoDoceReg;
	private JButton btnRefrescar;
	private JTextField textFieldCIModDoc;
	private JButton btnModificarDoc;
	private JTextField textFieldNombDocElim;
	private JButton btnEliminarDoc;
	private JTextField textFieldCIconsIna;
	private JTextField textFieldConsRegUsu;
	private JDateChooser dateDesdeInaDoc;
	private JDateChooser dateHastaInaDoc;
	private JDateChooser dateDesdeInaFecha;
	private JDateChooser dateHastaInaFecha;
	private JDateChooser dateDesdeRegUsuFech;
	private JDateChooser dateHastaRegUsuFecha;
	private JTextArea textAreaConsultas;
	private JLabel lblConsulta;
	private JTextField textFieldCedulaBus;
	private JTextField textFieldNombreBus;
	private JLabel lblRol;
	private JLabel lblUsuario;
	private JPanel panelAdminDocentes;
	private JPanel panelAdminUsuarios;
	private JPanel panelConsultas;

	public Menu(Usuarios user) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(350, 10, 1158, 733);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(128, 128, 255)));
		// coloca la ventana centrada en la pantalla:
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnX = new JButton("Cerrar");
		btnX.setBorderPainted(false);
		btnX.setBackground(new Color(128, 128, 255));
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setBounds(483, 689, 191, 31);
		contentPane.add(btnX);
		btnX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnX.setFont(new Font("Arial", Font.PLAIN, 18));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 15));
		tabbedPane.setBounds(12, 61, 1138, 615);
		contentPane.add(tabbedPane);

		JPanel panelInasistencias = new JPanel();
		panelInasistencias.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Inasistencias", null, panelInasistencias, null);
		panelInasistencias.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(12, 13, 568, 523);
		panelInasistencias.add(scrollPane_1);

		JLabel nom = new JLabel("Nombre");
		nom.setForeground(new Color(0, 51, 204));
		nom.setFont(new Font("Tahoma", Font.BOLD, 20));
		JLabel tipo = new JLabel("Tipo de Funcionario");
		tipo.setForeground(new Color(0, 51, 204));
		tipo.setFont(new Font("Tahoma", Font.BOLD, 20));

		table = new JTable();
		table.setEnabled(false);
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "Nombre", "C.I.", "Grupos", "Motivo", "Desde", "Hasta" }));
		table.setRowHeight(30);
		Metodos.obtenerInasistenciasObjeto(2);

		btnRefrescar = new JButton("Refrescar");
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodos.obtenerInasistenciasObjeto(2);
			}
		});
		btnRefrescar.setBorderPainted(false);
		btnRefrescar.setForeground(Color.WHITE);
		btnRefrescar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRefrescar.setBackground(new Color(128, 128, 255));
		btnRefrescar.setBounds(453, 549, 127, 22);
		panelInasistencias.add(btnRefrescar);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(592, 13, 529, 523);
		panelInasistencias.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Documento:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(12, 95, 94, 22);
		panel_6.add(lblNewLabel_5);

		textFieldCIRegistro = new JTextField();
		textFieldCIRegistro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (!(Character.isDigit(caracter))) {
					java.awt.Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
			}
		});
		textFieldCIRegistro.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldCIRegistro.setColumns(10);
		textFieldCIRegistro.setBounds(117, 86, 190, 31);
		panel_6.add(textFieldCIRegistro);
		
		JButton btnBuscarCIRegistro = new JButton("Buscar");
		btnBuscarCIRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textFieldCIRegistro.getText().isEmpty() || textFieldCIRegistro.getText().length() < 8
						|| textFieldCIRegistro.getText().length() > 8) {
					JOptionPane.showMessageDialog(null, "Error, no se encuentra el documento ingresado",
							"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
				} else {
					Docente docenteBuscar = Metodos.obtenerDocente(textFieldCIRegistro.getText());
					if (docenteBuscar.getCi() == Integer.parseInt(textFieldCIRegistro.getText())) {
						textFieldCIRegistro.setEnabled(false);
						lblNombreDocente.setText(docenteBuscar.getNombre());
						btnGuardarFalta.setEnabled(true);

					} else {
						JOptionPane.showMessageDialog(null, "Error, no se encuentra el documento ingresado",
								"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		btnBuscarCIRegistro.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBuscarCIRegistro.setBounds(330, 86, 88, 31);
		panel_6.add(btnBuscarCIRegistro);

		JLabel lblDesde = new JLabel("Desde:");
		lblDesde.setHorizontalAlignment(SwingConstants.LEFT);
		lblDesde.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDesde.setBounds(347, 138, 60, 31);
		panel_6.add(lblDesde);

		JDateChooser dateDesde = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		dateDesde.setBounds(407, 138, 111, 31);
		panel_6.add(dateDesde);

		JLabel lblHasta = new JLabel("Hasta:");
		lblHasta.setHorizontalAlignment(SwingConstants.LEFT);
		lblHasta.setFont(new Font("Arial", Font.PLAIN, 15));
		lblHasta.setBounds(347, 192, 50, 31);
		panel_6.add(lblHasta);

		JDateChooser dateHasta = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		dateHasta.setBounds(407, 192, 111, 31);
		panel_6.add(dateHasta);

		JTextPane textPaneMotivo = new JTextPane();
		textPaneMotivo.setBorder(new TitledBorder(null, "Motivo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textPaneMotivo.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaneMotivo.setBounds(12, 255, 506, 105);
		panel_6.add(textPaneMotivo);

		JTextPane textPaneGrupos = new JTextPane();
		textPaneGrupos.setBorder(
				new TitledBorder(null, "Grupos afectados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textPaneGrupos.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaneGrupos.setBounds(12, 385, 506, 50);
		panel_6.add(textPaneGrupos);

		btnGuardarFalta = new JButton("Guardar");
		btnGuardarFalta.setEnabled(false);
		btnGuardarFalta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inasistencias.registrarInasistencia(textFieldCIRegistro, textPaneGrupos, textPaneMotivo,
						btnGuardarFalta, lblNombreDocente, dateDesde, dateHasta);
			}
		});
		btnGuardarFalta.setFont(new Font("Arial", Font.PLAIN, 15));
		btnGuardarFalta.setBounds(375, 479, 143, 31);
		panel_6.add(btnGuardarFalta);

		lblNombreDocReg = new JLabel("Nombre:");
		lblNombreDocReg.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombreDocReg.setBounds(12, 138, 70, 31);
		panel_6.add(lblNombreDocReg);

		lblNombreDocente = new JLabel("...");
		lblNombreDocente.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombreDocente.setBounds(117, 138, 162, 31);
		panel_6.add(lblNombreDocente);

		btnNuevoDoceReg = new JButton("Nuevo");
		btnNuevoDoceReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textFieldCIRegistro.setText("");
				textFieldCIRegistro.setEnabled(true);
				lblNombreDocente.setText("");
				btnGuardarFalta.setEnabled(false);
				textPaneGrupos.setText("");
				textPaneMotivo.setText("");
				dateDesde.setDate(null);
				dateHasta.setDate(null);

			}
		});
		btnNuevoDoceReg.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNuevoDoceReg.setBounds(430, 86, 88, 31);
		panel_6.add(btnNuevoDoceReg);

		JLabel lblNewLabel_6 = new JLabel("Registrar Inasistencia");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(188, 13, 175, 31);
		panel_6.add(lblNewLabel_6);

		panelAdminDocentes = new JPanel();
		panelAdminDocentes.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Administrar Docentes", null, panelAdminDocentes, null);
		panelAdminDocentes.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBorder(new LineBorder(new Color(128, 128, 255), 1, true));
		panel_4.setBounds(12, 13, 1111, 177);
		panelAdminDocentes.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblRegistroNuevoFuncionario = new JLabel("Registrar nuevo Docente");
		lblRegistroNuevoFuncionario.setFont(new Font("Arial", Font.PLAIN, 20));
		lblRegistroNuevoFuncionario.setBounds(442, 13, 227, 50);
		panel_4.add(lblRegistroNuevoFuncionario);

		textFieldCedula = new JTextField();
		textFieldCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (!(Character.isDigit(caracter))) {
					java.awt.Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
			}
		});
		textFieldCedula.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldCedula.setColumns(10);
		textFieldCedula.setBounds(215, 60, 198, 35);
		panel_4.add(textFieldCedula);

		JLabel lblNewLabel = new JLabel("Cedula Identidad");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(94, 62, 123, 30);
		panel_4.add(lblNewLabel);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre.setBounds(157, 119, 60, 30);
		panel_4.add(lblNombre);

		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldName.setColumns(10);
		textFieldName.setBounds(215, 117, 198, 35);
		panel_4.add(textFieldName);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				AdministracionDocente.registrarDocente(textFieldCedula, textFieldName);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(781, 136, 180, 30);
		panel_4.add(btnNewButton);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBorder(new LineBorder(new Color(128, 128, 255), 1, true));
		panel_4_1.setBackground(Color.WHITE);
		panel_4_1.setBounds(12, 203, 1111, 171);
		panelAdminDocentes.add(panel_4_1);

		JLabel lblRegistroNuevoFuncionario_1 = new JLabel("Modificar Docente");
		lblRegistroNuevoFuncionario_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblRegistroNuevoFuncionario_1.setBounds(470, 13, 170, 50);
		panel_4_1.add(lblRegistroNuevoFuncionario_1);

		JButton btnObtener = new JButton("Buscar");
		btnObtener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministracionDocente.buscarDocente(textFieldCIModDoc, btnModificarDoc, textFieldNomModDoc);
			}
		});
		btnObtener.setBackground(new Color(255, 255, 255));
		btnObtener.setFont(new Font("Arial", Font.PLAIN, 15));
		btnObtener.setBounds(445, 64, 87, 36);
		panel_4_1.add(btnObtener);

		textFieldNomModDoc = new JTextField();
		textFieldNomModDoc.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldNomModDoc.setColumns(10);
		textFieldNomModDoc.setBounds(217, 114, 203, 36);
		panel_4_1.add(textFieldNomModDoc);

		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre_1.setBounds(159, 117, 60, 30);
		panel_4_1.add(lblNombre_1);

		btnModificarDoc = new JButton("Modificar");
		btnModificarDoc.setEnabled(false);
		btnModificarDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AdministracionDocente.modificarDocente(textFieldCIModDoc, btnModificarDoc, textFieldNomModDoc);

			}
		});
		btnModificarDoc.setBackground(new Color(255, 255, 255));
		btnModificarDoc.setFont(new Font("Arial", Font.PLAIN, 15));
		btnModificarDoc.setBounds(780, 128, 181, 30);
		panel_4_1.add(btnModificarDoc);

		textFieldCIModDoc = new JTextField();
		textFieldCIModDoc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (!(Character.isDigit(caracter))) {
					java.awt.Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
			}
		});
		textFieldCIModDoc.setBounds(217, 65, 203, 36);
		panel_4_1.add(textFieldCIModDoc);
		textFieldCIModDoc.setColumns(10);

		JButton btnLimpiarModDoc = new JButton("Limpiar");
		btnLimpiarModDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministracionDocente.limpiarDocenteMod(textFieldCIModDoc, btnModificarDoc, textFieldNomModDoc);
			}
		});
		btnLimpiarModDoc.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLimpiarModDoc.setBackground(Color.WHITE);
		btnLimpiarModDoc.setBounds(542, 64, 87, 36);
		panel_4_1.add(btnLimpiarModDoc);

		JLabel lblNewLabel_2_1 = new JLabel("Cedula Identidad");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(96, 64, 123, 30);
		panel_4_1.add(lblNewLabel_2_1);

		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBorder(new LineBorder(new Color(128, 128, 255), 1, true));
		panel_4_1_1.setBackground(Color.WHITE);
		panel_4_1_1.setBounds(12, 387, 1111, 183);
		panelAdminDocentes.add(panel_4_1_1);

		JLabel lblRegistroNuevoFuncionario_1_1 = new JLabel("Eliminar Docente");
		lblRegistroNuevoFuncionario_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblRegistroNuevoFuncionario_1_1.setBounds(478, 13, 155, 50);
		panel_4_1_1.add(lblRegistroNuevoFuncionario_1_1);

		JButton btnObtenerEliminar = new JButton("Buscar");
		btnObtenerEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AdministracionDocente.buscarDocente(textFieldCIBorrDoc, btnEliminarDoc, textFieldNombDocElim);

			}
		});
		btnObtenerEliminar.setBackground(new Color(255, 255, 255));
		btnObtenerEliminar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnObtenerEliminar.setBounds(445, 76, 87, 36);
		panel_4_1_1.add(btnObtenerEliminar);

		btnEliminarDoc = new JButton("Eliminar");
		btnEliminarDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministracionDocente.eliminarDocente(textFieldCIBorrDoc, btnEliminarDoc, textFieldNombDocElim);
			}
		});
		btnEliminarDoc.setBackground(new Color(255, 255, 255));
		btnEliminarDoc.setEnabled(false);
		btnEliminarDoc.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEliminarDoc.setBounds(780, 140, 181, 30);
		panel_4_1_1.add(btnEliminarDoc);

		JLabel lblNewLabel_2 = new JLabel("Cedula Identidad");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(96, 79, 116, 30);
		panel_4_1_1.add(lblNewLabel_2);

		textFieldCIBorrDoc = new JTextField();
		textFieldCIBorrDoc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (!(Character.isDigit(caracter))) {
					java.awt.Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
			}
		});
		textFieldCIBorrDoc.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldCIBorrDoc.setColumns(10);
		textFieldCIBorrDoc.setBounds(224, 77, 198, 35);
		panel_4_1_1.add(textFieldCIBorrDoc);

		JButton btnLimpiarElimDoc = new JButton("Limpiar");
		btnLimpiarElimDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministracionDocente.limpiarDocenteMod(textFieldCIBorrDoc, btnEliminarDoc, textFieldNombDocElim);
			}
		});
		btnLimpiarElimDoc.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLimpiarElimDoc.setBackground(Color.WHITE);
		btnLimpiarElimDoc.setBounds(546, 76, 87, 36);
		panel_4_1_1.add(btnLimpiarElimDoc);

		JLabel lblNombre_1_1 = new JLabel("Nombre");
		lblNombre_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre_1_1.setBounds(159, 129, 55, 30);
		panel_4_1_1.add(lblNombre_1_1);

		textFieldNombDocElim = new JTextField();
		textFieldNombDocElim.setEnabled(false);
		textFieldNombDocElim.setBounds(224, 123, 198, 36);
		panel_4_1_1.add(textFieldNombDocElim);
		textFieldNombDocElim.setColumns(10);

		panelAdminUsuarios = new JPanel();
		panelAdminUsuarios.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Administrar Usuarios", null, panelAdminUsuarios, null);
		panelAdminUsuarios.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(128, 128, 255), 1, true));
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(10, 10, 1113, 161);
		panelAdminUsuarios.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblRegistroNuevoFuncionario_2 = new JLabel("Registro nuevo usuario");
		lblRegistroNuevoFuncionario_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblRegistroNuevoFuncionario_2.setBounds(425, 10, 206, 33);
		panel_5.add(lblRegistroNuevoFuncionario_2);

		JLabel lblNewLabel_1 = new JLabel("Cedula Identidad");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(92, 57, 126, 30);
		panel_5.add(lblNewLabel_1);

		textFieldCIReg = new JTextField();
		textFieldCIReg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (!(Character.isDigit(caracter))) {
					java.awt.Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
			}
		});
		textFieldCIReg.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldCIReg.setColumns(10);
		textFieldCIReg.setBounds(220, 57, 220, 30);
		panel_5.add(textFieldCIReg);

		JLabel lblNombre_2 = new JLabel("Nombre");
		lblNombre_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre_2.setBounds(516, 57, 66, 30);
		panel_5.add(lblNombre_2);

		textFieldNomReg = new JTextField();
		textFieldNomReg.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldNomReg.setColumns(10);
		textFieldNomReg.setBounds(587, 56, 220, 33);
		panel_5.add(textFieldNomReg);

		JLabel lblTipoFuncionario = new JLabel("Tipo Funcionario");
		lblTipoFuncionario.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTipoFuncionario.setBounds(92, 97, 126, 30);
		panel_5.add(lblTipoFuncionario);

		JComboBox comboBoxRolReg = new JComboBox();
		comboBoxRolReg
				.setModel(new DefaultComboBoxModel(new String[] { "-", "Administrativo", "Coordinador", "Adscripto" }));
		comboBoxRolReg.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxRolReg.setBounds(220, 97, 220, 30);
		panel_5.add(comboBoxRolReg);

		JLabel lblNombre_2_1 = new JLabel("Password");
		lblNombre_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre_2_1.setBounds(516, 97, 66, 30);
		panel_5.add(lblNombre_2_1);

		textFieldPasswd = new JTextField();
		textFieldPasswd.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldPasswd.setColumns(10);
		textFieldPasswd.setBounds(587, 94, 220, 33);
		panel_5.add(textFieldPasswd);

		JButton btnRegistarU = new JButton("Registrar");
		btnRegistarU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministracionUsuario.registrarUsuario(comboBoxRolReg, textFieldCIReg, textFieldNomReg,
						textFieldPasswd);
			}
		});
		btnRegistarU.setBackground(new Color(255, 255, 255));
		btnRegistarU.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRegistarU.setBounds(861, 97, 150, 30);
		panel_5.add(btnRegistarU);

		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setBorder(new LineBorder(new Color(128, 128, 255), 1, true));
		panel_5_1.setBackground(Color.WHITE);
		panel_5_1.setBounds(10, 184, 1113, 177);
		panelAdminUsuarios.add(panel_5_1);

		JLabel lblRegistroNuevoFuncionario_2_1 = new JLabel("Modificar usuario");
		lblRegistroNuevoFuncionario_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblRegistroNuevoFuncionario_2_1.setBounds(448, 13, 161, 33);
		panel_5_1.add(lblRegistroNuevoFuncionario_2_1);

		JLabel lblNewLabel_1_2 = new JLabel("Cedula Identidad");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(92, 60, 113, 30);
		panel_5_1.add(lblNewLabel_1_2);

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
		textFieldCiMod.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldCiMod.setColumns(10);
		textFieldCiMod.setBounds(217, 59, 225, 33);
		panel_5_1.add(textFieldCiMod);

		JLabel lblNombre_1_2 = new JLabel("Nombre");
		lblNombre_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre_1_2.setBounds(144, 115, 61, 30);
		panel_5_1.add(lblNombre_1_2);

		textFieldNomMod = new JTextField();
		textFieldNomMod.setEnabled(false);
		textFieldNomMod.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldNomMod.setColumns(10);
		textFieldNomMod.setBounds(217, 109, 225, 36);
		panel_5_1.add(textFieldNomMod);

		JLabel lblTipoFuncionario_1 = new JLabel("Tipo Funcionario");
		lblTipoFuncionario_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTipoFuncionario_1.setBounds(674, 62, 113, 30);
		panel_5_1.add(lblTipoFuncionario_1);

		JComboBox comboTipoFunc = new JComboBox();
		comboTipoFunc
				.setModel(new DefaultComboBoxModel(new String[] { "-", "Administrativo", "Coordinador", "Adscripto" }));
		comboTipoFunc.setEnabled(false);
		comboTipoFunc.setFont(new Font("Arial", Font.PLAIN, 15));
		comboTipoFunc.setBounds(799, 59, 161, 33);
		panel_5_1.add(comboTipoFunc);

		JLabel lblNombre_2_1_1 = new JLabel("Password");
		lblNombre_2_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre_2_1_1.setBounds(669, 117, 78, 30);
		panel_5_1.add(lblNombre_2_1_1);

		passwordFieldMod = new JPasswordField();
		passwordFieldMod.setEnabled(false);
		passwordFieldMod.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordFieldMod.setEchoChar('*');
		passwordFieldMod.setBounds(747, 113, 213, 34);
		panel_5_1.add(passwordFieldMod);

		JButton btnModificarModU = new JButton("Modificar");
		btnModificarModU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministracionUsuario.modificarUsuario(comboTipoFunc, textFieldCiMod, textFieldNomMod, passwordFieldMod,
						btnModificarModU);
			}
		});
		btnModificarModU.setEnabled(false);
		btnModificarModU.setBackground(new Color(255, 255, 255));
		btnModificarModU.setFont(new Font("Arial", Font.PLAIN, 15));
		btnModificarModU.setBounds(969, 115, 132, 31);
		panel_5_1.add(btnModificarModU);

		JButton btnBuscarMod = new JButton("Buscar");
		btnBuscarMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textFieldCiMod.getText().isEmpty() || textFieldCiMod.getText().length() < 8
						|| textFieldCiMod.getText().length() > 8) {
					JOptionPane.showMessageDialog(null, "Error, no se encuentra el documento ingresado",
							"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
				} else {
					Usuarios usuarioBuscar = Metodos.obtenerUsuario(textFieldCiMod.getText());
					if (usuarioBuscar.getCi() == Integer.parseInt(textFieldCiMod.getText())) {
						textFieldCiMod.setEnabled(false);
						passwordFieldMod.setEnabled(true);
						passwordFieldMod.setText(usuarioBuscar.getPass());
						textFieldNomMod.setEnabled(true);
						textFieldNomMod.setText(usuarioBuscar.getNombre());
						comboTipoFunc.setEnabled(true);
						btnModificarModU.setEnabled(true);
						if (usuarioBuscar.getRol() == 1) {
							JOptionPane.showMessageDialog(null, "Error, no se puede editar director",
									"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
							textFieldCiMod.setEnabled(false);
							passwordFieldMod.setEnabled(false);
							textFieldNomMod.setEnabled(false);
							comboTipoFunc.setEnabled(false);
							btnModificarModU.setEnabled(false);

						} else {
							if (usuarioBuscar.getRol() == 2) {
								comboTipoFunc.setSelectedIndex(1);
							} else if (usuarioBuscar.getRol() == 3) {
								comboTipoFunc.setSelectedIndex(2);
							} else if (usuarioBuscar.getRol() == 4) {
								comboTipoFunc.setSelectedIndex(3);
							}
						}

					} else {
						JOptionPane.showMessageDialog(null, "Error, no se encuentra el documento ingresado",
								"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnBuscarMod.setBackground(new Color(255, 255, 255));
		btnBuscarMod.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBuscarMod.setBounds(449, 63, 89, 31);
		panel_5_1.add(btnBuscarMod);

		JButton btnNuevoModU = new JButton("Nuevo");
		btnNuevoModU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textFieldCiMod.setEnabled(true);
				textFieldCiMod.setText("");
				passwordFieldMod.setEnabled(false);
				passwordFieldMod.setText("");
				textFieldNomMod.setEnabled(false);
				textFieldNomMod.setText("");
				comboTipoFunc.setEnabled(false);
				btnModificarModU.setEnabled(false);
				comboTipoFunc.setSelectedIndex(0);

			}
		});
		btnNuevoModU.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNuevoModU.setBackground(Color.WHITE);
		btnNuevoModU.setBounds(550, 63, 89, 31);
		panel_5_1.add(btnNuevoModU);

		JPanel panel_5_2 = new JPanel();
		panel_5_2.setLayout(null);
		panel_5_2.setBorder(new LineBorder(new Color(128, 128, 255), 1, true));
		panel_5_2.setBackground(Color.WHITE);
		panel_5_2.setBounds(10, 374, 1113, 196);
		panelAdminUsuarios.add(panel_5_2);

		JLabel lblRegistroNuevoFuncionario_2_2 = new JLabel("Eliminar usuario");
		lblRegistroNuevoFuncionario_2_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblRegistroNuevoFuncionario_2_2.setBounds(455, 13, 147, 33);
		panel_5_2.add(lblRegistroNuevoFuncionario_2_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Cedula Identidad");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(93, 60, 113, 30);
		panel_5_2.add(lblNewLabel_1_2_1);

		textFieldCIBorrU = new JTextField();
		textFieldCIBorrU.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (!(Character.isDigit(caracter))) {
					java.awt.Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
			}
		});
		textFieldCIBorrU.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldCIBorrU.setColumns(10);
		textFieldCIBorrU.setBounds(218, 59, 225, 33);
		panel_5_2.add(textFieldCIBorrU);

		JButton btnBuscarElimU = new JButton("Buscar");
		btnBuscarElimU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textFieldCIBorrU.getText().isEmpty() || textFieldCIBorrU.getText().length() < 8
						|| textFieldCIBorrU.getText().length() > 8) {
					JOptionPane.showMessageDialog(null, "Error, no se encuentra el documento ingresado",
							"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
				} else {
					Usuarios usuarioBuscar = Metodos.obtenerUsuario(textFieldCIBorrU.getText());
					if (usuarioBuscar.getRol() == 1) {
						JOptionPane.showMessageDialog(null, "Error, no puede eliminar un director!!",
								"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
					} else {
						if (usuarioBuscar.getCi() == Integer.parseInt(textFieldCIBorrU.getText())) {
							lblNombreEliminarU.setText(usuarioBuscar.getNombre());
							textFieldCIBorrU.setEnabled(false);
							btnEliminarU.setEnabled(true);
						} else {
							JOptionPane.showMessageDialog(null, "Error, no se encuentra el documento ingresado",
									"Error de ingreso...", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		btnBuscarElimU.setBackground(new Color(255, 255, 255));
		btnBuscarElimU.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBuscarElimU.setBounds(450, 63, 106, 31);
		panel_5_2.add(btnBuscarElimU);

		btnEliminarU = new JButton("Eliminar");
		btnEliminarU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministracionUsuario.eliminarUsuario(textFieldCIBorrU, lblNombreEliminarU, btnEliminarU);

			}
		});
		btnEliminarU.setEnabled(false);
		btnEliminarU.setBackground(new Color(255, 255, 255));
		btnEliminarU.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEliminarU.setBounds(503, 158, 106, 27);
		panel_5_2.add(btnEliminarU);

		lblNombreEliminarU = new JLabel("...");
		lblNombreEliminarU.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombreEliminarU.setBounds(218, 103, 244, 33);
		panel_5_2.add(lblNombreEliminarU);

		JButton btnNuevoEliminarU = new JButton("Nuevo");
		btnNuevoEliminarU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblNombreEliminarU.setText("");
				textFieldCIBorrU.setText("");
				textFieldCIBorrU.setEnabled(true);
				btnEliminarU.setEnabled(false);
			}
		});
		btnNuevoEliminarU.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNuevoEliminarU.setBackground(Color.WHITE);
		btnNuevoEliminarU.setBounds(568, 63, 106, 31);
		panel_5_2.add(btnNuevoEliminarU);

		JLabel lblNombre_1_2_1 = new JLabel("Nombre");
		lblNombre_1_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre_1_2_1.setBounds(145, 106, 61, 30);
		panel_5_2.add(lblNombre_1_2_1);

		panelConsultas = new JPanel();
		tabbedPane.addTab("Consultas", null, panelConsultas, null);
		panelConsultas.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_7.setBounds(10, 11, 510, 561);
		panelConsultas.add(panel_7);
		panel_7.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Cedula Identidad");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(22, 178, 116, 30);
		panel_7.add(lblNewLabel_1_1);

		textFieldCIconsIna = new JTextField();
		textFieldCIconsIna.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldCIconsIna.setColumns(10);
		textFieldCIconsIna.setBounds(142, 178, 190, 30);
		panel_7.add(textFieldCIconsIna);

		JButton btnBuscarInasistDocFecha = new JButton("Buscar");
		btnBuscarInasistDocFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Consultas.consultaInasistenciasDocenteFecha(textFieldCIconsIna, textAreaConsultas, dateDesdeInaDoc,
						dateHastaInaDoc, lblConsulta);
			}
		});
		btnBuscarInasistDocFecha.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBuscarInasistDocFecha.setBackground(Color.WHITE);
		btnBuscarInasistDocFecha.setBounds(343, 222, 111, 30);
		panel_7.add(btnBuscarInasistDocFecha);

		JLabel lblDesde_1 = new JLabel("Desde:");
		lblDesde_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDesde_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDesde_1.setBounds(22, 221, 60, 31);
		panel_7.add(lblDesde_1);

		dateDesdeInaDoc = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		dateDesdeInaDoc.setBounds(72, 221, 98, 31);
		panel_7.add(dateDesdeInaDoc);

		JLabel lblHasta_1 = new JLabel("Hasta:");
		lblHasta_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblHasta_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblHasta_1.setBounds(180, 222, 50, 31);
		panel_7.add(lblHasta_1);

		dateHastaInaDoc = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		dateHastaInaDoc.setBounds(234, 222, 98, 31);
		panel_7.add(dateHastaInaDoc);

		JLabel lblNewLabel_3 = new JLabel("Consulta inasistencias docente por fecha");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(95, 145, 292, 22);
		panel_7.add(lblNewLabel_3);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(128, 128, 255));
		separator.setBounds(22, 263, 441, 4);
		panel_7.add(separator);

		JButton btnListarDocentes = new JButton("Listar Docentes");
		btnListarDocentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultas.consultaTodosDocentes(textAreaConsultas, lblConsulta);
			}
		});
		btnListarDocentes.setFont(new Font("Arial", Font.PLAIN, 15));
		btnListarDocentes.setBackground(Color.WHITE);
		btnListarDocentes.setBounds(95, 520, 147, 30);
		panel_7.add(btnListarDocentes);

		JButton btnListarUsuarios = new JButton("Listar Usuarios");
		btnListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultas.consultaTodosUsuarios(textAreaConsultas, lblConsulta);
			}
		});
		btnListarUsuarios.setFont(new Font("Arial", Font.PLAIN, 15));
		btnListarUsuarios.setBackground(Color.WHITE);
		btnListarUsuarios.setBounds(254, 520, 147, 30);
		panel_7.add(btnListarUsuarios);

		JLabel lblNewLabel_3_1 = new JLabel("Consulta inasistencias por fecha");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(120, 278, 241, 22);
		panel_7.add(lblNewLabel_3_1);

		JLabel lblDesde_1_1 = new JLabel("Desde:");
		lblDesde_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDesde_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDesde_1_1.setBounds(22, 322, 50, 31);
		panel_7.add(lblDesde_1_1);

		dateDesdeInaFecha = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		dateDesdeInaFecha.setBounds(72, 322, 98, 31);
		panel_7.add(dateDesdeInaFecha);

		JLabel lblHasta_1_1 = new JLabel("Hasta:");
		lblHasta_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblHasta_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblHasta_1_1.setBounds(180, 322, 50, 31);
		panel_7.add(lblHasta_1_1);

		dateHastaInaFecha = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		dateHastaInaFecha.setBounds(235, 322, 98, 31);
		panel_7.add(dateHastaInaFecha);

		JButton btnBuscarInasistFecha = new JButton("Buscar");
		btnBuscarInasistFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultas.consultaInasistenciasFecha(textAreaConsultas, dateDesdeInaFecha, dateHastaInaFecha,
						lblConsulta);
			}
		});
		btnBuscarInasistFecha.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBuscarInasistFecha.setBackground(Color.WHITE);
		btnBuscarInasistFecha.setBounds(343, 323, 111, 30);
		panel_7.add(btnBuscarInasistFecha);

		JLabel lblNewLabel_3_2 = new JLabel("Consulta registros usuario por fecha");
		lblNewLabel_3_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(105, 391, 267, 22);
		panel_7.add(lblNewLabel_3_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("Cedula Identidad");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(22, 424, 116, 30);
		panel_7.add(lblNewLabel_1_1_1);

		textFieldConsRegUsu = new JTextField();
		textFieldConsRegUsu.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldConsRegUsu.setColumns(10);
		textFieldConsRegUsu.setBounds(142, 424, 190, 30);
		panel_7.add(textFieldConsRegUsu);

		JLabel lblDesde_1_2 = new JLabel("Desde:");
		lblDesde_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblDesde_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDesde_1_2.setBounds(22, 465, 60, 31);
		panel_7.add(lblDesde_1_2);

		dateDesdeRegUsuFech = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		dateDesdeRegUsuFech.setBounds(72, 465, 98, 31);
		panel_7.add(dateDesdeRegUsuFech);

		JLabel lblHasta_1_2 = new JLabel("Hasta:");
		lblHasta_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblHasta_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblHasta_1_2.setBounds(180, 465, 42, 31);
		panel_7.add(lblHasta_1_2);

		dateHastaRegUsuFecha = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		dateHastaRegUsuFecha.setBounds(235, 465, 98, 31);
		panel_7.add(dateHastaRegUsuFecha);

		JButton btnBuscarRegistUsuFecha = new JButton("Buscar");
		btnBuscarRegistUsuFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultas.consultaInasistenciasPorUsuarioFecha(textFieldConsRegUsu, textAreaConsultas,
						dateDesdeRegUsuFech, dateHastaRegUsuFecha, lblConsulta);
			}
		});
		btnBuscarRegistUsuFecha.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBuscarRegistUsuFecha.setBackground(Color.WHITE);
		btnBuscarRegistUsuFecha.setBounds(343, 465, 111, 30);
		panel_7.add(btnBuscarRegistUsuFecha);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(128, 128, 255));
		separator_1_1.setBounds(22, 507, 441, 4);
		panel_7.add(separator_1_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(128, 128, 255));
		separator_2.setBounds(22, 130, 441, 4);
		panel_7.add(separator_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(128, 128, 255));
		separator_1.setBounds(13, 376, 441, 4);
		panel_7.add(separator_1);

		JLabel lblNewLabel_3_3 = new JLabel("Consulta inasistencias docente por fecha");
		lblNewLabel_3_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3_3.setBounds(95, 11, 292, 22);
		panel_7.add(lblNewLabel_3_3);

		JLabel lblNewLabel_1_1_2 = new JLabel("Por Cedula");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(22, 44, 116, 30);
		panel_7.add(lblNewLabel_1_1_2);

		textFieldCedulaBus = new JTextField();
		textFieldCedulaBus.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldCedulaBus.setColumns(10);
		textFieldCedulaBus.setBounds(142, 44, 190, 30);
		panel_7.add(textFieldCedulaBus);

		JButton btnBuscarDocCedula = new JButton("Buscar");
		btnBuscarDocCedula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultas.consultaNombreDocentePorCI(textFieldCedulaBus, textAreaConsultas, lblConsulta);
			}
		});
		btnBuscarDocCedula.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBuscarDocCedula.setBackground(Color.WHITE);
		btnBuscarDocCedula.setBounds(343, 44, 111, 30);
		panel_7.add(btnBuscarDocCedula);

		textFieldNombreBus = new JTextField();
		textFieldNombreBus.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldNombreBus.setColumns(10);
		textFieldNombreBus.setBounds(142, 89, 190, 30);
		panel_7.add(textFieldNombreBus);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Por nombre");
		lblNewLabel_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1.setBounds(22, 89, 116, 30);
		panel_7.add(lblNewLabel_1_1_2_1);

		JButton btnBuscarDocNombre = new JButton("Buscar");
		btnBuscarDocNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultas.consultaNombreDocentePorNombre(textFieldNombreBus, textAreaConsultas, lblConsulta);
			}
		});
		btnBuscarDocNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBuscarDocNombre.setBackground(Color.WHITE);
		btnBuscarDocNombre.setBounds(343, 89, 111, 30);
		panel_7.add(btnBuscarDocNombre);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		panel_8.setBounds(530, 11, 593, 561);
		panelConsultas.add(panel_8);
		panel_8.setLayout(null);

		JPanel panel_9 = new JPanel();
		panel_9.setBounds(10, 88, 573, 436);
		panel_8.add(panel_9);
		panel_9.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 573, 435);
		panel_9.add(scrollPane);

		textAreaConsultas = new JTextArea();
		textAreaConsultas.setEditable(false);
		scrollPane.setViewportView(textAreaConsultas);
		textAreaConsultas.setFont(new Font("Arial", Font.PLAIN, 15));
		textAreaConsultas
				.setBorder(new TitledBorder(null, "Consulta:", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		lblConsulta = new JLabel("...");
		lblConsulta.setFont(new Font("Arial", Font.PLAIN, 15));
		lblConsulta.setBounds(152, 35, 302, 28);
		panel_8.add(lblConsulta);

		JLabel lblConsulta_1 = new JLabel("Consulta:");
		lblConsulta_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblConsulta_1.setBounds(42, 35, 100, 28);
		panel_8.add(lblConsulta_1);

		JLabel lblNewLabel_4 = new JLabel("Bienvenido: ");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(12, 13, 88, 31);
		contentPane.add(lblNewLabel_4);

		lblUsuario = new JLabel("...");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUsuario.setBounds(112, 13, 191, 31);
		contentPane.add(lblUsuario);

		lblRol = new JLabel("...");
		lblRol.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRol.setBounds(988, 697, 144, 31);
		contentPane.add(lblRol);

		JLabel lblNewLabel_4_1 = new JLabel("Menu - ");
		lblNewLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(927, 697, 49, 31);
		contentPane.add(lblNewLabel_4_1);


		//Visibilidad de tabs segun rol
				usuario = user;

				if (usuario.getRol() == 1) {
					lblRol.setText("Director");
				} else {
					if (usuario.getRol() == 2) {
						lblRol.setText("Administrativo");
						tabbedPane.setEnabledAt(2, false);
					} else {
						if (usuario.getRol() == 3) {
							lblRol.setText("Coordinadores");
							tabbedPane.setEnabledAt(1, false);
							tabbedPane.setEnabledAt(2, false);
							tabbedPane.setEnabledAt(3, false);
						} else {
							if (usuario.getRol() == 4) {
								lblRol.setText("Adscriptos");
								tabbedPane.setEnabledAt(1, false);
								tabbedPane.setEnabledAt(2, false);
								tabbedPane.setEnabledAt(3, false);
							}
						}
					}
				}
				lblUsuario.setText(usuario.getNombre());

		
	}
}
