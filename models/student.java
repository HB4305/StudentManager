package models;

public class student extends Objectbase {
    private String studentID;
    private String name;
    private int age;
    private double gpa;
    private String imgPath;
    private String address;
    private String notes;

    public student() {
        this.studentID = "";
        this.name = "";
        this.age = 0;
        this.gpa = 0.0;
        this.imgPath = "";
        this.address = "";
        this.notes = "";
    }

    public student(String studentID, String name, int age, double gpa, String imgPath, String address, String notes) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.imgPath = imgPath;
        this.address = address;
        this.notes = notes;
    }

    // Setters
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // Getters
    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return gpa;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getAddress() {
        return address;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return studentID + "," + name + "," + age + "," + gpa + "," + imgPath + "," + address + "," + notes;
    }
}