import javax.swing.*;

public class Librarian extends BaseUser implements LibrarianController
{
    private int librarianID;
    private String name;
    private String surName;
    private String userName;
    private String password;
    private int bookID;
    private String title;
    private String bookCategory;
    private String bookAuthor;
    private int bookPage;
    private String bookDate;
    private int userID;
    private String dateOfIssue;
    private String returnDate;

    public int getLibrarianID() {
        return librarianID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurName() {
        return surName;
    }

    @Override
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

    public String getBookName() {
        return bookName;
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

    public String getBookDate() {
        return bookDate;
    }

    public int getUserID() {
        return userID;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setLibrarianID(Stintring librarianID) {
        this.librarianID = librarianID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
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

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    protected void  addBook(int bookID, String bookName, String bookCategory, String bookAuthor, int bookPage, String bookDate )
    {
        //Kitap ekleme yeri
    }

    protected void addBookFromFile(String FileName)
    {
        //Dosyadan kitap ekleme yeri
    }
    protected  void issueBooks(int librarianID, int userID, int bookID, String dateOfIssue, String returnDate)
    {
        //kitap Ã¶dÃ¼nÃ§ verme
    }
    protected void getBooks()
    {
        //bÃ¼tÃ¼n ve raflardaki kitaplarÄ± gÃ¶sterme
    }

    private void chargeFine()
    {

    }
    protected  void getBooks(String issueStatusId)
    {
        //Ã¶dÃ¼nÃ§ verilen gÃ¶sterilen kitaplarÄ± gÃ¶sterme
    }
    protected void getOutDatedBooks()
    {
        //tarihi geÃ§en kitaplarÄ± gÃ¶sterme
    }

    protected void returnBook(String librarianID, String userID, String bookID, String returnDate)
    {
        //kitap geri alma
    }

    protected void Login()
    {
        if ((userName=="halil")&&(password=="123"))
        {
            JOptionPane.showMessageDialog(null, "GiriÅŸ YapÄ±ldÄ±", "MESAJ", -1);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Kullanici Adi veya Parola YanlÄ±ÅŸ.", "HATALI GÄ°RÄ°Å�", -1);
        }
    }
}
