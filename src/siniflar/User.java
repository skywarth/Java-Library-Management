package siniflar;
import javax.swing.*;

public class User extends BaseUser implements UserController
{
    private String TCNo;
    private String name;
    private int userId;
    private String userName;
    private String password;
    private double debt;

    public double getDebt() {
        return debt;
    }
    @Override
    public void setDebt(double debt) 
    {

    }
    public User(int userId,String TCNo, String name,  String userName, String password) {
        this.TCNo = TCNo;
        this.name = name;

        this.userName = userName;
        this.password = password;
    }


    public int getUserId() {
        return userId;
    }
    public void setUserId(String TCNo) {

    }
    public String getTCNo() {
        return TCNo;
    }
    public void setTCNo(String TCNo) {

    }


    public String getName() {
        return name;
    }
    public void setName(String name) {

    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {

    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {

    }

    protected void Login()
    {
 
    }

    public void getBooks()
    {
        //Kitap Alma
    }
    public void getBooks(int issueStatusId)
    {
        //Raflardaki ve Ã¶dÃ¼nÃ§ verilen kitaplar
    }
    public void getBooks(String searchQuery)
    {
        //Kitap arama
    }
    public void getSelfIssuedBooks()
    {
        //Kendisine ait ÅŸuan ve Ã¶nceki kitaplar
    }
}
