## 1. Steel Fabrication Manager Class

### Task:

Complete the `SteelFabricationManager` class as follows:

1. **Class Overview**:  
   The `SteelFabricationManager` class manages a list of steel fabrication projects. Each project is represented by a `FabricationProject` object with the following attributes:
   - `name` (String): The name of the project.
   - `cost` (double): The total cost of materials for the project.

2. **Constructor**:  
   The constructor `SteelFabricationManager()` initializes an empty list of projects.

3. **Methods**:
   - `addProject(String name, double cost)`:  
     Adds a new project to the list. If a project with the same name already exists, update its cost.
     
   - `getTotalCost()`:  
     Returns the total cost of all the projects combined.
     
   - `getProjectCost(String name)`:  
     Returns the cost of a specific project based on its name. If the project doesn't exist, return `-1`.
     
   - `getProjectCount()`:  
     Returns the total number of projects in the list.

---
## 2. Natural Disaster Management System

### Task:

Complete the `DisasterEvent` class as follows:

1. **Class Overview**:  
   The `DisasterEvent` class represents a natural disaster event. Each event has:
   - `id` (String): A unique identifier for the disaster event.
   - `name` (String): The name of the disaster (e.g., "Hurricane Katrina").
   - `location` (String): The location where the disaster occurred.
   - `impactLevel` (String): A description of the severity (e.g., "Severe", "Moderate").
   - `damageCost` (double): The estimated cost of damage caused by the disaster.

2. **Constructors**:
   - **Constructor 1**:  
     The constructor `DisasterEvent(String id, String name)` initializes the disaster event with a unique ID and name. The location is set to "Unknown", the impact level is set to "Unknown", and the damage cost is set to 0.0.
   
   - **Constructor 2**:  
     The constructor `DisasterEvent(String id, String name, String location, String impactLevel, double damageCost)` initializes the disaster event with all attributes, including location, impact level, and damage cost.

   - **Constructor 3**:  
     The constructor `DisasterEvent(String id, String name, String location)` initializes the disaster event with an ID, name, and location, but sets the impact level to "Unknown" and the damage cost to 0.0.

3. **Methods**:
   - `getDisasterDetails()`:  
     Returns a string containing the disaster's details, including ID, name, location, impact level, and damage cost.
   
   - `updateDamageCost(double newDamageCost)`:  
     Updates the damage cost of the disaster event to the new value passed as a parameter.

---
## 3. Criminal Investigation System

### Task:

Complete the `CriminalInvestigation` class as follows:

1. **Class Overview**:  
   The `CriminalInvestigation` class manages criminal cases. Each case is represented by a `Case` object, which stores information about the case, including:
   - `caseId` (String): A unique identifier for the case.
   - `victimName` (String): The name of the victim.
   - `suspectName` (String): The name of the suspect.
   - `status` (String): The status of the case (e.g., "Open", "Closed").
   - `crimeType` (String): The type of crime (e.g., "Theft", "Murder").

2. **HashMap**:  
   The `CriminalInvestigation` class uses a `HashMap` to store and manage multiple cases. The key of the `HashMap` is the `caseId` (String), and the value is the `Case` object representing that particular case.

3. **Static Variable**:  
   There is a static variable `totalCases` that keeps track of the total number of cases in the system. Each time a new case is added, the `totalCases` variable should increment by 1.

4. **Methods**:
   - **Constructor**:  
     The constructor `CriminalInvestigation()` initializes an empty `HashMap` for storing cases and sets `totalCases` to 0.
   
   - **addCase(String caseId, String victimName, String suspectName, String crimeType)**:  
     Adds a new case to the `HashMap`. The status of the new case should be set to "Open" by default.
   
   - **updateCaseStatus(String caseId, String status)**:  
     Updates the status of an existing case identified by `caseId`. If the case does not exist, it should print "Case not found".
   
   - **getCaseDetails(String caseId)**:  
     Returns the details of a case, including the victim name, suspect name, status, and crime type. If the case does not exist, it should return "Case not found".
   
   - **getTotalCases()**:  
     Returns the total number of cases in the system (using the `totalCases` static variable).

5. **Additional Requirements**:
   - Ensure that the `totalCases` variable is updated properly whenever a new case is added.
   - Handle cases where an invalid `caseId` is provided for updates or retrieval.

---

## 4. RPG Character System
Complete the following `Character` abstract class and its subclasses `Warrior` and `Mage` as follows:  

### **Character (Abstract Class)**  
- Represents a general RPG character.  
- Attributes:  
  - `name` (String): The character's name.  
  - `level` (int): The character's level.  
- Methods:  
  - `getDetails()`: Returns a string in the format **"Name: {name}, Level: {level}"**.  
  - **Abstract Method** `attack()`: Returns a string describing the character’s attack.  

### **Warrior (Subclass of Character)**  
- Specializes in melee combat.  
- Attributes:  
  - `weaponType` (String): The type of weapon the warrior uses (e.g., "Sword", "Axe").  
- Overrides:  
  - `attack()`: Returns a message like **"{name} swings his {weaponType}!"**.  

### **Mage (Subclass of Character)**  
- Specializes in magical combat.  
- Attributes:  
  - `element` (String): The type of magic the mage uses (e.g., "Fire", "Ice").  
- Overrides:  
  - `attack()`: Returns a message like **"{name} casts a {element} spell!"**.  

## **Requirements**  
- Implement the `Character` abstract class and ensure that `Warrior` and `Mage` correctly inherit from it.  
- Override the `attack()` method in each subclass to provide specific behavior.  
- Ensure `getDetails()` works correctly for all classes. 

---

## 5. Space Mission Fleet

## Task Overview:
Complete the `SpaceFleet` class as follows:

The `SpaceFleet` class manages a list of spaceships in a fleet, each with a name and a mission status.

### The class includes the following methods:

- **`addSpaceship(String name)`**: Adds a spaceship to the fleet.
- **`updateMissionStatus(String name, String status)`**: Updates the mission status of a spaceship.
- **`getMissionStatus(String name)`**: Returns the mission status of a spaceship.
- **`listSpaceships()`**: Returns an `ArrayList<String>` of the names of all spaceships in the fleet.
- **`getSpaceshipsByStatus(String status)`**: Returns an `ArrayList<String>` of the names of spaceships with a specific mission status.
- **`removeSpaceship(String name)`**: Removes a spaceship from the fleet by its name.
- **`printFleetSummary()`**: Prints a formatted summary of all spaceships and their mission statuses. Each spaceship’s information should be printed on a new line in the following format:
  - `"Spaceship [name] - Status: [status]"`

---

## 6. Bank Account
Complete the `BankAccount` class as follows:
- Each `BankAccount` has a balance and an account number.
- The `deposit(double amount)` method adds funds (ignore negative values).
- The `withdraw(double amount)` method subtracts funds if sufficient.
- The `transferTo(BankAccount other, double amount)` method transfers money if sufficient funds exist.
- Use a **static variable** to track the number of accounts created.
- The `getTotalAccounts()` static method returns the number of total accounts.