package YoneticiModul;

import siniflar.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sun.corba.se.pept.transport.Connection;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Properties;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JPasswordField;

public class YonetKutuphane {

	public JFrame frameKutuphane;
	private JTextField txtKutuphaneTCNo;
	private JTextField txtKutuphaneAdi;
	private JTextField txtKutuphaneSoyadi;
	private JTextField txtKutuphaneTel;
	private JTextField txtKutuphaneKAdi;
	private JTextField txtKuGoruntuleTC;
	private JTable tblKuGoruntule;
	private java.sql.Connection connection;
	private Statement statement;
	private ResultSet rs;
	private JTextField txtKutuphaneMail;
	private JTextField txtSilBulTC;
	private JTextField txtKAdi;
	private JTextField txtTCNo;
	private JTextField txtAd;
	private JTextField txtMail;
	private JTextField txtSeviye;
	private JTextField txtSifre;
	private JTextField txtTelefon;
	private JTextField txtSoyad;
	private JPasswordField txtKutuphaneParola;

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

	public YonetKutuphane() {
		initialize();
	}

	private void initialize() {
		frameKutuphane = new JFrame();
		frameKutuphane.setTitle("K\u00FCt\u00FCphane \u0130\u015Flemleri");
		frameKutuphane.setBounds(100, 100, 815, 479);
		frameKutuphane.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameKutuphane.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 779, 419);
		frameKutuphane.getContentPane().add(tabbedPane);
		
		JPanel pnlEkle = new JPanel();
		tabbedPane.addTab("Ekleme", null, pnlEkle, null);
		pnlEkle.setLayout(null);
		
		JLabel lblTc = new JLabel("TC Numaras\u0131 :");
		lblTc.setBounds(174, 44, 102, 14);
		pnlEkle.add(lblTc);
		
		JLabel lblAd = new JLabel("Ad\u0131 :");
		lblAd.setBounds(174, 125, 102, 14);
		pnlEkle.add(lblAd);
		
		JLabel lblNewLabel = new JLabel("Soyad\u0131 :");
		lblNewLabel.setBounds(174, 150, 102, 14);
		pnlEkle.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Telefon Numaras\u0131 :");
		lblNewLabel_1.setBounds(174, 175, 133, 14);
		pnlEkle.add(lblNewLabel_1);
		
		txtKutuphaneTCNo = new JTextField();
		txtKutuphaneTCNo.setBounds(317, 41, 86, 20);
		pnlEkle.add(txtKutuphaneTCNo);
		txtKutuphaneTCNo.setColumns(10);
		
		txtKutuphaneAdi = new JTextField();
		txtKutuphaneAdi.setBounds(317, 122, 86, 20);
		pnlEkle.add(txtKutuphaneAdi);
		txtKutuphaneAdi.setColumns(10);
		
		txtKutuphaneSoyadi = new JTextField();
		txtKutuphaneSoyadi.setBounds(317, 147, 86, 20);
		pnlEkle.add(txtKutuphaneSoyadi);
		txtKutuphaneSoyadi.setColumns(10);
		
		txtKutuphaneTel = new JTextField();
		txtKutuphaneTel.setBounds(317, 172, 86, 20);
		pnlEkle.add(txtKutuphaneTel);
		txtKutuphaneTel.setColumns(10);
		
		JTextArea txtKutuphaneAdres = new JTextArea();
		txtKutuphaneAdres.setLineWrap(true);
		txtKutuphaneAdres.setBounds(317, 234, 202, 92);
		pnlEkle.add(txtKutuphaneAdres);
		
		JButton btnKutuphaneKaydet = new JButton("EKLE");
		btnKutuphaneKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				try
				{
					int seviye=2;
					String userName=txtKutuphaneKAdi.getText();
					String password=txtKutuphaneParola.getText();
					String name=txtKutuphaneAdi.getText()+" "+txtKutuphaneSoyadi.getText();
					int tcNo=Integer.valueOf(txtKutuphaneTCNo.getText());
					String mail=txtKutuphaneMail.getText();
					int phoneNumber=Integer.valueOf(txtKutuphaneTel.getText());
					String address=txtKutuphaneAdres.getText();
					//Ekleme(seviye, userName, password, name, tcNo, mail, phoneNumber, address);
					Admin admin=new Admin();
					admin.add(seviye, userName, password, name, tcNo, mail, phoneNumber, address);
					JOptionPane.showMessageDialog(pnlEkle, "Ekleme Ýþlemi Baþarýlý");
				}
				catch (NumberFormatException ex) 
				{
					JOptionPane.showMessageDialog(pnlEkle, "TC ve Telefonu Doðru Giriniz.");
				}
				catch (SQLException ex) 
				{
					JOptionPane.showMessageDialog(pnlEkle, "Veri Tabaný Hatasý.");
				}
				
			}
		});
		btnKutuphaneKaydet.setBounds(464, 71, 89, 23);
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
			}
		});
		btnKutuphaneVazgec.setBounds(464, 121, 89, 23);
		pnlEkle.add(btnKutuphaneVazgec);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblKullancAd.setBounds(174, 75, 102, 14);
		pnlEkle.add(lblKullancAd);
		
		txtKutuphaneKAdi = new JTextField();
		txtKutuphaneKAdi.setBounds(317, 72, 86, 20);
		pnlEkle.add(txtKutuphaneKAdi);
		txtKutuphaneKAdi.setColumns(10);
		
		JLabel lblParola = new JLabel("Parola :");
		lblParola.setBounds(174, 100, 102, 14);
		pnlEkle.add(lblParola);
		
		JLabel lblEmail = new JLabel("e-mail :");
		lblEmail.setBounds(174, 200, 46, 14);
		pnlEkle.add(lblEmail);
		
		txtKutuphaneMail = new JTextField();
		txtKutuphaneMail.setBounds(317, 203, 86, 20);
		pnlEkle.add(txtKutuphaneMail);
		txtKutuphaneMail.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Adres :");
		lblNewLabel_2.setBounds(174, 225, 46, 14);
		pnlEkle.add(lblNewLabel_2);
		
		txtKutuphaneParola = new JPasswordField();
		txtKutuphaneParola.setBounds(317, 97, 86, 20);
		pnlEkle.add(txtKutuphaneParola);
		
		JPanel pnlGoruntule = new JPanel();
		tabbedPane.addTab("Görüntüle", null, pnlGoruntule, null);
		pnlGoruntule.setLayout(null);
		
		JLabel lblTcNumaras = new JLabel("TC Numaras\u0131 :");
		lblTcNumaras.setBounds(10, 11, 86, 14);
		pnlGoruntule.add(lblTcNumaras);
		
		txtKuGoruntuleTC = new JTextField();
		txtKuGoruntuleTC.setBounds(106, 8, 127, 20);
		pnlGoruntule.add(txtKuGoruntuleTC);
		txtKuGoruntuleTC.setColumns(10);
		
		tblKuGoruntule = new JTable();
		tblKuGoruntule.setEnabled(false);
		tblKuGoruntule.setBounds(10, 36, 651, 276);
		
		JScrollPane KutuphaneSPane = new JScrollPane(tblKuGoruntule);
		KutuphaneSPane.setBounds(0, 36, 764, 344);
		pnlGoruntule.add(KutuphaneSPane);
		
		
		JButton btnGster = new JButton("G\u00FCncelle");
		btnGster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String []baslik={"Eriþim Seviyesi","Kullanýcý Adý","Þifre","Ad-Soyad","TC NO","Mail","Telefon","Adres"};
					//String query="SELECT * FROM librarymanagement.user";
					String query="SELECT access_level.access_level_description,user.user_username,user.user_password,user.user_name,user.user_tc,user.user_email,user.user_phone_number,user.user_address FROM librarymanagement.user INNER JOIN librarymanagement.access_level ON user.user_access_level_id=access_level.access_level_id WHERE user.user_access_level_id='2'";
		            //tblKuGoruntule.setModel(listele(query,baslik));
					Admin admin=new Admin();
					tblKuGoruntule.setModel(admin.get(query, baslik));
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		});
		btnGster.setBounds(343, 7, 89, 23);
		pnlGoruntule.add(btnGster);
		
		JButton btnBul = new JButton("Bul");
		btnBul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String []baslik={"Eriþim Seviyesi","Kullanýcý Adý","Þifre","Ad-Soyad","TC NO","Mail","Telefon","Adres"};
					String query="SELECT access_level.access_level_description,user.user_username,user.user_password,user.user_name,user.user_tc,user.user_email,user.user_phone_number,user.user_address FROM librarymanagement.user INNER JOIN librarymanagement.access_level ON user.user_access_level_id=access_level.access_level_id WHERE user.user_access_level_id='2' AND user.user_tc='"+txtKuGoruntuleTC.getText()+"'";
		            //tblKuGoruntule.setModel(listele(query,baslik));
					Admin admin=new Admin();
					tblKuGoruntule.setModel(admin.get(query, baslik));
				}
				catch (SQLException ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnBul.setBounds(243, 7, 89, 23);
		pnlGoruntule.add(btnBul);
		
		
		
		JPanel pnlSil = new JPanel();
		tabbedPane.addTab("Silme", null, pnlSil, null);
		pnlSil.setLayout(null);
		
		JLabel label = new JLabel("Tc Kimlik Numaras\u0131 :");
		label.setBounds(10, 19, 137, 14);
		pnlSil.add(label);
		
		txtSilBulTC = new JTextField();
		txtSilBulTC.setColumns(10);
		txtSilBulTC.setBounds(157, 16, 100, 20);
		pnlSil.add(txtSilBulTC);
		
		JLabel label_1 = new JLabel("Silinecek Ki\u015Fi Bilgileri");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_1.setBounds(422, 11, 212, 29);
		pnlSil.add(label_1);
		
		JLabel lblSilBil = new JLabel("");
		lblSilBil.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSilBil.setBounds(340, 30, 380, 29);
		pnlSil.add(lblSilBil);
		
		txtKAdi = new JTextField();
		txtKAdi.setEditable(false);
		txtKAdi.setColumns(10);
		txtKAdi.setBounds(450, 88, 130, 20);
		pnlSil.add(txtKAdi);
		
		txtTCNo = new JTextField();
		txtTCNo.setEditable(false);
		txtTCNo.setColumns(10);
		txtTCNo.setBounds(450, 190, 130, 20);
		pnlSil.add(txtTCNo);
		
		txtAd = new JTextField();
		txtAd.setEditable(false);
		txtAd.setColumns(10);
		txtAd.setBounds(450, 138, 130, 20);
		pnlSil.add(txtAd);
		
		txtMail = new JTextField();
		txtMail.setEditable(false);
		txtMail.setColumns(10);
		txtMail.setBounds(450, 215, 130, 20);
		pnlSil.add(txtMail);
		
		txtSeviye = new JTextField();
		txtSeviye.setEditable(false);
		txtSeviye.setColumns(10);
		txtSeviye.setBounds(450, 63, 130, 20);
		pnlSil.add(txtSeviye);
		
		txtSifre = new JTextField();
		txtSifre.setEditable(false);
		txtSifre.setColumns(10);
		txtSifre.setBounds(450, 113, 130, 20);
		pnlSil.add(txtSifre);
		
		txtTelefon = new JTextField();
		txtTelefon.setEditable(false);
		txtTelefon.setColumns(10);
		txtTelefon.setBounds(450, 242, 130, 20);
		pnlSil.add(txtTelefon);
		
		txtSoyad = new JTextField();
		txtSoyad.setEditable(false);
		txtSoyad.setColumns(10);
		txtSoyad.setBounds(450, 163, 130, 20);
		pnlSil.add(txtSoyad);
		
		JTextArea txtAdres = new JTextArea();
		txtAdres.setEditable(false);
		txtAdres.setBounds(450, 273, 212, 78);
		pnlSil.add(txtAdres);
		
		JButton btnSil = new JButton("S\u0130L");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Admin admin=new Admin();
					int tcNo= Integer.valueOf(txtSilBulTC.getText());
					
					String bilgi= admin.Bul(tcNo, 2);
					String[] bilgiler=bilgi.split(" ");
					txtSeviye.setText(bilgiler[0]);
					txtKAdi.setText(bilgiler[1]);
					txtSifre.setText(bilgiler[2]);
					txtAd.setText(bilgiler[3]);
					txtSoyad.setText(bilgiler[4]);
					txtTCNo.setText(bilgiler[5]);
					txtMail.setText(bilgiler[6]);
					txtTelefon.setText(bilgiler[7]);
					txtAdres.setText(bilgiler[8]);
					
					Object [] noDeleteOption = {"Evet","Hayýr","Ýptal" };
					int noDelete=JOptionPane.showConfirmDialog(null, "Silmek Ýstiyor Musunuz ? ","Ýþlem Onayý!",JOptionPane.YES_NO_OPTION);
					if(noDelete==JOptionPane.YES_OPTION)
					{
						//Silme(userName, tcNo, name);
						admin.delete(2,tcNo);
						txtSeviye.setText("");
						txtKAdi.setText("");
						txtSifre.setText("");
						txtAd.setText("");
						txtSoyad.setText("");
						txtTCNo.setText("");
						txtMail.setText("");
						txtTelefon.setText("");
						txtAdres.setText("");
						lblSilBil.setText("SÝLME ÝÞLEMÝ BAÞARILI!");
					}
					else 
					{
						txtSilBulTC.setText("");
					}	
				}
				catch (NumberFormatException ex) 
				{
					JOptionPane.showMessageDialog(pnlSil, "TC'yi Doðru Giriniz.");
				}
				catch (SQLException ex) {
					JOptionPane.showMessageDialog(pnlSil, "Veri Tabaný Hatasý.");
				}
			}
		});
		btnSil.setBounds(26, 62, 89, 23);
		pnlSil.add(btnSil);
		
		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				txtSeviye.setText("");
				txtKAdi.setText("");
				txtSifre.setText("");
				txtAd.setText("");
				txtSoyad.setText("");
				txtTCNo.setText("");
				txtMail.setText("");
				txtTelefon.setText("");
				txtAdres.setText("");
				lblSilBil.setText("");
				txtSilBulTC.setText("");
			}
		});
		btnTemizle.setBounds(157, 62, 89, 23);
		pnlSil.add(btnTemizle);
		
		JLabel label_3 = new JLabel("Erisim Seviyesi :");
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_3.setBounds(340, 65, 100, 17);
		pnlSil.add(label_3);
		
		JLabel label_4 = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_4.setBounds(340, 91, 111, 14);
		pnlSil.add(label_4);
		
		JLabel label_5 = new JLabel("\u015Eifre :");
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_5.setBounds(340, 116, 74, 14);
		pnlSil.add(label_5);
		
		JLabel label_6 = new JLabel("Ad :");
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_6.setBounds(340, 141, 74, 14);
		pnlSil.add(label_6);
		
		JLabel label_7 = new JLabel("TC No :");
		label_7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_7.setBounds(340, 193, 46, 14);
		pnlSil.add(label_7);
		
		JLabel label_8 = new JLabel("Mail :");
		label_8.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_8.setBounds(340, 218, 46, 14);
		pnlSil.add(label_8);
		
		JLabel label_9 = new JLabel("Telefon :");
		label_9.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_9.setBounds(340, 245, 74, 14);
		pnlSil.add(label_9);
		
		JLabel label_10 = new JLabel("Adres :");
		label_10.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_10.setBounds(340, 273, 46, 14);
		pnlSil.add(label_10);
		
		JLabel label_11 = new JLabel("Soyad :");
		label_11.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_11.setBounds(340, 166, 74, 14);
		pnlSil.add(label_11);
	}
	
/*	
		//baðlantý açma metodu
	 	private void connectDB()
	    {
	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver");
	            //String url="jdbc:mysql://127.0.0.1:3306/librarymanagement?serverTimezone=UTC";
	            String url="jdbc:mysql://127.0.0.1:3306/librarymanagement?serverTimezone=UTC";
	            connection = DriverManager.getConnection(url,"root","1234");
	            statement =connection.createStatement();
	        }
	        catch (ClassNotFoundException ex)
	        {
	            ex.printStackTrace();
	        }
	        catch (SQLException ex)
	        {
	            ex.printStackTrace();
	        }
	    }
	 	
	 	//baðlantý kapatma metodu
	    private void closeDB()
	    {
	        try
	        {
	            connection.close();
	        }
	        catch (SQLException ex)
	        {
	            ex.printStackTrace();
	        }
	    }
	    
	    public DefaultTableModel createModel(ResultSet rest) throws SQLException
	    {
	    	DefaultTableModel dtm = new DefaultTableModel();
	    	ResultSetMetaData rsmd = rest.getMetaData();
	    	for (int i = 1; i <= rsmd.getColumnCount(); i++) 
	    	{
	    		dtm.addColumn(rsmd.getColumnName(i));
	    	}
	    	Vector rows;
	    	while (rest.next()) 
	    	{
	    		rows = new Vector();
	    		for (int j = 1; j <= rsmd.getColumnCount(); j++) 
	    		{
	    			rows.addElement(rest.getString(j));
	    		}
	    		dtm.addRow(rows);
	    	}
	    	return dtm;
	    }
	    
	    
	    //Listeleme Metodu
	    public DefaultTableModel listele(String query,String[] baslik) throws SQLException
	    {
	    	connectDB();
	    	rs=statement.executeQuery(query);
	    	Object [][]veri;
	    	int count=0;
	    	rs.last();
			count=rs.getRow();
			veri=new Object[count][9];
			rs.first();
			for(int i=0;i<count;i++)
			{
				 for(int j=0;j<9;j++)
				 veri[i][j]=rs.getObject(j+1);
				 rs.next();
			}
			closeDB();
			return new DefaultTableModel(veri, baslik);
	    }
	    
	    public void Ekleme(int seviye, String userName,String password, String name, int tcNo, String mail, int phoneNumber, String address) throws SQLException
	    {
	    	connectDB();
			statement.executeUpdate("INSERT INTO librarymanagement.user(user_access_level_id,user_username,user_password,user_name,user_tc,user_email,user_phone_number,user_address) VALUES ('"+seviye+"','"+userName+"','"+password+"','"+name+"','"+tcNo+"','"+mail+"','"+phoneNumber+"','"+address+"')");
			closeDB();
	    }
	    
	    public void Silme(String userName, int tcNo, String name ) throws SQLException
	    {
	    	connectDB();
			statement.executeUpdate("DELETE FROM librarymanagement.user WHERE (user.user_username='"+userName+"' AND user.user_tc='"+tcNo+"' AND user.user_name='"+name+"')");
			closeDB();
	    }
	    
	    public String silBilgiGoster(String userName, int tcNo, String name) throws SQLException
	    {
	    	connectDB();
	    	String cumle="";
	    	String query="SELECT * FROM librarymanagement.user WHERE (user.user_username='"+userName+"' AND user.user_tc='"+tcNo+"' AND user.user_name='"+name+"')";
	    	rs=statement.executeQuery(query);
	    	while(rs.next())
	    	{
	    		cumle=rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9);
	    	}
	    	closeDB();
	    	
	    	return cumle;
	    	
	    }
	    */
}
