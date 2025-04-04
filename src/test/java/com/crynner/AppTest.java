package com.crynner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;



public class AppTest 
{

    @TestMethodOrder(MethodOrderer.MethodName.class)
    public static class SteelFabricationManagerTest {

        SteelFabricationManager manager;
    
        @BeforeEach
        void setUp() {
            manager = new SteelFabricationManager(); // Initialize the manager before each test
        }
    
        @Test
        void testAddProjectNewProject() {
            manager.addProject("Bridge Construction", 50000.0);
            assertEquals(50000.0, manager.getProjectCost("Bridge Construction"), "The cost of the new project is incorrect");
            assertEquals(1, manager.getProjectCount(), "The project count is incorrect after adding a new project");
        }
    
        @Test
        void testAddProjectUpdateExisting() {
            manager.addProject("Bridge Construction", 50000.0);
            manager.addProject("Bridge Construction", 60000.0); // Update the cost
            assertEquals(60000.0, manager.getProjectCost("Bridge Construction"), "The cost was not updated correctly");
            assertEquals(1, manager.getProjectCount(), "The project count should remain the same after updating a project");
        }
    
        @Test
        void testGetTotalCost() {
            manager.addProject("Bridge Construction", 50000.0);
            manager.addProject("Road Construction", 30000.0);
            assertEquals(80000.0, manager.getTotalCost(), "The total cost of all projects is incorrect");
        }
    
        @Test
        void testGetProjectCostNonExistentProject() {
            assertEquals(-1, manager.getProjectCost("Nonexistent Project"), "The cost for a nonexistent project should return -1");
        }
    
        @Test
        void testGetProjectCountEmptyList() {
            assertEquals(0, manager.getProjectCount(), "The project count should be 0 for an empty list");
        }
    
        @Test
        void testGetProjectCountMultipleProjects() {
            manager.addProject("Bridge Construction", 50000.0);
            manager.addProject("Road Construction", 30000.0);
            assertEquals(2, manager.getProjectCount(), "The project count is incorrect after adding multiple projects");
        }
    
        @Test
        void testAddProjectWithZeroCost() {
            manager.addProject("Bridge Construction", 0.0);
            assertEquals(0.0, manager.getProjectCost("Bridge Construction"), "The cost for a project with zero cost should be handled correctly");
        }
    
        @Test
        void testGetTotalCostAfterRemoval() {
            manager.addProject("Bridge Construction", 50000.0);
            manager.addProject("Road Construction", 30000.0);
            manager.addProject("Tunnel Construction", 40000.0);
            manager.addProject("Bridge Construction", 60000.0); // Updating the existing project cost
            assertEquals(130000.0, manager.getTotalCost(), "The total cost is incorrect after project cost update");
        }
    
        @Test
        void testAddMultipleProjects() {
            manager.addProject("Project A", 1000.0);
            manager.addProject("Project B", 2000.0);
            manager.addProject("Project C", 3000.0);
            assertEquals(6000.0, manager.getTotalCost(), "The total cost of multiple projects is incorrect");
            assertEquals(3, manager.getProjectCount(), "The project count should be 3 after adding multiple projects");
        }
    
        @Test
        void testAddProjectSameNameDifferentCosts() {
            manager.addProject("Project X", 5000.0);
            manager.addProject("Project X", 7000.0); // Update cost of existing project
            assertEquals(7000.0, manager.getProjectCost("Project X"), "The cost of 'Project X' should be updated to 7000.0");
        }
    }

    @TestMethodOrder(MethodOrderer.MethodName.class)
    public static class BankAccountTest {

        BankAccount account1;
        BankAccount account2;

        @BeforeEach
        void setUp() {
            BankAccount.resetTotalAccounts();
            account1 = new BankAccount(1000.0); // Initial balance for account1
            account2 = new BankAccount(500.0);  // Initial balance for account2
        }

        @Test
        void testDepositPositiveAmount() {
            account1.deposit(200.0); 
            assertEquals(1200.0, account1.getBalance(), "Deposit did not update balance correctly");
        }

        @Test
        void testDepositNegativeAmount() {
            account1.deposit(-50.0);
            assertEquals(1000.0, account1.getBalance(), "Deposit should not change balance for negative amounts");
        }

        @Test
        void testWithdrawSufficientFunds() {
            account1.withdraw(200.0);
            assertEquals(800.0, account1.getBalance(), "Withdraw did not update balance correctly");
        }

        @Test
        void testWithdrawInsufficientFunds() {
            account1.withdraw(1500.0); 
            assertEquals(1000.0, account1.getBalance(), "Withdraw should not change balance for insufficient funds");
        }

        @Test
        void testTransferSufficientFunds() {
            account1.transferTo(account2, 300.0);
            assertEquals(700.0, account1.getBalance(), "Transfer did not update account1 balance correctly");
            assertEquals(800.0, account2.getBalance(), "Transfer did not update account2 balance correctly");
        }

        @Test
        void testTransferInsufficientFunds() {
            account1.transferTo(account2, 1500.0); 
            assertEquals(1000.0, account1.getBalance(), "Transfer should not happen with insufficient funds");
            assertEquals(500.0, account2.getBalance(), "Transfer should not affect account2 balance");
        }

        @Test
        void testGetTotalAccounts() {
            BankAccount account3 = new BankAccount(1000.0); // Create another account
            assertEquals(3, BankAccount.getTotalAccounts(), "Total accounts count is incorrect");
        }

        @Test
        void testCreateBankAccount() {
            BankAccount account3 = new BankAccount(500.0); 
            assertNotNull(account3, "Account creation failed");
            assertEquals(3, BankAccount.getTotalAccounts(), "Total accounts count is incorrect after creating a new account");
        }

        @Test
        void testAccountBalanceAfterMultipleDeposits() {
            account1.deposit(500.0);
            account1.deposit(100.0);
            account1.deposit(200.0);
            assertEquals(1800.0, account1.getBalance(), "Balance did not update correctly after multiple deposits");
        }

        @Test
        void testAccountBalanceAfterMultipleWithdrawals() {
            account1.withdraw(200.0);
            account1.withdraw(100.0);
            account1.withdraw(50.0);
            assertEquals(650.0, account1.getBalance(), "Balance did not update correctly after multiple withdrawals");
        }
    }

    @TestMethodOrder(MethodOrderer.MethodName.class)
    public static class SpaceFleetTest {
    
        SpaceFleet fleet;

        @BeforeEach
        void setUp() {
            fleet = new SpaceFleet();
            fleet.addSpaceship("Apollo");
            fleet.addSpaceship("Orion");
            fleet.addSpaceship("Discovery");
        }

        @Test
        void testAddSpaceship() {
            fleet.addSpaceship("Voyager");
            ArrayList<String> spaceships = fleet.listSpaceships();
            assertEquals(4, spaceships.size());
            assertTrue(spaceships.contains("Voyager"));
        }

        @Test
        void testUpdateMissionStatus() {
            fleet.updateMissionStatus("Apollo", "Active");
            String status = fleet.getMissionStatus("Apollo");
            assertEquals("Active", status);
        }

        @Test
        void testGetMissionStatus() {
            fleet.updateMissionStatus("Discovery", "Inactive");
            assertEquals("Inactive", fleet.getMissionStatus("Discovery"));
        }

        @Test
        void testListSpaceships() {
            ArrayList<String> spaceships = fleet.listSpaceships();
            assertEquals(3, spaceships.size());
            assertTrue(spaceships.contains("Apollo"));
            assertTrue(spaceships.contains("Orion"));
            assertTrue(spaceships.contains("Discovery"));
        }

        @Test
        void testGetSpaceshipsByStatus() {
            fleet.updateMissionStatus("Apollo", "Active");
            fleet.updateMissionStatus("Orion", "Inactive");
            
            ArrayList<String> activeSpaceships = fleet.getSpaceshipsByStatus("Active");
            assertEquals(1, activeSpaceships.size());
            assertTrue(activeSpaceships.contains("Apollo"));
        }

        @Test
        void testRemoveSpaceship() {
            fleet.removeSpaceship("Orion");
            ArrayList<String> spaceships = fleet.listSpaceships();
            assertEquals(2, spaceships.size());
            assertFalse(spaceships.contains("Orion"));
        }

        @Test
        void testPrintFleetSummary() {
            fleet.updateMissionStatus("Apollo", "Active");
            fleet.updateMissionStatus("Orion", "Inactive");
            fleet.updateMissionStatus("Discovery", "Active");
            
            fleet.printFleetSummary();
            // The printed output should match the expected output, but for test cases, we can only verify through manual inspection or mocking the print statement
        }

        @Test
        void testEmptyFleet() {
            SpaceFleet emptyFleet = new SpaceFleet();
            ArrayList<String> spaceships = emptyFleet.listSpaceships();
            assertTrue(spaceships.isEmpty());
        }

        @Test
        void testGetMissionStatusNotFound() {
            fleet.updateMissionStatus("Discovery", "Active");
            assertNull(fleet.getMissionStatus("Voyager"));
        }

        @Test
        void testSpaceshipNameWithSpaces() {
            fleet.addSpaceship("USS Enterprise");
            fleet.updateMissionStatus("USS Enterprise", "Active");
            assertEquals("Active", fleet.getMissionStatus("USS Enterprise"));
        }
    }

    @TestMethodOrder(MethodOrderer.MethodName.class)
    public static class CharacterTest {

        @Test
        void testWarriorCreation() {
            Warrior warrior = new Warrior("Sir Arthur", 5, "Sword");
            assertEquals("Sir Arthur", warrior.getDetails().split(", ")[0].split(": ")[1]);
            assertEquals(5, Integer.parseInt(warrior.getDetails().split(", ")[1].split(": ")[1]));
        }
    
        @Test
        void testMageCreation() {
            Mage mage = new Mage("Merlin", 10, "Fire");
            assertEquals("Merlin", mage.getDetails().split(", ")[0].split(": ")[1]);
            assertEquals(10, Integer.parseInt(mage.getDetails().split(", ")[1].split(": ")[1]));
        }
    
        @Test
        void testWarriorAttack() {
            Warrior warrior = new Warrior("Sir Arthur", 5, "Sword");
            assertEquals("Sir Arthur swings his Sword!", warrior.attack());
        }
    
        @Test
        void testMageAttack() {
            Mage mage = new Mage("Merlin", 10, "Fire");
            assertEquals("Merlin casts a Fire spell!", mage.attack());
        }
    
        @Test
        void testWarriorWeaponChange() {
            Warrior warrior = new Warrior("Sir Arthur", 5, "Axe");
            assertEquals("Sir Arthur swings his Axe!", warrior.attack());
        }
    
        @Test
        void testMageElementChange() {
            Mage mage = new Mage("Gandalf", 15, "Lightning");
            assertEquals("Gandalf casts a Lightning spell!", mage.attack());
        }
    
        @Test
        void testCharacterPolymorphismWithWarrior() {
            Character character = new Warrior("Lancelot", 7, "Spear");
            assertEquals("Lancelot swings his Spear!", character.attack());
        }
    
        @Test
        void testCharacterPolymorphismWithMage() {
            Character character = new Mage("Morgana", 8, "Dark Magic");
            assertEquals("Morgana casts a Dark Magic spell!", character.attack());
        }
    
        @Test
        void testWarriorDetailsFormat() {
            Warrior warrior = new Warrior("Sir Percival", 6, "Mace");
            assertEquals("Name: Sir Percival, Level: 6", warrior.getDetails());
        }
    
        @Test
        void testMageDetailsFormat() {
            Mage mage = new Mage("Saruman", 12, "Necromancy");
            assertEquals("Name: Saruman, Level: 12", mage.getDetails());
        }
    }

    @TestMethodOrder(MethodOrderer.MethodName.class)
    public static class DisasterEventTest {

        // Test 1: Constructor 1 - Only ID and Name
        @Test
        public void testConstructor1() {
            DisasterEvent event = new DisasterEvent("D001", "Hurricane Katrina");
            assertEquals("D001", event.getId());
            assertEquals("Hurricane Katrina", event.getName());
            assertEquals("Unknown", event.getLocation());
            assertEquals("Unknown", event.getImpactLevel());
            assertEquals(0.0, event.getDamageCost());
        }
    
        // Test 2: Constructor 2 - All Parameters
        @Test
        public void testConstructor2() {
            DisasterEvent event = new DisasterEvent("D002", "Tsunami", "Japan", "Severe", 5000000.0);
            assertEquals("D002", event.getId());
            assertEquals("Tsunami", event.getName());
            assertEquals("Japan", event.getLocation());
            assertEquals("Severe", event.getImpactLevel());
            assertEquals(5000000.0, event.getDamageCost());
        }
    
        // Test 3: Constructor 3 - ID, Name, and Location
        @Test
        public void testConstructor3() {
            DisasterEvent event = new DisasterEvent("D003", "Earthquake", "Chile");
            assertEquals("D003", event.getId());
            assertEquals("Earthquake", event.getName());
            assertEquals("Chile", event.getLocation());
            assertEquals("Unknown", event.getImpactLevel());
            assertEquals(0.0, event.getDamageCost());
        }
    
        // Test 4: getDisasterDetails() - Constructor 1
        @Test
        public void testGetDisasterDetails_Constructor1() {
            DisasterEvent event = new DisasterEvent("D004", "Flood");
            String expected = "ID: D004, Name: Flood, Location: Unknown, Impact Level: Unknown, Damage Cost: 0.0";
            assertEquals(expected, event.getDisasterDetails());
        }
    
        // Test 5: getDisasterDetails() - Constructor 2
        @Test
        public void testGetDisasterDetails_Constructor2() {
            DisasterEvent event = new DisasterEvent("D005", "Tornado", "USA", "Moderate", 200000.0);
            String expected = "ID: D005, Name: Tornado, Location: USA, Impact Level: Moderate, Damage Cost: 200000.0";
            assertEquals(expected, event.getDisasterDetails());
        }
    
        // Test 6: updateDamageCost() - Increase Damage Cost
        @Test
        public void testUpdateDamageCost_Increase() {
            DisasterEvent event = new DisasterEvent("D006", "Wildfire", "Australia", "Severe", 1000000.0);
            event.updateDamageCost(2000000.0);
            assertEquals(2000000.0, event.getDamageCost());
        }
    
        // Test 7: updateDamageCost() - Decrease Damage Cost
        @Test
        public void testUpdateDamageCost_Decrease() {
            DisasterEvent event = new DisasterEvent("D007", "Volcanic Eruption", "Iceland", "Severe", 3000000.0);
            event.updateDamageCost(2500000.0);
            assertEquals(2500000.0, event.getDamageCost());
        }
    
        // Test 8: updateDamageCost() - Zero Damage Cost
        @Test
        public void testUpdateDamageCost_Zero() {
            DisasterEvent event = new DisasterEvent("D008", "Landslide", "India", "Moderate", 150000.0);
            event.updateDamageCost(0.0);
            assertEquals(0.0, event.getDamageCost());
        }
    
        // Test 9: updateDamageCost() - Large Value
        @Test
        public void testUpdateDamageCost_LargeValue() {
            DisasterEvent event = new DisasterEvent("D009", "Blizzard", "Canada", "Severe", 500000.0);
            event.updateDamageCost(100000000.0);
            assertEquals(100000000.0, event.getDamageCost());
        }
    
        // Test 10: getDisasterDetails() - After Updating Damage Cost
        @Test
        public void testGetDisasterDetails_AfterUpdate() {
            DisasterEvent event = new DisasterEvent("D010", "Drought", "Africa", "Severe", 5000000.0);
            event.updateDamageCost(8000000.0);
            String expected = "ID: D010, Name: Drought, Location: Africa, Impact Level: Severe, Damage Cost: 8000000.0";
            assertEquals(expected, event.getDisasterDetails());
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
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
