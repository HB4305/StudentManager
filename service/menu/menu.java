package service.menu;

import java.util.List;
import models.student;
import models.Objectbase;
import service.dataaccess.CSVDao;
import service.business.StudentManager;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class menu extends Objectbase {
    public void displayMenu() {
        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. add student");
        System.out.println("2. remove student");
        System.out.println("3. update student");
        System.out.println("4. view list of students");
        System.out.println("5. sort by ID");
        System.out.println("6. sort by GPA");
        System.out.println("7. import students from CSV");
        System.out.println("8. export students to CSV");
        System.out.println("9. exit");
        System.out.print("Choose an option: ");
    }

    public void handleUserInput(StudentManager manager, List<student> students) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice = 0;
        try {
            while (choice != 9) {
                displayMenu();
                choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        // Add student
                        System.out.println("");
                        System.out.print("Enter student ID: ");
                        String id = "";
                        try {
                            id = reader.readLine();
                            for (student stu : students) {
                                if (stu.getStudentID().equals(id)) {
                                    System.out.print("Student with ID " + id + " already exists. Cannot add duplicate.");
                                    System.out.println("");
                                    id = null;
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.print("Enter student Name: ");
                        String name = "";
                        try {
                            name = reader.readLine();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.print("Enter student Age: ");
                        int age = 0;
                        try {
                            age = Integer.parseInt(reader.readLine());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.print("Enter student GPA: ");
                        double gpa = 0.0;
                        try {
                            gpa = Double.parseDouble(reader.readLine());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.print("Enter student Image Path: ");
                        String imagePath = "";
                        try {
                            imagePath = reader.readLine();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.print("Enter student City: ");
                        String city = "";
                        try {
                            city = reader.readLine();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.print("Enter student Notes: ");
                        String notes = "";
                        try {
                            notes = reader.readLine();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        student newStudent = new student(id, name, age, gpa, imagePath, city, notes);
                        if (manager.addStudent(newStudent)) {
                            System.out.print("Student added successfully.");
                        } else {
                            System.out.print("Failed to add student. Student with ID " + id + " may already exist.");
                        }
                        System.out.println("");
                        break;
                    case 2:
                        // Remove student
                        System.out.println("");
                        System.out.print("Enter student ID to remove: ");
                        String removeId = "";
                        try {
                            removeId = reader.readLine();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        student toRemove = null;
                        for (student stu : students) {
                            if (stu.getStudentID().equals(removeId)) {
                                toRemove = stu;
                                break;
                            }
                        }
                        if (toRemove != null) {
                            manager.removeStudent(toRemove);
                            System.out.print("Student removed successfully.");
                        } else {
                            System.out.print("Student with ID " + removeId + " not found.");
                        }
                        System.out.println("");
                        break;
                    case 3:
                        // Update student
                        System.out.println("");
                        System.out.print("Enter student ID to update: ");
                        String updateId = "";
                        try {
                            updateId = reader.readLine();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        student toUpdate = null;
                        for (student stu : students) {
                            if (stu.getStudentID().equals(updateId)) {
                                toUpdate = stu;
                                break;
                            }
                        }
                        if (toUpdate != null) {
                            while (true) {
                                System.out.println("");
                                System.out.println("Select field to update:");
                                System.out.println("1. Student ID");
                                System.out.println("2. Name");
                                System.out.println("3. Age");
                                System.out.println("4. GPA");
                                System.out.println("5. Image Path");
                                System.out.println("6. Address");
                                System.out.println("7. Notes");
                                System.out.println("8. Exit update");
                                System.out.print("Enter your choice: ");
                                int updateChoice = Integer.parseInt(reader.readLine());
                                System.out.println("");
                                if (updateChoice == 8) {
                                    break;
                                }
                                System.out.print("Enter new value: ");
                                String newValue = reader.readLine();
                                switch (updateChoice) {
                                    case 1:
                                        toUpdate.setStudentID(newValue);
                                        break;
                                    case 2:
                                        toUpdate.setName(newValue);
                                        break;
                                    case 3:
                                        toUpdate.setAge(Integer.parseInt(newValue));
                                        break;
                                    case 4:
                                        toUpdate.setGPA(Double.parseDouble(newValue));
                                        break;
                                    case 5:
                                        toUpdate.setImgPath(newValue);
                                        break;
                                    case 6:
                                        toUpdate.setAddress(newValue);
                                        break;
                                    case 7:
                                        toUpdate.setNotes(newValue);
                                        break;
                                    default:
                                        System.out.print("Invalid choice. Please try again.");
                                        continue;
                                }
                            }
                            System.out.print("Student updated successfully.");
                        } else {
                            System.out.print("Student with ID " + updateId + " not found.");
                        }
                        System.out.println("");
                        break;
                    case 4:
                        // View list of students
                        System.out.println("");
                        System.out.println("List of students:");
                        System.out.println(manager.toString());
                        break;
                    case 5:
                        // Sort by ID
                        System.out.println("");
                        manager.sortByID();
                        System.out.println("Students sorted by ID.");
                        break;
                    case 6:
                        // Sort by GPA
                        System.out.println("");
                        manager.sortByGPA();
                        System.out.println("Students sorted by GPA.");
                        break;
                    case 7:
                        // Import from CSV
                        System.out.println("");
                        CSVDao csvDao = new CSVDao();
                        List<student> importedStudents = csvDao.getAll();
                        for (student stu : importedStudents) {
                            manager.addStudent(stu);
                        }
                        System.out.println("Imported " + importedStudents.size() + " students from CSV.");
                        break;
                    case 8:
                        // Export to CSV
                        System.out.println("");
                        CSVDao exportDao = new CSVDao();
                        exportDao.saveAll(students);
                        System.out.println("Exported students to CSV.");
                        break;
                    case 9:
                        // Exit
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Menu Class";
    }
}
