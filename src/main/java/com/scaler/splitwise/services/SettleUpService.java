package com.scaler.splitwise.services;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.ExpenseUser;
import com.scaler.splitwise.models.Group;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.repositories.ExpenseRepository;
import com.scaler.splitwise.repositories.ExpenseUserRepository;
import com.scaler.splitwise.repositories.GroupRepository;
import com.scaler.splitwise.repositories.UserRepository;
import com.scaler.splitwise.strategies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {

    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;
    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;


    public SettleUpService(UserRepository userRepository,
                           ExpenseUserRepository expenseUserRepository,
                           SettleUpStrategy settleUpStrategy,
                           GroupRepository groupRepository,
                           ExpenseRepository expenseRepository) {
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> settleUpUser(Long userId) {
        /*
        * 1. Get all the expenses the user is part of
        * 2. Iterate through all the people and find out who owes how much and who is
        * owed how much
        * 3. Use min and max heap approach to find all the transactions that have to be made
        * 4. Return transaction that this user is involved in
        * */

        Optional<User> userOptional = userRepository.findAllById(userId);

        // TODO::
        if(userOptional.isEmpty()){
            throw new RuntimeException();
        }

        User user = userOptional.get();

        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user);

        Set<Expense> expenses = new HashSet<>();

        for(ExpenseUser expenseUser: expenseUsers){
            expenses.add(expenseUser.getExpense());
        }


        List<Expense> expensesToSettleUp= settleUpStrategy.settleUp(expenses.stream().toList());


        // TODO::
        // Return the expenses that this user is part of.
        // H/W to do this

        return null;
    }

    public List<Expense> settleUpGroup(Long groupId){
        /*
        * 1. Get all the expense that are part of that group
        * 2. Iterate through all the people and find out who owes how much and who is
         * owed how much
         * 3. Use min and max heap approach to find all the transactions that have to be made
         * 4. Return all the transactions(dummy expenses)
        * */

        Optional<Group> optionalGroup = groupRepository.findById(groupId);
        if(optionalGroup.isEmpty()){
            throw new RuntimeException();
        }

        Group group = optionalGroup.get();

        List<Expense> expenses = expenseRepository.findAllByGroup(group);
        List<Expense> expensesToSettleUp = settleUpStrategy.settleUp(expenses);

        return expensesToSettleUp;

    }





//    public List<Expense> settleUpGroup(Long groupId) {
//       return null;
//    }
}