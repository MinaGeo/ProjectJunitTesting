package com.Banking;

import org.junit.*;

import static org.junit.Assert.*;
public class User_AccountTransactionBillsItemsStubs {
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
            System.out.println("Ending all testCases");}

        @Test
        public void TestCreateAccount()
        { //Tested User with Account , Transaction , Bills , Items as stubs
            int CounterBefore = User.counterAccount;
           Account acc= myUser.CreateAccount("Saving", "Farida278",2373, false);
            assertEquals(CounterBefore+1,User.counterAccount);

            String Withdraw = acc.Withdraw(100,true);
            assertEquals("Stubbed withdraw transaction",Withdraw);

            String Deposit = acc.Deposit(100,true);
            assertEquals("Stubbed deposit transaction",Deposit);

            Account acc2= myUser.CreateAccount("Saving", "Faridaaa28",2973, false);
            String Transfer = acc.Transfer(100,acc2,true);
            assertEquals("Stubbed transfer transaction",Transfer);

            Bill_payment_stub bill_payment_stub= new Bill_payment_stub("Electricity",100);
            String PayBills =acc.PayBills_Stub(bill_payment_stub);
            assertEquals("Stubbed payment operation",PayBills);

            Items_stub item_stub= new Items_stub("item1","1",100,3);
            String BuyItem=acc.BuyItems_stub(item_stub);
            assertEquals("Stubbed buy operation",BuyItem);

        }


    }

