package fr.wildcodeschool.xkcd;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.Schedule;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@ApplicationScoped
@Named
public class XkcdProvider {

    private final static ObjectMapper om = new ObjectMapper();
    private final static String todaysUrl = "https://xkcd.com/info.0.json";
    private Comic todaysComic;


    public XkcdProvider() throws IOException {
        refreshTodaysComic();
    }

    public Comic parseTodaysComic() throws IOException {
        URL url = new URL(todaysUrl);
        try(InputStream is = url.openStream()) {
            Comic comic = om.readValue(is, Comic.class); // I could use url straight away without opening the stream
            return comic;
        }
    }


    @Schedule(hour = "0", minute = "0", second = "0")
    public void refreshTodaysComic() throws IOException {
        this.todaysComic = parseTodaysComic();
    }


    public Comic getTodaysComic() {
        return todaysComic;
    }
}
