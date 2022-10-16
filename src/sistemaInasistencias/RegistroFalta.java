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
		btnX.setBounds(1045, 0, 46, 50);
		contentPane.add(btnX);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(67, 158, 959, 2);
		contentPane.add(separator);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setBounds(154, 96, 240, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cedula:");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(53, 88, 78, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNombre.setBounds(53, 160, 78, 38);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel_1 = new JLabel("...");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(154, 160, 240, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMotivo = new JLabel("Motivo:");
		lblMotivo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMotivo.setHorizontalAlignment(SwingConstants.LEFT);
		lblMotivo.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMotivo.setBounds(53, 244, 78, 38);
		contentPane.add(lblMotivo);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Arial", Font.PLAIN, 18));
		textPane.setBounds(154, 260, 371, 121);
		contentPane.add(textPane);
	}
}
