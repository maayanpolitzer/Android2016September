package com.example.hackeru.fragmentstabsproject;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private MyFragment firstFragment, secondFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(this);

        initFragments();

        changeFragment(firstFragment);
    }

    public void initFragments(){
        firstFragment = new MyFragment();
        Bundle args = new Bundle();
        args.putString("COLOR", "#0000ff");
        firstFragment.setArguments(args);
        secondFragment = new MyFragment();
        Bundle args2 = new Bundle();
        args2.putString("COLOR", "#ff0000");
        secondFragment.setArguments(args2);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        /*
        if (checkedId == R.id.activity_main_first_radio_button){
            //  FirstFragment clicked.
            changeFragment(firstFragment);
        }else{
            // SecondFragment clicked.
            changeFragment(secondFragment);
        }
        */
        changeFragment(checkedId == R.id.activity_main_first_radio_button ? firstFragment : secondFragment);
    }

    public void changeFragment(MyFragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit(); // to make a fragment appear on the screen, the onCreateView method get called!
    }
}
