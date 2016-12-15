package example.com.moviesapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MoviesActivity extends AppCompatActivity implements OnWorkCompletedListener {

    private String link = "http://www.omdbapi.com/?s=";
    private ListView listView;
    private ProgressBar progressBar;
    private TextView emptyTextView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        String movie = getIntent().getStringExtra(MainActivity.MOVIE_NAME_TO_SEARCH);

        final String search = link + movie;

        new GetMoviesThread(this, search).start();

        handler = new Handler();

        listView = (ListView) findViewById(R.id.list_view);
        progressBar = (ProgressBar) findViewById(R.id.activity_movies_progress_bar);
        emptyTextView = (TextView) findViewById(R.id.activity_movies_empty_text_view);

    }

    @Override
    public void onSuccess(final ArrayList<Movie> movies) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                MoviesAdapter adapter = new MoviesAdapter(MoviesActivity.this, movies);
                listView.setEmptyView(emptyTextView);
                listView.setAdapter(adapter);
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public void onError(final String error) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MoviesActivity.this, error, Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }
}
