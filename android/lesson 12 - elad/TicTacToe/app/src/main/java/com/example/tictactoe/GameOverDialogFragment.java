package com.example.tictactoe;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by eladlavi on 29/12/2016.
 */

public class GameOverDialogFragment extends DialogFragment {

    private String title;
    private GameOverListener listener;


    public void setTitle(String title) {
        this.title = title;
    }

    public void setListener(GameOverListener listener) {
        this.listener = listener;
    }

    public static interface GameOverListener{
        void onGameReset();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_over, container);
        TextView lblTitle = (TextView)view.findViewById(R.id.lblGameOver);
        lblTitle.setText(title);
        Button btnNewGame = (Button)view.findViewById(R.id.btnNewGame);
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null)
                    listener.onGameReset();
                dismiss();
            }
        });
        return view;

    }
}
