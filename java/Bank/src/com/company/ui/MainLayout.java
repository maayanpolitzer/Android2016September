package com.company.ui;

import com.company.Main;
import com.company.interfaces.ChangeSceneListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Created by hackeru on 11/10/2016.
 */
public class MainLayout extends BasicLayout {

    public MainLayout(ChangeSceneListener listener){
        super(listener, false);
    }

    @Override
    public void createUI() {
        Button b = new Button("Create new Account");
        b.setOnAction(e -> listener.changeScene(new CreateLayout(listener)));
        getChildren().addAll(b);
    }

}
