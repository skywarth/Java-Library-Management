package siniflar;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public interface AdminController 
{
	public void add(int seviye, String userName,String password, String name, int tcNo, String mail, int phoneNumber, String address) throws SQLException;
	
	public void deletLibrarian(String userName, int tcNo, String name)throws SQLException;
	public void delete(int tcNo,int seviye) throws SQLException;
	public void generateStatistic();
	public DefaultTableModel get(String query,String[] baslik) throws SQLException;
	
	public String Bul(int tcNo,int seviye)throws SQLException;

}
