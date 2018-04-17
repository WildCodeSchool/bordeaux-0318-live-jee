package fr.wildcodeschool.xkcd;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;

@ApplicationScoped
public class AuthenticationManager {

    /**
     * Authentication mock
     * @param userName
     * @param password
     * @return
     */
    public UserBean auth(String userName, String password) {

        boolean logged = "wilder".equals(userName) && "tata18$".equals(password);
        if(logged) {
            return new UserBean(userName, LocalDateTime.now());
        }
        else {
            return null;
        }
    }
}
