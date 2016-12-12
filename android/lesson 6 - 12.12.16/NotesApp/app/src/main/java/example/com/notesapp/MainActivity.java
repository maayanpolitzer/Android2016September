package example.com.notesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    public static final int REQUEST_ADD = 1;
    public static final int REQUEST_EDIT = 2;
    public static final String ACTION = "action";
    public static final String NOTE_TITLE = "note title";
    public static final String NOTE_CONTENT = "note content";
    public static final String POSITION = "position";

    private ArrayList<Note> notesList;
    private ArrayAdapter<Note> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesList = new ArrayList<>();

        notesList.add(new Note("note 1", "note 1 content"));
        notesList.add(new Note("note 2", "note 2 content"));
        notesList.add(new Note("note 3", "note 3 content"));

        ListView listView = (ListView) findViewById(R.id.list_view);
        adapter = new ArrayAdapter<Note>(this, android.R.layout.simple_list_item_1, notesList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        Button addNoteBtn = (Button) findViewById(R.id.add_note_button);
        addNoteBtn.setOnClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        goToEditorActivity(position, REQUEST_EDIT);
    }

    @Override
    public void onClick(View v) {
        goToEditorActivity(-1, REQUEST_ADD);
    }

    private void goToEditorActivity(int position, int requestCode){
        Intent intent = new Intent(this, EditorActivity.class);
        intent.putExtra(ACTION, requestCode);
        if (requestCode == REQUEST_EDIT) {  // can check if position is NOT -1.
            intent.putExtra(NOTE_TITLE, notesList.get(position).getTitle());
            intent.putExtra(NOTE_CONTENT, notesList.get(position).getContent());
            intent.putExtra(POSITION, position);
        }
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ADD){
            // from editorActivity adding...
            if (resultCode == RESULT_OK){
                String title = data.getStringExtra(NOTE_TITLE);
                String content = data.getStringExtra(NOTE_CONTENT);
                Note note = new Note(title, content);
                notesList.add(note);
                adapter.notifyDataSetChanged(); // updating the views!!!
            }else{
                // cancel, do nothing...
            }
        }else if(requestCode == REQUEST_EDIT){
            if (resultCode == RESULT_OK){
                int position = data.getIntExtra(POSITION, -1);
                String title = data.getStringExtra(NOTE_TITLE);
                String content = data.getStringExtra(NOTE_CONTENT);
                Note note = new Note(title, content);
                notesList.set(position, note);
                adapter.notifyDataSetChanged();
            }else{
                // cancel...
            }
        }
    }
}

