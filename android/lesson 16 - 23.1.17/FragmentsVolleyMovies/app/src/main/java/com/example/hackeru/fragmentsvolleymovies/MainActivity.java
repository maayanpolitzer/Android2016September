package com.example.hackeru.fragmentsvolleymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String SEARCH = "search";

    private EditText searchEditText;
    private Button searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = (EditText) findViewById(R.id.activity_main_edit_text);
        searchBtn = (Button) findViewById(R.id.activity_main_search_button);

        searchBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == searchBtn){
            Intent intent = new Intent(this, ResultsActivity.class);
            intent.putExtra(SEARCH, searchEditText.getText().toString());
            startActivity(intent);
        }
    }
}
