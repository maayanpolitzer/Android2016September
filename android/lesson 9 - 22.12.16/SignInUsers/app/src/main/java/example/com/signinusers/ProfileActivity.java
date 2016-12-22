package example.com.signinusers;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences settings = getSharedPreferences(PREFS_FILE_NAME, MODE_PRIVATE);

        String username = settings.getString(PREFS_USERNAME, null);

        Toast.makeText(this, "The username is: " + username, Toast.LENGTH_LONG).show();

    }
}
