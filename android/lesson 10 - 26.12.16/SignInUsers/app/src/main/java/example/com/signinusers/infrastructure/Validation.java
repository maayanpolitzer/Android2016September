package example.com.signinusers.infrastructure;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import example.com.signinusers.BaseActivity;

/**
 * Created by hackeru on 12/22/2016.
 */

public class Validation {

    private static boolean validateNoSpace(String str){
        return !str.isEmpty() && !str.contains(" ");
    }


    public static boolean validateLogin(EditText username, EditText password){
        boolean valid = true;
        String user = username.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if (!validateNoSpace(user)){
            username.setError("username problem");
            valid = false;
        }
        if (!validateNoSpace(pass)){
            password.setError("password problem");
            valid = false;
        }
        return valid;
    }


    public static boolean validateRegister(EditText username, EditText password, EditText conPassword) {
        if(validateLogin(username, password)){
            String pass = password.getText().toString();
            String conPass = conPassword.getText().toString();
            if (!pass.equals(conPass)){
                conPassword.setError("Doesn't match the password");
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean validationProfile(Context context, EditText firstNameEditText, EditText lastNameEditText, EditText phoneEditText, boolean isAvatarSet) {
        String firstName = firstNameEditText.getText().toString().trim();
        String lastName = lastNameEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        boolean valid = true;
        if (firstName.isEmpty()){
            valid = false;
            firstNameEditText.setError("Empty first name");
        }
        if (lastName.isEmpty()){
            valid = false;
            lastNameEditText.setError("Empty last name");
        }
        if (!validatePhone(phone)){
            valid = false;
            phoneEditText.setError("error in phone...");
        }
        if (!isAvatarSet){
            valid = false;
            Toast.makeText(context, "Please set your avatar", Toast.LENGTH_LONG).show();
        }
        if (valid) {
            SharedPreferences settings = context.getSharedPreferences(BaseActivity.PREFS_FILE_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            //editor.putString()
        }

        return valid;

    }

    private static boolean validatePhone(String phone){
        return true;
    }

}





