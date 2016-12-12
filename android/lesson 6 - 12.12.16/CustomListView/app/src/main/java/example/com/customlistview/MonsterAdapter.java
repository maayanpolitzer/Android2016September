package example.com.customlistview;


import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MonsterAdapter extends ArrayAdapter<Monster> {

    private Monster[] monsters;
    private Context context;

    public MonsterAdapter(Context context, Monster[] monsters){
        super(context, R.layout.list_item, monsters);
        this.monsters = monsters;
        this.context = context;
    }

    private class ViewHolder {
        ImageView monsterImageIV;
        TextView monsterNameTV;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);  // third parameter refers to the return. (true - parent, false - inflated xml)
            viewHolder.monsterNameTV = (TextView) convertView.findViewById(R.id.list_item_name_text_view);
            viewHolder.monsterImageIV = (ImageView) convertView.findViewById(R.id.list_item_image_view);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String name = monsters[position].getName();
        viewHolder.monsterImageIV.setImageResource(monsters[position].getImage());
        viewHolder.monsterNameTV.setText(name);
        return convertView;
    }
}
