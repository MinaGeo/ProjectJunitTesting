package com.Banking;

import org.junit.*;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import static org.junit.Assert.*;

public class TransactionTest {
    String transactionID = "T123";
    Date date = new Date();
    double amount = 100.0;
    String transactionType = "Transaction";
    String sender = "null";
    String recipient = "null";

    //static Transaction Transaction1;
    Transaction Transaction1 = new Transaction("T123", date, amount, transactionType);
   Account account = new Account(1000.0, "A125", "saving", "Ahmed", "123456789",2636 );

    LocalDateTime currentTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedTimestamp = currentTime.format(formatter);

//    static Account account;

    @BeforeClass
    static public void setUp() {
        System.out.println("Starting all testcases");

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
    public void testGetTransactionID() {

        String actualTransactionID = Transaction1.getTransactionID();

        assertEquals(transactionID, actualTransactionID);
    }

    @Test
    public void testGetAmount() {

        double actualAmount = Transaction1.getAmount();
        assertEquals(amount, actualAmount, 0.001);
    }
    @Test
    public void TestGetBalance(){
        assertEquals(1000,account.getBalance(),0.001);
    }

    @Test
    public void testDeposit() {
        String Deposit;
        Deposit= Transaction1.deposit(amount, account, 2636);
        double actualBalance = account.getBalance();
        assertEquals(1100.0, actualBalance, 0.001);
        assertEquals(Deposit , "Transaction ID: " + transactionID + "\nTimestamp: " + formattedTimestamp + "\nAmount: " + amount +
                "\nTransaction Type: deposit");
    }

    @Test
    public void TestWithdrawSufficient(){
        String Withdraw= Transaction1.withdraw(amount, account, 2636);
        double actualBalance = account.getBalance();
        assertEquals(900.0, actualBalance, 0.001);
        assertEquals(Withdraw, "Transaction ID: " + transactionID + "\nTimestamp: " + formattedTimestamp + "\nAmount: " + amount +
                "\nTransaction Type: withdraw");
    }

    @Test
    public void testDepositNegative() {
        String Deposit= Transaction1.deposit(-amount, account, 2636);
        assertEquals(Deposit, "invalid amount for Deposit or account does not exist");
    }
    @Test
    public void TestDepositZero(){
        String Deposit= Transaction1.deposit(0, account, 2636);
        assertEquals(Deposit, "invalid amount for Deposit or account does not exist");
    }


    @Test
    public void TestWithdrawNegative(){
        String Withdraw= Transaction1.withdraw(-amount, account, 2636);
        assertEquals(Withdraw,"invalid amount for Withdraw");
    }

    @Test
    public void TestWithdrawZero(){
        String Withdraw= Transaction1.withdraw(0, account, 2636);
       assertEquals(Withdraw, "invalid amount for Withdraw");
    }

    @Test
    public void TestWithdrawInsufficient(){
        String Withdraw= Transaction1.withdraw(2000, account,2636);
        assertEquals(Withdraw, "insufficient balance or account doesn't exist");
    }
    @Test
    public void TestTransfer(){
        Account account1 = new Account(2000, "B126", "saving", "omar", "123456789",1236);
        Account account2 = new Account(1000, "A123", "saving", "Aly", "1234567722",8264);
        String Transfer= Transaction1.transfer(amount, account1, account2,1236, 8264);
        double actualBalance = account1.getBalance();
        double actualBalance2 = account2.getBalance();
        assertEquals(1900.0, actualBalance, 0.001);
        assertEquals(1100.0, actualBalance2, 0.001);
        assertEquals(Transfer, "Transaction ID: " + transactionID + "\nTimestamp: " + formattedTimestamp + "\nAmount: " + amount +
                "\nTransaction Type: transfer" + "\nSender: " + account1.getAccountHolderName() + "\nRecipient: " + account2.getAccountHolderName());
    }
    @Test
    public void TestTransferNegative(){
        Account account1 = new Account(2000, "B126", "saving", "omar", "123456789",2634);
        Account account2 = new Account(1000, "A123", "saving", "Aly", "1234567722",2836);
        String Transfer = Transaction1.transfer(-amount, account1, account2,2634, 2836);
        double actualBalance = account1.getBalance();
        double actualBalance2 = account2.getBalance();
        assertEquals(Transfer, "invalid amount for Transfer");
        assertEquals(2000.0, actualBalance, 0.001);
        assertEquals(1000.0, actualBalance2, 0.001);
    }
    @Test
    public void TestTransferZero(){
        Account account1 = new Account(2000, "B126", "saving", "omar", "123456789",2735);
        Account account2 = new Account(1000, "A123", "saving", "Aly", "1234567722",2625);
        String Transfer = Transaction1.transfer(0, account1, account2,2735, 2625);
        double actualBalance = account1.getBalance();
        double actualBalance2 = account2.getBalance();
       assertEquals(Transfer, "invalid amount for Transfer");
        assertEquals(2000.0, actualBalance, 0.001);
        assertEquals(1000.0, actualBalance2, 0.001);

    }

    @Test
    public void TestTransferInsufficientBalance(){
        Account account1 = new Account(2000, "B126", "saving", "omar", "123456789",2635);
        Account account2 = new Account(1000, "A123", "saving", "Aly", "1234567722",1542 );
        String Transfer = Transaction1.transfer(3000, account1, account2,2635, 1542);
        double actualBalance = account1.getBalance();
        double actualBalance2 = account2.getBalance();
        assertEquals(Transfer, "insufficient balance for transfer or accounts doesn't exists");
        assertEquals(2000.0, actualBalance, 0.001);
        assertEquals(1000.0, actualBalance2, 0.001);
    }

    @Test
    public void TestUserDoesnotexist(){
        Account account1 = new Account(2000, "B126", "saving", "omar", "123456789",2000);
        String Transfer = Transaction1.transfer(amount, account,account1,2636, 1542 );
        assertEquals(Transfer, "insufficient balance for transfer or accounts doesn't exists");
    }
    @Test
    public void TestWithdrawUserDoesnotexist(){
        String Withdraw= Transaction1.withdraw(amount,account,2222 );
        assertEquals(Withdraw, "insufficient balance or account doesn't exist");
    }
    @Test
    public void TestDepositUserDoesnotexist(){
        String Deposit= Transaction1.deposit(amount, account, 2873);
        assertEquals(Deposit, "invalid amount for Deposit or account does not exist");
    }



}