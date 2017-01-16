package com.example.hackeru.sqlitewithimagesaving;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hackeru.sqlitewithimagesaving.infrastructure.DBOpenHelper;

/**
 * Created by hackeru on 1/16/2017.
 */

public class ContactsCursorAdapter extends CursorAdapter {

    public ContactsCursorAdapter(Context context, Cursor cursor){
        super(context, cursor, false);
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView nameTextView;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        ViewHolder holder = new ViewHolder();
        holder.imageView = (ImageView) view.findViewById(R.id.list_item_image_view);
        holder.nameTextView = (TextView) view.findViewById(R.id.list_item_text_view);
        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();
        final String imageName = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COL_IMAGE_FILE_URI));
        holder.imageView.setImageURI(Uri.parse(imageName));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DisplayActivity.class);
                intent.putExtra("image", imageName);
                context.startActivity(intent);
            }
        });
        String name = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COL_NAME));
        holder.nameTextView.setText(name);
    }
}
