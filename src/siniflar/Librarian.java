package siniflar;

import java.util.Date;

public class Librarian extends BaseUser implements LibrarianController
{
    private int librarianID;
    private String name;
  
    private String userName;
    private String password;
    private int bookID;
    private String title;
    private String bookCategory;
    private String bookAuthor;
    private int bookPage;
    private Date bookDate;
    private int userID;
    private Date dateOfIssue;
    private Date returnDate;

    public int getLibrarianID() {
        return librarianID;
    }

    @Override
    public String getName() {
        return name;
    }


    public String getUserName() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getBookPage() {
        return bookPage;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public int getUserID() {
        return userID;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setLibrarianID(int librarianID) {
        this.librarianID = librarianID;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookPage(int bookPage) {
        this.bookPage = bookPage;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
    public void  addBook(int bookId,int issueStatusId, String title, String bookCategory, String bookAuthor, int bookPage, Date bookDate )
    {
        //Kitap ekleme yeri
    }

    public void addBookFromFile(String fileName)
    {
        //Dosyadan kitap ekleme yeri
    }
    public  void issueBooks(int librarianID, int userID, int bookID, Date dateOfIssue)
    {
        //kitap Ã¶dÃ¼nÃ§ verme
    }
    public void getBooks()
    {
        //bÃ¼tÃ¼n ve raflardaki kitaplarÄ± gÃ¶sterme
    }

    private void chargeFine()
    {

    }
    public  void getBooks(int issueStatusId)
    {
        //Ã¶dÃ¼nÃ§ verilen gÃ¶sterilen kitaplarÄ± gÃ¶sterme
    }
    public void getOutDatedBooks()
    {
       
    }

    public void returnBook(String librarianID, String userID, String bookID, Date returnDate)
    {
        //kitap geri alma
    }

    public void Login()
    {
     
    }
}
