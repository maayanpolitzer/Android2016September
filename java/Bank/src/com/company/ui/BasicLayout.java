package com.company.ui;

import com.company.Main;
import com.company.interfaces.ChangeSceneListener;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Created by hackeru on 11/10/2016.
 */
public abstract class BasicLayout extends VBox {

    protected ChangeSceneListener listener;

    public BasicLayout(ChangeSceneListener listener, boolean displayBackBtn){
        this.listener = listener;
        createUI();
        if (displayBackBtn) {
            Button b = new Button("Back");
            getChildren().addAll(b);
        }
    }

    public abstract void createUI();

}
