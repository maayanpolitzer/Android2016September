package com.example.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements GameOverDialogFragment.GameOverListener {

    LinearLayout boardLayout;
    TicTacToe ticTacToe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ticTacToe = new TicTacToe();
        boardLayout = (LinearLayout)findViewById(R.id.boardLayout);
        int width = boardLayout.getLayoutParams().width;
        int margin = 5;
        int imageSize = (width/3-2*margin);
        for (int i = 0; i < 3; i++) {
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            for (int j = 0; j < 3; j++) {
                ImageView cellView = new ImageView(this);
                cellView.setOnClickListener(cellClickListener);
                cellView.setTag(i * 3 + j + 1);
                LinearLayout.LayoutParams layoutParams =
                        new LinearLayout.LayoutParams(imageSize, imageSize);
                layoutParams.setMargins(margin, margin, margin, margin);
                row.addView(cellView, layoutParams);
            }
            LinearLayout.LayoutParams rowLayout =
                    new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
            boardLayout.addView(row, rowLayout);
        }

    }



    private View.OnClickListener cellClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int cell = (Integer)v.getTag();
            TicTacToe.MoveResult moveResult = ticTacToe.makeMove(cell);
            if(moveResult == TicTacToe.MoveResult.INVALID_MOVE)
                Toast.makeText(MainActivity.this, "Invalid Move!", Toast.LENGTH_SHORT).show();
            else{
                ((ImageView)v).setImageResource(ticTacToe.isXturn() ? R.drawable.o : R.drawable.x);
                if(moveResult != TicTacToe.MoveResult.VALID_MOVE){
                    GameOverDialogFragment fragment = new GameOverDialogFragment();
                    fragment.setListener(MainActivity.this);
                    fragment.setTitle(moveResult == TicTacToe.MoveResult.VICTORY ?
                            (ticTacToe.isXturn() ? "O" : "X")+
                                    " is the winner" : "we have draw!") ;
                    fragment.setCancelable(false);
                    fragment.show(getFragmentManager(), "");
                }
            }

        }
    };

    @Override
    public void onGameReset() {
        ticTacToe.resetGame();
        for (int i = 1; i <= 9; i++) {
            ImageView cellView = (ImageView)boardLayout.findViewWithTag(i);
            cellView.setImageDrawable(null);
        }
    }
}










