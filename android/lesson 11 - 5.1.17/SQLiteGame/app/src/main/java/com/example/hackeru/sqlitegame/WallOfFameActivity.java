package com.example.hackeru.sqlitegame;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class WallOfFameActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_of_fame);

        ListView listView = (ListView) findViewById(R.id.activity_wall_of_fame_list_view);

        Cursor cursor = new DataSource(this).getAllData();
        if (cursor != null && cursor.getCount() > 0) {
            ScoresAdapter adapter = new ScoresAdapter(this, cursor);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
        }else{
            Toast.makeText(this, "No data to display", Toast.LENGTH_LONG).show();
        }
        /*
        ArrayList<Score> scores = new ArrayList<>();
        ArrayAdapter<Score> adapter = new ArrayAdapter<Score>(this, android.R.layout.simple_list_item_1, scores);
        */

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // delete from arrayList.remove(position);
        // delete from db.delete(id);
        // update adapter.
    }
}
