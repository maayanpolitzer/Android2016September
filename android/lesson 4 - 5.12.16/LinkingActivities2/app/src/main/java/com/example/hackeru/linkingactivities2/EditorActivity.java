package com.example.hackeru.linkingactivities2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditorActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameET, ageET;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        nameET = (EditText) findViewById(R.id.activity_editor_name_edit_text);
        ageET = (EditText) findViewById(R.id.activity_editor_age_edit_text);
        Button saveBtn = (Button) findViewById(R.id.activity_editor_save_button);

        saveBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = nameET.getText().toString().trim();
        String ageAsString = ageET.getText().toString();

        if(!name.isEmpty() && !ageAsString.isEmpty()){
            int age = Integer.parseInt(ageAsString);
            Intent intent = new Intent();
            intent.putExtra(MainActivity.NAME, name);  // String
            intent.putExtra(MainActivity.AGE, age);    // int
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
