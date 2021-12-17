package ua.kiev.prog;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Login {
    public static String login(Scanner sc) throws IOException {
        System.out.println("Enter your login");
        String login = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();
        URL loginUrl = new URL(Utils.getURL() + "/log?login=" + login + "&password=" + password);
        HttpURLConnection loginConnection = (HttpURLConnection) loginUrl.openConnection();
        loginConnection.setRequestMethod("POST");
        loginConnection.setDoOutput(true);
        int loginResponse = loginConnection.getResponseCode();
        if (loginResponse == 200) {
            System.out.println("You have logged in as " + login);
            return login;
        } else if (loginResponse == 401) {
            System.out.println("Wrong password! Try again!");
            return "password";
        } else if (loginResponse == 403) {
            System.out.println(login + " is not registered yet");
            return "register";
        }
        return null;
    }
}
