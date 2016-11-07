package com.company.ui;

import com.company.infrastructure.Methods;
import com.company.threads.GetMessagesThread;
import com.company.threads.SendMessageThread;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by hackeru on 11/7/2016.
 */
public class ChatLayout extends VBox {

    private int counter = 0;

    private TextField inputMessage;
    private TextArea chatView;

    public ChatLayout(){

        chatView = new TextArea();
        chatView.setPrefSize(500, 500);
        chatView.setEditable(false);

        inputMessage = new TextField();
        inputMessage.setPrefSize(400, 100);
        Button sendBtn = new Button("Send");
        sendBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                sendMessage();
            }
        });

        inputMessage.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER){
                    sendMessage();
                }
            }
        });
        sendBtn.setPrefSize(100, 100);

        HBox inputView = new HBox(inputMessage,sendBtn);

        getChildren().addAll(chatView, inputView);

        new GetMessagesThread(counter).start();
    }

    private void sendMessage(){
        String message = inputMessage.getText().trim();
        if (Methods.validate(message)){
            new SendMessageThread(message).start();
            /*
            chatView.appendText(NameLayout.getName() + ": " + message + "\n");
            inputMessage.clear();
            inputMessage.requestFocus();
            */

        }

    }

}
