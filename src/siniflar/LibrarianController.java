package siniflar;

import java.sql.SQLException;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

public interface LibrarianController {
	  	public int getLibrarianID();
	  	public void setLibrarianID(int librarianID);
	  	
	  	public String getName();
		public void setName(String name);
		
	  	
	  	
	  	public String getUserName();
	  	public void setUserName(String userName);
	  	
	  	public String getPassword();
	  	public void setPassword(String password);
	  	
	  	public int getBookID();
	  	public void setBookID(int bookID);
	  	
	  	public String getTitle();
	  	public void setTitle(String bookName);
	  	
	  	public String getBookCategory();
	  	public void setBookCategory(String bookCategory);
	  	
	  	public String getBookAuthor();
	  	public void setBookAuthor(String bookAuthor);
	  	
	  	public int getBookPage();
	  	public void setBookPage(int bookPage);
	  	
	  	public Date getBookDate();
	  	public void setBookDate(Date bookDate);
	  	
	  	public int getUserID();
	  	public void setUserID(int userID);
	  	
	  	public Date getDateOfIssue();
	  	public void setDateOfIssue(Date dateOfIssue);
	  	
	  	public Date getReturnDate();
	  	public void setReturnDate(Date returnDate);
	
	  	public void addBook(int bookId,int issueStatusId, String title, String bookCategory, String bookAuthor, int bookPage, Date bookDate);
	  	public void addBookFromFile(String fileName);
		
	  	public DefaultTableModel getBooks(String query,String[] baslik)throws SQLException;
		
		public void getOutDatedBooks();
		public void issueBooks(int librarianID, int userID, int bookID, Date dateOfIssue);
		public void returnBook(String librarianID, String userID, String bookID, Date returnDate);
}
