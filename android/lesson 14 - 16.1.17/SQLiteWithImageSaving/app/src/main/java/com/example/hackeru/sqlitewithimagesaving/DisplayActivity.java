package com.example.hackeru.sqlitewithimagesaving;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        ImageView imageView = (ImageView) findViewById(R.id.activity_display_image_view);

        Intent intent = getIntent();
        String imageAddress = intent.getStringExtra("image");

        Uri imageUri = Uri.parse(imageAddress);

        imageView.setImageURI(imageUri);

    }
}
