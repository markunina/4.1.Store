package users;

public interface IUser {

    boolean hasLogin(String login);
    boolean hasPassword(String login, String password);
    boolean isSetPassword(String password);

}
