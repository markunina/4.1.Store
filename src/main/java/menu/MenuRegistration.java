package menu;

import input.IInput;
import users.Buyer;
import users.IBuyer;
import users.IUser;

import static main.Main.*;

//Liskov substitution principle - класс Buyer исполняет роль IUser(строка 17)
public class MenuRegistration {

    public static IBuyer registration(IInput input){
        IBuyer buyer = null;
        output.print("Придумайте логин");
        String login = input.getString();
        IUser testUser = new Buyer(login);
        if (testUser.hasLogin(login)) {
            output.print("Такой логин уже есть");
        } else {
            while (true) {
                output.print("Придумайте пароль");
                String password = input.getString();
                if (testUser.isSetPassword(password)) {
                    output.print("Учетная запись создана");
                    buyer = (IBuyer) testUser;
                    break;
                }
                output.print("Пароль слишком короткий:");
                if (exitToMainMenu()) {
                    break;
                }
            }
        }
        return buyer;
    }

}
