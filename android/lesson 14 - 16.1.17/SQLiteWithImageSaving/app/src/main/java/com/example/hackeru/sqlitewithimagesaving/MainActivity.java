package com.example.hackeru.sqlitewithimagesaving;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.hackeru.sqlitewithimagesaving.infrastructure.DBOpenHelper;
import com.example.hackeru.sqlitewithimagesaving.infrastructure.DataSource;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ContactsCursorAdapter adapter;
    private static final int EDITOR_ACTIVITY_REQUEST_CODE = 1;
    private DataSource dbConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list_view);
        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                //intent.putExtra(ACTION, ADD);
                startActivityForResult(intent, EDITOR_ACTIVITY_REQUEST_CODE);
            }
        });

        dbConnection = new DataSource(this);

        adapter = new ContactsCursorAdapter(this, dbConnection.getData());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == EDITOR_ACTIVITY_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                adapter.changeCursor(dbConnection.getData());
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Clicked contact: position: " + position + ", id: " + id, Toast.LENGTH_LONG).show();
        // start activity editor with clicked contact data...
        //Intent intent = new Intent(this, EditorActivity.class);
        //intent.putExtra(ACTION, EDIT);
        //startActivityForResult(intent, EDITOR_ACTIVITY_REQUEST_CODE);
    }
}
