# Student Record Management System (CLI) 🎓

This repository contains the solution for **Task 2: Student Record Management System**.

## Objective

The goal was to create a Command-Line Interface (CLI) application in Java for managing student records. This task demonstrates core Object-Oriented Programming (OOP) concepts, file management using an `ArrayList`, and implementing standard CRUD operations (Create, Read, Update, Delete).

## Implementation Details

### Classes
1.  **`Student.java`**: A simple class defining the structure of a single student record with fields for **ID**, **name**, and **marks**. Includes a constructor, getters, setters, and an overridden `toString()` method for clean output.
2.  **`StudentManager.java`**: The main driver class that contains the `main` method, manages the data using an `ArrayList<Student>`, and provides the interactive console menu.

### Data Storage
* The system uses a static `ArrayList<Student>` named `studentList` to store all records in memory while the program is running.
* A static integer `nextId` is used to automatically generate unique student IDs.

### CRUD Operations
The system provides the following menu options:

* **1. Add New Student (CREATE)**: Prompts for name and marks, generates a unique ID, and adds the new `Student` object to the `ArrayList`.
* **2. View All Students (READ)**: Iterates through the `ArrayList` and prints all student records.
* **3. Update Student Record (UPDATE)**: Prompts for a Student ID, finds the record, and allows the user to update the name and/or marks.
* **4. Delete Student Record (DELETE)**: Prompts for a Student ID, finds the record in the `ArrayList`, and removes it.

## How to Run

1.  Ensure both `Student.java` and `StudentManager.java` are in the same folder.
2.  **Compile the Java files:**
    ```bash
    javac Student.java StudentManager.java
    ```
3.  **Run the main class:**
    ```bash
    java StudentManager
    ```

## Example Interaction
