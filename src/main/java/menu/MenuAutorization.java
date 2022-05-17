package menu;

import input.IInput;
import users.Buyer;
import users.IBuyer;
import users.IUser;

import static main.Main.*;

public class MenuAutorization {

    public static IBuyer autorization(IInput input) {
        IBuyer buyer = null;
        output.print("Введите логин");
        String login = input.getString();
        IUser testUser = new Buyer(login);
        if (testUser.hasLogin(login)) {
            while (true) {
                output.print("Введите пароль");
                String password = input.getString();
                testUser = new Buyer(login, password);
                if (testUser.hasPassword(login, password)) {
                    buyer = (IBuyer) testUser;
                    return buyer;
                } else {
                    output.print("Пароль введен неверно");
                    if (exitToMainMenu()) {
                        break;
                    }
                }
            }
        }
        return buyer;
    }
}
