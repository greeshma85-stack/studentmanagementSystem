import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // rollNo → Student
        HashMap<Integer, Student> students = new HashMap<>();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Add Marks");
            System.out.println("3. Update Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Display Student");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1: // Add Student
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    if (students.containsKey(roll)) {
                        System.out.println("Student already exists!");
                    } else {
                        students.put(roll, new Student(roll, name));
                        System.out.println("Student added successfully.");
                    }
                    break;

                case 2: // Add Marks
                    System.out.print("Enter Roll No: ");
                    roll = sc.nextInt();

                    if (!students.containsKey(roll)) {
                        System.out.println("Student not found.");
                    } else {
                        System.out.print("Enter Mark: ");
                        int mark = sc.nextInt();
                        students.get(roll).addMark(mark);
                        System.out.println("Mark added.");
                    }
                    break;

                case 3: // Update Marks
                    System.out.print("Enter Roll No: ");
                    roll = sc.nextInt();

                    if (!students.containsKey(roll)) {
                        System.out.println("Student not found.");
                    } else {
                        Student s = students.get(roll);
                        System.out.println("Current Marks: " + s.marks);
                        System.out.print("Enter index to update: ");
                        int index = sc.nextInt();
                        System.out.print("Enter new mark: ");
                        int newMark = sc.nextInt();

                        if (index >= 0 && index < s.marks.size()) {
                            s.marks.set(index, newMark);
                            System.out.println("Mark updated.");
                        } else {
                            System.out.println("Invalid index.");
                        }
                    }
                    break;

                case 4: // Delete Student
                    System.out.print("Enter Roll No: ");
                    roll = sc.nextInt();

                    if (students.remove(roll) != null) {
                        System.out.println("Student deleted.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5: // Display One Student
                    System.out.print("Enter Roll No: ");
                    roll = sc.nextInt();

                    if (students.containsKey(roll)) {
                        students.get(roll).display();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 6: // Display All Students
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        for (Student s : students.values()) {
                            s.display();
                        }
                    }
                    break;

                case 7: // Exit
                    System.out.println("Exiting program.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
