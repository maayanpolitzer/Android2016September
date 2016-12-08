package javelopers.displaylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final int BACK_FROM_SECOND_ACTIVITY = 1;
    public static final String POSITION = "position";
    public static final String NAME = "name";

    private String[] names = {"zero", "one", "two", "three", "four", "five"};

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list_view);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(POSITION, position);
        intent.putExtra(NAME, names[position]);
        startActivityForResult(intent, BACK_FROM_SECOND_ACTIVITY);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BACK_FROM_SECOND_ACTIVITY){
            if (resultCode == RESULT_OK){
                String name = data.getStringExtra(NAME);
                int position = data.getIntExtra(POSITION, -1);
                if (position != -1){
                    names[position] = name; // updating the array data.
                    adapter.notifyDataSetChanged(); // update the listView by it's adapter.
                }
            }
        }
    }
}
