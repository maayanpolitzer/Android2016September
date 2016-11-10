package com.company.ui;

import com.company.interfaces.ChangeSceneListener;
import javafx.scene.layout.VBox;

/**
 * Created by hackeru on 11/10/2016.
 */
public abstract class BasicLayout extends VBox {

    protected ChangeSceneListener listener;

    public BasicLayout(ChangeSceneListener listener){
        this.listener = listener;
    }

}
