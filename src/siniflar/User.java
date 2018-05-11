
package siniflar;
import javax.swing.*;

public class User extends BaseUser implements UserControler
{
    private String TCNo;
    private String name;
    private String surName;
    private String userName;
    private String password;
    private double debt;

    public double getDebt() {
        return debt;
    }

    public User(String TCNo, String name, String surName, String userName, String password) {
        this.TCNo = TCNo;
        this.name = name;
        this.surName = surName;
        this.userName = userName;
        this.password = password;
    }

    public User()
    {
        this.TCNo = "---";
        this.name = "---";
        this.surName = "---";
        this.userName = "---";
        this.password = "---";
    }

    public String getTCNo() {
        return TCNo;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
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
        //Raflardaki ve ödünç verilen kitaplar
    }
    public void getBooks(String searchQuery)
    {
        //Kitap arama
    }
    public void getSelfIssuedBooks()
    {
        //Kendisine ait şuan ve önceki kitaplar
    }
}
