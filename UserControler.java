 public interface UserControler
{

    void getBooks();

    void getBooks(int issueStatusId);

    void getBooks(String searchQuery);

    void getSelfIssuedBooks();

}
