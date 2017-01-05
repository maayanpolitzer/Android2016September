package com.example.hackeru.sqlitegame;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by hackeru on 1/5/2017.
 */
public class ScoresAdapter extends CursorAdapter {

    private String name;
    private int score;

    public ScoresAdapter(Context context, Cursor cursor){
        super(context, cursor, true);
    }

    private static class ViewHolder {
        TextView nameTextView;
        TextView scoreTextView;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.nameTextView = (TextView) v.findViewById(R.id.list_item_name_text_view);
        viewHolder.scoreTextView = (TextView) v.findViewById(R.id.list_item_score_text_view);
        v.setTag(viewHolder);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();

        name = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_NAME));
        score = cursor.getInt(cursor.getColumnIndex(DBOpenHelper.COLUMN_SCORE));

        viewHolder.nameTextView.setText(name);
        viewHolder.scoreTextView.setText(String.valueOf(score));
    }
}
