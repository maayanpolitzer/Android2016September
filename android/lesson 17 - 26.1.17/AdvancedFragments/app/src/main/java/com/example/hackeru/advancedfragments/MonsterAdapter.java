package com.example.hackeru.advancedfragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hackeru on 1/26/2017.
 */

public class MonsterAdapter extends ArrayAdapter<Monster> {

    private Context context;
    private Monster[] monsters;

    public MonsterAdapter(Context context, Monster[] monsters){
        super(context, R.layout.list_item, monsters);
        this.context = context;
        this.monsters = monsters;
    }


    private static class ViewHolder {
        TextView monsterName;
        ImageView monsterImage;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            holder.monsterName = (TextView) convertView.findViewById(R.id.list_item_text_view);
            holder.monsterImage = (ImageView) convertView.findViewById(R.id.list_item_image_view);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.monsterName.setText(monsters[position].getName());
        holder.monsterImage.setImageResource(monsters[position].getImage());
        return convertView;
    }
}
