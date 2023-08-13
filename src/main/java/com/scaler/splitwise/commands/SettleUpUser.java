package com.scaler.splitwise.commands;

import com.scaler.splitwise.controllers.SettleUpController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpUser implements Command {

    public SettleUpUser(SettleUpController settleUpController) {
    }

    @Override
    public boolean matches(String input) {
        return false;
    }

    @Override
    public void execute(String input) {

    }
}
