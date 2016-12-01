package com.example.hackeru.userinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_text);

    }

    public void register(View view) {
        String name = editText.getText().toString().trim();
        if (name.isEmpty()){    // same as if(name.length == 0){
            editText.setError("Cannot stay empty...");
        }else {
            Toast.makeText(this, "Hello " + name, Toast.LENGTH_SHORT).show();
            editText.setText("");
        }
    }
}
