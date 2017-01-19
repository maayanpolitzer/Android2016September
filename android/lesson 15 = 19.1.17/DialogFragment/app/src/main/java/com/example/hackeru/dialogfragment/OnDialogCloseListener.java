package com.example.hackeru.dialogfragment;

/**
 * Created by hackeru on 1/19/2017.
 */

public interface OnDialogCloseListener {

    void update(boolean result);

    void update(String email, String password);

}
