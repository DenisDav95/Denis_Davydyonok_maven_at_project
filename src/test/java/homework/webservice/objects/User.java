package homework.webservice.objects;

import java.util.Objects;

public class User {

    int id;
    String username;
    String realname;
    String password;
    String email;

    public User(int id, String username, String realName, String password, String email) {
        this.id = id;
        this.username = username;
        this.realname = realName;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realname;
    }

    public void setRealName(String realName) {
        this.realname = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User data = (User) o;
        return id == data.id && username.equals(data.username) && realname.equals(data.realname) && password.equals(data.password) && email.equals(data.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, realname, password, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realName='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
