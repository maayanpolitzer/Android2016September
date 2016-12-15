package example.com.moviesapp;


import org.json.JSONException;
import org.json.JSONObject;

public class Movie {
    private String title;
    private String poster;
    private String year;
    private String id;

    public Movie(String title, String poster, String year, String id) {
        this.title = title;
        this.poster = poster;
        this.year = year;
        this.id = id;
    }

    public Movie(JSONObject obj) throws JSONException {
        title = obj.getString("Title");
        poster = obj.getString("Poster");
        id = obj.getString("imdbID");
        year = obj.getString("Year");
    }

    @Override
    public String toString() {
        return id + ": " + title + ", " + year;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getYear() {
        return year;
    }

    public String getId() {
        return id;
    }
}
