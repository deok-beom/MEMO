public class User {
    private String userID;
    private String name;
    private String password;

    public User(String userID, String name, String password) {
        this.userID = userID;
        this.name = "✒" + name;
        this.password = password;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword() {
        this.password = password;
    }
}
