package siniflar;
public interface UserControler
{
        public String getTCNo();
        public void setTCNo(String TCNo);

        public int getUserId();
        public void setUserId(String userId);

        public String getName();
        public void setName(String name);



        public String getUserName();
        public void setUserName(String userName);

        public String getPassword();
        public void setPassword(String password);

        public double getDebt();
        public void setDebt(double debt);


        void getBooks();

        void getBooks(int issueStatusId);

        void getBooks(String searchQuery);

        void getSelfIssuedBooks();

}