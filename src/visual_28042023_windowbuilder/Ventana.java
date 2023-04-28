package visual_28042023_windowbuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 347);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 33, 161, 208);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(37, 5, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("jfoifs");
		lblNewLabel.setBounds(37, 56, 76, 31);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("haz click");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(textField.getText());
			}
		});
		btnNewButton.setBounds(34, 151, 89, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(256, 33, 181, 224);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(10, 11, 161, 14);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Conectar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//registrar conector
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String cadena="jdbc:mysql://localhost/test";
					Connection conn=DriverManager.getConnection(cadena,"root","");
					//lblNewLabel_1.setText(conn.toString());
					
					//Consulta.
					PreparedStatement ps = conn.prepareStatement("select * from clientes");
					ResultSet rs=ps.executeQuery();
					//lblNewLabel_1.setText(rs.toString());
					StringBuilder sb=new StringBuilder();
					while(rs.next()) {
						sb.append(rs.getString(2));
					}
					lblNewLabel_1.setText(sb.toString());
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}//Cierra método
		});
		btnNewButton_1.setBounds(47, 36, 89, 23);
		panel_1.add(btnNewButton_1);
	}
}
