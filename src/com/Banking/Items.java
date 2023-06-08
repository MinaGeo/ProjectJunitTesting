package com.Banking;

public class Items {
    String name;
    String id;
    double price;
    int count;


    public Items(String name, String id, double price, int count){
        this.name=name;
        this.id=id;
        this.price=price;
        this.count=count;
    }
    public String buy(Account account){
        if(account.getBalance() >price){
            double newBalance=account.getBalance()-price;
            account.setBalance(newBalance);
            count--;
            return "Item bought";
        }
        else{
            return "Not Enough Balance";
        }
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}