package fr.wildcodeschool.xkcd;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@ApplicationScoped
@Named
public class XkcdProvider {

    @Inject
    private ObjectMapper om;

    private final static String todaysUrl = "https://xkcd.com/info.0.json";
    private Comic todaysComic;


    @PostConstruct
    private void postConstruct() {
        try {
            refreshTodaysComic();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Comic parseTodaysComic() throws IOException {
        URL url = new URL(todaysUrl);
        Comic comic = om.readValue(url, Comic.class);
        return comic;
    }


    @Schedule(hour = "0", minute = "0", second = "0")
    public void refreshTodaysComic() throws IOException {
        this.todaysComic = parseTodaysComic();
    }


    public Comic getTodaysComic() {
        return todaysComic;
    }

    // http://xkcd.com/614/info.0.json
    public List<Comic> getComicRange(int start, int end) {
        if(start > end) {
            int tmp = start;
            start = end;
            end = tmp;
        }

        List<Comic> comics = new ArrayList<>();

        for(int c = start; c <= end; c++) {
            try {
                URL url = new URL("https://xkcd.com/" + c + "/info.0.json");
                log.info("Parsing: " + url);

                Comic comic = om.readValue(url, Comic.class);
                comics.add(comic);
            }
            catch (IOException e) {
                log.warn(e.getMessage(), e);
            }
        }
        return comics;
    }
}
