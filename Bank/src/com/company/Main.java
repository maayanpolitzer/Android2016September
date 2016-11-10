package com.company;

import com.company.interfaces.ChangeSceneListener;
import com.company.ui.MainLayout;
import javafx.application.Application;
import javafx.scene.Parent;
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
        changeScene(new MainLayout(this));
        primaryStage.show();
    }

    @Override
    public void changeScene(Parent layout){
        window.setScene(new Scene(layout));
    }

    public void check(){

    }

}
