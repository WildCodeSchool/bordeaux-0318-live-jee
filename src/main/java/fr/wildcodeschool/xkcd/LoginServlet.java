package fr.wildcodeschool.xkcd;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Inject
    private AuthenticationManager am;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("login");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        UserBean userBean = am.auth(userName, password);
        if(userBean != null) { // user is signed in
            session.setAttribute("userBean", userBean);
            req.getRequestDispatcher("/xkcd").forward(req, resp);
        }
        else {
            session.invalidate();
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
