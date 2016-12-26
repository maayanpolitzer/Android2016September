package example.com.signinusers;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import example.com.signinusers.infrastructure.Validation;

public class RegisterActivity extends BaseActivity {


    private SharedPreferences settings;                         // the object that related to the file.
    private SharedPreferences.Editor editor;                    // the object that can insert data to the file.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        settings = getSharedPreferences(PREFS_FILE_NAME, MODE_PRIVATE);  // read data from file.
        editor = settings.edit();                                   // write data to file.

        final EditText username = (EditText) findViewById(R.id.activity_register_username_edit_text);
        final EditText password = (EditText) findViewById(R.id.activity_register_password_edit_text);
        final EditText conPassword = (EditText) findViewById(R.id.activity_register_confirm_password_edit_text);

        findViewById(R.id.activity_register_register_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Validation.validateRegister(username, password, conPassword)){
                    String user = username.getText().toString().trim();
                    String pass = password.getText().toString().trim();
                    saveData(user, pass);
                    moveToAnotherActivity(ProfileActivity.class, true);

                }
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // display back button in the action bar.

    }

    private void saveData(String user, String pass) {
        editor.putString(PREFS_USERNAME, user);
        editor.putString(PREFS_PASSWORD, pass);
        editor.commit();    // execute the data changing... DON'T FORGET!!!!
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                moveToAnotherActivity(LoginActivity.class, true);
                return true;    // if i've changed the behavior, return true, else return false.
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        moveToAnotherActivity(LoginActivity.class, true);
    }
}
