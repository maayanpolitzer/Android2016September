package example.com.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Monster[] monsters = {
            new Monster("0 monster", R.drawable.three),
            new Monster("1 monster", R.drawable.one),
            new Monster("2 monster", R.drawable.two),
            new Monster("3 monster", R.drawable.three),
            new Monster("4 monster", R.drawable.one),
            new Monster("5 monster", R.drawable.two),
            new Monster("6 monster", R.drawable.three),
            new Monster("7 monster", R.drawable.one),
            new Monster("8 monster", R.drawable.two),
            new Monster("9 monster", R.drawable.three),
            new Monster("10 monster", R.drawable.one),
            new Monster("11 monster", R.drawable.two),
            new Monster("12 monster", R.drawable.three),
            new Monster("13 monster", R.drawable.one),
            new Monster("14 monster", R.drawable.two),
            new Monster("15 monster", R.drawable.three),
            new Monster("16 monster", R.drawable.one),
            new Monster("17 monster", R.drawable.two),
            new Monster("18 monster", R.drawable.three),
            new Monster("19 monster", R.drawable.one),
            new Monster("20 monster", R.drawable.two)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list_view);
        MonsterAdapter adapter = new MonsterAdapter(this, monsters);
        listView.setAdapter(adapter);

    }
}
