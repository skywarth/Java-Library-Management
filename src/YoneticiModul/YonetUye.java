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

public class YonetUye {

	public JFrame frameUye;
	private JTextField txtUyeTc;
	private JTextField txtUyeKAdi;
	private JTextField txtUyeParola;
	private JTextField txtUyeAdi;
	private JTextField txtUyeSoyadi;
	private JTextField txtUyeDTarihi;
	private JTextField txtUyeTelNo;
	private JTextField txtUyeMail;
	private JTextField txtUyelikTarihi;
	private JTextField txtUyeGoruntuleTc;
	private JTextField txtUyeSilTc;
	private JTable tblUyeGoruntule;
	private JTextField txtUyeSilKAdi;
	private JTextField txtUyeSilAdi;
	private JTextField txtUyeSilSoyadi;

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
		lblNewLabel.setBounds(24, 27, 89, 14);
		panelUyeEkle.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ad\u0131 :");
		lblNewLabel_1.setBounds(24, 102, 89, 14);
		panelUyeEkle.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Soyad\u0131 :");
		lblNewLabel_2.setBounds(24, 127, 89, 14);
		panelUyeEkle.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Do\u011Fum Tarihi");
		lblNewLabel_3.setBounds(24, 152, 89, 14);
		panelUyeEkle.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefon :");
		lblNewLabel_4.setBounds(24, 177, 89, 14);
		panelUyeEkle.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("E-Mail :");
		lblNewLabel_5.setBounds(24, 227, 89, 14);
		panelUyeEkle.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u00DCyelik Tarihi :");
		lblNewLabel_6.setBounds(24, 251, 89, 14);
		panelUyeEkle.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Cinsiyet :");
		lblNewLabel_7.setBounds(24, 202, 89, 14);
		panelUyeEkle.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Adres :");
		lblNewLabel_8.setBounds(24, 276, 89, 14);
		panelUyeEkle.add(lblNewLabel_8);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblKullancAd.setBounds(24, 52, 89, 14);
		panelUyeEkle.add(lblKullancAd);
		
		JLabel lblParola = new JLabel("Parola :");
		lblParola.setBounds(24, 77, 89, 14);
		panelUyeEkle.add(lblParola);
		
		txtUyeTc = new JTextField();
		txtUyeTc.setBounds(153, 24, 127, 20);
		panelUyeEkle.add(txtUyeTc);
		txtUyeTc.setColumns(10);
		
		txtUyeKAdi = new JTextField();
		txtUyeKAdi.setBounds(153, 49, 127, 20);
		panelUyeEkle.add(txtUyeKAdi);
		txtUyeKAdi.setColumns(10);
		
		txtUyeParola = new JTextField();
		txtUyeParola.setBounds(153, 74, 127, 20);
		panelUyeEkle.add(txtUyeParola);
		txtUyeParola.setColumns(10);
		
		txtUyeAdi = new JTextField();
		txtUyeAdi.setBounds(153, 99, 127, 20);
		panelUyeEkle.add(txtUyeAdi);
		txtUyeAdi.setColumns(10);
		
		txtUyeSoyadi = new JTextField();
		txtUyeSoyadi.setBounds(153, 124, 127, 20);
		panelUyeEkle.add(txtUyeSoyadi);
		txtUyeSoyadi.setColumns(10);
		
		txtUyeDTarihi = new JTextField();
		txtUyeDTarihi.setBounds(153, 149, 127, 20);
		panelUyeEkle.add(txtUyeDTarihi);
		txtUyeDTarihi.setColumns(10);
		
		txtUyeTelNo = new JTextField();
		txtUyeTelNo.setBounds(153, 174, 127, 20);
		panelUyeEkle.add(txtUyeTelNo);
		txtUyeTelNo.setColumns(10);
		
		txtUyeMail = new JTextField();
		txtUyeMail.setBounds(153, 224, 127, 20);
		panelUyeEkle.add(txtUyeMail);
		txtUyeMail.setColumns(10);
		
		txtUyelikTarihi = new JTextField();
		txtUyelikTarihi.setBounds(153, 248, 127, 20);
		panelUyeEkle.add(txtUyelikTarihi);
		txtUyelikTarihi.setColumns(10);
		
		JComboBox CboxUyeCinsiyet = new JComboBox();
		CboxUyeCinsiyet.setModel(new DefaultComboBoxModel(new String[] {"K\u0131z", "Erkek"}));
		CboxUyeCinsiyet.setBounds(153, 199, 59, 20);
		panelUyeEkle.add(CboxUyeCinsiyet);
		
		TextArea txtUyeAdres = new TextArea();
		txtUyeAdres.setBounds(153, 276, 284, 76);
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
					admin.addUser(seviye, userName, password, name, tcNo, mail, phoneNumber, address);
					JOptionPane.showMessageDialog(panelUyeEkle, "Ekleme Ýþlemi Baþarýlý");
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
		btnUyeEkle.setBounds(348, 48, 89, 56);
		panelUyeEkle.add(btnUyeEkle);
		
		JButton btnUyeCikis = new JButton("Temizle");
		btnUyeCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUyeTc.setText("");
				txtUyeAdi.setText("");
				txtUyeKAdi.setText("");
				txtUyeParola.setText("");
				txtUyeSoyadi.setText("");
				txtUyelikTarihi.setText("");
				txtUyeMail.setText("");
				txtUyeTelNo.setText("");
				txtUyeDTarihi.setText("");
				txtUyeAdres.setText(" ");
				CboxUyeCinsiyet.setSelectedIndex(0);
			}
		});
		btnUyeCikis.setBounds(348, 123, 89, 56);
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
		panel_1.add(tblUyeGoruntule);
		
		JButton btnUyeGosterGun = new JButton("G\u00FCncelle");
		btnUyeGosterGun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String []baslik={"1","2","3","4","5","6","7","8"};
					String query="SELECT access_level.access_level_description,user.user_username,user.user_password,user.user_name,user.user_tc,user.user_email,user.user_phone_number,user.user_address FROM librarymanagement.user INNER JOIN librarymanagement.access_level ON user.user_access_level_id=access_level.access_level_id WHERE user.user_access_level_id='3'";
		            //tblKuGoruntule.setModel(listele(query,baslik));
					Admin admin=new Admin();
					tblUyeGoruntule.setModel(admin.getUsers(query, baslik));
				}
				catch (SQLException ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnUyeGosterGun.setBounds(302, 7, 89, 23);
		panel_1.add(btnUyeGosterGun);
		
		JPanel panelUyeSil = new JPanel();
		tabbedPane.addTab("Silme", null, panelUyeSil, null);
		panelUyeSil.setLayout(null);
		
		JLabel lblTcKimlikNumaras_1 = new JLabel("Tc Kimlik Numaras\u0131 :");
		lblTcKimlikNumaras_1.setBounds(10, 38, 137, 14);
		panelUyeSil.add(lblTcKimlikNumaras_1);
		
		txtUyeSilTc = new JTextField();
		txtUyeSilTc.setBounds(157, 35, 100, 20);
		panelUyeSil.add(txtUyeSilTc);
		txtUyeSilTc.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Kulan\u0131c\u0131 Ad\u0131 :");
		lblNewLabel_9.setBounds(10, 11, 137, 14);
		panelUyeSil.add(lblNewLabel_9);
		
		txtUyeSilKAdi = new JTextField();
		txtUyeSilKAdi.setBounds(157, 8, 100, 20);
		panelUyeSil.add(txtUyeSilKAdi);
		txtUyeSilKAdi.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Ad\u0131 :");
		lblNewLabel_10.setBounds(10, 66, 137, 14);
		panelUyeSil.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Soyad\u0131 :");
		lblNewLabel_11.setBounds(10, 91, 137, 14);
		panelUyeSil.add(lblNewLabel_11);
		
		txtUyeSilAdi = new JTextField();
		txtUyeSilAdi.setBounds(157, 63, 100, 20);
		panelUyeSil.add(txtUyeSilAdi);
		txtUyeSilAdi.setColumns(10);
		
		txtUyeSilSoyadi = new JTextField();
		txtUyeSilSoyadi.setBounds(157, 91, 100, 20);
		panelUyeSil.add(txtUyeSilSoyadi);
		txtUyeSilSoyadi.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Silinecek Ki\u015Fi Bilgileri");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_12.setBounds(422, 11, 212, 29);
		panelUyeSil.add(lblNewLabel_12);
		
		JLabel lblUyeSilGoster = new JLabel("lblUyeSilGoster");
		lblUyeSilGoster.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUyeSilGoster.setBounds(340, 30, 380, 29);
		panelUyeSil.add(lblUyeSilGoster);
		
		JButton btnUyeSil = new JButton("S\u0130L");
		btnUyeSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Admin admin=new Admin();
					int tcNo= Integer.valueOf(txtUyeSilTc.getText());
					String userName=txtUyeSilKAdi.getText();
					String name=txtUyeSilAdi.getText()+" "+txtUyeSilSoyadi.getText();
					
					//lblSilGoster.setText(silBilgiGoster(userName, tcNo, name));
					lblUyeSilGoster.setText(admin.silBilgiGoster(userName, tcNo, name));
					Object [] noDeleteOption = {"Evet","Hayýr","Ýptal" };
					int noDelete=JOptionPane.showConfirmDialog(null, "Silmek Ýstiyor Musunuz ? ","Ýþlem Onayý!",JOptionPane.YES_NO_OPTION);
					if(noDelete==JOptionPane.YES_OPTION)
					{
						//Silme(userName, tcNo, name);
						admin.deletLibrarian(userName, tcNo, name);
						txtUyeSilTc.setText("");
						txtUyeSilKAdi.setText("");
						txtUyeSilAdi.setText("");
						txtUyeSilSoyadi.setText("");
						lblUyeSilGoster.setText("SÝLME ÝÞLEMÝ BAÞARILI!");
					}
					else 
					{
						txtUyeSilTc.setText("");
						txtUyeSilKAdi.setText("");
						txtUyeSilAdi.setText("");
						txtUyeSilSoyadi.setText("");
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
		btnUyeSil.setBounds(25, 151, 89, 23);
		panelUyeSil.add(btnUyeSil);
		
		JButton btnUyeSilVazgec = new JButton("Temizle");
		btnUyeSilVazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUyeSilTc.setText("");
			}
		});
		btnUyeSilVazgec.setBounds(168, 151, 89, 23);
		panelUyeSil.add(btnUyeSilVazgec);
		
		
		frameUye.setBounds(100, 100, 793, 451);
		frameUye.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameUye.getContentPane().setLayout(null);
	}
}
