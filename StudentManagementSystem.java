import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;

    // Constructor
    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Display student info
    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age);
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            // Menu
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: // Add
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    students.add(new Student(id, name, age));
                    System.out.println("✅ Student Added!");
                    break;

                case 2: // View
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        System.out.println("--- All Students ---");
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

                case 3: // Search
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.id == searchId) {
                            System.out.println("Student Found:");
                            s.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4: // Delete
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    Student toRemove = null;
                    for (Student s : students) {
                        if (s.id == deleteId) {
                            toRemove = s;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        students.remove(toRemove);
                        System.out.println("✅ Student Deleted!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5: // Exit
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
