package siniflar;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	try {
		        
	           Class.forName("com.mysql.jdbc.Driver");
	           String url="jdbc:mysql://localhost:3306/librarymanagement?serverTimezone=UTC";
	           Connection con = DriverManager.getConnection(url, "root", "");
	           Statement stmt = con.createStatement();
	           
	           String sql = "SELECT * FROM user WHERE user_username='"+kullaniciAdi+"'and user_password='"+parola+"'";
	           
	           ResultSet rs=stmt.executeQuery(sql);
	           if(rs.next())
	           {
	        	JOptionPane.showMessageDialog(null, "Login Successfuly..");
	           	Yonetici admin = new Yonetici();
				admin.frameYonetici.setVisible(true);
	    	   }
				
	           else
	        	   JOptionPane.showMessageDialog(null, "Incorrect username and Password...");
	        	   
	         
	           con.close();
	           } 
	    	   
	    	   catch (Exception ex){
	               System.out.println(ex);
	           }	
    }
    
    //Kutuphaneci Ekleme
    @Override
    public void addLibrarian(int seviye, String userName,String password, String name, int tcNo, String mail, int phoneNumber, String address) throws SQLException
    {
    	connectDB();
		statement.executeUpdate("INSERT INTO librarymanagement.user(user_access_level_id,user_username,user_password,user_name,user_tc,user_email,user_phone_number,user_address) VALUES ('"+seviye+"','"+userName+"','"+password+"','"+name+"','"+tcNo+"','"+mail+"','"+phoneNumber+"','"+address+"')");
		closeDB();
    }
    
    //User Ekleme
    @Override
    public void addUser(int seviye, String userName,String password, String name, int tcNo, String mail, int phoneNumber, String address) throws SQLException
    {
    	connectDB();
		statement.executeUpdate("INSERT INTO librarymanagement.user(user_access_level_id,user_username,user_password,user_name,user_tc,user_email,user_phone_number,user_address) VALUES ('"+seviye+"','"+userName+"','"+password+"','"+name+"','"+tcNo+"','"+mail+"','"+phoneNumber+"','"+address+"')");
		closeDB();
    }
    
    //Kutuphaneci Silme
    @Override
    public void deletLibrarian(String userName, int tcNo, String name) throws SQLException
    {
    	connectDB();
		statement.executeUpdate("DELETE FROM librarymanagement.user WHERE (user.user_username='"+userName+"' AND user.user_tc='"+tcNo+"' AND user.user_name='"+name+"')");
		closeDB();
    }
    
    //Silme Gosterme
    @Override
    public String silBilgiGoster(String userName, int tcNo, String name)throws SQLException
    {
    	connectDB();
    	String cumle="";
    	String query="SELECT access_level.access_level_description,user.user_username,user.user_password,user.user_name,user.user_tc,user.user_email,user.user_phone_number,user.user_address FROM librarymanagement.user INNER JOIN librarymanagement.access_level ON user.user_access_level_id=access_level.access_level_id WHERE (user.user_username='"+userName+"' AND user.user_tc='"+tcNo+"' AND user.user_name='"+name+"')";
    	rs=statement.executeQuery(query);
    	while(rs.next())
    	{
    		cumle=rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8);
    	}
    	closeDB();
    	
    	return cumle;
    }
    
    // User Silme
    @Override
    public void deleteUser(String userName, int tcNo, String name) throws SQLException
    {
    	connectDB();
		statement.executeUpdate("DELETE FROM librarymanagement.user WHERE (user.user_username='"+userName+"' AND user.user_tc='"+tcNo+"' AND user.user_name='"+name+"')");
		closeDB();
    }
    public void generateStatistic()
    {

    }
    
    //Kutuphaneci Listeleme
    @Override
    public DefaultTableModel getLibrarians(String query,String[] baslik) throws SQLException
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
    
    //Users Listeleme
    @Override
    public DefaultTableModel getUsers(String query,String[] baslik)throws SQLException
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
