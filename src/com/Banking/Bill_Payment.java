package com.Banking;

public class Bill_Payment {
    String type;
    double amount;


    Bill_Payment(String type,double amount){
        this.type = type;
        this.amount=amount;
    }

    String pay(Account account){
        int index=findBill(type,account);
        if(index!=-1) {
            if (account.getBalance() > amount) {
                double Balance = account.getBalance();
                Balance -= account.bills.get(index).getAmount();
                account.setBalance(Balance);
                account.bills.remove(index);
                return "Successful transaction";
            } else {
                return "Not Enough Balance";
            }
        }
        return "Bill not found";

    }
    int findBill(String type, Account account){


        for (int i = 0; i < account.bills.size(); i++) {
            if (account.bills.get(i).getType().equals(type)) {
                return i;
            }
        }
        return -1;

    }

    public String getType(){
        return type;
    }

    public void addBill(String type, double amount, Account account){
        if(findBill(type,account)==-1) {
            Account.bills.add(new Bill_Payment(type, amount));
        }
    }
    public double getAmount(){
        return amount;
    }

    String getBillsId(Account account){
        String out="";
        for(int i=0;i<account.bills.size();i++){
            out+=account.bills.get(i).getType();
            out+="\n";
        }
        return out;
    }

    String getBillsAmount(Account account){
        String out="";
        for(int i=0;i<account.bills.size();i++){
            out+=Double.toString(account.bills.get(i).getAmount());
            out+="\n";
        }
        return out;
    }




}