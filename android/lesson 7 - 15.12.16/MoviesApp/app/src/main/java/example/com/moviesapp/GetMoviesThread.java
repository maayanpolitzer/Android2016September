package example.com.moviesapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by hackeru on 12/15/2016.
 */

public class GetMoviesThread extends Thread {

    private String link;
    private OnWorkCompletedListener listener;

    public GetMoviesThread(OnWorkCompletedListener listener, String link){
        this.listener = listener;
        this.link = link;
    }

    @Override
    public void run() {
        String data = getData();
        if (data != null){
            extractMoviesFromString(data);
        }
    }

    private void extractMoviesFromString(String data){
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(data);
            JSONArray arr = obj.getJSONArray("Search");
            for (int i = 0; i < arr.length(); i++){
                movies.add(new Movie(arr.getJSONObject(i)));
            }
            listener.onSuccess(movies);
        } catch (JSONException e) {
            e.printStackTrace();
            listener.onError(e.getMessage());
        }
    }

    private String getData() {
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder(); // better than make += to a String.
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (MalformedURLException e) {
            // something is wrong with the link... (no http:// - for example)...
            Log.e("Maayan", e.getMessage());
            Log.d("Maayan", "BIG PROBLEM!!!!!");
            listener.onError("URL problem...");
        } catch (IOException e) {
            // input/output problems... like no harddisk or no internet connection...
            // inform the user that there is NO internet...
            listener.onError("No internet, please try again later...");
        }
        return null;
    }

}
