package service.business;

import java.util.List;

import models.Objectbase;
import models.student;

public class StudentManager extends Objectbase {
    private List<student> students;

    public StudentManager(List<student> students) {
        this.students = students;
    }

    public boolean addStudent(student s) {
        return students.add(s);
    }

    public boolean removeStudent(student s) {
        return students.remove(s);
    }

    public boolean updateInfo(String studentID, student newInfo) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID().equals(studentID)) {
                students.set(i, newInfo);
                return true;
            }
        }
        return false;
    }

    public void sortByID() {
        students.sort((s1, s2) -> s1.getStudentID().compareTo(s2.getStudentID()));
    }

    public void sortByGPA() {
        students.sort((s1, s2) -> Double.compare(s1.getGPA(), s2.getGPA()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (student s : students) {
            sb.append(s.toString()).append("\n");
        }
        return sb.toString();
    }
}
