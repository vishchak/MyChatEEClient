package ua.kiev.prog;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user = User.getInstance();
        Scanner scanner = new Scanner(System.in);
        try {
            String login = (String) LogReg.logReg(scanner);
            if (login == null) {
                System.exit(1);
            } else {
                user.setLogin(login);
                Thread th = new Thread(new GetThread());
                th.setDaemon(true);
                th.start();

                System.out.println("Who do you want to send a message to? (Leave blank to send everyone)");
                String to = scanner.nextLine();

                while (true) {
                    System.out.println("Enter your message: ");
                    String text = scanner.nextLine();
                    if (text.isEmpty()) break;

                    Message m = new Message(login, to, text);
                    int res = m.send(Utils.getURL() + "/add");

                    if (res != 200) { // 200 OK
                        System.out.println("HTTP error occurred: " + res);
                        return;
                    }
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}

