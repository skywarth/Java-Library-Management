package siniflar;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import KutuphaneciModul.Kutuphaneci;	
import YoneticiModul.Yonetici;

public class Admin extends BaseUser implements AdminController
{
    private String TCNo;
    private String name;
    private String userName;
    private String password;
    private int adminId;
    
    
    private java.sql.Connection connection;
	private Statement statement;
	private ResultSet rs;

    public Admin(String TCNo, String name, String userName, String password) {
        this.TCNo = TCNo;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public Admin()
    {
         this.TCNo = "---";
         this.name = "---";

         this.userName = "---";
         this.password = "---";
    }

    public String getTCNo() {
        return TCNo;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void Login(String kullaniciAdi,String parola)
    {
	
    }
    //ekleme
    @Override
    public void add(int seviye, String userName,String password, String name, int tcNo, String mail, int phoneNumber, String address) throws SQLException
    {
    	connectDB();
		statement.executeUpdate("INSERT INTO librarymanagement.user(user_access_level_id,user_username,user_password,user_name,user_tc,user_email,user_phone_number,user_address) VALUES ('"+seviye+"','"+userName+"','"+password+"','"+name+"','"+tcNo+"','"+mail+"','"+phoneNumber+"','"+address+"')");
		closeDB();
    }   
    // Silme
    @Override
    public void delete(int seviye,int tcNo) throws SQLException
    {
    	connectDB();
    	statement.executeUpdate("DELETE FROM librarymanagement.user WHERE (user.user_tc='"+tcNo+"' AND user.user_access_level_id='"+seviye+"')");
		closeDB();
    }
    
   @Override
    public String Bul(int tcNo,int seviye)throws SQLException
    {
    	connectDB();
    	String cumle="";
    	String query="SELECT access_level.access_level_description,user.user_username,user.user_password,user.user_name,user.user_tc,user.user_email,user.user_phone_number,user.user_address FROM librarymanagement.user INNER JOIN librarymanagement.access_level ON user.user_access_level_id=access_level.access_level_id WHERE user.user_access_level_id='"+seviye+"' AND user.user_tc='"+tcNo+"'";
    	rs=statement.executeQuery(query);
    	while(rs.next())
    	{
    		cumle=rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+","+rs.getString(7)+","+rs.getString(8);
    	}
    	closeDB();
    	
    	return cumle;
    }

    
    //Kategori Adini Alma
    @Override
    public ArrayList<String> getCategoryNames() 
    {
    	ArrayList<String> category=new ArrayList<>();
    	try
    	{
    		connectDB();
        	
        	String query="SELECT category.category_name FROM category";
        	rs=statement.executeQuery(query);
        	while(rs.next())
        	{
        		category.add(rs.getString(1));
        	}
        	closeDB();
    	}   	
    	catch (SQLException ex) 
    	{
			ex.printStackTrace();
		}
    	return category;
    }
    
    //Kategorilere Gore Kitap Sayisi Alma
    @Override
    public double categoryKitapSayi(String categoryName)
    {
    	double sayi=0.0;
    	int categoryID=0;
    	ResultSet rsSayi;
    	try
    	{
    		connectDB();
        	
        	String queryCategoryID="SELECT category_id FROM category WHERE category_name='"+categoryName+"'";
        	rs=statement.executeQuery(queryCategoryID);
        	while(rs.next())
        	{
        		categoryID=rs.getInt(1);
        	}
        	
        	String queryCategorySayisi="SELECT COUNT(book.book_category_id) FROM book WHERE book.book_category_id='"+categoryID+"'";
        	rsSayi=statement.executeQuery(queryCategorySayisi);
        	while(rsSayi.next())
        	{
        		sayi=rsSayi.getDouble(1);
        	}

        	closeDB();
    	}   	
    	catch (SQLException ex) 
    	{
			ex.printStackTrace();
		}
    	return sayi;
    	
    }
    
    //Islem Tarihini Alma
    @Override
    public ArrayList<String> getTransactionDate() 
    {
    	ArrayList<String> date=new ArrayList<>();
    	try
    	{
    		connectDB();
        	
        	String query="SELECT transaction_date FROM transaction GROUP BY transaction_date";
        	rs=statement.executeQuery(query);
        	while(rs.next())
        	{
        		date.add(rs.getString(1));
        	}
        	closeDB();
    	}   	
    	catch (SQLException ex) 
    	{
			ex.printStackTrace();
		}
    	return date;
    }
    
    //Hangi tarih de kac tane kitap verildiði ogreniliyor.
    @Override
    public double dateBookCount(String date)
    {
    	double sayi=0.0;
    	
    	try
    	{
    		connectDB();
        	
        	String query="SELECT COUNT(transaction.transaction_id) FROM transaction WHERE transaction_return_status_id='1' AND transaction_date='"+date+"'";
        	rs=statement.executeQuery(query);
        	while(rs.next())
        	{
        		sayi=rs.getInt(1);
        	}

        	closeDB();
    	}   	
    	catch (SQLException ex) 
    	{
			ex.printStackTrace();
		}
    	return sayi;
    	
    }
    
    
    //Kutuphaneci Listeleme
    @Override
    public DefaultTableModel get(String query,String[] baslik) throws SQLException
    {
    	connectDB();
    	rs=statement.executeQuery(query);
    	Object [][]veri;
    	int count=0;
    	rs.last();
		count=rs.getRow();
		veri=new Object[count][8];
		rs.first();
		for(int i=0;i<count;i++)
		{
			 for(int j=0;j<8;j++)
			 veri[i][j]=rs.getObject(j+1);
			 rs.next();
		}
		closeDB();
		return new DefaultTableModel(veri, baslik);
    }
    
    
    
    //veri tabani baglantisi
    private void connectDB()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //String url="jdbc:mysql://localhost:3306/librarymanagement?serverTimezone=UTC";
            String url="jdbc:mysql://localhost:3306/librarymanagement?serverTimezone=UTC";
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
    
    //veri tabani baglantisi kapatma
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
}
