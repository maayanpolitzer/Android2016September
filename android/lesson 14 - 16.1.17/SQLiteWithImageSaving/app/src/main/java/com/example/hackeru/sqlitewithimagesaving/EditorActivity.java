package com.example.hackeru.sqlitewithimagesaving;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hackeru.sqlitewithimagesaving.infrastructure.DataSource;

import java.io.File;
import java.io.IOException;

public class EditorActivity extends AppCompatActivity {

    private static final int CAMERA_APP_REQUEST_CODE = 1;
    private EditText nameET, phoneET;
    private ImageView avatarIV;
    private File imageFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        nameET = (EditText) findViewById(R.id.name_edit_text);
        phoneET = (EditText) findViewById(R.id.phone_edit_text);
        avatarIV = (ImageView) findViewById(R.id.image_view);


        avatarIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageFile = new File(Environment.getExternalStorageDirectory(), "img_" + System.currentTimeMillis() + ".jpg");
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imageFile));
                startActivityForResult(intent, CAMERA_APP_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_APP_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                avatarIV.setImageURI(Uri.fromFile(imageFile));
            }
        }
    }

    private void saveToDatabase(){
        String name = nameET.getText().toString();
        String phone = phoneET.getText().toString();
        String imageAddress = Uri.fromFile(imageFile).toString();
        Log.d("Maayan", "save: name: " + name + ", phone: " + phone + ", imageAddress: " + imageAddress);
        DataSource dbConnection = new DataSource(this);
        dbConnection.insert(name, phone, imageAddress);
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_save:
                saveToDatabase();
                return true;
            case R.id.action_remove:
                Toast.makeText(this, "Removing...", Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }
}
