package com.company;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button("Click me");
        TextField input = new TextField();
        TextArea output = new TextArea();
        btn.setPrefSize(500, 50);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn.setText("stop click me...");
                output.setText(input.getText());
            }
        });
        VBox mainLayout = new VBox();



        mainLayout.getChildren().add(input);
        mainLayout.getChildren().add(btn);
        mainLayout.getChildren().add(output);

        Scene mainScene = new Scene(mainLayout, 500, 500);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
