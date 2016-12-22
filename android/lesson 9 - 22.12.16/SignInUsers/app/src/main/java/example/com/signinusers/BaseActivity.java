package example.com.signinusers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hackeru on 12/22/2016.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected static final String PREFS_FILE_NAME = "myPrefs";
    protected static final String PREFS_USERNAME = "username";
    protected static final String PREFS_PASSWORD = "password";

    protected void moveToAnotherActivity(Class targetClass, int requestCode, boolean closeRecentActivity){
        Intent intent = new Intent(this, targetClass);
        startActivityForResult(intent, requestCode);
        if (closeRecentActivity){
            finish();
        }
    }

    protected void moveToAnotherActivity(Class targetClass, boolean closeRecentActivity){
        Intent intent = new Intent(this, targetClass);
        startActivity(intent);
        if (closeRecentActivity){
            finish();
        }
    }

}
