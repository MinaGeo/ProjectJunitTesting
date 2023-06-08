package com.Banking;

import java.util.ArrayList;

public class  User {

    private String name;
    private String Email;
    private String Password;

    private ArrayList<Account> accountsInUser;
    static ArrayList<User> userList = new ArrayList<>();
    static int counter =0;
static int counterAccount =0;

    public User(String name, String email, String password) {
        this.name = name;
        this.Email = email;
        this.Password = password;
        counter++;
    }

    public Account CreateAccount( String AccountType, String UserId,int SecurityNumber, boolean isStub)
    {
        if (!isStub)
        {  Account account = new Account( 0,Integer.toString(counter),AccountType, name,UserId,SecurityNumber);
        counterAccount++;
            return account;

        }
    else {
        AccountStub account = new AccountStub( 0,Integer.toString(counter),AccountType, name,UserId,SecurityNumber);
        counterAccount++;
            return account;

        }

    }

    public static String register(String name, String email, String password) {
        boolean flag = false;
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                flag = true;
                System.out.println("User already exist.");
                return "User already exist.";
            }
        }
        if(!flag)
        {
            User userl = new User(name, email, password);
            userList.add(userl);
            System.out.println("User registered successfully.");
            return "User registered successfully.";
        }

        return "";
    }

    public static boolean login(String email, String password) {
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful.");
                return true;
            }
        }
        System.out.println("Invalid email or password.");
        return false;
    }


    public static boolean updateProfile(String oldEmail, String oldPassword, String newEmail, String newPassword)
    {
        for (User user : userList) {
            if (login(oldEmail,oldPassword)) {
                user.setEmail(newEmail);
                user.setPassword(newPassword);
                System.out.println("Updated successfully.");

                return true;
            }
        }
        System.out.println("Invalid email or password.");
        return false;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return Email;
    }
    public String getPassword() {
        return Password;
    }
}
