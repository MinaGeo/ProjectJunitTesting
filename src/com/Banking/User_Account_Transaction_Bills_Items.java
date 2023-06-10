package com.Banking;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class User_Account_Transaction_Bills_Items {


    static User myUser;

    @BeforeClass
    static public void startup()
    {
        System.out.println("Starting all testcases");
        myUser = new User("mina","mina@gmail.com","12345678");
    }


    @Before
    public void testCaseStart()
    {
        System.out.println("Starting testCase");
    }
    @After
    public void testCasesEnd()
    {
        System.out.println("Ending testCase");
    }
    @AfterClass
    static public  void shutDown()
    {
        System.out.println("Ending all testCases");
    }
    @Test
    public void TestCreateAccount3()
    { //Tested User with Account , Transaction , Bills , Items as stubs
        int CounterBefore = User.counterAccount;
        Account acc= myUser.CreateAccount("Saving", "Farida278",2373, false);
        assertEquals(CounterBefore+1,User.counterAccount);


        String Deposit = acc.Deposit(1000,false);
        double newbalance = acc.getBalance();
        assertEquals(1000.0, newbalance, 0.001);


        String Withdraw = acc.Withdraw(100,false);
        double actualBalance = acc.getBalance();
        assertEquals(900.0, actualBalance, 0.001);

        Account acc2 = new Account(1000.0, "123456789", "Savings", "John Doe", "123456789",1234);
        String Transfer = acc.Transfer(100,acc2,false);
        double Balance = acc.getBalance();
        double actualBalance2 = acc2.getBalance();
        assertEquals(800, Balance, 0.001);
        assertEquals(1100.0, actualBalance2, 0.001);

        Bill_Payment bill_payment= new Bill_Payment("Electricity",100);
        bill_payment.addBill("Electricity", 100.0,acc);

        int initialBillsSize = acc.getBills().size();
        double initialBalance=acc.getBalance();
        System.out.println("initial balance"+initialBalance);

        String PayBills =acc.PayBills(bill_payment);
        int updatedBillsSize = acc.getBills().size();
        double updatedBalance = acc.getBalance();
        System.out.println("updatedBalance "+updatedBalance);
        assertEquals(initialBillsSize - 1, updatedBillsSize);
        assertEquals(updatedBalance,initialBalance-100,0.0001);

        Items item= new Items("item1","1",100,3);
        String BuyItem=acc.BuyItems(item);
        double initialBalance2 = acc.getBalance();
        String out=item.buy(acc);
        double updatedBalance2 = acc.getBalance();
        assertEquals("Item bought",out);
        assertEquals(updatedBalance2 , initialBalance2- item.getPrice(),0.0);

    }

}
