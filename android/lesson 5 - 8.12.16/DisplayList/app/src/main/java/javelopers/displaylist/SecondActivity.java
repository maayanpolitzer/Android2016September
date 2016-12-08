package javelopers.displaylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private EditText editText;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        position = getIntent().getIntExtra(MainActivity.POSITION, -1);
        String name = getIntent().getStringExtra(MainActivity.NAME);

        editText = (EditText) findViewById(R.id.edit_text);

        if (name != null) {
            editText.setText(name);
        }

    }

    public void save(View view) {
        String name = editText.getText().toString().trim();
        if (!name.isEmpty()) {     // name.equals("");
            Intent intent = new Intent();
            intent.putExtra(MainActivity.NAME, name);
            intent.putExtra(MainActivity.POSITION, position);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
