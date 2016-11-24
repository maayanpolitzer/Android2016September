package com.company.ui;


import com.company.Main;
import com.company.infrastructure.Methods;
import com.company.interfaces.ChangeSceneListener;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Created by hackeru on 11/7/2016.
 */
public class NameLayout extends VBox {

    private ChangeSceneListener listener;

    private static String name;

    public NameLayout(ChangeSceneListener listener){
        this.listener = listener;
        TextField nameInput = new TextField();
        nameInput.setPromptText("Enter your name");
        Button button = new Button("START CHAT");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nameToCheck = nameInput.getText().trim();
                if(Methods.validate(nameToCheck)){
                    name = nameToCheck;
                    listener.changeScene(2);
                }else{
                    nameInput.requestFocus();
                }
            }
        });
        getChildren().addAll(nameInput, button);
    }

    public static String getName() {
        return name;
    }
}
