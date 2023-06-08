package com.Banking;
import org.junit.*;
//import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.*;

public class ItemsTest {
    static Account account;

    @BeforeClass
    static public void setUp() {
        System.out.println("Starting all testcases");

        account = new Account(1000.0, "123456789", "Savings", "John Doe", "123456789",1234);
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
    public void testBuyItemWithSufficientBalance() {
        Items item = new Items("Item 1", "A123", 500.0, 3);
        double initialBalance = account.getBalance();
        String out=item.buy(account);
        double updatedBalance = account.getBalance();
      assertEquals("Item bought",out);
      assertEquals(updatedBalance , initialBalance- item.getPrice(),0.0);
    }

    @Test
    public void testBuyItemWithInsufficientBalance() {
        Items item = new Items("Item 2", "A1234",5000,4);
        double initialBalance = account.getBalance();
        String out = item.buy(account);
        double updatedBalance = account.getBalance();
        assertEquals("Not Enough Balance",out);
        assertEquals(initialBalance, updatedBalance,0.0);

    }


}