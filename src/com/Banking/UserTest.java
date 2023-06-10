package com.Banking;

import org.junit.*;

import static org.junit.Assert.*;

public class UserTest {
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
    public void testValidRegister()
    {
        //Tests of User already exists
        String successfulRegister = myUser.register("Ahmed","Ahmed@gmail.com","12345678");
        assertEquals("User registered successfully.",successfulRegister);
        String unsuccessfulRegister = myUser.register("Ahmed","Ahmed@gmail.com","12345678");
        assertEquals("User already exist.",unsuccessfulRegister);

    }

    @Test
    public void testValidLogin()
    {
        myUser.register("Mostafa","Mostafa@gmail.com","9876543210");
        boolean login = myUser.login("Mostafa@gmail.com","9876543210");
     //   GlobalData.setUserID("Mostafa@gmail.com");
        assertTrue(login);
    }
    @Test
    public void testInValidLogin()
    {
        //com.Banking.Account doesn't exist

        myUser.register("Khaled","Khaled@gmail.com","987654321");
        boolean login = myUser.login("mina@gmail.com","987654321");
        assertFalse(login);
    }
    @Test
    public void testInValidPasswordLogin()
    {
        myUser.register("Mina","Mina@gmail.com","123456789");
        boolean login = myUser.login("mina@gmail.com","987654321");
        assertFalse(login);
    }

    @Test
    public void testValidUpdate()
    {
        myUser.register("Mina","Mina@gmail.com","123456789");
        boolean update = myUser.updateProfile("Mina@gmail.com","123456789", "James@gmail.com","8282828");
        assertTrue(update);
    }
    @Test
    public void testInvalidUpdate()
    { //old email doesn't exist
        myUser.register("Mina","Mina@gmail.com","123456789");
        boolean update = myUser.updateProfile("Khaled@gmail.com","433232223", "James@gmail.com","8282828");
        assertFalse(update);
    }
    @Test
    public void TestCreateAccount5()
    { //Tested User with Account Stub
        int CounterBefore = User.counterAccount;
        myUser.CreateAccount("Saving", "Farida278",2373, true);
        assertEquals(CounterBefore+1,User.counterAccount);
     }
}