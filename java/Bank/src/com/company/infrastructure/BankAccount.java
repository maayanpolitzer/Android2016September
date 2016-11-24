package com.company.infrastructure;

import java.util.ArrayList;

/**
 * Created by hackeru on 11/14/2016.
 */
public class BankAccount {

    private String owner;
    private double balance;
    private int accountNumber;
    private static int counter = 0;
    private ArrayList<AccountAction> actions;

    public BankAccount(String owner){
        this.owner = owner;
        balance = 0;
        accountNumber = counter++;
        actions = new ArrayList<>();
    }

    public void addAction(AccountAction action){
        actions.add(action);
        if (action.getAction() == Action.DEPOSIT){
            balance += action.getAmount();
        }else{
            balance -= action.getAmount();
        }
        System.out.println(this);
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return accountNumber + ": " + owner + ", " + balance;
    }
}
