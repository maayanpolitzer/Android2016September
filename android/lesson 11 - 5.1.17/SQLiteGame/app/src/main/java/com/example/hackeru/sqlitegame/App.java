package com.example.hackeru.sqlitegame;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by hackeru on 1/5/2017.
 */

public class App extends Application {
    
    private ArrayList<String> names;

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
    
    
}
