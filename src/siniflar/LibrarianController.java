package siniflar;
public interface LibrarianController {
	  	public int getLibrarianID();
	  	public void setLibrarianID(int librarianID);
	  	
	  	public String getName();
		public void setName(String name);
		
	  	public String getSurName();
	  	public void setSurName(String surName);
	  	
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
	  	
	  	public String getBookDate();
	  	public void setBookDate(String bookDate);
	  	
	  	public int getUserID();
	  	public void setUserID(int userID);
	  	
	  	public String getDateOfIssue();
	  	public void setDateOfIssue(String dateOfIssue);
	  	
	  	public String getReturnDate();
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
