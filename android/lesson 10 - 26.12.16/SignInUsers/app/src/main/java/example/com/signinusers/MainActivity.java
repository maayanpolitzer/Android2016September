package example.com.signinusers;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences settings = getSharedPreferences(PREFS_FILE_NAME, MODE_PRIVATE);
        String username = settings.getString(PREFS_USERNAME, null);
        if (username == null){
            moveToAnotherActivity(LoginActivity.class, true);
        }

        findViewById(R.id.activity_main_logout_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = settings.edit();
                editor.clear(); // delete all data from file.
                editor.commit();    // execute update.
                moveToAnotherActivity(LoginActivity.class, true);

            }
        });

    }
}
