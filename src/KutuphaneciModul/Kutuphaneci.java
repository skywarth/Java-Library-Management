package KutuphaneciModul;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class Kutuphaneci extends JFrame {

	public JPanel frameKutupheneci;
	private JTextField txtKitapID;
	private JTextField txtKitapAdi;
	private JTextField txtKitapYazar;
	private JTextField txtKitapSayfasý;
	private JTextField txtKitapTarih;
	private JTextField txtOdVerKuID;
	private JTextField txtOdVerUyeID;
	private JTextField txtOdVerKitapID;
	private JTextField txtOdVerTarihi;
	private JTextField txtIadeTarihi;
	private JTextField txtKitapGorAdi;
	private JTable tblButunKitaplar;
	private JTable tblRafKitap;
	private JTable tblOduncKitap;
	private JTextField txtIadeAlKuID;
	private JTextField txtIadeAlUyeID;
	private JTextField txtIadeAlKitapID;
	private JTextField txtIadeAlTarihi;
	private JTable tblIadeTarihiGecmis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kutuphaneci frame = new Kutuphaneci();
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
	public Kutuphaneci() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 898, 503);
		frameKutupheneci = new JPanel();
		frameKutupheneci.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frameKutupheneci);
		frameKutupheneci.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 862, 443);
		frameKutupheneci.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Kitap Ekleme", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Kitap ID :");
		lblNewLabel_1.setBounds(30, 33, 119, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Katagori :");
		lblNewLabel_2.setBounds(30, 83, 119, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Yazar\u0131 :");
		lblNewLabel_3.setBounds(30, 108, 119, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sayfa Say\u0131s\u0131 :");
		lblNewLabel_4.setBounds(30, 133, 119, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Yay\u0131mlanma Tarihi :");
		lblNewLabel_5.setBounds(30, 158, 119, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblKitapAd_1 = new JLabel("Kitap Ad\u0131 :");
		lblKitapAd_1.setBounds(30, 58, 119, 14);
		panel.add(lblKitapAd_1);
		
		txtKitapID = new JTextField();
		txtKitapID.setBounds(159, 30, 119, 20);
		panel.add(txtKitapID);
		txtKitapID.setColumns(10);
		
		txtKitapAdi = new JTextField();
		txtKitapAdi.setBounds(159, 55, 119, 20);
		panel.add(txtKitapAdi);
		txtKitapAdi.setColumns(10);
		
		JComboBox CboxKitapKatagori = new JComboBox();
		CboxKitapKatagori.setModel(new DefaultComboBoxModel(new String[] {"Romantizim", "Hikaye", "Fab\u0131l", "Bilim Kurgu", "\u00C7ocuk", "F\u0131rat"}));
		CboxKitapKatagori.setBounds(159, 80, 119, 20);
		panel.add(CboxKitapKatagori);
		
		txtKitapYazar = new JTextField();
		txtKitapYazar.setBounds(159, 105, 119, 20);
		panel.add(txtKitapYazar);
		txtKitapYazar.setColumns(10);
		
		txtKitapSayfasý = new JTextField();
		txtKitapSayfasý.setBounds(159, 130, 119, 20);
		panel.add(txtKitapSayfasý);
		txtKitapSayfasý.setColumns(10);
		
		txtKitapTarih = new JTextField();
		txtKitapTarih.setBounds(159, 155, 119, 20);
		panel.add(txtKitapTarih);
		txtKitapTarih.setColumns(10);
		
		JButton btnKitapEkle = new JButton("Ekle");
		btnKitapEkle.setBounds(116, 213, 89, 23);
		panel.add(btnKitapEkle);
		
		JButton btnKitapVazgec = new JButton("Temizle");
		btnKitapVazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				txtKitapID.setText("");
				txtKitapAdi.setText("");
				txtKitapTarih.setText("");
				txtKitapYazar.setText("");
				txtKitapTarih.setText("");
				txtKitapSayfasý.setText("");
				CboxKitapKatagori.setSelectedIndex(0);
			}
		});
		btnKitapVazgec.setBounds(344, 213, 89, 23);
		panel.add(btnKitapVazgec);
		
		JButton btnKitapDosyadanEkle = new JButton("Dosyadan Ekle");
		btnKitapDosyadanEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File f=null;
				String path=null;
				JOptionPane x=new JOptionPane();
				JFileChooser fileChooser=new JFileChooser();
				fileChooser.showOpenDialog(fileChooser);
				f =fileChooser.getSelectedFile();
				try {
					BufferedReader reader = new BufferedReader(new FileReader(f));
					String line=null;
					while (reader.ready()) {
					    line=reader.readLine();
					    String[] dosyadan=line.split("*");
					    for(int i=0;i<dosyadan.length;i++) {
					    txtKitapID.setText(line+"\n");//Burada ifadeyi direk sql e aktaracak sql ifadesi yazamadým
					}
					}
					reader.close();
					} catch (Exception ex) {
					x.showMessageDialog(frameKutupheneci, "HATA: "+ex);
					}
			}
		});
		btnKitapDosyadanEkle.setBounds(215, 213, 119, 23);
		panel.add(btnKitapDosyadanEkle);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Kitap Görüntüle", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 11, 837, 393);
		panel_1.add(tabbedPane_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("Bütün Kitaplar", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Kitap Ad\u0131 : ");
		lblNewLabel_10.setBounds(10, 11, 71, 14);
		panel_3.add(lblNewLabel_10);
		
		txtKitapGorAdi = new JTextField();
		txtKitapGorAdi.setBounds(117, 8, 86, 20);
		panel_3.add(txtKitapGorAdi);
		txtKitapGorAdi.setColumns(10);
		
		tblButunKitaplar = new JTable();
		tblButunKitaplar.setBounds(0, 36, 832, 329);
		panel_3.add(tblButunKitaplar);
		
		JLabel lblKategori = new JLabel("Kategori :");
		lblKategori.setBounds(245, 11, 71, 14);
		panel_3.add(lblKategori);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Romantizim", "Bilim Kurgu", "\u00C7ocuk", "Tarih", "Edebi"}));
		comboBox.setBounds(324, 8, 97, 20);
		panel_3.add(comboBox);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Raflardaki Kitaplar", null, panel_4, null);
		panel_4.setLayout(null);
		
		tblRafKitap = new JTable();
		tblRafKitap.setBounds(0, 0, 832, 365);
		panel_4.add(tblRafKitap);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Ödünç Verilen Kitaplar", null, panel_5, null);
		panel_5.setLayout(null);
		
		tblOduncKitap = new JTable();
		tblOduncKitap.setBounds(0, 0, 832, 365);
		panel_5.add(tblOduncKitap);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_1.addTab("Ýade Tarihi Geçmiþ Kitaplar", null, panel_7, null);
		panel_7.setLayout(null);
		
		tblIadeTarihiGecmis = new JTable();
		tblIadeTarihiGecmis.setBounds(0, 0, 832, 365);
		panel_7.add(tblIadeTarihiGecmis);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Ýade Al", null, panel_6, null);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("K\u00FCt\u00FCphaneci ID :");
		lblNewLabel_11.setBounds(10, 11, 96, 14);
		panel_6.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Uye ID :");
		lblNewLabel_12.setBounds(10, 36, 80, 14);
		panel_6.add(lblNewLabel_12);
		
		JLabel lblKitapId = new JLabel("Kitap ID :");
		lblKitapId.setBounds(10, 61, 80, 14);
		panel_6.add(lblKitapId);
		
		JLabel lblIadeTarihi = new JLabel("\u0130ade Tarihi :");
		lblIadeTarihi.setBounds(10, 86, 80, 14);
		panel_6.add(lblIadeTarihi);
		
		txtIadeAlKuID = new JTextField();
		txtIadeAlKuID.setBounds(116, 8, 86, 20);
		panel_6.add(txtIadeAlKuID);
		txtIadeAlKuID.setColumns(10);
		
		txtIadeAlUyeID = new JTextField();
		txtIadeAlUyeID.setBounds(116, 33, 86, 20);
		panel_6.add(txtIadeAlUyeID);
		txtIadeAlUyeID.setColumns(10);
		
		txtIadeAlKitapID = new JTextField();
		txtIadeAlKitapID.setBounds(116, 58, 86, 20);
		panel_6.add(txtIadeAlKitapID);
		txtIadeAlKitapID.setColumns(10);
		
		txtIadeAlTarihi = new JTextField();
		txtIadeAlTarihi.setBounds(116, 83, 86, 20);
		panel_6.add(txtIadeAlTarihi);
		txtIadeAlTarihi.setColumns(10);
		
		JButton btnIadeAl = new JButton("\u0130ADE AL");
		btnIadeAl.setBounds(10, 143, 89, 23);
		panel_6.add(btnIadeAl);
		
		JButton btnIadeVazgec = new JButton("Temizle");
		btnIadeVazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIadeAlKitapID.setText("");
				txtIadeAlKuID.setText("");
				txtIadeAlUyeID.setText("");
				txtIadeAlTarihi.setText("");
			}
		});
		btnIadeVazgec.setBounds(116, 143, 89, 23);
		panel_6.add(btnIadeVazgec);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Ödünç Ver", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("K\u00FCt\u00FCphaneci ID :");
		lblNewLabel.setBounds(10, 11, 80, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("Uye ID :");
		lblNewLabel_6.setBounds(10, 36, 80, 14);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Kitap ID :");
		lblNewLabel_7.setBounds(10, 61, 80, 14);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Verili\u015F Tarihi :");
		lblNewLabel_8.setBounds(10, 86, 80, 14);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("\u0130ade Tarihi :");
		lblNewLabel_9.setBounds(10, 111, 80, 14);
		panel_2.add(lblNewLabel_9);
		
		txtOdVerKuID = new JTextField();
		txtOdVerKuID.setBounds(100, 8, 86, 20);
		panel_2.add(txtOdVerKuID);
		txtOdVerKuID.setColumns(10);
		
		txtOdVerUyeID = new JTextField();
		txtOdVerUyeID.setBounds(100, 33, 86, 20);
		panel_2.add(txtOdVerUyeID);
		txtOdVerUyeID.setColumns(10);
		
		txtOdVerKitapID = new JTextField();
		txtOdVerKitapID.setBounds(100, 58, 86, 20);
		panel_2.add(txtOdVerKitapID);
		txtOdVerKitapID.setColumns(10);
		
		txtOdVerTarihi = new JTextField();
		txtOdVerTarihi.setBounds(100, 83, 86, 20);
		panel_2.add(txtOdVerTarihi);
		txtOdVerTarihi.setColumns(10);
		
		txtIadeTarihi = new JTextField();
		txtIadeTarihi.setBounds(100, 108, 86, 20);
		panel_2.add(txtIadeTarihi);
		txtIadeTarihi.setColumns(10);
		
		JButton btnOduncVer = new JButton("\u00D6d\u00FCn\u00E7 Ver");
		btnOduncVer.setBounds(10, 155, 89, 23);
		panel_2.add(btnOduncVer);
		
		JButton btnOdVerVazgec = new JButton("Temizle");
		btnOdVerVazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOdVerKuID.setText("");
				txtOdVerKitapID.setText("");
				txtOdVerUyeID.setText("");
				txtOdVerTarihi.setText("");
				txtIadeTarihi.setText("");
				
			}
		});
		btnOdVerVazgec.setBounds(109, 155, 89, 23);
		panel_2.add(btnOdVerVazgec);
	}
}
