package business.entities;

public class User {

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    int user_id; // just used to demo retrieval of autogen keys in UserMapper
    String email;
    String password; // Should be hashed and secured
    String role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

}
