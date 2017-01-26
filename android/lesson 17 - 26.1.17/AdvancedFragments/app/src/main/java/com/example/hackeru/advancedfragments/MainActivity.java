package com.example.hackeru.advancedfragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickedImage {

    public static final String MONSTER = "monster";
    private boolean isLandscape;    // default is false.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.container) != null){
            isLandscape = true;
        }

    }

    @Override
    public void onClick(Bundle bundle) {
        if (isLandscape){
            DetailsFragment fragment = new DetailsFragment();
            fragment.setArguments(bundle);
            getFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
        }else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }
}
