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
     Returns a string containing the disaster's details, including ID, name, location, impact level, and damage cost. Shown below is the format to use:

     `ID: {id}, Name: {name}, Location: {location}, Impact Level: {impactLevel}, Damage Cost: {damageCost (1dp)}`
   
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
     Returns the details of a case, including the victim name, suspect name, status, and crime type. If the case does not exist, it should return "Case not found". Below is the formatting style that is used:

     `Case ID: {id}, Victim: {victim}, Suspect: {suspect}, Status: {status}, Crime Type: {type}`
   
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
- Each `BankAccount` has a balance.
- The `deposit(double amount)` method adds funds (ignore negative values).
- The `withdraw(double amount)` method subtracts funds if sufficient.
- The `transferTo(BankAccount other, double amount)` method transfers money if sufficient funds exist.
- Use a **static variable** to track the number of accounts created.
- The `getTotalAccounts()` static method returns the number of total accounts.

---

## 7. Library System with Borrowing, Multiple Copies, and Tracking Possession

### Question:
Create a `Library` class and a `User` class for a library system. The library can own multiple copies of the same book, and multiple users can borrow a copy of the book if one is available. Additionally, you should be able to find out who is in possession of each copy of a given book. Implement the following:

- **`Library` class**:
  - `addBook(Book book, int copies)`: Adds a specific number of copies of a book to the library.
  - `borrowBook(User user, Book book)`: Allows a user to borrow a book. A user can only borrow a copy if there are available copies in the library.
  - `returnBook(User user, Book book)`: Allows a user to return a borrowed copy of a book. When a book is returned, it becomes available for other users to borrow.
  - `getAvailableCopies(Book book)`: Returns the number of available copies of a book in the library.
  - `getPossessors(Book book)`: Returns a list of `User` objects who currently have a copy of the specified book.

- **`User` class**:
  - `User(String name)`: Initializes a user with a given name.
  - `borrowedBooks()`: Returns a list of books currently borrowed by the user.
  - `borrowBook(Book book)`: Adds a borrowed book to the user’s list of borrowed books.
  - `returnBook(Book book)`: Removes a book from the user’s borrowed books list.
  - `toString()`: Returns a string representation of the user’s name followed by the list of books they are currently in possession of.

- **`Book` class**:
  - `Book(String title)`: Initializes a book with a title.
  - `getTitle()`: Returns the title of the book.

---

## 8. Animal Class

### Methods

- **Animal(String species)**:  
  Creates a new animal of the given species.

- **assignTo(Zookeeper zookeeper)**:  
  Assigns the animal to the given zookeeper.  
  If the animal was previously assigned to someone else, they are unassigned from the previous zookeeper.  
  Assignment is mutual — the animal knows its zookeeper, and the zookeeper knows which animals they care for.

- **hasZookeeper()**:  
  Returns `true` if the animal has a zookeeper.

- **getZookeeper()**:  
  Returns the current zookeeper assigned to this animal, or `null` if none.

- **toString()**:  
  Returns the species of the animal as a string.


### Zookeeper Class

- **Zookeeper(String name)**:  
  Creates a zookeeper with the given name.

- **takeCareOf(Animal animal)**:  
  Assigns the animal to this zookeeper.  
  If the animal was already cared for by someone else, remove it from that zookeeper first.

- **getAssignedAnimals()**:  
  Returns a list of animals this zookeeper is responsible for.

- **caresFor(Animal animal)**:  
  Returns `true` if the zookeeper is currently responsible for that animal.

- **toString()**:  
  Returns the zookeeper's name followed by the number of animals, e.g., "Sam (3 animals)".


### ZooManager Class

- **addZookeeper(Zookeeper zookeeper)**:  
  Adds a zookeeper to the zoo system.

- **addAnimal(Animal animal)**:  
  Adds an animal to the zoo.

- **assignAnimalToZookeeper(Animal animal, Zookeeper zookeeper)**:  
  Assigns the animal to the zookeeper.

- **getUnassignedAnimals()**:  
  Returns a list of animals that currently don’t have a zookeeper.

- **getIdleZookeepers()**:  
  Returns a list of zookeepers not responsible for any animals.

---

## 9. Java OOP Task: Publication and Book Classes

### **Task Overview**

Complete the `Publication`, `Book`, and `Magazine` classes as follows:

### **1. Class Hierarchy**
- `Publication` is an **abstract class** representing any general publication.
- `Book` and `Magazine` are **subclasses** of `Publication`.

### **2. Fields and Constructors**

#### **Publication**
- Fields:
  - `title` (String): The title of the publication.
  - `year` (int): The year it was published.
- Constructor:
  - `Publication(String title, int year)` initializes these fields.

#### **Book**
- Fields:
  - `author` (String): The name of the author.
  - `pages` (int): The number of pages.
- Constructors:
  - `Book(String title, int year, String author, int pages)`
  - `Book(String title, String author)`  
    Defaults `year` to 2024 and `pages` to 100.

#### **Magazine**
- Fields:
  - `issueNumber` (int): The magazine’s issue number.
  - `monthly` (boolean): Whether it is a monthly publication.
- Constructor:
  - `Magazine(String title, int year, int issueNumber, boolean monthly)`

### **3. Abstract and Overridden Methods**

- **Publication** defines:
  - `public abstract int getLength()`  
    Returns the length of the publication (pages or issue number).
  - `public abstract void updateInfo()`  
    Updates internal data (see below).
  - `public String getSummary()`  
    Returns `"<title> - <year>"`

- **Book** implements:
  - `getLength()` as the number of pages.
  - `updateInfo()` increases the number of pages by 10.

- **Magazine** implements:
  - `getLength()` as the issue number.
  - `updateInfo()` increases the issue number by 1.  
    If monthly, also increases the year by 1.

### **4. String Representation**

- **Book**:  
  `"<title> by <author> (<pages> pages)"`
- **Magazine**:  
  `"<title> - Issue <issueNumber> (<year>)"`

## You Must Implement:

- All constructors and fields.
- Abstract class with abstract and concrete methods.
- Method overriding in subclasses.
- Custom `toString()` methods.
- Use of polymorphism (`Publication` references holding `Book` or `Magazine` objects`).

---

## 10. Chemical Substances and Reactions

### **Task Overview**

Complete the `ChemicalSubstance`, `Element`, and `Compound` classes as follows:

### **1. Class Hierarchy**

- `ChemicalSubstance` is an **abstract class** representing a generic chemical.
- `Element` and `Compound` are **concrete subclasses** of `ChemicalSubstance`.

### **2. Fields and Constructors**

#### **ChemicalSubstance**
- Fields:
  - `name` (String): The name of the chemical.
  - `symbol` (String): The chemical symbol.
- Constructor:
  - `ChemicalSubstance(String name, String symbol)`

#### **Element**
- Additional Fields:
  - `atomicNumber` (int)
- Constructor:
  - `Element(String name, String symbol, int atomicNumber)`

#### **Compound**
- Additional Fields:
  - `components` (ArrayList<Element>): List of elements that make up the compound.
- Constructor:
  - `Compound(String name, String symbol, ArrayList<Element> components)`

### **3. Methods and Behaviors**

#### **ChemicalSubstance**
- Abstract Methods:
  - `public abstract String describe()`:  
    Returns a textual description of the substance.
  - `public abstract boolean reactsWith(ChemicalSubstance other)`:  
    Determines if this substance reacts with another.

#### **Element**
- Implements `describe()` as:  
  `"<name> [<symbol>] - Atomic Number: <atomicNumber>"`
- Implements `reactsWith(ChemicalSubstance other)`:
  - Returns `true` if the other is a `Compound` and this element is part of it.
  - Otherwise, returns `false`.

#### **Compound**
- Implements `describe()` as:  
  `"<name> [<symbol>] - Composed of: <list of element symbols>"`
- Implements `reactsWith(ChemicalSubstance other)`:
  - Returns `true` if the other is an `Element` and is part of this compound.
  - Otherwise, returns `false`.

### **4. Additional Requirements**
- Use appropriate encapsulation (fields should be private, with getters if needed).
- Override `toString()` to return the same string as `describe()` for each subclass.
- Support flexible object interaction (e.g., `Element` reacts with `Compound`, `Compound` with `Element`).

### You Must Implement:
- An abstract base class and two subclasses.
- Object-to-object interaction using polymorphism.
- ArrayList usage to store compound components.
- String formatting and dynamic descriptions.