package com.company;

import com.company.interfaces.ChangeSceneListener;
import com.company.ui.ChatLayout;
import com.company.ui.NameLayout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application implements ChangeSceneListener {

    private Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        /*
        NameLayout layout = new NameLayout();
        Scene firstScene = new Scene(layout);
        primaryStage.setScene(firstScene);
        */
        changeScene(1);
        primaryStage.setTitle("Class chat");
        primaryStage.show();
    }

    @Override
    public void changeScene(int sceneNumber){
        if(sceneNumber == 1){
            ChangeSceneListener listener = this;
            window.setScene(new Scene(new NameLayout(listener)));
        }else if(sceneNumber == 2){
            window.setScene(new Scene(new ChatLayout()));
        }else{
            System.out.println("What?????????");
        }
    }
}
