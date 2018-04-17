package fr.wildcodeschool.xkcd;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/", "/today", "/xkcd"})
public class XkcdServlet extends HttpServlet {

    @Inject
    private XkcdProvider provider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imgUrl = provider.getTodaysComic().getImg();
        req.setAttribute("todaysComicUrl", imgUrl);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
