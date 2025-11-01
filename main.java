import java.util.List;
import models.student;
import service.business.StudentManager;
import service.menu.menu;

public class main {
    public static void main(String[] args) {

        List<student> students = new java.util.ArrayList<>();
        StudentManager studentManager = new StudentManager(students);
        menu menu = new menu();
        menu.handleUserInput(studentManager, students);

    }
}
