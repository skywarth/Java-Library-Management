D
public interface LibrarianController {
	  	public void getLibrarianID();
	  	public void setLibrarianID(int librarianID);
	  	
	  	public void getName();
		public void setName(String name);
		
	  	public void getSurName();
	  	public void setSurName(String surName);
	  	
	  	public void getUserName();
	  	public void setUserName(String userName);
	  	
	  	public void getPassword();
	  	public void setPassword(String password);
	  	
	  	public void getBookID();
	  	public void setBookID(int bookID);
	  	
	  	public void getBookName();
	  	public void setBookName(String bookName);
	  	
	  	public void getBookCategory();
	  	public void setBookCategory(String bookCategory);
	  	
	  	public void getBookAuthor();
	  	public void setBookAuthor(String bookAuthor);
	  	
	  	public void getBookPage();
	  	public void setBookPage(int bookPage);
	  	
	  	public void getBookDate();
	  	public void setBookDate(String bookDate);
	  	
	  	public void getUserID();
	  	public void setUserID(int userID);
	  	
	  	public void getDateOfIssue();
	  	public void setDateOfIssue(String dateOfIssue);
	  	
	  	public void getReturnDate();
	  	public void setReturnDate(String returnDate);
	
	    void addBook();
	    void addBookFromFile();
		void chargeFine();
		void getBooks();
		void getBooks(int issueStatusId);
		void getOutDatedBooks();
		void issueBook();
		void returnBook();
}
