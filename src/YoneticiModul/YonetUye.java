package YoneticiModul;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import siniflar.Admin;

import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class YonetUye {

	public JFrame frameUye;
	private JTextField txtUyeTc;
	private JTextField txtUyeKAdi;
	private JTextField txtUyeAdi;
	private JTextField txtUyeSoyadi;
	private JTextField txtUyeTelNo;
	private JTextField txtUyeMail;
	private JTextField txtUyeGoruntuleTc;
	private JTextField txtUyeSilTc;
	private JTable tblUyeGoruntule;
	private JTextField txtSilGkAdi;
	private JTextField txtSilGTC;
	private JTextField txtSilGAd;
	private JTextField txtSilGMail;
	private JTextField txtSilGSeviye;
	private JTextField txtSilGSifre;
	private JTextField txtSilGTelefon;
	private JTextField txtSilGSoyad;
	private JPasswordField txtUyeParola;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YonetUye window = new YonetUye();
					window.frameUye.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public YonetUye() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	frameUye = new JFrame();
	frameUye.setTitle("\u00DCye \u0130\u015Flemleri");
		
		frameUye.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameUye.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 757, 390);
		frameUye.getContentPane().add(tabbedPane);
		
		JPanel panelUyeEkle = new JPanel();
		tabbedPane.addTab("Ekleme", null, panelUyeEkle, null);
		panelUyeEkle.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TC No :");
		lblNewLabel.setBounds(155, 45, 89, 14);
		panelUyeEkle.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ad\u0131 :");
		lblNewLabel_1.setBounds(155, 120, 89, 14);
		panelUyeEkle.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Soyad\u0131 :");
		lblNewLabel_2.setBounds(155, 145, 89, 14);
		panelUyeEkle.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Telefon :");
		lblNewLabel_4.setBounds(155, 170, 89, 14);
		panelUyeEkle.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("E-Mail :");
		lblNewLabel_5.setBounds(155, 192, 89, 14);
		panelUyeEkle.add(lblNewLabel_5);
		
		JLabel lblNewLabel_8 = new JLabel("Adres :");
		lblNewLabel_8.setBounds(155, 217, 89, 14);
		panelUyeEkle.add(lblNewLabel_8);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblKullancAd.setBounds(155, 70, 89, 14);
		panelUyeEkle.add(lblKullancAd);
		
		JLabel lblParola = new JLabel("Parola :");
		lblParola.setBounds(155, 95, 89, 14);
		panelUyeEkle.add(lblParola);
		
		txtUyeTc = new JTextField();
		txtUyeTc.setBounds(284, 42, 127, 20);
		panelUyeEkle.add(txtUyeTc);
		txtUyeTc.setColumns(10);
		
		txtUyeKAdi = new JTextField();
		txtUyeKAdi.setBounds(284, 67, 127, 20);
		panelUyeEkle.add(txtUyeKAdi);
		txtUyeKAdi.setColumns(10);
		
		txtUyeAdi = new JTextField();
		txtUyeAdi.setBounds(284, 117, 127, 20);
		panelUyeEkle.add(txtUyeAdi);
		txtUyeAdi.setColumns(10);
		
		txtUyeSoyadi = new JTextField();
		txtUyeSoyadi.setBounds(284, 142, 127, 20);
		panelUyeEkle.add(txtUyeSoyadi);
		txtUyeSoyadi.setColumns(10);
		
		txtUyeTelNo = new JTextField();
		txtUyeTelNo.setBounds(284, 167, 127, 20);
		panelUyeEkle.add(txtUyeTelNo);
		txtUyeTelNo.setColumns(10);
		
		txtUyeMail = new JTextField();
		txtUyeMail.setBounds(284, 192, 127, 20);
		panelUyeEkle.add(txtUyeMail);
		txtUyeMail.setColumns(10);
		
		txtUyeParola = new JPasswordField();
		txtUyeParola.setBounds(284, 92, 127, 20);
		panelUyeEkle.add(txtUyeParola);
		
		TextArea txtUyeAdres = new TextArea();
		txtUyeAdres.setBounds(284, 217, 284, 76);
		panelUyeEkle.add(txtUyeAdres);
		
		JButton btnUyeEkle = new JButton("Ekle");
		btnUyeEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					int seviye=3;
					String userName=txtUyeKAdi.getText();
					String password=txtUyeParola.getText();
					String name=txtUyeAdi.getText()+" "+txtUyeSoyadi.getText();
					int tcNo=Integer.valueOf(txtUyeTc.getText());
					String mail=txtUyeMail.getText();
					int phoneNumber=Integer.valueOf(txtUyeTelNo.getText());
					String address=txtUyeAdres.getText();
					//Ekleme(seviye, userName, password, name, tcNo, mail, phoneNumber, address);
					Admin admin=new Admin();
					admin.add(seviye, userName, password, name, tcNo, mail, phoneNumber, address);
					JOptionPane.showMessageDialog(panelUyeEkle, "Ekleme Ýþlemi Baþarýlý");
					txtUyeTc.setText("");
					txtUyeParola.setText("");
					txtUyeAdi.setText("");
					txtUyeKAdi.setText("");
					txtUyeSoyadi.setText("");
					txtUyeMail.setText("");
					txtUyeTelNo.setText("");
					txtUyeAdres.setText(" ");
				}
				catch (NumberFormatException ex) 
				{
					JOptionPane.showMessageDialog(panelUyeEkle, "TC ve Telefonu Doðru Giriniz.");
				}
				catch (SQLException ex) 
				{
					JOptionPane.showMessageDialog(panelUyeEkle, "Veri Tabaný Hatasý.");
				}
			}
		});
		btnUyeEkle.setBounds(479, 66, 89, 56);
		panelUyeEkle.add(btnUyeEkle);
		
		JButton btnUyeCikis = new JButton("Temizle");
		btnUyeCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUyeTc.setText("");
				txtUyeParola.setText("");
				txtUyeAdi.setText("");
				txtUyeKAdi.setText("");
				txtUyeSoyadi.setText("");
				txtUyeMail.setText("");
				txtUyeTelNo.setText("");
				txtUyeAdres.setText(" ");
				
			}
		});
		btnUyeCikis.setBounds(479, 141, 89, 56);
		panelUyeEkle.add(btnUyeCikis);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Görüntüle", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblTcKimlikNumaras = new JLabel("Tc Kimlik Numaras\u0131 :");
		lblTcKimlikNumaras.setBounds(10, 11, 136, 14);
		panel_1.add(lblTcKimlikNumaras);
		
		txtUyeGoruntuleTc = new JTextField();
		txtUyeGoruntuleTc.setBounds(156, 8, 136, 20);
		panel_1.add(txtUyeGoruntuleTc);
		txtUyeGoruntuleTc.setColumns(10);
		
		tblUyeGoruntule = new JTable();
		tblUyeGoruntule.setBounds(10, 45, 732, 306);
		
		JScrollPane UyeSPane = new JScrollPane(tblUyeGoruntule);
		UyeSPane.setBounds(10, 45, 732, 306);
		panel_1.add(UyeSPane);
		
		JButton btnUyeGosterGun = new JButton("G\u00FCncelle");
		btnUyeGosterGun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String []baslik={"Eriþim Seviyesi","Kullanýcý Adý","Þifre","Ad-Soyad","TC NO","Mail","Telefon","Adres"};
					String query="SELECT access_level.access_level_description,user.user_username,user.user_password,user.user_name,user.user_tc,user.user_email,user.user_phone_number,user.user_address FROM librarymanagement.user INNER JOIN librarymanagement.access_level ON user.user_access_level_id=access_level.access_level_id WHERE user.user_access_level_id='3'";
		            //tblKuGoruntule.setModel(listele(query,baslik));
					Admin admin=new Admin();
					tblUyeGoruntule.setModel(admin.get(query, baslik));
				}
				catch (SQLException ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnUyeGosterGun.setBounds(404, 7, 89, 23);
		panel_1.add(btnUyeGosterGun);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 45, 648, 306);
		panel_1.add(scrollPane);
		
		JButton btnUyeBul = new JButton("Bul");
		btnUyeBul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					String []baslik={"Eriþim Seviyesi","Kullanýcý Adý","Þifre","Ad-Soyad","TC NO","Mail","Telefon","Adres"};
					String query="SELECT access_level.access_level_description,user.user_username,user.user_password,user.user_name,user.user_tc,user.user_email,user.user_phone_number,user.user_address FROM librarymanagement.user INNER JOIN librarymanagement.access_level ON user.user_access_level_id=access_level.access_level_id WHERE user.user_access_level_id='3' AND user.user_tc='"+txtUyeGoruntuleTc.getText()+"'";
		            //tblKuGoruntule.setModel(listele(query,baslik));
					Admin admin=new Admin();
					tblUyeGoruntule.setModel(admin.get(query, baslik));
				}
				catch (SQLException ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnUyeBul.setBounds(305, 7, 89, 23);
		panel_1.add(btnUyeBul);
		
		
		
		JPanel panelUyeSil = new JPanel();
		tabbedPane.addTab("Silme", null, panelUyeSil, null);
		panelUyeSil.setLayout(null);
		
		JLabel lblTcKimlikNumaras_1 = new JLabel("Tc Kimlik Numaras\u0131 :");
		lblTcKimlikNumaras_1.setBounds(10, 19, 137, 14);
		panelUyeSil.add(lblTcKimlikNumaras_1);
		
		txtUyeSilTc = new JTextField();
		txtUyeSilTc.setBounds(157, 16, 100, 20);
		panelUyeSil.add(txtUyeSilTc);
		txtUyeSilTc.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Silinecek Ki\u015Fi Bilgileri");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_12.setBounds(422, 11, 212, 29);
		panelUyeSil.add(lblNewLabel_12);
		
		JLabel lblUyeSilGoster = new JLabel("");
		lblUyeSilGoster.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUyeSilGoster.setBounds(340, 30, 380, 29);
		panelUyeSil.add(lblUyeSilGoster);
		
		txtSilGkAdi = new JTextField();
		txtSilGkAdi.setEditable(false);
		txtSilGkAdi.setBounds(450, 88, 130, 20);
		panelUyeSil.add(txtSilGkAdi);
		txtSilGkAdi.setColumns(10);
		
		txtSilGTC = new JTextField();
		txtSilGTC.setEditable(false);
		txtSilGTC.setBounds(450, 190, 130, 20);
		panelUyeSil.add(txtSilGTC);
		txtSilGTC.setColumns(10);
		
		txtSilGAd = new JTextField();
		txtSilGAd.setEditable(false);
		txtSilGAd.setBounds(450, 138, 130, 20);
		panelUyeSil.add(txtSilGAd);
		txtSilGAd.setColumns(10);
		
		txtSilGMail = new JTextField();
		txtSilGMail.setEditable(false);
		txtSilGMail.setBounds(450, 215, 130, 20);
		panelUyeSil.add(txtSilGMail);
		txtSilGMail.setColumns(10);
		
		txtSilGSeviye = new JTextField();
		txtSilGSeviye.setEditable(false);
		txtSilGSeviye.setBounds(450, 63, 130, 20);
		panelUyeSil.add(txtSilGSeviye);
		txtSilGSeviye.setColumns(10);
		
		txtSilGSifre = new JTextField();
		txtSilGSifre.setEditable(false);
		txtSilGSifre.setBounds(450, 113, 130, 20);
		panelUyeSil.add(txtSilGSifre);
		txtSilGSifre.setColumns(10);
		
		txtSilGTelefon = new JTextField();
		txtSilGTelefon.setEditable(false);
		txtSilGTelefon.setBounds(450, 242, 130, 20);
		panelUyeSil.add(txtSilGTelefon);
		txtSilGTelefon.setColumns(10);
		
		txtSilGSoyad = new JTextField();
		txtSilGSoyad.setEditable(false);
		txtSilGSoyad.setBounds(450, 163, 130, 20);
		panelUyeSil.add(txtSilGSoyad);
		txtSilGSoyad.setColumns(10);
		
		JTextArea txtSilGAdres = new JTextArea();
		txtSilGAdres.setEditable(false);
		txtSilGAdres.setBounds(450, 273, 212, 78);
		panelUyeSil.add(txtSilGAdres);
		
		JButton btnUyeSil = new JButton("S\u0130L");
		btnUyeSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Admin admin=new Admin();
					int tcNo= Integer.valueOf(txtUyeSilTc.getText());
					
					String bilgi= admin.Bul(tcNo, 3);
					String[] bilgiler=bilgi.split(" ");
					txtSilGSeviye.setText(bilgiler[0]);
					txtSilGkAdi.setText(bilgiler[1]);
					txtSilGSifre.setText(bilgiler[2]);
					txtSilGAd.setText(bilgiler[3]);
					txtSilGSoyad.setText(bilgiler[4]);
					txtSilGTC.setText(bilgiler[5]);
					txtSilGMail.setText(bilgiler[6]);
					txtSilGTelefon.setText(bilgiler[7]);
					txtSilGAdres.setText(bilgiler[8]);
		
					Object [] noDeleteOption = {"Evet","Hayýr","Ýptal" };
					int noDelete=JOptionPane.showConfirmDialog(null, "Silmek Ýstiyor Musunuz ? ","Ýþlem Onayý!",JOptionPane.YES_NO_OPTION);
					if(noDelete==JOptionPane.YES_OPTION)
					{
						//Silme(userName, tcNo, name);
						admin.delete(3,tcNo);
						txtUyeSilTc.setText("");
						txtUyeSilTc.setText("");
						txtSilGSeviye.setText("");
						txtSilGkAdi.setText("");
						txtSilGSifre.setText("");
						txtSilGAd.setText("");
						txtSilGSoyad.setText("");
						txtSilGTC.setText("");
						txtSilGMail.setText("");
						txtSilGTelefon.setText("");
						txtSilGAdres.setText("");
						lblUyeSilGoster.setText("SÝLME ÝÞLEMÝ BAÞARILI!");
					}
					else 
					{
						txtUyeSilTc.setText("");
					}	
				}
				catch (NumberFormatException ex) 
				{
					JOptionPane.showMessageDialog(panelUyeSil, "TC'yi Doðru Giriniz.");
				}
				catch (SQLException ex) {
					JOptionPane.showMessageDialog(panelUyeSil, "Veri Tabaný Hatasý.");
				}
			}
		});
		btnUyeSil.setBounds(26, 62, 89, 23);
		panelUyeSil.add(btnUyeSil);
		
		JButton btnUyeSilVazgec = new JButton("Temizle");
		btnUyeSilVazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				lblUyeSilGoster.setText("");
				txtUyeSilTc.setText("");
				txtSilGSeviye.setText("");
				txtSilGkAdi.setText("");
				txtSilGSifre.setText("");
				txtSilGAd.setText("");
				txtSilGSoyad.setText("");
				txtSilGTC.setText("");
				txtSilGMail.setText("");
				txtSilGTelefon.setText("");
				txtSilGAdres.setText("");
			}
		});
		btnUyeSilVazgec.setBounds(157, 62, 89, 23);
		panelUyeSil.add(btnUyeSilVazgec);
		
		JLabel lblKullancAd_1 = new JLabel("Erisim Seviyesi :");
		lblKullancAd_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblKullancAd_1.setBounds(340, 65, 100, 17);
		panelUyeSil.add(lblKullancAd_1);
		
		JLabel lblTcNo = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblTcNo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTcNo.setBounds(340, 91, 111, 14);
		panelUyeSil.add(lblTcNo);
		
		JLabel lblAd = new JLabel("\u015Eifre :");
		lblAd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblAd.setBounds(340, 116, 74, 14);
		panelUyeSil.add(lblAd);
		
		JLabel lblMail = new JLabel("Ad :");
		lblMail.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMail.setBounds(340, 141, 74, 14);
		panelUyeSil.add(lblMail);
		
		JLabel lblNewLabel_9 = new JLabel("TC No :");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_9.setBounds(340, 193, 46, 14);
		panelUyeSil.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Mail :");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_10.setBounds(340, 218, 46, 14);
		panelUyeSil.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Telefon :");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_11.setBounds(340, 245, 74, 14);
		panelUyeSil.add(lblNewLabel_11);
		
		JLabel lblNewLabel_13 = new JLabel("Adres :");
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_13.setBounds(340, 273, 46, 14);
		panelUyeSil.add(lblNewLabel_13);
		
		JLabel lblSoyad = new JLabel("Soyad :");
		lblSoyad.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSoyad.setBounds(340, 166, 74, 14);
		panelUyeSil.add(lblSoyad);
	
		frameUye.setBounds(100, 100, 793, 451);
		frameUye.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameUye.getContentPane().setLayout(null);
	}
}
