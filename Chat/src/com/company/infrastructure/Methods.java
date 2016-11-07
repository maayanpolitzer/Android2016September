package com.company.infrastructure;

/**
 * Created by hackeru on 11/7/2016.
 */
public class Methods {

    public static boolean validate(String str){
        boolean valid = true;
        if (str.isEmpty()){
            valid = false;
        }
        return valid;
    }

}
