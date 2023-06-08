package com.Banking;

import java.util.ArrayList;
import java.util.Date;

public class Account
{

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private  String userId;
    private int SecurityNumber;
    private double balance;
    private String accountNumber;
    private String accountType;
    private String accountHolderName;
    static ArrayList<Bill_Payment> bills = new ArrayList<>();

    static ArrayList<Account> accountsList = new ArrayList<>();

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public ArrayList<Bill_Payment> getBills(){
        return bills;
    }

    public Account( double balance, String accountNumber, String accountType, String Name, String userId, int SecurityNumber)
    {
        this.accountHolderName = Name;
        this.SecurityNumber = SecurityNumber;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.userId = userId;
        Account.accountsList.add(this);
        System.out.println("com.Banking.Account successfully created");
    }

    public String Deposit(double amount, boolean isStub){
    if (!isStub) {
        Transaction transaction = new Transaction("Deposit", new Date(), amount, "Deposit");
        return  transaction.deposit(amount, this, SecurityNumber);

    }
    else {
        Transaction_Stub transaction = new Transaction_Stub("Deposit", new Date(), amount, "Deposit");
        return transaction.deposit(amount, this,SecurityNumber);
    }

    }

    public String  Transfer(double amount, Account account1, boolean isStub){
        if (!isStub) {
            Transaction transaction = new Transaction("Transfer", new Date(), amount, "Transfer");
            return transaction.transfer(amount, this, account1, SecurityNumber, account1.getSecurityNumber());
        }
        else {
            Transaction_Stub transaction = new Transaction_Stub("Transfer", new Date(), amount, "Transfer");
            return transaction.transfer(amount, this,account1, SecurityNumber, account1.getSecurityNumber());
        }
    }


    public  String Withdraw(double amount, boolean isStub){
        if (!isStub) {
        Transaction transaction = new Transaction("Withdraw", new Date(),amount,"Withdraw");
        return transaction.withdraw(amount, this, SecurityNumber);
        }
        else {
            Transaction_Stub transaction = new Transaction_Stub("Withdraw", new Date(),amount,"Withdraw");
            return transaction.withdraw(amount, this, SecurityNumber);
        }
    }

    public String PayBills(Bill_Payment bill_payment){

        return bill_payment.pay(this);
    }

    public String PayBills_Stub(Bill_payment_stub bill_payment_stub)
    {
        return bill_payment_stub.pay(this);
    }
    public String BuyItems(Items items){
        return items.buy(this);
    }

    public String BuyItems_stub(Items_stub items_stub){
        return items_stub.buy(this);
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setName(String name) {
        accountHolderName = name;
    }

    public int getSecurityNumber() {
        return SecurityNumber;
    }

    public void setSecurityNumber(int securityNumber) {
        SecurityNumber = securityNumber;
    }

    public static Account validation(int securityNumber)
    {

        for (Account account : accountsList) {

            if (account.SecurityNumber == securityNumber ) {
                return account;
            }
        }

        return null;
    }

//
//    public Account createAccount (double balance, String accountNumber, String accountType, String Name, String userId, int SecurityNumber)
//    {
//        Account account = new Account(balance,accountNumber,accountType,Name,userId,SecurityNumber);
//        Account.accountsList.add(account);
//        return account;
//    }


}