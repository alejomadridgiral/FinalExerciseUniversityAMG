package com.universityAmg.data;

import java.util.ArrayList;

public class Course {

    private String courseName;
    private String assignClassroom;
    private Teacher teacher;
    private ArrayList<Student> courseStudents;

    public Course(String nCourseName, String nAssignClassroom, Teacher nTeacher, ArrayList<Student> nCourseStudents) {
        this.courseName = nCourseName;
        this.assignClassroom = nAssignClassroom;
        this.teacher = nTeacher;
        this.courseStudents = nCourseStudents;
    }

    @Override
    public String toString() {
        return ("Course Name:" + this.getCourseName() +
                " Classroom:" + this.getAssignClassroom() +
                " " + this.getTeacher() +
                " " + this.getCourseStudents() + "\n");
    }

    public void showListCoursesPerStudentID(){
        System.out.println("Name of courses: " + courseName);
    }

    public String getCourseName() {
        return courseName;
    }

    public String getAssignClassroom() {
        return assignClassroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public ArrayList<Student> getCourseStudents() {
        return courseStudents;
    }

    public void addStudentToCourseStudents(Student nCourseStudent){
        this.courseStudents.add(nCourseStudent);
    }
}
