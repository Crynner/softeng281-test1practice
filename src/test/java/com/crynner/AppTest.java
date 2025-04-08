package com.crynner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @TestMethodOrder(MethodOrderer.MethodName.class)
    public static class LibrarySystemTest {

        private Library library;
        private Book book1;
        private Book book2;
        private User user1;
        private User user2;
        private User user3;

        @BeforeEach
        public void setUp() {
            library = new Library();
            book1 = new Book("Java Programming");
            book2 = new Book("Algorithms 101");
            user1 = new User("Alice");
            user2 = new User("Bob");
            user3 = new User("Charlie");
            library.addBook(book1, 3); // Add 3 copies of "Java Programming"
            library.addBook(book2, 2); // Add 2 copies of "Algorithms 101"
        }

        @Test
        public void testBorrowBookWhenAvailable() {
            // User1 borrows a book
            library.borrowBook(user1, book1);
            assertEquals(2, library.getAvailableCopies(book1)); // 2 copies should be available
            assertTrue(user1.borrowedBooks().contains(book1)); // User1 should have borrowed the book
        }

        @Test
        public void testBorrowBookWhenNoCopiesAvailable() {
            // User1 borrows all copies of the book
            library.borrowBook(user1, book1);
            library.borrowBook(user2, book1);
            library.borrowBook(user3, book1);

            // There are no more available copies
            assertEquals(0, library.getAvailableCopies(book1));

            // Now, if a fourth user tries to borrow the book, it should fail
            User user4 = new User("Dave");
            library.borrowBook(user4, book1);
            assertEquals(0, library.getAvailableCopies(book1)); // Still 0 available copies
            assertFalse(user4.borrowedBooks().contains(book1)); // User4 shouldn't have borrowed the book
        }

        @Test
        public void testReturnBook() {
            // User1 borrows and then returns a book
            library.borrowBook(user1, book1);
            assertEquals(2, library.getAvailableCopies(book1)); // 2 copies should be available

            library.returnBook(user1, book1);
            assertEquals(3, library.getAvailableCopies(book1)); // 3 copies should be available now
            assertFalse(user1.borrowedBooks().contains(book1)); // User1 should not have the book anymore
        }

        @Test
        public void testGetPossessors() {
            // User1 and User2 borrow a copy of the book
            library.borrowBook(user1, book1);
            library.borrowBook(user2, book1);

            List<User> possessors = library.getPossessors(book1);
            assertEquals(2, possessors.size());
            assertTrue(possessors.contains(user1));
            assertTrue(possessors.contains(user2));
        }

        @Test
        public void testUserToStringNoBooks() {
            // Test the toString method when the user has no books borrowed
            assertEquals("Alice: No books borrowed", user1.toString());
        }

        @Test
        public void testUserToStringWithBooks() {
            // User1 borrows a book and we check toString
            library.borrowBook(user1, book1);
            assertEquals("Alice: Java Programming", user1.toString());
        }

        @Test
        public void testMultipleUsersBorrowSameBook() {
            // User1 and User2 borrow a copy of the same book
            library.borrowBook(user1, book2);
            library.borrowBook(user2, book2);

            assertTrue(user1.borrowedBooks().contains(book2));
            assertTrue(user2.borrowedBooks().contains(book2));
            assertEquals(0, library.getAvailableCopies(book2)); // No copies left
        }

        @Test
        public void testReturnBookAndBorrowAgain() {
            // User1 borrows a book, then returns it, and borrows it again
            library.borrowBook(user1, book1);
            library.returnBook(user1, book1);
            library.borrowBook(user1, book1); // Borrow again

            assertTrue(user1.borrowedBooks().contains(book1)); // User1 should have the book again
            assertEquals(2, library.getAvailableCopies(book1)); // 2 copies should be available
        }

        @Test
        public void testBorrowBookWhenLibraryEmpty() {
            // Try to borrow a book when no copies are available
            library.borrowBook(user1, book1);
            library.borrowBook(user2, book1);
            library.borrowBook(user3, book1); // All copies are borrowed

            // There should be no more available copies
            assertEquals(0, library.getAvailableCopies(book1));

            User user4 = new User("Dave");
            library.borrowBook(user4, book1); // User4 tries to borrow, should fail
            assertFalse(user4.borrowedBooks().contains(book1)); // User4 should not have the book
        }

        @Test
        public void testComprehensiveTest() {
            // Borrowing, returning, multiple users, and possession tracking
            library.borrowBook(user1, book1);
            library.borrowBook(user2, book2);
            library.borrowBook(user3, book1);

            // Assert borrowed books for each user
            assertTrue(user1.borrowedBooks().contains(book1));
            assertTrue(user2.borrowedBooks().contains(book2));
            assertTrue(user3.borrowedBooks().contains(book1));

            // Assert the library’s available copies
            assertEquals(1, library.getAvailableCopies(book1)); // 1 copy of book1 left
            assertEquals(1, library.getAvailableCopies(book2)); // 1 copy of book2 left

            // Return a book and check the system again
            library.returnBook(user1, book1);
            assertEquals(2, library.getAvailableCopies(book1)); // 2 copies should be available now
            assertFalse(user1.borrowedBooks().contains(book1)); // User1 should not have book1 anymore

            // User1 borrows again
            library.borrowBook(user1, book1);
            assertTrue(user1.borrowedBooks().contains(book1)); // User1 should now have book1
            assertEquals(1, library.getAvailableCopies(book1)); // Only 1 copy left in the library

            // Get and assert all possessors of book1
            List<User> possessors = library.getPossessors(book1);
            assertEquals(2, possessors.size());
            assertTrue(possessors.contains(user1));
            assertTrue(possessors.contains(user3));
        }
    }

    @TestMethodOrder(MethodOrderer.MethodName.class)
    public static class ZooTest {

        private Animal lion;
        private Animal tiger;
        private Zookeeper alice;
        private Zookeeper bob;
        private ZooManager zooManager;
    
        @BeforeEach
        void setUp() {
            lion = new Animal("Lion");
            tiger = new Animal("Tiger");
            alice = new Zookeeper("Alice");
            bob = new Zookeeper("Bob");
            zooManager = new ZooManager();
            
            zooManager.addZookeeper(alice);
            zooManager.addZookeeper(bob);
            zooManager.addAnimal(lion);
            zooManager.addAnimal(tiger);
        }
    
        @Test
        void testAnimalHasNoZookeeperInitially() {
            assertFalse(lion.hasZookeeper(), "Lion should not have a zookeeper initially.");
            assertFalse(tiger.hasZookeeper(), "Tiger should not have a zookeeper initially.");
        }
    
        @Test
        void testAssignAnimalToZookeeper() {
            lion.assignTo(alice);
            assertTrue(lion.hasZookeeper(), "Lion should have a zookeeper after being assigned.");
            assertEquals(alice, lion.getZookeeper(), "The zookeeper assigned to the lion should be Alice.");
        }
    
        @Test
        void testAssignMultipleAnimalsToZookeeper() {
            lion.assignTo(alice);
            tiger.assignTo(alice);
            List<Animal> assignedAnimals = alice.getAssignedAnimals();
            
            assertEquals(2, assignedAnimals.size(), "Alice should be assigned 2 animals.");
            assertTrue(assignedAnimals.contains(lion), "Alice should take care of the lion.");
            assertTrue(assignedAnimals.contains(tiger), "Alice should take care of the tiger.");
        }
    
        @Test
        void testReassignAnimalToAnotherZookeeper() {
            lion.assignTo(alice);
            lion.assignTo(bob);
            
            List<Animal> aliceAnimals = alice.getAssignedAnimals();
            List<Animal> bobAnimals = bob.getAssignedAnimals();
            
            assertTrue(bobAnimals.contains(lion), "Bob should be assigned the lion after reassigning.");
            assertFalse(aliceAnimals.contains(lion), "Alice should no longer be assigned the lion.");
        }
    
        @Test
        void testZookeeperCaresForAnimal() {
            lion.assignTo(alice);
            assertTrue(alice.caresFor(lion), "Alice should care for the lion.");
            assertFalse(bob.caresFor(lion), "Bob should not care for the lion.");
        }
    
        @Test
        void testZooManagerAddZookeeper() {
            assertEquals(2, zooManager.getIdleZookeepers().size(), "There should be 2 idle zookeepers initially.");
        }
    
        @Test
        void testZooManagerGetUnassignedAnimals() {
            List<Animal> unassignedAnimals = zooManager.getUnassignedAnimals();
            assertEquals(2, unassignedAnimals.size(), "There should be 2 unassigned animals initially.");
        }
    
        @Test
        void testZooManagerAssignAnimalToZookeeper() {
            zooManager.assignAnimalToZookeeper(lion, alice);
            List<Animal> aliceAnimals = alice.getAssignedAnimals();
            assertTrue(aliceAnimals.contains(lion), "Lion should be assigned to Alice via ZooManager.");
        }
    
        @Test
        void testZooManagerGetIdleZookeepers() {
            zooManager.assignAnimalToZookeeper(lion, alice);
            List<Zookeeper> idleZookeepers = zooManager.getIdleZookeepers();
            assertEquals(1, idleZookeepers.size(), "There should be 1 idle zookeeper after assigning an animal.");
            assertTrue(idleZookeepers.contains(bob), "Bob should be the idle zookeeper.");
        }
    
        @Test
        void testZookeeperToString() {
            lion.assignTo(alice);
            tiger.assignTo(bob);
            
            String aliceToString = alice.toString();
            String bobToString = bob.toString();
            
            assertEquals("Alice (1 animals)", aliceToString, "Alice's toString should return the correct format.");
            assertEquals("Bob (1 animals)", bobToString, "Bob's toString should return the correct format.");
        }

        @Test
        void testAssignAnimalToNullZookeeper() {
            assertThrows(NullPointerException.class, () -> {
                lion.assignTo(null);
            }, "Assigning an animal to a null zookeeper should throw an exception.");
        }

        @Test
        void testAssignNullAnimalToZookeeper() {
            assertThrows(NullPointerException.class, () -> {
                alice.takeCareOf(null);
            }, "Assigning a null animal should throw an exception.");
        }

        @Test
        void testUnassignUnassignedAnimal() {
            assertDoesNotThrow(() -> {
                lion.assignTo(null);  // Unassigning the lion without reassigning.
                assertNull(lion.getZookeeper(), "Lion should have no zookeeper after unassignment.");
            });
        }

        @Test
        void testReassignAnimalToSameZookeeper() {
            lion.assignTo(alice);
            lion.assignTo(alice); // Reassigning the same animal to the same zookeeper
        
            List<Animal> assignedAnimals = alice.getAssignedAnimals();
            assertEquals(1, assignedAnimals.size(), "Alice should still be assigned only 1 animal.");
            assertTrue(assignedAnimals.contains(lion), "Alice should take care of the lion.");
        }

        @Test
        void testAssignAnimalToZookeeperWhoAlreadyCaresForIt() {
            lion.assignTo(alice);
            assertDoesNotThrow(() -> {
                alice.takeCareOf(lion); // Reassigning the lion to the same zookeeper
            }, "Assigning the same animal to the same zookeeper should not cause any error.");
        }

        // Behavioral Tests

        @Test
        void testToStringForAnimalWithoutZookeeper() {
            assertEquals("Lion", lion.toString(), "The string representation of an unassigned animal should be its species.");
        }

        @Test
        void testToStringForZookeeperWithoutAnimals() {
            assertEquals("Alice (0 animals)", alice.toString(), "A zookeeper with no animals should display '0 animals'.");
        }

        @Test
        void testCaresForUnassignedAnimal() {
            assertFalse(alice.caresFor(lion), "Alice should not care for the lion since it is not assigned.");
        }

        @Test
        void testToStringAfterAnimalsAssigned() {
            lion.assignTo(alice);
            tiger.assignTo(alice);
            assertEquals("Alice (2 animals)", alice.toString(), "Alice should now have 2 animals after assignment.");
        }

        // Edge Case Testing

        @Test
        void testAnimalWithEmptySpecies() {
            Animal emptySpeciesAnimal = new Animal("");
            assertEquals("", emptySpeciesAnimal.toString(), "Animal with an empty species name should return an empty string.");
        }

        @Test
        void testZookeeperWithEmptyName() {
            Zookeeper emptyNameZookeeper = new Zookeeper("");
            assertEquals(" (0 animals)", emptyNameZookeeper.toString(), "Zookeeper with an empty name should still display the correct format.");
        }

        @Test
        void testAddingAnimalsWithoutZookeepers() {
            zooManager.addAnimal(new Animal("Giraffe"));
            zooManager.addAnimal(new Animal("Elephant"));
            List<Animal> unassignedAnimals = zooManager.getUnassignedAnimals();
            assertEquals(4, unassignedAnimals.size(), "There should be 4 unassigned animals when no zookeepers are added.");
        }

        @Test
        void testAssignAllAnimalsToOneZookeeper() {
            lion.assignTo(alice);
            tiger.assignTo(alice);
            List<Animal> assignedAnimals = alice.getAssignedAnimals();
            assertEquals(2, assignedAnimals.size(), "Alice should now care for both the lion and the tiger.");
        }

        @Test
        void testAddingLargeNumberOfAnimals() {
            for (int i = 0; i < 1000; i++) {
                zooManager.addAnimal(new Animal("Animal" + i));
            }
            List<Animal> unassignedAnimals = zooManager.getUnassignedAnimals();
            assertEquals(1000, unassignedAnimals.size(), "There should be 1000 unassigned animals initially.");
    }
    }

    @TestMethodOrder(MethodOrderer.MethodName.class)
    public static class PublicationTest {

        @Test
        void testBookConstructorFull() {
            Book book = new Book("1984", 1949, "George Orwell", 328);
            assertEquals("1984 - 1949", book.getSummary());
            assertEquals(328, book.getLength());
            assertEquals("1984 by George Orwell (328 pages)", book.toString());
        }
    
        @Test
        void testBookConstructorWithDefaults() {
            Book book = new Book("Dune", "Frank Herbert");
            assertEquals("Dune - 2024", book.getSummary());
            assertEquals(100, book.getLength());
        }
    
        @Test
        void testBookUpdateInfoIncreasesPages() {
            Book book = new Book("Dune", "Frank Herbert");
            book.updateInfo();
            assertEquals(110, book.getLength());
        }
    
        @Test
        void testMagazineConstructor() {
            Magazine mag = new Magazine("Tech Monthly", 2022, 5, true);
            assertEquals("Tech Monthly - 2022", mag.getSummary());
            assertEquals(5, mag.getLength());
            assertEquals("Tech Monthly - Issue 5 (2022)", mag.toString());
        }
    
        @Test
        void testMagazineUpdateMonthly() {
            Magazine mag = new Magazine("Science Today", 2023, 10, true);
            mag.updateInfo();
            assertEquals(11, mag.getLength());
            assertEquals("Science Today - 2024", mag.getSummary());
        }
    
        @Test
        void testMagazineUpdateNonMonthly() {
            Magazine mag = new Magazine("Annual Digest", 2023, 1, false);
            mag.updateInfo();
            assertEquals(2, mag.getLength());
            assertEquals("Annual Digest - 2023", mag.getSummary());
        }
    
        @Test
        void testPolymorphismWithPublicationArray() {
            Publication[] items = {
                new Book("1984", 1949, "George Orwell", 328),
                new Magazine("Tech Monthly", 2024, 8, true)
            };
            assertEquals(328, items[0].getLength());
            assertEquals(8, items[1].getLength());
        }
    
        @Test
        void testMultipleBookUpdates() {
            Book book = new Book("A Tale", 2024, "Author", 90);
            book.updateInfo();
            book.updateInfo();
            assertEquals(110, book.getLength());
        }
    
        @Test
        void testMultipleMagazineUpdatesMonthly() {
            Magazine mag = new Magazine("Space Today", 2020, 12, true);
            mag.updateInfo(); // issue = 13, year = 2021
            mag.updateInfo(); // issue = 14, year = 2022
            assertEquals(14, mag.getLength());
            assertEquals("Space Today - 2022", mag.getSummary());
        }
    
        @Test
        void testToStringMethods() {
            Book b = new Book("Winds of Winter", 2024, "GRRM", 500);
            Magazine m = new Magazine("World News", 2022, 3, false);
            assertEquals("Winds of Winter by GRRM (500 pages)", b.toString());
            assertEquals("World News - Issue 3 (2022)", m.toString());
        }
    }

    @TestMethodOrder(MethodOrderer.MethodName.class)
    public static class ChemicalSubstanceTest {
        Element hydrogen;
        Element oxygen;
        Element carbon;
        Compound water;
        Compound carbonDioxide;
    
        @BeforeEach
        void setup() {
            hydrogen = new Element("Hydrogen", "H", 1);
            oxygen = new Element("Oxygen", "O", 8);
            carbon = new Element("Carbon", "C", 6);
    
            ArrayList<Element> h2oComponents = new ArrayList<>();
            h2oComponents.add(hydrogen);
            h2oComponents.add(oxygen);
            water = new Compound("Water", "H2O", h2oComponents);
    
            ArrayList<Element> co2Components = new ArrayList<>();
            co2Components.add(carbon);
            co2Components.add(oxygen);
            carbonDioxide = new Compound("Carbon Dioxide", "CO2", co2Components);
        }
    
        @Test
        void testElementDescribe() {
            assertEquals("Hydrogen [H] - Atomic Number: 1", hydrogen.describe());
        }
    
        @Test
        void testCompoundDescribe() {
            assertEquals("Water [H2O] - Composed of: H, O", water.describe());
        }
    
        @Test
        void testElementReactWithCompoundTrue() {
            assertTrue(hydrogen.reactsWith(water));
        }
    
        @Test
        void testElementReactWithCompoundFalse() {
            assertFalse(carbon.reactsWith(water));
        }
    
        @Test
        void testCompoundReactWithElementTrue() {
            assertTrue(water.reactsWith(oxygen));
        }
    
        @Test
        void testCompoundReactWithElementFalse() {
            assertFalse(water.reactsWith(carbon));
        }
    
        @Test
        void testToStringOverrideForElement() {
            assertEquals(hydrogen.describe(), hydrogen.toString());
        }
    
        @Test
        void testToStringOverrideForCompound() {
            assertEquals(water.describe(), water.toString());
        }
    
        @Test
        void testGettersInElement() {
            assertEquals(8, oxygen.getAtomicNumber());
            assertEquals("Oxygen", oxygen.getName());
            assertEquals("O", oxygen.getSymbol());
        }
    
        @Test
        void testCompoundContainsCorrectElements() {
            ArrayList<Element> elements = carbonDioxide.getComponents();
            assertTrue(elements.contains(carbon));
            assertTrue(elements.contains(oxygen));
            assertEquals(2, elements.size());
        }
    }

    @TestMethodOrder(MethodOrderer.MethodName.class)
    class PetHotelTest {

        private Pet pet1;
        private Pet pet2;
        private PetHotel hotel;
    
        @BeforeEach
        void setUp() {
            // Create Pet objects and a PetHotel object before each test
            pet1 = new Pet("Buddy", "Cat");
            pet2 = new Pet("Lucy", "Pterodactyl");
            hotel = new PetHotel();
        }
    
        // Test Pet class functionality
    
        @Test
        void testPetName() {
            // Test that the name is correctly initialized and retrieved
            assertEquals("Buddy", pet1.getName());
        }
    
        @Test
        void testAssignOwner() {
            // Test assigning an owner to a pet
            pet1.assignOwner("John");
            assertEquals("John", pet1.getOwner());
        }
    
        @Test
        void testRemoveOwner() {
            // Test removing an owner from a pet
            pet1.assignOwner("John");
            pet1.removeOwner();
            assertNull(pet1.getOwner());
        }
    
        @Test
        void testGetOwnerWhenNotAssigned() {
            // Test that a pet without an owner returns null
            assertNull(pet2.getOwner());
        }
    
        // Test PetHotel class functionality
    
        @Test
        void testCheckInPet() {
            // Test checking in a pet
            hotel.checkIn(pet1);
            assertTrue(hotel.isGuest(pet1));
        }
    
        @Test
        void testCheckOutPet() {
            // Test checking out a pet
            hotel.checkIn(pet1);
            hotel.checkOut(pet1);
            assertFalse(hotel.isGuest(pet1));
        }
    
        @Test
        void testIsCheckedInBeforeCheckIn() {
            // Test checking in status before check-in
            assertFalse(hotel.isGuest(pet2));
        }
    
        @Test
        void testListCheckedInPets() {
            // Test listing checked-in pets
            hotel.checkIn(pet1);
            hotel.checkIn(pet2);
            assertEquals("Buddy,Lucy", hotel.listCheckedInPets());
        }
    
        @Test
        void testCheckInPetTwice() {
            // Test checking in the same pet twice (should fail)
            hotel.checkIn(pet1);
            hotel.checkIn(pet1);  // Should not add the pet a second time
            assertEquals("Buddy", hotel.listCheckedInPets());
        }
    
        @Test
        void testCheckOutPetNotCheckedIn() {
            // Test trying to check out a pet that is not checked in
            hotel.checkOut(pet1);  // No effect because pet1 was not checked in
            assertFalse(hotel.isGuest(pet1));
        }
    }



}
