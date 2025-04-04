package com.crynner;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses({AppTest.BankAccountTests.class})
@Suite
class TestSuite {
}

public class AppTest 
{

    @TestMethodOrder(MethodOrderer.MethodName.class)
    public static class BankAccountTests {
        @AfterEach
        public void reset() {
            BankAccount.resetTotalAccounts();
        }
        
        @Test
        public void E1_checkBankZero() {
            assertEquals(0, BankAccount.getTotalAccounts());
        }
    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testSystemOutPrintln() {
        // Arrange: Create a ByteArrayOutputStream to capture the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        // Backup the original System.out
        PrintStream originalSystemOut = System.out;

        // Redirect System.out to our ByteArrayOutputStream
        System.setOut(ps);

        // Act: Print something to System.out
        System.out.println("Hello, JUnit!");

        // Reset System.out to the original one
        System.setOut(originalSystemOut);

        // Assert: Check if the output matches the expected output
        String output = baos.toString().trim();  // .trim() to remove the newline character
        assertEquals("Hello, JUnit!", output);
    }
}
