package com.company.ui;

import com.company.infrastructure.Action;
import com.company.infrastructure.BankAccount;
import com.company.interfaces.ChangeSceneListener;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Created by hackeru on 11/10/2016.
 */
public class DetailsLayout extends ComplexLayout {

    private Label nameLabel;
    private Label numberLabel;
    private Label balanceLabel;

    public DetailsLayout(ChangeSceneListener listener, BankAccount account) {
        super(listener, true, account);
        this.account = account;
    }

    @Override
    public void createUI() {
        GridPane pane = new GridPane();
        nameLabel = new Label();
        numberLabel = new Label();
        balanceLabel = new Label();
        Button depositBtn = new Button("Deposit");
        depositBtn.setOnAction(e -> choice(Action.DEPOSIT));
        Button withdrawalBtn = new Button("Withdrawal");
        withdrawalBtn.setOnAction(e -> choice(Action.WITHDRAWAL));
        Button transferBtn = new Button("Transfer");
        transferBtn.setOnAction(e -> choice(Action.TRANSFER));
        Button viewActionsBtn = new Button("View actions");
        viewActionsBtn.setDisable(true);

        pane.addRow(0, new Label("Name:"), nameLabel);
        pane.addRow(1, new Label("Account number: "), numberLabel);
        pane.addRow(2, new Label("Balance:"), balanceLabel);

        pane.addRow(3, depositBtn, withdrawalBtn);
        pane.addRow(4, transferBtn, viewActionsBtn);
        getChildren().add(pane);
    }

    private void choice(Action action){
        listener.changeScene(new ActionLayout(listener, action, account));
    }

    @Override
    public void addDataToUI() {
        nameLabel.setText(account.getOwner());
        numberLabel.setText(String.valueOf(account.getAccountNumber()));
        balanceLabel.setText(String.valueOf(account.getBalance()));
    }
}
