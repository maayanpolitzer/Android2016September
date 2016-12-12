package example.com.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private String simpleJsonObject = "{\"firstName\":\"Maayan\", \"lastName\":\"Politzer\"}";
    private String simpleJsonArray = "[{\"student\":\"Dudi\", \"age\": 23},{\"student\":\"Aviv\", \"age\": 60}, {\"student\":\"Kobi\", \"age\": 27}]";
    private String complex = "{\"weekly-weather\":[{\"day\":\"sunday\", \"temp\":18},{\"day\":\"monday\", \"temp\":6},{\"day\":\"3\", \"temp\":10}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        try {
            JSONObject object = new JSONObject(simpleJsonObject);
            String firstName = object.getString("firstName");
            String lastName = object.getString("lastName");
            Log.d("Maayan", "You are: " + firstName + " " + lastName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */

        /*
        try {
            JSONArray arr = new JSONArray(simpleJsonArray);
            for (int i = 0; i < arr.length(); i++){
                JSONObject obj = arr.getJSONObject(i);
                String name = obj.getString("student");
                int age = obj.getInt("age");
                Log.d("Maayan", "welcome: " + name + ", " + age);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */

        JSONObject mainObject = null;
        try {
            mainObject = new JSONObject(complex);
            JSONArray arr = mainObject.getJSONArray("weekly-weather");
            for (int i = 0; i < arr.length(); i++){
                JSONObject obj = arr.getJSONObject(i);
                String day = obj.getString("day");
                int temp = obj.getInt("temp");
                Log.d("Maayan", day + " -> " + temp);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
