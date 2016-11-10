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
public class MainLayout extends VBox {

    public MainLayout(ChangeSceneListener listener){
        Button b = new Button("Create new Account");
        /*
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listener.changeScene(new CreateLayout(listener));
            }
        });
        */
        //Lambda expressions.
        b.setOnAction(e -> listener.changeScene(new CreateLayout(listener)));
        /*
        b.setOnAction(e -> {
            listener.changeScene(new CreateLayout(listener);
        });
        */
        getChildren().addAll(b);
    }

}
