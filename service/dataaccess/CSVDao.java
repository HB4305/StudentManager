package service.dataaccess;

import models.student;
import service.business.IParsable;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class CSVDao extends IDao {
    @Override
    public List<student> getAll() {
        List<student> students = new java.util.ArrayList<>();
        IParsable<student> parser = new service.business.studentParser();
        String filePath = "data/students.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                student stu = parser.parse(line);
                students.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public void saveAll(List<student> students) {
        // Implementation for saving students to CSV can be added here
        String filePath = "data/output.csv";
        try (java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.FileWriter(filePath))) {
            for (student stu : students) {
                bw.write(stu.toString());
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "CSV Data Access Object";
    }

}