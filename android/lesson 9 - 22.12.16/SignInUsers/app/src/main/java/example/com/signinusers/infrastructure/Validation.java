package example.com.signinusers.infrastructure;

import android.widget.EditText;

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
}
