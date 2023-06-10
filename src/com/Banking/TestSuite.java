package com.Banking;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.*;
@RunWith(Suite.class)
@Suite.SuiteClasses({
        User_Account_Transaction_Bills_Items.class,
        User_Account_Transaction_BillsItemsStubs.class,
        User_Account_TransactionBillsItemsStubs.class,
        User_AccountTransactionBillsItemsStubs.class
})


public class TestSuite {
}
