package com.company;

import com.company.infrastructure.BankAccount;
import com.company.interfaces.ChangeSceneListener;
import com.company.ui.MainLayout;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application implements ChangeSceneListener {

    private Stage window;
    private ArrayList<BankAccount> accounts;

    public static void main(String[] args) {
	    launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        accounts = new ArrayList<>();
        window = primaryStage;
        changeScene(new MainLayout(this));
        primaryStage.show();
    }

    @Override
    public void changeScene(Parent layout){
        window.setScene(new Scene(layout,600,400));
    }

    @Override
    public boolean createAccountAndSwitchScene(Parent layout, BankAccount account) {
        changeScene(layout);
        return accounts.add(account);
    }

}
