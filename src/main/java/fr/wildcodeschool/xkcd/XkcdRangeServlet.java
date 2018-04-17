package fr.wildcodeschool.xkcd;


import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/xkcd/range"})
public class XkcdRangeServlet extends HttpServlet {

    public static final int MAX_COMICS = 20;

    @Inject
    private XkcdProvider provider;
    @Inject
    private ObjectMapper om;

    // The user is supposed to type http://localhost:8080/live_jee/xkcd/range?start=123&end=456
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int start = Integer.parseInt(req.getParameter("start"));
        int end = Integer.parseInt(req.getParameter("end"));

        int amount = Math.abs(end - start) + 1;
        if(amount > MAX_COMICS) {
            String message = String.format("No more than %s comics! Be nice on the API!", MAX_COMICS);
            resp.sendError(HttpServletResponse.SC_REQUEST_ENTITY_TOO_LARGE, message);
        }
        else {
            List<Comic> comics = provider.getComicRange(start, end);
            //om.writeValue(resp.getOutputStream(), comics); // output as json
            req.setAttribute("range", comics);
            req.getRequestDispatcher("/range.jsp").forward(req, resp);
        }
    }
}
