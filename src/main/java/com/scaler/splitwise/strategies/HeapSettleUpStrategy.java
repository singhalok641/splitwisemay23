package com.scaler.splitwise.strategies;

import com.scaler.splitwise.models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HeapSettleUpStrategy implements SettleUpStrategy {

    @Override
    public List<Expense> settleUp(List<Expense> expensesToSettle) {
        // TODO::
        // Please implement this as H/W
        return null;
    }
}
