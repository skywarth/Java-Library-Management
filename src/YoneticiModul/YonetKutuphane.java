package YoneticiModul;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class YonetKutuphane {

	public JFrame frameKutuphane;
	private JTextField txtKutuphaneTCNo;
	private JTextField txtKutuphaneAdi;
	private JTextField txtKutuphaneSoyadi;
	private JTextField txtKutuphaneTel;
	private JTextField txtKutuphaneKAdi;
	private JTextField txtKutuphaneParola;
	private JTextField txtKuGoruntuleTC;
	private JTable tblKuGoruntule;
	private JTextField txtKuSil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YonetKutuphane window = new YonetKutuphane();
					window.frameKutuphane.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public YonetKutuphane() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameKutuphane = new JFrame();
		frameKutuphane.setBounds(100, 100, 542, 411);
		frameKutuphane.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameKutuphane.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 35, 506, 327);
		frameKutuphane.getContentPane().add(tabbedPane);
		
		JPanel pnlEkle = new JPanel();
		tabbedPane.addTab("Ekleme", null, pnlEkle, null);
		pnlEkle.setLayout(null);
		
		JLabel lblTc = new JLabel("TC Numaras\u0131 :");
		lblTc.setBounds(10, 11, 102, 14);
		pnlEkle.add(lblTc);
		
		JLabel lblAd = new JLabel("Ad\u0131 :");
		lblAd.setBounds(10, 92, 102, 14);
		pnlEkle.add(lblAd);
		
		JLabel lblNewLabel = new JLabel("Soyad\u0131 :");
		lblNewLabel.setBounds(10, 117, 102, 14);
		pnlEkle.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Telefon Numaras\u0131 :");
		lblNewLabel_1.setBounds(10, 167, 133, 14);
		pnlEkle.add(lblNewLabel_1);
		
		JLabel lblCinsiyet = new JLabel("Cinsiyet :");
		lblCinsiyet.setBounds(10, 142, 102, 14);
		pnlEkle.add(lblCinsiyet);
		
		txtKutuphaneTCNo = new JTextField();
		txtKutuphaneTCNo.setBounds(153, 8, 86, 20);
		pnlEkle.add(txtKutuphaneTCNo);
		txtKutuphaneTCNo.setColumns(10);
		
		txtKutuphaneAdi = new JTextField();
		txtKutuphaneAdi.setBounds(153, 89, 86, 20);
		pnlEkle.add(txtKutuphaneAdi);
		txtKutuphaneAdi.setColumns(10);
		
		txtKutuphaneSoyadi = new JTextField();
		txtKutuphaneSoyadi.setBounds(153, 114, 86, 20);
		pnlEkle.add(txtKutuphaneSoyadi);
		txtKutuphaneSoyadi.setColumns(10);
		
		txtKutuphaneTel = new JTextField();
		txtKutuphaneTel.setBounds(153, 164, 86, 20);
		pnlEkle.add(txtKutuphaneTel);
		txtKutuphaneTel.setColumns(10);
		
		JComboBox cBoxCinsiyet = new JComboBox();
		cBoxCinsiyet.setModel(new DefaultComboBoxModel(new String[] {"Erkek", "K\u0131z"}));
		cBoxCinsiyet.setBounds(153, 138, 86, 22);
		pnlEkle.add(cBoxCinsiyet);
		
		JButton btnKutuphaneKaydet = new JButton("EKLE");
		btnKutuphaneKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnKutuphaneKaydet.setBounds(41, 207, 89, 23);
		pnlEkle.add(btnKutuphaneKaydet);
		
		JButton btnKutuphaneVazgec = new JButton("Temizle");
		btnKutuphaneVazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtKutuphaneTCNo.setText("");
				txtKutuphaneAdi.setText("");
				txtKutuphaneSoyadi.setText("");
				txtKutuphaneKAdi.setText("");
				txtKutuphaneParola.setText("");
				txtKutuphaneTel.setText("");
				cBoxCinsiyet.setSelectedIndex(0);
				
				
			}
		});
		btnKutuphaneVazgec.setBounds(140, 207, 89, 23);
		pnlEkle.add(btnKutuphaneVazgec);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblKullancAd.setBounds(10, 42, 102, 14);
		pnlEkle.add(lblKullancAd);
		
		txtKutuphaneKAdi = new JTextField();
		txtKutuphaneKAdi.setBounds(153, 39, 86, 20);
		pnlEkle.add(txtKutuphaneKAdi);
		txtKutuphaneKAdi.setColumns(10);
		
		JLabel lblParola = new JLabel("Parola :");
		lblParola.setBounds(10, 67, 102, 14);
		pnlEkle.add(lblParola);
		
		txtKutuphaneParola = new JTextField();
		txtKutuphaneParola.setBounds(153, 64, 86, 20);
		pnlEkle.add(txtKutuphaneParola);
		txtKutuphaneParola.setColumns(10);
		
		
		
		JPanel pnlGoruntule = new JPanel();
		tabbedPane.addTab("Görüntüle", null, pnlGoruntule, null);
		pnlGoruntule.setLayout(null);
		
		JLabel lblTcNumaras = new JLabel("TC Numaras\u0131 :");
		lblTcNumaras.setBounds(10, 11, 86, 14);
		pnlGoruntule.add(lblTcNumaras);
		
		txtKuGoruntuleTC = new JTextField();
		txtKuGoruntuleTC.setBounds(106, 8, 86, 20);
		pnlGoruntule.add(txtKuGoruntuleTC);
		txtKuGoruntuleTC.setColumns(10);
		
		tblKuGoruntule = new JTable();
		tblKuGoruntule.setBounds(10, 36, 481, 276);
		pnlGoruntule.add(tblKuGoruntule);
		
		JPanel pnlSil = new JPanel();
		tabbedPane.addTab("Silme", null, pnlSil, null);
		pnlSil.setLayout(null);
		
		JLabel lblTcNo = new JLabel("TC Numaras\u0131 :");
		lblTcNo.setBounds(10, 21, 103, 14);
		pnlSil.add(lblTcNo);
		
		txtKuSil = new JTextField();
		txtKuSil.setBounds(94, 18, 86, 20);
		pnlSil.add(txtKuSil);
		txtKuSil.setColumns(10);
		
		JButton btnKuSil = new JButton("S\u0130L");
		btnKuSil.setBounds(10, 71, 89, 23);
		pnlSil.add(btnKuSil);
		
		JButton btnKuSilVazgec = new JButton("Temizle");
		btnKuSilVazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtKuSil.setText("");
			}
		});
		btnKuSilVazgec.setBounds(120, 71, 89, 23);
		pnlSil.add(btnKuSilVazgec);
	}
}
