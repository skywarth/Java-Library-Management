package LoginModülü;



import siniflar.LoginController;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtLoginKAdi;
	private JPasswordField txtLoginParola;
	public int KUTUPHANECITC;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblKullancAd.setBounds(45, 43, 86, 14);
		contentPane.add(lblKullancAd);
		
		txtLoginKAdi = new JTextField();
		txtLoginKAdi.setBounds(141, 40, 162, 20);
		contentPane.add(txtLoginKAdi);
		txtLoginKAdi.setColumns(10);
		
		JLabel lblParola = new JLabel("Parola :");
		lblParola.setBounds(45, 73, 46, 14);
		contentPane.add(lblParola);
		
		txtLoginParola = new JPasswordField();
		txtLoginParola.setBounds(141, 70, 162, 20);
		contentPane.add(txtLoginParola);
		
		JButton btnGiri = new JButton("Giri\u015F");
		btnGiri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginController giris=new LoginController();
				giris.Login(txtLoginKAdi.getText(), txtLoginParola.getText());
				KUTUPHANECITC=giris.KutuphaneciTC;
				System.out.println(KUTUPHANECITC);
				dispose();
				
			}
		});
		btnGiri.setBounds(105, 127, 89, 23);
		contentPane.add(btnGiri);
		
		JButton btnk = new JButton("\u00C7\u0131k\u0131\u015F");
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnk.setBounds(229, 127, 89, 23);
		contentPane.add(btnk);
	}

}
