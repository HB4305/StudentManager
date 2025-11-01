package service.business;

import models.student;

public class studentParser extends IParsable<student> {
    @Override
    public student parse(String data) {
        String[] parts = data.split(",");
        if (parts.length != 7) {
            throw new IllegalArgumentException("Invalid data format for student");
        }
        String studentID = parts[0].trim();
        String name = parts[1].trim();
        int age = Integer.parseInt(parts[2].trim());
        double gpa = Double.parseDouble(parts[3].trim());
        String imgPath = parts[4].trim();
        String address = parts[5].trim();
        String notes = parts[6].trim();

        return new models.student(studentID, name, age, gpa, imgPath, address, notes);
    }

    @Override
    public String toString() {
        return "studentParser";
    }
}
