abstract public class BaseUser
{
    private String TCNo;
    private String name;
    private String surName;
    private String userName;
    private String password;

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

    abstract protected void Login();
}
