package com.example.hackeru.advancedfragments;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
        }
        
        Bundle bundle = getIntent().getExtras();

        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(bundle);

        getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

    }
}
