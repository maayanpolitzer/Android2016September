package com.company.ui;

import com.company.infrastructure.BankAccount;
import com.company.interfaces.ChangeSceneListener;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by hackeru on 11/10/2016.
 */
public class CreateLayout extends BasicLayout {

    public CreateLayout(ChangeSceneListener listener) {
        super(listener, true);
    }

    @Override
    public void createUI() {
        TextField nameTF = new TextField();
        nameTF.setPromptText("enter your name");
        Button createAccountBtn = new Button("Create");
        createAccountBtn.setOnAction(e -> {
            String name = nameTF.getText().trim();
            if (!name.isEmpty()){
                BankAccount account = new BankAccount(name);
                System.out.println(account);
                listener.createAccountAndSwitchScene(new DetailsLayout(listener, account), account);
            }
        });

        getChildren().addAll(nameTF, createAccountBtn);

    }




}
