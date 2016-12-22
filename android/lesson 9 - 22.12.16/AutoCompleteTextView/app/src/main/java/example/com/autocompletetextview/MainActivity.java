package example.com.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView actv;
    private ArrayList<String> cities;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities = new ArrayList<>();
        cities.add("Haifa");
        cities.add("Tel aviv");
        cities.add("Tel mond");
        cities.add("Givataim");

        actv = (AutoCompleteTextView) findViewById(R.id.actv);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, cities);
        actv.setThreshold(1);
        actv.setAdapter(adapter);

    }

    public void addCity(View view) {
        String city = actv.getText().toString().trim();
        if (validate(city)){
            actv.setText("");
            //cities.add(city);
            adapter.add(city);
        }else{
            actv.setError("Problem...");
        }
    }

    private boolean validate(String str){
        if (str.isEmpty()){
            return false;
        }
        for (String city : cities){
            if (city.equalsIgnoreCase(str)){
                return false;
            }
        }
        /*  LEARN FOR EACH!!!
        for (int i = 0; i < cities.size(); i++){
            String city = cities.get(i);

        }
        */
        return true;

    }

}
