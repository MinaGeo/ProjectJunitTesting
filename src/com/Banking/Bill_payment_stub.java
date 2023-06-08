package com.Banking;

public class Bill_payment_stub extends Bill_Payment {

    public Bill_payment_stub(String type, double amount) {
        super(type, amount);
    }

    @Override
    public String pay(Account account) {
        // Perform stubbed pay logic
        return "Stubbed payment operation";
    }

    public String addBills(String type, double amount, Account account) {
        // Perform stubbed addBill logic
        // You can choose to implement this method if needed in your testing scenario
        return "stubbed addBill operation";
    }
}
