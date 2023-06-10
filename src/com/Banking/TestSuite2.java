package com.Banking;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.*;
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccountTest.class,
        Bill_PaymentTest.class,
        ItemsTest.class,
        TransactionTest.class,
        UserTest.class,
})


public class TestSuite2 {
}
