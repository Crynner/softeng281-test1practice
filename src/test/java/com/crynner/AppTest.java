package com.crynner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

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
    @TestMethodOrder(MethodOrderer.MethodName.class)
    public static class CriminalInvestigationTests {
        @AfterEach
        public void reset() {
            CriminalInvestigation.resetTotalCases();
        }

        private CriminalInvestigation investigation;

        @BeforeEach
        void setUp() {
            investigation = new CriminalInvestigation(); // Initializes a fresh instance of the system before each test
        }

        // Test Case 1: Adding a new case
        @Test
        void testAddCase() {
            investigation.addCase("C001", "John Doe", "Jane Smith", "Murder");
            assertEquals(1, CriminalInvestigation.getTotalCases());
            assertEquals("Case ID: C001, Victim: John Doe, Suspect: Jane Smith, Status: Open, Crime Type: Murder",
                        investigation.getCaseDetails("C001"));
        }

        // Test Case 2: Retrieving details of an existing case
        @Test
        void testGetCaseDetailsExistingCase() {
            investigation.addCase("C001", "John Doe", "Jane Smith", "Murder");
            String caseDetails = investigation.getCaseDetails("C001");
            assertTrue(caseDetails.contains("Victim: John Doe"));
            assertTrue(caseDetails.contains("Suspect: Jane Smith"));
            assertTrue(caseDetails.contains("Status: Open"));
        }

        // Test Case 3: Retrieving details of a non-existing case
        @Test
        void testGetCaseDetailsNonExistingCase() {
            String caseDetails = investigation.getCaseDetails("C999");
            assertEquals("Case not found", caseDetails);
        }

        // Test Case 4: Updating case status (Valid update)
        @Test
        void testUpdateCaseStatusValid() {
            investigation.addCase("C001", "John Doe", "Jane Smith", "Murder");
            investigation.updateCaseStatus("C001", "Closed");
            assertEquals("Case ID: C001, Victim: John Doe, Suspect: Jane Smith, Status: Closed, Crime Type: Murder",
                        investigation.getCaseDetails("C001"));
        }

        // Test Case 5: Updating case status for a non-existing case
        @Test
        void testUpdateCaseStatusInvalid() {
            investigation.updateCaseStatus("C999", "Closed");
            assertEquals("Case not found", investigation.getCaseDetails("C999"));
        }

        // Test Case 6: Adding multiple cases and verifying total cases count
        @Test
        void testAddMultipleCases() {
            investigation.addCase("C001", "John Doe", "Jane Smith", "Murder");
            investigation.addCase("C002", "Alice Green", "Bob Brown", "Theft");
            investigation.addCase("C003", "Eve White", "Tom Black", "Fraud");
            
            assertEquals(3, CriminalInvestigation.getTotalCases());
        }

        // Test Case 7: Adding a case and checking its status after initialization
        @Test
        void testDefaultStatusOnCaseAdd() {
            investigation.addCase("C001", "John Doe", "Jane Smith", "Murder");
            String caseDetails = investigation.getCaseDetails("C001");
            assertTrue(caseDetails.contains("Status: Open"));
        }

        // Test Case 8: Adding a case and checking if the total count of cases is correct
        @Test
        void testTotalCasesAfterAdding() {
            investigation.addCase("C001", "John Doe", "Jane Smith", "Murder");
            investigation.addCase("C002", "Alice Green", "Bob Brown", "Theft");
            assertEquals(2, CriminalInvestigation.getTotalCases());
        }

        // Test Case 9: Verifying behavior when trying to add a case with an already existing ID
        @Test
        void testAddCaseWithDuplicateId() {
            investigation.addCase("C001", "John Doe", "Jane Smith", "Murder");
            investigation.addCase("C001", "Alice Green", "Bob Brown", "Theft"); // Same ID
            String caseDetails = investigation.getCaseDetails("C001");
            assertEquals("Case ID: C001, Victim: John Doe, Suspect: Jane Smith, Status: Open, Crime Type: Murder", caseDetails);
            // Check that the second case does not overwrite the first one
        }

        // Test Case 10: Testing getTotalCases() after adding and updating cases
        @Test
        void testGetTotalCasesAfterAddUpdate() {
            investigation.addCase("C001", "John Doe", "Jane Smith", "Murder");
            investigation.addCase("C002", "Alice Green", "Bob Brown", "Theft");
            investigation.updateCaseStatus("C001", "Closed");

            assertEquals(2, CriminalInvestigation.getTotalCases());
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
