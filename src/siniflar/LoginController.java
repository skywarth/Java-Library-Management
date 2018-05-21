package siniflar;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import LoginModülü.Login;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import KutuphaneciModul.Kutuphaneci;
import YoneticiModul.Yonetici;

public class LoginController{
	private java.sql.Connection connection;
	private Statement statement;
	private ResultSet rs;
	public int KutuphaneciTC;
	
	
	public void  Login(String kullaniciAdi,String parola)
	{
		 try {
		 		Class.forName("com.mysql.jdbc.Driver");
		 		String url="jdbc:mysql://localhost:3306/librarymanagement?serverTimezone=UTC";
		 		connection = DriverManager.getConnection(url, "root", "1234");
		 		statement= connection.createStatement();
	         
	         String sql = "SELECT user.user_access_level_id FROM user WHERE user_username='"+kullaniciAdi+"'and user_password='"+parola+"'";
	         String seviye="";
	         
	         String queryLibTC="SELECT user.user_tc FROM user WHERE user.user_username='"+kullaniciAdi+"'AND user.user_password='"+parola+"' AND user.user_access_level_id='2'";
	         ResultSet rsLibTC;
	         rsLibTC=statement.executeQuery(queryLibTC);
	         while(rsLibTC.next())
	         {
	        	 KutuphaneciTC=rsLibTC.getInt(1);
	         }
	         
			rs=statement.executeQuery(sql);
	         while(rs.next())
	         {
	        	  seviye=rs.getString(1);
	     
	         }
	         if(seviye.equals("2"))
	         {
	        	 JOptionPane.showMessageDialog(null, "Login Successfuly..");
	        
	          	Kutuphaneci librarian = new Kutuphaneci();
	     		librarian.setVisible(true);
	     		
	         }
	         else if(seviye.equals("1"))
	         {
	        	 JOptionPane.showMessageDialog(null, "Login Successfuly..");
		           	Yonetici admin = new Yonetici();
		          
					admin.frameYonetici.setVisible(true);
				
	         }
	    
	         else
	      	   JOptionPane.showMessageDialog(null, "Incorrect username and Password...");
	         
	         	
	         connection.close();
	         } 
	  	   
	  	   catch (Exception ex){
	             System.out.println(ex);
	         } 
	

	}
	public void LogOut()
	{
		Login giriseDon=new Login();
		giriseDon.setVisible(true);
		
	}

}

