package com.scaler.splitwise.dtos;

import com.scaler.splitwise.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class SettleUpGroupResponseDto {
    private List<Expense> expenses; // transactions(dummy expenses) which when executed the group is settled
}
