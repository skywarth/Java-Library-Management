package YoneticiModul;

import java.awt.EventQueue;

import siniflar.Admin;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class Login {

	private JFrame frame;
	private JTextField txtLoginKAdi;
	private JPasswordField txtLoginParola;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 487, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblNewLabel.setBounds(31, 64, 86, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Parola :");
		lblNewLabel_1.setBounds(31, 89, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtLoginKAdi = new JTextField();
		txtLoginKAdi.setBounds(127, 61, 188, 20);
		frame.getContentPane().add(txtLoginKAdi);
		txtLoginKAdi.setColumns(10);
		
		JButton btnYonetGiris = new JButton("G\u0130R\u0130\u015E");
		btnYonetGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Admin giris=new Admin();
				giris.Login(txtLoginKAdi.getText(),txtLoginParola.getText());
				frame.dispose();
			}
		});
		btnYonetGiris.setBounds(78, 137, 89, 23);
		frame.getContentPane().add(btnYonetGiris);
		
		JButton btnGirisVazgec = new JButton("\u0130ptal");
		btnGirisVazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnGirisVazgec.setBounds(248, 137, 89, 23);
		frame.getContentPane().add(btnGirisVazgec);
		
		txtLoginParola = new JPasswordField();
		txtLoginParola.setBounds(127, 86, 188, 20);
		frame.getContentPane().add(txtLoginParola);
		
		JLabel lblYneticiGiri = new JLabel("Y\u00F6netici Giri\u015F");
		lblYneticiGiri.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		lblYneticiGiri.setBounds(155, 11, 157, 28);
		frame.getContentPane().add(lblYneticiGiri);
	}
}
