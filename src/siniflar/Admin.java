package siniflar;

public class Admin extends BaseUser implements AdminController
{
    private String TCNo;
    private String name;
    private String userName;
 
    private String password;
    private int adminId;

    public Admin(String TCNo, String name, String userName, String password) {
        this.TCNo = TCNo;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public Admin()
    {
         this.TCNo = "---";
         this.name = "---";

         this.userName = "---";
         this.password = "---";
    }

    public String getTCNo() {
        return TCNo;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void Login()
    {

    }

    public void addLibrarian()
    {
        //Kütüphaneci ekleme
    }
    public void addUser()
    {
        //user ekleme
    }
    public void deletLibrarian()
    {
        //kütüphaneci silme
    }
    public void deleteUser()
    {
        //user silme
    }
    public void generateStatistic()
    {

    }
    public void getLibrarians()
    {

    }
    public void getUsers()
    {

    }
}
