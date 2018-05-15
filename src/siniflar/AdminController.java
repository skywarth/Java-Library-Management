package siniflar;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public interface AdminController 
{
	public void addLibrarian(int seviye, String userName,String password, String name, int tcNo, String mail, int phoneNumber, String address) throws SQLException;
	public void addUser(int seviye, String userName,String password, String name, int tcNo, String mail, int phoneNumber, String address) throws SQLException;
	public void deletLibrarian(String userName, int tcNo, String name)throws SQLException;
	public void deleteUser(String userName, int tcNo, String name) throws SQLException;
	public void generateStatistic();
	public DefaultTableModel getLibrarians(String query,String[] baslik) throws SQLException;
	public DefaultTableModel getUsers(String query,String[] baslik)throws SQLException;
	public String silBilgiGoster(String userName, int tcNo, String name)throws SQLException;

}
