package users;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Open-Closed Principle, класс User наследуется классом Buyer
public class User implements IUser{

    protected final String login;
    protected String password;

    protected static List<IUser> users = new ArrayList<>();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login) {
        this.login = login;
        this.password = "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login);
    }

    public boolean hasLogin(String login){
        return users.stream().filter(o -> o.equals(new User(login,""))).findFirst().isPresent();
    }

    public boolean hasPassword(String login, String password){
        return users.stream().filter(o -> o.equals(new User(login,password))).findFirst().isPresent();
    }

    public boolean isSetPassword(String password){
        if(password.length() >= 8){
            this.password = password;
            return true;
        }
        return false;
    }

}
