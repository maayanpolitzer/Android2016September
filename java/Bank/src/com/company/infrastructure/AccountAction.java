package com.company.infrastructure;

/**
 * Created by hackeru on 11/14/2016.
 */
public class AccountAction {

    // creates change in the balance.

    private Action action;
    private double amount;

    public AccountAction(Action action, double amount){
        this.action = action;
        this.amount = amount;
    }

    public Action getAction() {
        return action;
    }

    public double getAmount() {
        return amount;
    }
}
