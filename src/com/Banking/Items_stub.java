package com.Banking;

public class Items_stub extends Items {

    public Items_stub(String name, String id, double price, int count) {
        super(name, id, price, count);
    }

    @Override
    public String buy(Account account) {
        // Perform stubbed buy logic
        return "Stubbed buy operation";
    }
}
