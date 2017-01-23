package com.example.hackeru.fragmentstabsproject;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by hackeru on 1/23/2017.
 */

public class MyFragment extends Fragment {

    private TextView counterTextView;
    private int counter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("TAG", "onCreateView()");
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        RelativeLayout layout = (RelativeLayout) view.findViewById(R.id.layout);
        Bundle arguments = getArguments();
        layout.setBackgroundColor(Color.parseColor(arguments.getString("COLOR")));
        counterTextView = (TextView) view.findViewById(R.id.fragment_my_counter_text_view);
        counterTextView.setText(++counter + "");
        return view;
    }

    /*
    public void updateCounter(){
        counter++;
        counterTextView.setText(counter + "");
    }
    */

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("TAG", "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG", "onCreate()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TAG", "onPause");
    }
}
