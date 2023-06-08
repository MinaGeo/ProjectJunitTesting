package com.Banking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public class Transaction {


    private String transactionID;
    private Date date;
    private double amount;

    private String transactionType;

    // Constructor
    public Transaction(String transactionID, Date date, double amount, String transactionType) {
        this.transactionID = transactionID;
        this.date = date;
        this.amount = amount;
        this.transactionType = transactionType;

    }

    // Getters
    public String getTransactionID() {
        return transactionID;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
    LocalDateTime currentTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedTimestamp = currentTime.format(formatter);
    // Function to retrieve transaction details



    public String deposit(double amount, Account account, int securityNumber) {
        if (amount > 0 && Account.validation(securityNumber)!=null) {
            double currentBalance = account.getBalance();
            double newBalance = currentBalance + amount;
            account.setBalance(newBalance);

            return("Transaction ID: " + transactionID + "\nTimestamp: " + formattedTimestamp + "\nAmount: " + amount +
                    "\nTransaction Type: deposit" );
        }
        else {
            return("invalid amount for Deposit or account does not exist");

        }
    }
//TO DO : make functions return strings instead of printing
    public String withdraw(double amount, Account account, int securityNumber) {
        double currentBalance = account.getBalance();
        if (amount <= 0 && Account.validation(securityNumber)!=null) {
            return("invalid amount for Withdraw");
        }
        else if (amount <= currentBalance && Account.validation(securityNumber)!=null) {
            double newBalance = currentBalance - amount;
            account.setBalance(newBalance);
           return("Transaction ID: " + transactionID + "\nTimestamp: " + formattedTimestamp + "\nAmount: " + amount +
                   "\nTransaction Type: withdraw");
        }
        else
        {  return("insufficient balance or account doesn't exist");
        }
    }

    //Function to transfer money between accounts
    public String transfer(double amount, Account sender, Account recipient, int securityNumberSender , int securityNumberRecipient) {
        double SenderCurrentBalance = sender.getBalance();
        if (amount <=0 && sender.validation(securityNumberSender)!=null && recipient.validation(securityNumberRecipient)!=null){
           return("invalid amount for Transfer");
        }
        else if (amount <= SenderCurrentBalance && Account.validation(securityNumberSender)!=null && Account.validation(securityNumberRecipient)!=null) {
            double newBalance = SenderCurrentBalance - amount;
            sender.setBalance(newBalance);
            recipient.setBalance(recipient.getBalance() + amount);
            return("Transaction ID: " + transactionID + "\nTimestamp: " + formattedTimestamp + "\nAmount: " + amount +
                    "\nTransaction Type: transfer" + "\nSender: " + sender.getAccountHolderName() + "\nRecipient: " + recipient.getAccountHolderName());
        } else {
            return("insufficient balance for transfer or accounts doesn't exists");
        }
    }

}
