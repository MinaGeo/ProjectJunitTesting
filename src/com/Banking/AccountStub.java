package com.Banking;

import java.util.ArrayList;

public class AccountStub extends Account {
    public AccountStub( double balance, String accountNumber, String accountType, String Name, String userId, int SecurityNumber) {
        super ( balance,  accountNumber,  accountType,  Name,  userId, SecurityNumber);
    }

    // Override methods from the Account class with stub implementations

    @Override
    public String Deposit(double amount, boolean isStub) {
        return "Stub implementation - Deposit operation";
    }

    @Override
    public String Transfer(double amount, Account account1, boolean isStub) {
        return "Stub implementation - Transfer operation";
    }

    @Override
    public String Withdraw(double amount, boolean isStub) {
        return "Stub implementation - Withdraw operation";
    }

    @Override
    public String PayBills(Bill_Payment bill_payment) {
        return "Stub implementation - PayBills operation";
    }

    @Override
    public String BuyItems(Items items) {
        return "Stub implementation - BuyItems operation";
    }
}
