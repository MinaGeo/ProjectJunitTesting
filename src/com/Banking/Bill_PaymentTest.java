package com.Banking;

import org.junit.*;
import static org.junit.Assert.*;

public class Bill_PaymentTest {
//    Account account = new Account(1000, "A123", "Saving", "John","123456789",1234);
//    Bill_Payment bill_payment = new Bill_Payment("Electricity", 50.0);
    static Account account;
    static Bill_Payment bill_payment;

    @BeforeClass
    static public void setUp() {
        System.out.println("Starting all testcases");

        account = new Account(1000.0, "123456789", "Savings", "John Doe", "123456789",1234);
        bill_payment = new Bill_Payment("Electricity", 50.0);
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
        double actualBalance = account.getBalance();
        assertEquals(expectedBalance, actualBalance,0.00);
    }
    @Test
    public void testAddBill() {

        int initialBillsSize = account.getBills().size();
        bill_payment.addBill("Electricity", 50.0,account);
        int updatedBillsSize = account.getBills().size();
        assertEquals(initialBillsSize + 1, updatedBillsSize);
    }


    @Test
    public void testPayBillAfterPayment() {
        bill_payment.addBill("Electricity", 50.0,account);
        int initialBillsSize = account.getBills().size();
        double initialBalance=account.getBalance();
        bill_payment.pay(account);
        int updatedBillsSize = account.getBills().size();
        double updatedBalance = account.getBalance();
        assertEquals(initialBillsSize - 1, updatedBillsSize);
        assertEquals(updatedBalance,initialBalance-50,0.0);
    }

    @Test
    public void testPayBillWithNonExistingBill() {
        int initialBillsSize = account.getBills().size();
        String out= bill_payment.pay(account);
        int updatedBillsSize = account.getBills().size();
        double updatedBalance = account.getBalance();
        assertEquals(initialBillsSize, updatedBillsSize);
        assertEquals(1000.0, updatedBalance,0.0);
        assertEquals("Bill not found",out);
    }

    @Test
    public void testFindBillWithExistingBillType() {
        bill_payment.addBill("Electricity", 50.0,account);
        int billIndex = bill_payment.findBill("Electricity",account);
        assertEquals(0, billIndex);
    }

    @Test
    public void testFindBillWithNonExistingBillType() {
        int billIndex = bill_payment.findBill("Water",account);
        assertEquals(-1, billIndex);
    }

}