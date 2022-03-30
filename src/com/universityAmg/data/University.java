package com.universityAmg.data;

import java.util.ArrayList;
import java.util.Collection;

public class University {

    private ArrayList<Course> coursesArrayList;
    private ArrayList<Teacher> teachersArrayList;
    private ArrayList<Student> studentsArrayList;

    @Override
    public String toString() {
        return ("Students:"+ this.getStudents()
                );
    }

    public University() {
        this.coursesArrayList = new ArrayList<>();
        this.teachersArrayList = new ArrayList<>();
        this.studentsArrayList = new ArrayList<>();
    }

    public void addStudents(Student nStudent){
        this.studentsArrayList.add(nStudent);
    }

    public ArrayList<Student> getStudents() {
        return this.studentsArrayList;
    }

    public void addTeachers(Teacher nTeacher){
        this.teachersArrayList.add(nTeacher);
    }

    public ArrayList<Teacher> getTeachers() {
        return this.teachersArrayList;
    }

    public void addCourses(Course nCourse){
        this.coursesArrayList.add(nCourse);
    }

    public ArrayList<Course> getCourses() {
        return this.coursesArrayList;
    }

    public void addPartTimeTeacher(String newTeacherName, float newTeacherBaseSalary, int activeHrsWeek){
        Teacher newParTimeTeacher = new PartTimeTeacher(newTeacherName,newTeacherBaseSalary,activeHrsWeek);
        this.teachersArrayList.add(newParTimeTeacher);
    }

    public void addFullTimeTeacher(String newTeacherName, float newTeacherBaseSalary, int yearOfExperience){
        Teacher newFullTimeTeacher = new FullTimeTeacher(newTeacherName,newTeacherBaseSalary, yearOfExperience);
        this.teachersArrayList.add(newFullTimeTeacher);
    }

    public void listCoursesPerStudentID(int studentIdIndex){
        this.studentsArrayList.get(studentIdIndex-1);
        for (int i = 0; i < coursesArrayList.size(); i++) {
            for (int j = 0; j < coursesArrayList.get(i).getCourseStudents().size(); j++) {
                if (studentIdIndex==coursesArrayList.get(i).getCourseStudents().get(j).getStudentId()){
                    coursesArrayList.get(i).showListCoursesPerStudentID();
                }
            }
        }
    }
}
