package SRMS;

import java.util.ArrayList;
import java.util.Scanner;

public class SRMS {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentFileManager file = new StudentFileManager();

        // Load existing students
        ArrayList<Student> students = file.load();
          AutoSaveThread auto = new AutoSaveThread(students, file);
        auto.start();

        int choice = -1;

        while (choice != 8) {

            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Show All Students");
            System.out.println("5. Update student");
            System.out.println("6. GPA Report");
            System.out.println("7. Department Report");
            System.out.println("8. Save & Exit");
            System.out.print("Choose: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {    //!! try and catch

                case 1:
                    // Add student
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Nationality: ");
                    String nationality = sc.nextLine();

                    System.out.print("Enter GPA: ");
                    double gpa = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Level (year): ");
                    int level = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Department Name: ");
                    String deptName = sc.nextLine();

                    Department dept = new Department(1, deptName);

                    Student st = new Student(id, name, age, nationality, gpa, level, dept);

                    file.addStudent(st, students);
                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    // Delete Student
                    System.out.print("Enter ID to delete: ");
                    String deleteId = sc.nextLine();

                    boolean removed = file.deleteStudent(deleteId, students);

                    if (removed) {
                        System.out.println("Student Deleted Successfully!");
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 3:
                    // Search Student
                    System.out.print("Enter ID to search: ");
                    String searchId = sc.nextLine();

                    Student found = file.search(searchId, students);

                    if (found != null) {
                        System.out.println("Found Student:\n" + found);
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 4:
                    // Show all
                    System.out.println("===== All Students =====");
                    for (Student s : students) {
                        System.out.println(s + "\n");
                    }
                    break;
                case 5:  // Update Student
                    System.out.print("Enter ID to update: ");
                    String uId = sc.nextLine();

                    Student old = file.search(uId, students);

                    if (old == null) {
                        System.out.println("Student Not Found!");
                        break;
                    }

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Nationality: ");
                    String newNationality = sc.nextLine();

                    System.out.print("Enter New GPA: ");
                    double newGpa = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter New Level: ");
                    int newLevel = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Department Name: ");
                    String newDept = sc.nextLine();

                    Department deptUP = new Department(1, newDept);

                    Student newSt = new Student(uId, newName, newAge, newNationality, newGpa, newLevel, deptUP);

                    boolean updated = file.updateStudent(uId, newSt, students);

                    if (updated) {
                        System.out.println("Student Updated Successfully!");
                    } else {
                        System.out.println("Update Failed!");
                    }
                    break;
                
                case 6:
                    GPA g=new GPA();
                   g.generate(students); // Generate GPA report for all students

                   break;
                case 7:
                    DepartmentReport der=new DepartmentReport();
               der.generate(students);// Generate DepartmentReport for students

               break;
                case 8:
                    auto.stopSaving();  // Stop the auto-save thread

               file.save(students);
               System.out.println("SAved.");// Confirmation message

               break;

                default:
                    System.out.println("Invalid choice!");// invalid menu option
                    break;

            }
        }
    }
}
