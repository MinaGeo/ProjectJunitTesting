package com.Banking;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class User_Account_TransactionBillsItemsStubs {

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
    public void TestCreateAccount4()
    { //Tested User with Account , Transaction , Bills , Items as stubs
        int CounterBefore = User.counterAccount;
        Account acc= myUser.CreateAccount("Saving", "Farida278",2373, false);
        assertEquals(CounterBefore+1,User.counterAccount);


        String Withdraw = acc.Withdraw(100,false);
        double actualBalance = acc.getBalance();
        assertEquals(Withdraw, "insufficient balance or account doesn't exist");


        String Deposit = acc.Deposit(1000,false);
        double newbalance = acc.getBalance();
        assertEquals(1000.0, newbalance, 0.001);


        Account acc2 = new Account(1000.0, "123456789", "Savings", "John Doe", "123456789",1234);
        String Transfer = acc.Transfer(100,acc2,false);
        double Balance = acc.getBalance();
        double actualBalance2 = acc2.getBalance();
        assertEquals(900, Balance, 0.001);
        assertEquals(1100.0, actualBalance2, 0.001);


        Bill_payment_stub bill_payment_stub= new Bill_payment_stub("Electricity",100);
        String PayBills =acc.PayBills_Stub(bill_payment_stub);
        assertEquals("Stubbed payment operation",PayBills);

        Items_stub item_stub= new Items_stub("item1","1",100,3);
        String BuyItem=acc.BuyItems_stub(item_stub);
        assertEquals("Stubbed buy operation",BuyItem);

    }





}
