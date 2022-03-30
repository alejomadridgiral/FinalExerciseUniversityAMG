package com.universityAmg.data;

public class Student {

    private String studentName;
    private static int generateId = 1;
    private int studentId;
    private int studentAge;

    public Student(String nStudentName, int nStudentAge) {
        this.studentName = nStudentName;
        this.studentAge = nStudentAge;
        this.studentId = generateId++;

    }

    @Override
    public String toString() {
        return ("Student Name:" + this.getStudentName() +
                " Age:" + this.getStudentAge() +
                " ID:" + this.studentId);
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public int getStudentId() {
        return studentId;
    }


}
