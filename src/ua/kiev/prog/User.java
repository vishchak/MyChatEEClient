package ua.kiev.prog;

public class User {
    private static final User user = new User();
    private String login;
    private String chatRoom;

    public static User getInstance() {
        return user;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }


}
