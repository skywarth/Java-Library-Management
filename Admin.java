import javax.swing.JOptionPane;

public class Admin  extends BaseUser iplements AdminController
{
	private String TCNo;
    private String name;
    private String surName;
    private String userName;
    private String password;
    private int adminId;
    
    public Admin(String TCNo, String name, String surName, String userName, String password) {
        this.TCNo = TCNo;
        this.name = name;
        this.surName = surName;
        this.userName = userName;
        this.password = password;
    }
    
    public Admin()
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
        if ((userName=="halil")&&(password=="123"))
        {
            JOptionPane.showMessageDialog(null, "GiriÅŸ YapÄ±ldÄ±", "MESAJ", -1);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Kullanici Adi veya Parola YanlÄ±ÅŸ.", "HATALI GÄ°RÄ°Å�", -1);
        }
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
