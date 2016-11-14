package com.company.ui;

import com.company.infrastructure.BankAccount;
import com.company.interfaces.ChangeSceneListener;

/**
 * Created by hackeru on 11/14/2016.
 */
public abstract class ComplexLayout extends BasicLayout {

    protected BankAccount account;

    public ComplexLayout(ChangeSceneListener listener, boolean displayBackBtn, BankAccount account) {
        super(listener, displayBackBtn);
        this.account = account;
        addDataToUI();
    }

    public abstract void addDataToUI();

}
