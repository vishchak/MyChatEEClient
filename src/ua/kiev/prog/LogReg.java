package ua.kiev.prog;

import java.io.IOException;
import java.util.Scanner;

public class LogReg {

    public static Object logReg(Scanner sc) throws IOException {
        String login;
        System.out.println("Enter /log for login, enter /reg for registration");
        String logReg = sc.nextLine();
        if (logReg.equalsIgnoreCase("/log")) {
            login = Login.login(sc);
            while (login.equalsIgnoreCase("password")) {
                login = Login.login(sc);
            }
            return login;
        } else if (logReg.equalsIgnoreCase("/reg")) {
            login = (String) Register.register(sc);
            while (login.equalsIgnoreCase("error")) {
                login = Register.register(sc);
            }
            return login;
        } else {
            System.out.println("Unknown command, try again");
            return null;
        }
    }
}
