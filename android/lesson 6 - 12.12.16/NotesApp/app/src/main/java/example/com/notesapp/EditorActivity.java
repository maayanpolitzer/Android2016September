package example.com.notesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditorActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent receivedIntent;
    private EditText titleET;
    private EditText contentET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);


        titleET = (EditText) findViewById(R.id.title_edit_text);
        contentET = (EditText) findViewById(R.id.content_edit_text);
        Button saveBtn = (Button) findViewById(R.id.save_note_button);

        saveBtn.setOnClickListener(this);


        receivedIntent = getIntent();

        int action = receivedIntent.getIntExtra(MainActivity.ACTION, -1);
        if (action == MainActivity.REQUEST_EDIT) {
            String title = receivedIntent.getStringExtra(MainActivity.NOTE_TITLE);
            String content = receivedIntent.getStringExtra(MainActivity.NOTE_CONTENT);
            titleET.setText(title);
            contentET.setText(content);
        }

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        String title, content;
        if (receivedIntent.getIntExtra(MainActivity.ACTION, -1) == MainActivity.REQUEST_EDIT) {
            title = titleET.getText().toString().trim();
            content = contentET.getText().toString().trim();
            if (validate(title)) {
                intent.putExtra(MainActivity.NOTE_TITLE, title);
                intent.putExtra(MainActivity.NOTE_CONTENT, content);
                intent.putExtra(MainActivity.POSITION, receivedIntent.getIntExtra(MainActivity.POSITION, -1));
                setResult(RESULT_OK, intent);
                finish();
            }
        } else {
            title = titleET.getText().toString().trim();
            content = contentET.getText().toString().trim();
            if (validate(title)) {
                intent.putExtra(MainActivity.NOTE_TITLE, title);
                intent.putExtra(MainActivity.NOTE_CONTENT, content);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }


    private boolean validate(String str) {
        return !str.isEmpty();
    }

}
