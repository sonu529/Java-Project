package com.studentregistration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Registration System");
            System.out.println("1. Register Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    Student student = new Student(id, name, email, course);
                    service.registerStudent(student);
                    break;
                case 2:
                    System.out.println("All Students:");
                    service.getAllStudents().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    String searchId = scanner.nextLine();
                    service.getStudentById(searchId).ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Student not found")
                    );
                    break;
                case 4:
                    System.out.print("Enter ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter new Course: ");
                    String newCourse = scanner.nextLine();
                    Student updatedStudent = new Student(updateId, newName, newEmail, newCourse);
                    if (service.updateStudent(updateId, updatedStudent)) {
                        System.out.println("Student updated");
                    } else {
                        System.out.println("Student not found");
                    }
                    break;
                case 5:
                    System.out.print("Enter ID to delete: ");
                    String deleteId = scanner.nextLine();
                    if (service.deleteStudent(deleteId)) {
                        System.out.println("Student deleted");
                    } else {
                        System.out.println("Student not found");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
