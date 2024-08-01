package Entity;

public class loginEntity {
    
    private String username ;
    private String password ;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public loginEntity() {
    }
    public loginEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    public String toString() {
        return "loginEntity [username=" + username + ", password=" + password + "]";
    }


    

}
