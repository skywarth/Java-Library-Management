package siniflar;
public interface UserControler
{
		public String getTCNo();
		public void setTCNo(String TCNo);
		
		public String getName();
		public void setName(String name);
		
		public String getSurName();
		public void setSurName(String surName);
		
		public String getUserName();
		public void setUserName(String userName);
		
		public String getPassword();
		public void setPassword(String password);
		
		public Double getDept();
		public void setDept(double dept);
		
		
		void getBooks();

		void getBooks(int issueStatusId);
		
		void getBooks(String searchQuery);

		void getSelfIssuedBooks();

}
