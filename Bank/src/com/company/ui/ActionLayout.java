package com.company.ui;

import com.company.infrastructure.AccountAction;
import com.company.infrastructure.Action;
import com.company.infrastructure.BankAccount;
import com.company.interfaces.ChangeSceneListener;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ActionLayout extends ComplexLayout {

    private Button makeBtn;
    private TextField amountTF;
    private Action action;

    public ActionLayout(ChangeSceneListener listener, Action action, BankAccount account) {
        super(listener,true, account);
        this.action = action;
        System.out.println(action);
    }

    @Override
    public void createUI() {
        amountTF = new TextField();
        makeBtn = new Button("Make");
        getChildren().addAll(amountTF, makeBtn);
    }

    @Override
    public void addDataToUI() {
        makeBtn.setOnAction(e -> {
            String amountString = amountTF.getText().trim();
            if (!amountString.isEmpty()){
                double amount = 0;
                try {
                    amount = Double.parseDouble(amountString);
                    if (amount > 0 && action == Action.DEPOSIT){
                        account.addAction(new AccountAction(Action.DEPOSIT, amount));
                    }else if(amount > 0 && action == Action.WITHDRAWAL){
                        account.addAction(new AccountAction(Action.WITHDRAWAL, amount));
                    }
                    listener.changeScene(new DetailsLayout(listener, account));
                }catch (NumberFormatException ex){
                    amount = -1;
                }
            }
        });
    }
}
