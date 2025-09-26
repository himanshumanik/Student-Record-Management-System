import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManager {
    // Use a static list to store all student objects
    private static ArrayList<Student> studentList = new ArrayList<>();
    // Use a static ID counter to ensure unique IDs for new students
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Initialize with some dummy data for easy testing
        studentList.add(new Student(nextId++, "Alice Smith", 85.5));
        studentList.add(new Student(nextId++, "Bob Johnson", 78.2));

        System.out.println("--- Student Record Management System (CLI) ---");

        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        addStudent(scanner);
                        break;
                    case 2:
                        viewAllStudents();
                        break;
                    case 3:
                        updateStudent(scanner);
                        break;
                    case 4:
                        deleteStudent(scanner);
                        break;
                    case 5:
                        running = false;
                        System.out.println("\nExiting system. Goodbye! 👋");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select an option between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a number for your choice.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student Record");
        System.out.println("4. Delete Student Record");
        System.out.println("5. Exit");
    }

    // 1. CREATE Operation
    private static void addStudent(Scanner scanner) {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        double marks = -1;
        while (marks < 0 || marks > 100) {
            try {
                System.out.print("Enter student marks (0-100): ");
                marks = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                if (marks < 0 || marks > 100) {
                    System.out.println("Marks must be between 0 and 100.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid marks input. Please enter a number.");
                scanner.nextLine(); // Clear the buffer
            }
        }

        Student newStudent = new Student(nextId, name, marks);
        studentList.add(newStudent);
        System.out.println("✅ Student Added Successfully! ID: " + nextId);
        nextId++; // Increment ID for the next student
    }

    // 2. READ Operation
    private static void viewAllStudents() {
        System.out.println("\n--- All Student Records ---");
        if (studentList.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    // 3. UPDATE Operation
    private static void updateStudent(Scanner scanner) {
        System.out.println("\n--- Update Student Record ---");
        System.out.print("Enter Student ID to update: ");
        
        try {
            int idToUpdate = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Find the student by ID
            Student studentToUpdate = null;
            for (Student s : studentList) {
                if (s.getId() == idToUpdate) {
                    studentToUpdate = s;
                    break;
                }
            }

            if (studentToUpdate == null) {
                System.out.println("❌ Error: Student with ID " + idToUpdate + " not found.");
                return;
            }

            System.out.println("Current Record: " + studentToUpdate);
            System.out.print("Enter new name (or press Enter to skip): ");
            String newName = scanner.nextLine();
            if (!newName.trim().isEmpty()) {
                studentToUpdate.setName(newName);
            }

            System.out.print("Enter new marks (or -1 to skip): ");
            double newMarks = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            
            if (newMarks >= 0 && newMarks <= 100) {
                studentToUpdate.setMarks(newMarks);
            } else if (newMarks != -1) {
                 System.out.println("Marks update skipped. Value must be between 0 and 100.");
            }
            
            System.out.println("⭐ Student Updated Successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid ID or Marks input. Please enter a number.");
            scanner.nextLine(); // Clear the buffer
        }
    }

    // 4. DELETE Operation
    private static void deleteStudent(Scanner scanner) {
        System.out.println("\n--- Delete Student Record ---");
        System.out.print("Enter Student ID to delete: ");

        try {
            int idToDelete = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Attempt to remove the student using a simple loop and index
            boolean removed = false;
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getId() == idToDelete) {
                    studentList.remove(i);
                    removed = true;
                    break;
                }
            }

            if (removed) {
                System.out.println("🗑️ Student with ID " + idToDelete + " deleted successfully.");
            } else {
                System.out.println("❌ Error: Student with ID " + idToDelete + " not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid ID input. Please enter a number.");
            scanner.nextLine(); // Clear the buffer
        }
    }
}
