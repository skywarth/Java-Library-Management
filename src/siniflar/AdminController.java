package siniflar;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public interface AdminController 
{
	public void add(int seviye, String userName,String password, String name, int tcNo, String mail, int phoneNumber, String address) throws SQLException;
	public void delete(int tcNo,int seviye) throws SQLException;
	public DefaultTableModel get(String query,String[] baslik) throws SQLException;
	public String Bul(int tcNo,int seviye)throws SQLException;
	
	public ArrayList<String> getCategoryNames();
	public double categoryKitapSayi(String categoryName);
	
	public ArrayList<String> getTransactionDate();
	public double dateBookCount(String date);

}
