package example.com.signinusers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import example.com.signinusers.infrastructure.Validation;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.activity_login_username_edit_text);
        password = (EditText) findViewById(R.id.activity_login_password_edit_text);

        findViewById(R.id.activity_login_login_button).setOnClickListener(this);
        findViewById(R.id.activity_login_register_text_view).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_login_login_button:
                if (Validation.validateLogin(username, password)){
                    moveToAnotherActivity(MainActivity.class, true);
                }
                break;
            case R.id.activity_login_register_text_view:
                    moveToAnotherActivity(RegisterActivity.class, true);
                break;
        }
    }
}
