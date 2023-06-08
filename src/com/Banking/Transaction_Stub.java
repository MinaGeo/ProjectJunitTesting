package com.Banking;

import java.util.Date;

public class Transaction_Stub extends Transaction {

    public Transaction_Stub(String transactionID, Date date, double amount, String transactionType) {
        super(transactionID, date, amount, transactionType);
    }

    @Override
    public String deposit(double amount, Account account, int securityNumber)
    {
        // Perform stubbed deposit logic
        return "Stubbed deposit transaction";
    }

    @Override
    public String withdraw(double amount, Account account, int securityNumber) {
        // Perform stubbed withdraw logic
        return "Stubbed withdraw transaction";
    }

    @Override
    public String transfer(double amount, Account sender, Account recipient, int securityNumberSender, int securityNumberRecipient) {
        // Perform stubbed transfer logic
        return "Stubbed transfer transaction";
    }
}
