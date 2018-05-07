package YoneticiModul;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class YonetUye {

	public JFrame frameUye;
	private JTextField txtUyeTc;
	private JTextField txtUyeKadi;
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
		
		frameUye.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameUye.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 482, 390);
		frameUye.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Ekleme", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tc Kimlik(Uye ID) :");
		lblNewLabel.setBounds(24, 27, 89, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ad\u0131 :");
		lblNewLabel_1.setBounds(24, 102, 89, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Soyad\u0131 :");
		lblNewLabel_2.setBounds(24, 127, 89, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Do\u011Fum Tarihi");
		lblNewLabel_3.setBounds(24, 152, 89, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefon :");
		lblNewLabel_4.setBounds(24, 177, 89, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("E-Mail :");
		lblNewLabel_5.setBounds(24, 227, 89, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u00DCyelik Tarihi :");
		lblNewLabel_6.setBounds(24, 251, 89, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Cinsiyet :");
		lblNewLabel_7.setBounds(24, 202, 89, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Adres :");
		lblNewLabel_8.setBounds(24, 276, 89, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblKullancAd.setBounds(24, 52, 89, 14);
		panel.add(lblKullancAd);
		
		JLabel lblParola = new JLabel("Parola :");
		lblParola.setBounds(24, 77, 89, 14);
		panel.add(lblParola);
		
		txtUyeTc = new JTextField();
		txtUyeTc.setBounds(153, 24, 127, 20);
		panel.add(txtUyeTc);
		txtUyeTc.setColumns(10);
		
		txtUyeKadi = new JTextField();
		txtUyeKadi.setBounds(153, 49, 127, 20);
		panel.add(txtUyeKadi);
		txtUyeKadi.setColumns(10);
		
		txtUyeParola = new JTextField();
		txtUyeParola.setBounds(153, 74, 127, 20);
		panel.add(txtUyeParola);
		txtUyeParola.setColumns(10);
		
		txtUyeAdi = new JTextField();
		txtUyeAdi.setBounds(153, 99, 127, 20);
		panel.add(txtUyeAdi);
		txtUyeAdi.setColumns(10);
		
		txtUyeSoyadi = new JTextField();
		txtUyeSoyadi.setBounds(153, 124, 127, 20);
		panel.add(txtUyeSoyadi);
		txtUyeSoyadi.setColumns(10);
		
		txtUyeDTarihi = new JTextField();
		txtUyeDTarihi.setBounds(153, 149, 127, 20);
		panel.add(txtUyeDTarihi);
		txtUyeDTarihi.setColumns(10);
		
		txtUyeTelNo = new JTextField();
		txtUyeTelNo.setBounds(153, 174, 127, 20);
		panel.add(txtUyeTelNo);
		txtUyeTelNo.setColumns(10);
		
		txtUyeMail = new JTextField();
		txtUyeMail.setBounds(153, 224, 127, 20);
		panel.add(txtUyeMail);
		txtUyeMail.setColumns(10);
		
		txtUyelikTarihi = new JTextField();
		txtUyelikTarihi.setBounds(153, 248, 127, 20);
		panel.add(txtUyelikTarihi);
		txtUyelikTarihi.setColumns(10);
		
		JComboBox CboxUyeCinsiyet = new JComboBox();
		CboxUyeCinsiyet.setModel(new DefaultComboBoxModel(new String[] {"K\u0131z", "Erkek"}));
		CboxUyeCinsiyet.setBounds(153, 199, 59, 20);
		panel.add(CboxUyeCinsiyet);
		
		TextArea txtAreaUyeAdres = new TextArea();
		txtAreaUyeAdres.setBounds(153, 276, 284, 76);
		panel.add(txtAreaUyeAdres);
		
		JButton btnUyeEkle = new JButton("Ekle");
		btnUyeEkle.setBounds(348, 48, 89, 56);
		panel.add(btnUyeEkle);
		
		JButton btnUyeCikis = new JButton("Temizle");
		btnUyeCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUyeTc.setText("");
				txtUyeAdi.setText("");
				txtUyeKadi.setText("");
				txtUyeParola.setText("");
				txtUyeSoyadi.setText("");
				txtUyelikTarihi.setText("");
				txtUyeMail.setText("");
				txtUyeTelNo.setText("");
				txtUyeDTarihi.setText("");
				txtAreaUyeAdres.setText(" ");
				CboxUyeCinsiyet.setSelectedIndex(0);
			}
		});
		btnUyeCikis.setBounds(348, 123, 89, 56);
		panel.add(btnUyeCikis);
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Görüntüle", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblTcKimlikNumaras = new JLabel("Tc Kimlik Numaras\u0131 :");
		lblTcKimlikNumaras.setBounds(30, 11, 136, 14);
		panel_1.add(lblTcKimlikNumaras);
		
		txtUyeGoruntuleTc = new JTextField();
		txtUyeGoruntuleTc.setBounds(191, 8, 136, 20);
		panel_1.add(txtUyeGoruntuleTc);
		txtUyeGoruntuleTc.setColumns(10);
		
		tblUyeGoruntule = new JTable();
		tblUyeGoruntule.setBounds(10, 45, 457, 306);
		panel_1.add(tblUyeGoruntule);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Silme", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblTcKimlikNumaras_1 = new JLabel("Tc Kimlik Numaras\u0131 :");
		lblTcKimlikNumaras_1.setBounds(36, 11, 137, 14);
		panel_2.add(lblTcKimlikNumaras_1);
		
		txtUyeSilTc = new JTextField();
		txtUyeSilTc.setBounds(163, 8, 147, 20);
		panel_2.add(txtUyeSilTc);
		txtUyeSilTc.setColumns(10);
		
		JButton btnUyeSil = new JButton("S\u0130L");
		btnUyeSil.setBounds(72, 53, 89, 23);
		panel_2.add(btnUyeSil);
		
		JButton btnUyeSilVazgec = new JButton("Temizle");
		btnUyeSilVazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUyeSilTc.setText("");
			}
		});
		btnUyeSilVazgec.setBounds(187, 53, 89, 23);
		panel_2.add(btnUyeSilVazgec);
		frameUye.setBounds(100, 100, 518, 450);
		frameUye.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameUye.getContentPane().setLayout(null);
	}
}
