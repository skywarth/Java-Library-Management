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
	private JTextField txtKuSilTc;
	private java.sql.Connection connection;
	private Statement statement;
	private ResultSet rs;
	private JTextField txtKutuphaneMail;
	private JTextField txtKuSilKAdi;
	private JTextField txtKuSilAdi;
	private JTextField txtKuSilSoyadi;

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
		frameKutuphane.setBounds(100, 100, 712, 411);
		frameKutuphane.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameKutuphane.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 676, 351);
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
		
		JTextArea txtKutuphaneAdres = new JTextArea();
		txtKutuphaneAdres.setLineWrap(true);
		txtKutuphaneAdres.setBounds(153, 220, 202, 92);
		pnlEkle.add(txtKutuphaneAdres);
		
		JComboBox cBoxCinsiyet = new JComboBox();
		cBoxCinsiyet.setModel(new DefaultComboBoxModel(new String[] {"Erkek", "K\u0131z"}));
		cBoxCinsiyet.setBounds(153, 138, 86, 22);
		pnlEkle.add(cBoxCinsiyet);
		
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
					admin.addLibrarian(seviye, userName, password, name, tcNo, mail, phoneNumber, address);
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
		btnKutuphaneKaydet.setBounds(300, 38, 89, 23);
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
		btnKutuphaneVazgec.setBounds(300, 88, 89, 23);
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
		
		JLabel lblEmail = new JLabel("e-mail :");
		lblEmail.setBounds(10, 192, 46, 14);
		pnlEkle.add(lblEmail);
		
		txtKutuphaneMail = new JTextField();
		txtKutuphaneMail.setBounds(153, 189, 86, 20);
		pnlEkle.add(txtKutuphaneMail);
		txtKutuphaneMail.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Adres :");
		lblNewLabel_2.setBounds(10, 217, 46, 14);
		pnlEkle.add(lblNewLabel_2);
		
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
		tblKuGoruntule.setEnabled(false);
		tblKuGoruntule.setBounds(10, 36, 651, 211);
		pnlGoruntule.add(tblKuGoruntule);
		
		JLabel lblGoster = new JLabel("goster");
		lblGoster.setBounds(10, 263, 481, 14);
		pnlGoruntule.add(lblGoster);
		
		JButton btnGster = new JButton("G\u00FCncelle");
		btnGster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String []baslik={"1","2","3","4","5","6","7","8"};
					//String query="SELECT * FROM librarymanagement.user";
					String query="SELECT access_level.access_level_description,user.user_username,user.user_password,user.user_name,user.user_tc,user.user_email,user.user_phone_number,user.user_address FROM librarymanagement.user INNER JOIN librarymanagement.access_level ON user.user_access_level_id=access_level.access_level_id WHERE user.user_access_level_id='2'";
		            //tblKuGoruntule.setModel(listele(query,baslik));
					Admin admin=new Admin();
					tblKuGoruntule.setModel(admin.getLibrarians(query, baslik));
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		});
		btnGster.setBounds(202, 7, 89, 23);
		pnlGoruntule.add(btnGster);
		
		JPanel pnlSil = new JPanel();
		tabbedPane.addTab("Silme", null, pnlSil, null);
		pnlSil.setLayout(null);
		
		JLabel lblTcNo = new JLabel("TC Numaras\u0131 :");
		lblTcNo.setBounds(10, 36, 103, 14);
		pnlSil.add(lblTcNo);
		
		txtKuSilTc = new JTextField();
		txtKuSilTc.setBounds(123, 33, 86, 20);
		pnlSil.add(txtKuSilTc);
		txtKuSilTc.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblNewLabel_3.setBounds(10, 11, 103, 14);
		pnlSil.add(lblNewLabel_3);
		
		txtKuSilKAdi = new JTextField();
		txtKuSilKAdi.setBounds(123, 8, 86, 20);
		pnlSil.add(txtKuSilKAdi);
		txtKuSilKAdi.setColumns(10);
		
		JLabel lblAd_1 = new JLabel("Ad\u0131 :");
		lblAd_1.setBounds(10, 61, 103, 14);
		pnlSil.add(lblAd_1);
		
		JLabel lblSoyad = new JLabel("Soyad\u0131 :");
		lblSoyad.setBounds(10, 89, 46, 14);
		pnlSil.add(lblSoyad);
		
		txtKuSilAdi = new JTextField();
		txtKuSilAdi.setBounds(123, 58, 86, 20);
		pnlSil.add(txtKuSilAdi);
		txtKuSilAdi.setColumns(10);
		
		txtKuSilSoyadi = new JTextField();
		txtKuSilSoyadi.setBounds(123, 86, 86, 20);
		pnlSil.add(txtKuSilSoyadi);
		txtKuSilSoyadi.setColumns(10);
		
		JLabel lblSilBilgi = new JLabel("Silinecek Ki\u015Fi Bilgileri");
		lblSilBilgi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSilBilgi.setBounds(362, 11, 174, 23);
		pnlSil.add(lblSilBilgi);
		
		JLabel lblSilGoster = new JLabel("lblSilBilgi");
		lblSilGoster.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSilGoster.setBounds(250, 36, 411, 23);
		pnlSil.add(lblSilGoster);
		
		JButton btnKuSil = new JButton("S\u0130L");
		btnKuSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Admin admin=new Admin();
					int tcNo= Integer.valueOf(txtKuSilTc.getText());
					String userName=txtKuSilKAdi.getText();
					String name=txtKuSilAdi.getText()+" "+txtKuSilSoyadi.getText();
					
					//lblSilGoster.setText(silBilgiGoster(userName, tcNo, name));
					lblSilGoster.setText(admin.silBilgiGoster(userName, tcNo, name));
					Object [] noDeleteOption = {"Evet","Hayýr","Ýptal" };
					int noDelete=JOptionPane.showConfirmDialog(null, "Silmek Ýstiyor Musunuz ? ","Ýþlem Onayý!",JOptionPane.YES_NO_OPTION);
					if(noDelete==JOptionPane.YES_OPTION)
					{
						//Silme(userName, tcNo, name);
						admin.deletLibrarian(userName, tcNo, name);
						txtKuSilAdi.setText("");
						txtKuSilSoyadi.setText("");
						txtKuSilKAdi.setText("");
						txtKuSilTc.setText("");
						lblSilGoster.setText("SÝLME ÝÞLEMÝ BAÞARILI!");
					}
					else 
					{
						txtKuSilAdi.setText("");
						txtKuSilSoyadi.setText("");
						txtKuSilKAdi.setText("");
						txtKuSilTc.setText("");
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
		btnKuSil.setBounds(120, 132, 89, 23);
		pnlSil.add(btnKuSil);
		
		JButton btnKuSilVazgec = new JButton("Temizle");
		btnKuSilVazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtKuSilTc.setText("");
			}
		});
		btnKuSilVazgec.setBounds(273, 132, 89, 23);
		pnlSil.add(btnKuSilVazgec);
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
