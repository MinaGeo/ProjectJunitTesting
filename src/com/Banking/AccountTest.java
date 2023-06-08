package com.Banking;

import org.junit.*;
//import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.*;


public class AccountTest {

    static Account my_account;

    @BeforeClass
     static public void setUp() {
        System.out.println("Starting all testcases");
        my_account = new Account(1000.0, "123456789", "Savings", "John Doe", "123456789",1234);
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
    public void testGetBalance() {
        double expectedBalance = 1000.0;
        double actualBalance = my_account.getBalance();
        assertEquals(expectedBalance, actualBalance,0.00);
    }


    @Test
    public void TestValidation()
    {
        Account testaccount = my_account.validation(1234);
        assertNotNull(testaccount);
    }

    @Test
    public void TestInvalidValidation(){
        Account testaccount = my_account.validation(1235);
        assertNull(testaccount);
    }

    @Test
    public void testWithdraw()
    {
//Test withdraw with stub
        assertEquals("Stubbed withdraw transaction", my_account.Withdraw(1000,true));
    }

    @Test
    public void TestDeposit(){
        //Test Deposit with stub
        assertEquals("Stubbed deposit transaction",my_account.Deposit(1000,true));

    }

    @Test
    public void TestTransfer(){
        //Test Transfer with stub
        Account new_account = new Account(1000.0, "123456789", "Savings", "Harry", "123456789",1234);
        assertEquals("Stubbed transfer transaction",my_account.Transfer(1000,new_account,true));
    }
    @Test
    public void TestPayBills_Stub(){
        Bill_payment_stub bill_payment_stub = new Bill_payment_stub("electricity", 300);
        assertEquals("Stubbed payment operation",my_account.PayBills_Stub(bill_payment_stub));
    }
    public void TestBuyItems_stub(){
        Items_stub buy_items_stub = new Items_stub("item1","123",100,1);
        assertEquals("Stubbed buy operation",my_account.BuyItems_stub(buy_items_stub));
    }


}