 public interface UserControler
{
		public void getTCNo();
		public void setTCNo(String TCNo)
		
		public void getName();
		public void setName(String name);
		
		public void getSurName();
		public void setSurName(String surName);
		
		public void getUserName();
		public void setUserName(String userName);
		
		public void getPassword();
		public void setPassword(String password);
		
		public void getDept();
		public void setDept(double dept);
		
		
		void getBooks();

		void getBooks(int issueStatusId);
		
		void getBooks(String searchQuery);

		void getSelfIssuedBooks();

}
