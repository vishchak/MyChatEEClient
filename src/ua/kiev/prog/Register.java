package ua.kiev.prog;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Register {
    public static String register(Scanner sc) throws IOException {
        System.out.println("Create new login");
        String login = sc.nextLine();
        System.out.println("Create new password");
        String password = sc.nextLine();
        URL registerUrl = new URL(Utils.getURL() + "/reg?login=" + login + "&password=" + password);
        HttpURLConnection registerConnection = (HttpURLConnection) registerUrl.openConnection();
        registerConnection.setRequestMethod("POST");
        registerConnection.setDoOutput(true);
        int registerResponse = registerConnection.getResponseCode();
        if (registerResponse == 200) {
            System.out.println("You have successfully registered!");
            return login;
        } else if (registerResponse == 409) {
            System.out.println("Login is already in use, try another one!");
            return "error";
        }
        return null;
    }
}
