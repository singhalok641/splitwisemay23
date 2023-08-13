package com.scaler.splitwise.controllers;

import com.scaler.splitwise.dtos.SettleUpGroupRequestDto;
import com.scaler.splitwise.dtos.SettleUpGroupResponseDto;
import com.scaler.splitwise.dtos.SettleUpUserRequestDto;
import com.scaler.splitwise.dtos.SettleUpUserResponseDto;
import org.springframework.stereotype.Controller;

@Controller
public class SettleUpController {
    /*
    * Returns the list of transactions, which when executed will make the
    * balance of the user who called this api as 0 with their friends
    * */

    public SettleUpUserResponseDto settleUpUser(
            SettleUpUserRequestDto settleUpUserRequestDto){
        return null;
    }

    public SettleUpGroupResponseDto settleUpGroup(
            SettleUpGroupRequestDto settleUpGroupRequestDto){
        return null;
    }

}

// Get settleup/list -> done -> /settleup/done/expense?=1
// Get /expenses


