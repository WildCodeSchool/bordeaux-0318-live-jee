package fr.wildcodeschool.xkcd;

import java.time.LocalDateTime;

public class UserBean {
    private final String userName;
    private final LocalDateTime signInDate;

    public UserBean(String userName, LocalDateTime signInDate) {
        this.userName = userName;
        this.signInDate = signInDate;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isSignedIn() {
        return userName != null;
    }

    public LocalDateTime getSignInDate() {
        return signInDate;
    }
}
