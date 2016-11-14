package com.company.interfaces;

import com.company.infrastructure.BankAccount;
import javafx.scene.Parent;

/**
 * Created by hackeru on 11/10/2016.
 */
public interface ChangeSceneListener {

    // pointer to Main class.

    void changeScene(Parent layout);

    boolean createAccountAndSwitchScene(Parent layout, BankAccount account);

}
