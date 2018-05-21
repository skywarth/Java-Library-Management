package KutuphaneciModul;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.ParseConversionEvent;

import siniflar.Librarian;
import siniflar.LoginController;

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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import LoginModülü.Login;

public class Kutuphaneci extends JFrame {

	public JPanel frameKutupheneci;
	private JTextField txtKitapAdi;
	private JTextField txtKitapYazar;
	private JTextField txtKitapSayfasi;
	private JTextField txtKitapTarih;
	private JTable tblButunKitaplar;
	private JTable tblRafKitap;
	private JTable tblOduncKitap;
	private JTable tblIadeTarihiGecmis;
	
	 private java.sql.Connection connection;
	 private Statement statement;
	 private ResultSet rs;
	 private JTextField txtKitapID;
	 private JTextField txtKitapYayimci;
	 private JTextField txtIadeAlKutuphaneciTc;
	 private JTextField txtIadeAlUyeTc;
	 private JTextField txtIadeAlKitapAdi;
	 private JTextField txtOduncVerKutuphaneciTc;
	 private JTextField txtOduncVerUyeTc;
	 private JTextField txtOduncVerKitapAdi;

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
		tabbedPane.setBounds(10, 31, 862, 423);
		frameKutupheneci.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Kitap Ekleme", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Katagori :");
		lblNewLabel_2.setBounds(248, 103, 119, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Yazar\u0131 :");
		lblNewLabel_3.setBounds(248, 128, 119, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sayfa Say\u0131s\u0131 :");
		lblNewLabel_4.setBounds(248, 153, 119, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Yay\u0131mlanma Tarihi :");
		lblNewLabel_5.setBounds(248, 178, 119, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblKitapAd_1 = new JLabel("Kitap Ad\u0131 :");
		lblKitapAd_1.setBounds(248, 78, 119, 14);
		panel.add(lblKitapAd_1);
		
		txtKitapID = new JTextField();
		txtKitapID.setEditable(false);
		txtKitapID.setBounds(377, 50, 180, 20);
		panel.add(txtKitapID);
		txtKitapID.setColumns(10);
		
		txtKitapAdi = new JTextField();
		txtKitapAdi.setBounds(377, 75, 180, 20);
		panel.add(txtKitapAdi);
		txtKitapAdi.setColumns(10);
		
		//JComboBox CboxKitapKatagori = new JComboBox(Librarian.cmbCategory().toArray());
		JComboBox CboxKitapKatagori = new JComboBox();
		CboxKitapKatagori.setBounds(377, 100, 119, 20);
		panel.add(CboxKitapKatagori);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) 
			{
				try
				{
					
					 Class.forName("com.mysql.jdbc.Driver");
		        	 String url="jdbc:mysql://127.0.0.1:3306/librarymanagement?serverTimezone=UTC";
		             connection = DriverManager.getConnection(url,"root","1234");
		             statement = connection.createStatement();
		         	 String query="SELECT * FROM category";
		         	 rs=statement.executeQuery(query);
		         	 while(rs.next())
		         	 {
		         		CboxKitapKatagori.addItem(rs.getString(2));
		         	 }

				}
				catch (SQLException ex) 
				{
					ex.printStackTrace();
				}
				catch (ClassNotFoundException ex)
		        {
		            ex.printStackTrace();
		        }
			}
		});
		
		txtKitapYazar = new JTextField();
		txtKitapYazar.setBounds(377, 125, 180, 20);
		panel.add(txtKitapYazar);
		txtKitapYazar.setColumns(10);
		
		txtKitapSayfasi = new JTextField();
		txtKitapSayfasi.setBounds(377, 150, 180, 20);
		panel.add(txtKitapSayfasi);
		txtKitapSayfasi.setColumns(10);
		
		txtKitapTarih = new JTextField();
		txtKitapTarih.setBounds(377, 175, 119, 20);
		panel.add(txtKitapTarih);
		txtKitapTarih.setColumns(10);
		
		txtKitapYayimci = new JTextField();
		txtKitapYayimci.setBounds(377, 204, 180, 20);
		panel.add(txtKitapYayimci);
		txtKitapYayimci.setColumns(10);
		
		JButton btnKitapEkle = new JButton("Ekle");
		btnKitapEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				try
				{
					SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
		        	
					
					Librarian librarian =new Librarian();
					String title=txtKitapAdi.getText().toUpperCase();
					int numberOfPages=Integer.valueOf(txtKitapSayfasi.getText());
					int categoryId=CboxKitapKatagori.getSelectedIndex()+2;
					int bookIssueId=1;
					String date=txtKitapTarih.getText();
					Date bookReleaseDate = dt1.parse(date); 
					String bookPublisher=txtKitapYayimci.getText();
					String authorName=txtKitapYazar.getText().toUpperCase();
					librarian.addBook(title, numberOfPages, categoryId, bookIssueId, dt1.format(bookReleaseDate), bookPublisher, authorName);
					JOptionPane.showMessageDialog(panel, "Ekleme Ýþlemi Baþarýlý");
					
					txtKitapAdi.setText("");
					txtKitapSayfasi.setText("");
					txtKitapTarih.setText("");
					txtKitapYayimci.setText("");
					txtKitapYazar.setText("");
					CboxKitapKatagori.setSelectedIndex(0);
					txtKitapYayimci.setText("");

				}
				catch (ParseException ex) {

					JOptionPane.showMessageDialog(panel, "Tarih Bilgisini Doðru Giriniz.");
				}
				catch (NumberFormatException ex) 
				{
					JOptionPane.showMessageDialog(panel, "Kitap Sayýsýný Rakam Olarak Giriniz.");
				}
				catch (SQLException ex) 
				{
					JOptionPane.showMessageDialog(panel, "Veri Tabaný Hatasý.");
					ex.printStackTrace();
				}
				
			}
		});
		btnKitapEkle.setBounds(278, 280, 89, 23);
		panel.add(btnKitapEkle);
		
		JButton btnKitapVazgec = new JButton("Temizle");
		btnKitapVazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				txtKitapAdi.setText("");
				txtKitapTarih.setText("");
				txtKitapYazar.setText("");
				txtKitapTarih.setText("");
				txtKitapSayfasi.setText("");
				CboxKitapKatagori.setSelectedIndex(0);
				txtKitapYayimci.setText("");
			}
		});
		btnKitapVazgec.setBounds(506, 280, 89, 23);
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
					
					Librarian librarian= new Librarian();
					BufferedReader reader = new BufferedReader(new FileReader(f));
					String line=null;
					int islemSayisi=0;
					while (reader.ready()) 
					{
					    line=reader.readLine();
					    String[] dosyadan=line.split(",");
					    for(int i=0;i<(dosyadan.length)/6;i++) 
					    {
					    	librarian.addBook(dosyadan[0].toUpperCase(), Integer.valueOf(dosyadan[2]), Integer.valueOf(dosyadan[3]), 1, dosyadan[4], dosyadan[5].toUpperCase(), dosyadan[1].toUpperCase());
					    	islemSayisi++;
					    }
					}
					JOptionPane.showMessageDialog(panel, "Dosyadan "+islemSayisi+" Tane Kitap Eklendi.");
					reader.close();
					} catch (Exception ex) {
					x.showMessageDialog(frameKutupheneci, "HATA: "+ex);
					}
			}
		});
		btnKitapDosyadanEkle.setBounds(377, 280, 119, 23);
		panel.add(btnKitapDosyadanEkle);
		
		JLabel lblKitapId_1 = new JLabel("Kitap ID :");
		lblKitapId_1.setBounds(248, 53, 119, 14);
		panel.add(lblKitapId_1);
		
		JLabel lblYaymc = new JLabel("Yay\u0131mc\u0131 :");
		lblYaymc.setBounds(248, 207, 119, 14);
		panel.add(lblYaymc);
		
		JLabel lblYyyyaagg = new JLabel("YYYY-AA-GG");
		lblYyyyaagg.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblYyyyaagg.setBounds(506, 178, 87, 14);
		panel.add(lblYyyyaagg);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Kitap Görüntüle", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 11, 837, 393);
		panel_1.add(tabbedPane_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("Bütün Kitaplar", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		//panel_3.setLayout(null);
		
		tblButunKitaplar = new JTable();
		tblButunKitaplar.setBounds(0, 36, 832, 329);
		JScrollPane scrlPane = new JScrollPane(tblButunKitaplar);
		
		panel_3.add(scrlPane,BorderLayout.CENTER);
		
		JButton btnGrntle_3 = new JButton("G\u00F6r\u00FCnt\u00FCle");
		btnGrntle_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String []baslik={"Adý","Kategorisi","Yayýmcý","Sayfa Sayýsý","Yazarlar"};
					//String query="SELECT book.book_title,book.book_number_of_pages,book.book_publisher,book.book_release_date,author.author_name,category.category_name FROM librarymanagement.book INNER JOIN librarymanagement.category ON category.category_id=book.book_category_id INNER JOIN librarymanagement.authors_of_book ON authors_of_book.authorsOfBook_book_id=book.book_id INNER JOIN author ON author.author_id=authors_of_book.authorsOfBook_author_id ";
					String query="SELECT book.book_title, category.category_name, book.book_publisher, book.book_number_of_pages, GROUP_CONCAT(author.author_name) AS \"Yazarlar\" FROM book INNER JOIN authors_of_book ON authors_of_book.authorsOfBook_book_id=book.book_id INNER JOIN author ON author.author_id=authors_of_book.authorsOfBook_author_id INNER JOIN category ON category.category_id=book.book_category_id GROUP BY book.book_id";
		           
					Librarian oduncverilen=new Librarian();
					tblButunKitaplar.setModel(oduncverilen.getBooks(query, baslik));
				}
				catch (SQLException ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnGrntle_3.setBounds(704, 7, 89, 23);
		panel_3.add(btnGrntle_3,BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Raflardaki Kitaplar", null, panel_4, null);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		tblRafKitap = new JTable();
		tblRafKitap.setBounds(0, 50, 832, 315);
		JScrollPane scrlPane_1 = new JScrollPane(tblRafKitap);
		panel_4.add(scrlPane_1,BorderLayout.CENTER);
		
		JButton btnGrntle_2 = new JButton("G\u00F6r\u00FCnt\u00FCle");
		btnGrntle_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String []baslik={"Adý","Kategorisi","Yayýmcý","Sayfa Sayýsý","Yazarlar"};
					//String query="SELECT book.book_title,book.book_number_of_pages,book.book_publisher,book.book_release_date,author.author_name,category.category_name FROM librarymanagement.book INNER JOIN librarymanagement.category ON category.category_id=book.book_category_id INNER JOIN librarymanagement.authors_of_book ON authors_of_book.authorsOfBook_book_id=book.book_id INNER JOIN author ON author.author_id=authors_of_book.authorsOfBook_author_id WHERE book.book_issue_status_id ='1'";
					String query="SELECT book.book_title, category.category_name, book.book_publisher, book.book_number_of_pages, GROUP_CONCAT(author.author_name) AS \"Yazarlar\" FROM book INNER JOIN authors_of_book ON authors_of_book.authorsOfBook_book_id=book.book_id INNER JOIN author ON author.author_id=authors_of_book.authorsOfBook_author_id \r\n" + 
							"INNER JOIN category ON category.category_id=book.book_category_id\r\n" + 
							"WHERE book.book_issue_status_id='1' GROUP BY book.book_id ";
					Librarian raftakiler=new Librarian();
					tblRafKitap.setModel(raftakiler.getBooks(query, baslik));
				}
				catch (SQLException ex) 
				{
					ex.printStackTrace();
				}
				
			}
		});
		btnGrntle_2.setBounds(705, 11, 89, 23);
		panel_4.add(btnGrntle_2,BorderLayout.EAST);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Ödünç Verilen Kitaplar", null, panel_5, null);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		tblOduncKitap = new JTable();
		tblOduncKitap.setBounds(0, 44, 832, 321);
		JScrollPane scrlPane_2 = new JScrollPane(tblOduncKitap);
		panel_5.add(scrlPane_2,BorderLayout.CENTER);
		
		
		JButton btnGrntle_1 = new JButton("G\u00F6r\u00FCnt\u00FCle");
		btnGrntle_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String []baslik={"1","2","3","4","5"};
					//String query="SELECT book.book_title,book.book_number_of_pages,book.book_publisher,book.book_release_date,author.author_name,category.category_name FROM librarymanagement.book INNER JOIN librarymanagement.category ON category.category_id=book.book_category_id INNER JOIN librarymanagement.authors_of_book ON authors_of_book.authorsOfBook_book_id=book.book_id INNER JOIN author ON author.author_id=authors_of_book.authorsOfBook_author_id WHERE book.book_issue_status_id ='2'";
					String query="SELECT book.book_title, category.category_name, book.book_publisher, book.book_number_of_pages, GROUP_CONCAT(author.author_name) AS \"Yazarlar\" FROM book INNER JOIN authors_of_book ON authors_of_book.authorsOfBook_book_id=book.book_id INNER JOIN author ON author.author_id=authors_of_book.authorsOfBook_author_id \r\n" + 
							"INNER JOIN category ON category.category_id=book.book_category_id\r\n" + 
							"WHERE book.book_issue_status_id='2' GROUP BY book.book_id ";
					Librarian oduncverilen=new Librarian();
					tblOduncKitap.setModel(oduncverilen.getBooks(query, baslik));
				}
				catch (SQLException ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnGrntle_1.setBounds(718, 11, 89, 23);
		panel_5.add(btnGrntle_1,BorderLayout.EAST);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_1.addTab("Ýade Tarihi Geçmiþ Kitaplar", null, panel_7, null);
		panel_7.setLayout(null);
		
		tblIadeTarihiGecmis = new JTable();
		tblIadeTarihiGecmis.setBounds(0, 39, 832, 326);
		panel_7.add(tblIadeTarihiGecmis);
		
		JButton btnGrntle = new JButton("G\u00F6r\u00FCnt\u00FCle");
		btnGrntle.setBounds(733, 11, 89, 23);
		panel_7.add(btnGrntle);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Ödünç Ver", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_4 = new JLabel("K\u00FCt\u00FCphaneci TC NO :");
		label_4.setBounds(241, 63, 129, 14);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Uye TC NO :");
		label_5.setBounds(241, 94, 80, 14);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Kitap Ad\u0131 :");
		label_6.setBounds(241, 125, 80, 14);
		panel_2.add(label_6);
		
		txtOduncVerKutuphaneciTc = new JTextField();
		txtOduncVerKutuphaneciTc.setColumns(10);
		txtOduncVerKutuphaneciTc.setBounds(364, 60, 129, 20);
		panel_2.add(txtOduncVerKutuphaneciTc);
		
		txtOduncVerUyeTc = new JTextField();
		txtOduncVerUyeTc.setColumns(10);
		txtOduncVerUyeTc.setBounds(364, 91, 129, 20);
		panel_2.add(txtOduncVerUyeTc);
		
		txtOduncVerKitapAdi = new JTextField();
		txtOduncVerKitapAdi.setColumns(10);
		txtOduncVerKitapAdi.setBounds(364, 122, 129, 20);
		panel_2.add(txtOduncVerKitapAdi);
		
		JButton btnOduncVer = new JButton("\u00D6D\u00DCN\u00C7 VER");
		btnOduncVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int librarianTC=Integer.valueOf(txtOduncVerKutuphaneciTc.getText());
				int userTC=Integer.valueOf(txtOduncVerUyeTc.getText());
				String bookTitle=txtOduncVerKitapAdi.getText().toUpperCase();
				
				Librarian librarian=new Librarian();
				Login lg=new Login();
				int libTC=lg.KUTUPHANECITC;
				System.out.println(libTC);
				try
				{
					librarian.issueBooks(librarianTC, userTC, bookTitle);
					JOptionPane.showMessageDialog(panel_2, "Ödünç Verme Ýþlemi Baþarýlý");
					System.out.println(libTC);
					txtOduncVerKutuphaneciTc.setText("");
					txtOduncVerKitapAdi.setText("");
					txtOduncVerUyeTc.setText("");
				}
				catch (NumberFormatException ex) 
				{
					JOptionPane.showMessageDialog(panel_2, "Kütüphaneci ve Uye TC'sini Doðru Giriniz.");
				}
				catch (SQLException ex) 
				{
					JOptionPane.showMessageDialog(panel_2, "Veri Tabaný Hatasý.");
					ex.printStackTrace();
				}
			}
		});
		btnOduncVer.setBounds(257, 199, 129, 23);
		panel_2.add(btnOduncVer);
		
		JButton button_3 = new JButton("Temizle");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				txtOduncVerKutuphaneciTc.setText("");
				txtOduncVerKitapAdi.setText("");
				txtOduncVerUyeTc.setText("");
			}
		});
		button_3.setBounds(396, 199, 89, 23);
		panel_2.add(button_3);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Ýade Al", null, panel_6, null);
		panel_6.setLayout(null);
		
		JLabel label = new JLabel("K\u00FCt\u00FCphaneci TC NO :");
		label.setBounds(147, 57, 127, 14);
		panel_6.add(label);
		
		JLabel label_1 = new JLabel("Uye TC NO :");
		label_1.setBounds(147, 82, 80, 14);
		panel_6.add(label_1);
		
		JLabel label_2 = new JLabel("Kitap Ad\u0131 :");
		label_2.setBounds(147, 107, 80, 14);
		panel_6.add(label_2);
		
		txtIadeAlKutuphaneciTc = new JTextField();
		txtIadeAlKutuphaneciTc.setColumns(10);
		txtIadeAlKutuphaneciTc.setBounds(284, 54, 129, 20);
		panel_6.add(txtIadeAlKutuphaneciTc);
		
		txtIadeAlUyeTc = new JTextField();
		txtIadeAlUyeTc.setColumns(10);
		txtIadeAlUyeTc.setBounds(284, 79, 129, 20);
		panel_6.add(txtIadeAlUyeTc);
		
		txtIadeAlKitapAdi = new JTextField();
		txtIadeAlKitapAdi.setColumns(10);
		txtIadeAlKitapAdi.setBounds(284, 104, 129, 20);
		panel_6.add(txtIadeAlKitapAdi);
		
		JButton btnIadeAl = new JButton("IADE AL");
		btnIadeAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int librarianTC=Integer.valueOf(txtIadeAlKutuphaneciTc.getText());
				int userTC=Integer.valueOf(txtIadeAlUyeTc.getText());
				String bookTitle=txtIadeAlKitapAdi.getText().toUpperCase();
				
				Login login=new Login();
				int libTC=login.KUTUPHANECITC;
				
				Librarian librarian=new Librarian();
				try
				{
					librarian.returnBook(librarianTC, userTC, bookTitle);
					JOptionPane.showMessageDialog(panel_2, "Ýade Alma Ýþlemi Baþarýlý");
					txtIadeAlKutuphaneciTc.setText("");
					txtIadeAlUyeTc.setText("");
					txtIadeAlKitapAdi.setText("");
				}
				catch (NumberFormatException ex) 
				{
					JOptionPane.showMessageDialog(panel_2, "Kütüphaneci ve Uye TC'sini Doðru Giriniz.");
				}
				catch (SQLException ex) 
				{
					JOptionPane.showMessageDialog(panel_2, "Veri Tabaný Hatasý.");
					ex.printStackTrace();
				}
			}
		});
		btnIadeAl.setBounds(166, 177, 133, 23);
		panel_6.add(btnIadeAl);
		
		JButton button_1 = new JButton("Temizle");
		button_1.setBounds(319, 177, 89, 23);
		panel_6.add(button_1);
		
		JButton btnSistemdenk = new JButton("Sistemden \u00C7\u0131k\u0131\u015F");
		btnSistemdenk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginController sistemcikis=new LoginController();
                sistemcikis.LogOut();
                dispose();
			}
		});
		btnSistemdenk.setBounds(705, 0, 167, 32);
		frameKutupheneci.add(btnSistemdenk);
	}
}
