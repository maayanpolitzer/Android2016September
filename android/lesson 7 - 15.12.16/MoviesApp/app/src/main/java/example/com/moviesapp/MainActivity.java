package example.com.moviesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.EventLog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String MOVIE_NAME_TO_SEARCH = "movie";
    private int lastCharEntered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText searchEditText = (EditText) findViewById(R.id.activity_main_movie_edit_text);

        /*
        // NOT WORKING ON A VIRTUAL KEYBOARD!!!
        // prevent the user from typing twice SPACE button...
        searchEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.d("Maayan", keyCode + "");
                if (event.getAction() == KeyEvent.ACTION_DOWN) {

                    if (lastCharEntered == 62 && keyCode == 62){
                        return true;
                    }
                    lastCharEntered = keyCode;
                    return false;
                }else{
                    return true;
                }
            }
        });
        */




        findViewById(R.id.activity_main_search_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String movieName = searchEditText.getText().toString().trim();
                if (!movieName.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, MoviesActivity.class);
                    intent.putExtra(MOVIE_NAME_TO_SEARCH, movieName.replace(" ", "+"));
                    startActivity(intent);
                } else {
                    searchEditText.setError("Please enter movie name...");
                }
            }
        });
    }
}
