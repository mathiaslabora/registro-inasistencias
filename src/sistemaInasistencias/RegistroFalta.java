package sistemaInasistencias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class RegistroFalta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	
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
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setBounds(173, 96, 220, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cedula:");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(85, 96, 78, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNombre.setBounds(457, 96, 78, 38);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel_1 = new JLabel("...");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(558, 96, 304, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMotivo = new JLabel("Motivo:");
		lblMotivo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMotivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMotivo.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMotivo.setBounds(85, 279, 78, 38);
		contentPane.add(lblMotivo);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Arial", Font.PLAIN, 18));
		textPane.setBounds(173, 297, 610, 96);
		contentPane.add(textPane);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(173, 197, 220, 38);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(545, 197, 220, 38);
		contentPane.add(dateChooser_1);
		
		JLabel lblDesde = new JLabel("Desde:");
		lblDesde.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDesde.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDesde.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDesde.setBounds(85, 197, 78, 38);
		contentPane.add(lblDesde);
		
		JLabel lblHasta = new JLabel("Hasta:");
		lblHasta.setVerticalAlignment(SwingConstants.BOTTOM);
		lblHasta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHasta.setFont(new Font("Arial", Font.PLAIN, 18));
		lblHasta.setBounds(457, 197, 78, 38);
		contentPane.add(lblHasta);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("Arial", Font.PLAIN, 18));
		textPane_1.setBounds(173, 418, 610, 38);
		contentPane.add(textPane_1);
		
		JLabel lblGrupos = new JLabel("Grupos:");
		lblGrupos.setVerticalAlignment(SwingConstants.BOTTOM);
		lblGrupos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrupos.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGrupos.setBounds(85, 418, 78, 38);
		contentPane.add(lblGrupos);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 18));
		lblUsuario.setBounds(85, 491, 78, 38);
		contentPane.add(lblUsuario);
		
		JLabel lblNewLabel_1_1 = new JLabel("...");
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(173, 491, 304, 38);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("REGISTRO DE INASISTENCIA DOCENTE");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(285, 28, 359, 38);
		contentPane.add(lblNewLabel_1_1_1);
	}
}
