package com.universityAmg.test;

import com.universityAmg.data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        University universityAMG = uploadData();

        int menuOn = 0;

        while (menuOn == 0) {
            System.out.println("\n Please select one of the following options: " +
                    "\n 1. Print all the professors with its data: " +
                    "\n 2. Print all the courses and select a course to see the course info: " +
                    "\n 3. Create a new student and add it to a course" +
                    "\n 4. Create a new course and add the teacher and students" +
                    "\n 5. List the courses a student is in:" +
                    "\n 6. Exit");

            Scanner scan = new Scanner(System.in);
            int menuChose = scan.nextInt();

            switch (menuChose) {
                case 1:
                    printTeachers(universityAMG.getTeachers());
                    break;

                case 2:
                    printCoursesName(universityAMG.getCourses());
                    System.out.println("Please select one of the courses");
                    Scanner scanSubMenu = new Scanner(System.in);
                    int nSubMenu = scanSubMenu.nextInt();
                    printSubMenuCourseInfo(universityAMG.getCourses().get(nSubMenu - 1));
                    break;

                case 3:
                    System.out.println("Please enter the student name: ");
                    Scanner scanStudentName = new Scanner(System.in);
                    String scannedStudentName = scanStudentName.nextLine();
                    System.out.println("Please enter the student age: ");
                    Scanner scanStudentAge = new Scanner(System.in);
                    int scannedStudentAge = scanStudentAge.nextInt();
                    Student nStudent = new Student(scannedStudentName, scannedStudentAge);
                    universityAMG.addStudents(nStudent);
                    System.out.println("the new Student was added");
                    printStudents(universityAMG.getStudents());

                    System.out.println("Please select the course to add the student");
                    printCoursesName(universityAMG.getCourses());
                    System.out.println("Please select one of the courses");
                    Scanner scanSubMenuToSelectCourse = new Scanner(System.in);
                    int subMenuToSelectCourse = scanSubMenuToSelectCourse.nextInt();
                    universityAMG.getCourses().get(subMenuToSelectCourse - 1).addStudentToCourseStudents(nStudent);
                    System.out.println("the new courses status as follow;");
                    printCourses(universityAMG.getCourses());
                    break;

                case 4:
                    System.out.println("Please enter the course name: ");
                    Scanner scanNewCourseName = new Scanner(System.in);
                    String newCourseName = scanNewCourseName.nextLine();
                    System.out.println("Please enter the Classroom (ei C###)");
                    Scanner scanNewCourseClassroom = new Scanner(System.in);
                    String newCourseClassroom = scanNewCourseClassroom.nextLine();
                    System.out.println("Please fill the Teacher info");
                    System.out.println("Is the teacher? 1. Part Time or 2. Full Time");
                    Scanner scanTeacherContract = new Scanner(System.in);
                    int choseTeacherContract = scanTeacherContract.nextInt();
                    if (choseTeacherContract == 1) {
                        System.out.println("Please enter the teacher name: ");
                        Scanner scanNewTeacherName = new Scanner(System.in);
                        String newTeacherName = scanNewTeacherName.nextLine();
                        System.out.println("Please enter the base Salary in Hrs");
                        Scanner scanNewPartTimeTeacherBaseSalary = new Scanner(System.in);
                        float newTeacherBaseSalary = scanNewPartTimeTeacherBaseSalary.nextFloat();
                        System.out.println("Please enter the active hour per week");
                        Scanner scanActiveHrsWeek = new Scanner(System.in);
                        int activeHrsWeek = scanActiveHrsWeek.nextInt();
                        universityAMG.addPartTimeTeacher(newTeacherName, newTeacherBaseSalary, activeHrsWeek);
                    } else if (choseTeacherContract == 2) {
                        System.out.println("Please enter the teacher name: ");
                        Scanner scanNewTeacherName = new Scanner(System.in);
                        String newTeacherName = scanNewTeacherName.nextLine();
                        System.out.println("Please enter the base Salary in Hrs");
                        Scanner scanNewPartTimeTeacherBaseSalary = new Scanner(System.in);
                        float newTeacherBaseSalary = scanNewPartTimeTeacherBaseSalary.nextFloat();
                        System.out.println("Please enter the teacher years of experience");
                        Scanner scanYearsOfExperience = new Scanner(System.in);
                        int yearsOfExperience = scanYearsOfExperience.nextInt();
                        universityAMG.addFullTimeTeacher(newTeacherName, newTeacherBaseSalary, yearsOfExperience);
                    } else {
                        System.out.println("Select and option between 1 or 2");
                    }

                    System.out.println("Please enter the student name: ");
                    Scanner scanStudentNameForNewCourse = new Scanner(System.in);
                    String studentNameForNewCourse = scanStudentNameForNewCourse.nextLine();
                    System.out.println("Please enter the student age: ");
                    Scanner scanStudentAgeForNewCourse = new Scanner(System.in);
                    int studentAgeForNewCourse = scanStudentAgeForNewCourse.nextInt();
                    Student newStudentForNewCourse = new Student(studentNameForNewCourse, studentAgeForNewCourse);
                    universityAMG.addStudents(newStudentForNewCourse);
                    System.out.println("the new Student was added");
                    ArrayList<Student> myStudentList = new ArrayList<>();
                    Course newCourse = new Course(newCourseName, newCourseClassroom, universityAMG.getTeachers().get(universityAMG.getTeachers().size() - 1), myStudentList);
                    universityAMG.addCourses(newCourse);
                    universityAMG.getCourses().get(universityAMG.getCourses().size() - 1).addStudentToCourseStudents(newStudentForNewCourse);
                    printStudents(universityAMG.getStudents());
                    System.out.println("the new course was added");
                    printCoursesName(universityAMG.getCourses());
                    break;

                case 5:
                    System.out.println("Please select the student with ID Number");
                    printStudents(universityAMG.getStudents());
                    Scanner scanStudentID = new Scanner(System.in);
                    int studentIdIndex = scanStudentID.nextInt();
                    System.out.println("the student is in the following courses");
                    universityAMG.listCoursesPerStudentID(studentIdIndex);
                    break;

                case 6:
                    System.out.println("Come back soon to your University app!! ");
                    menuOn = 1;
                    break;

                default:
                    System.out.println("Please choose a valid option");
                    break;
            }
        }
    }

    public static University uploadData() {

        University universityAMG = new University();

        Student student1 = new Student("Sergio", 36);
        Student student2 = new Student("Mile", 30);
        Student student3 = new Student("Marco", 33);
        Student student4 = new Student("John", 38);
        Student student5 = new Student("Will", 39);

        Student student6 = new Student("Alejo", 15);
        Student student7 = new Student("Lucy", 15);
        Student student8 = new Student("Fede", 12);
        Student student9 = new Student("Otto", 14);
        Student student10 = new Student("Jane", 22);
        Student student11 = new Student("Nico", 29);
        Student student12 = new Student("Soco", 41);

        universityAMG.addStudents(student1);
        universityAMG.addStudents(student2);
        universityAMG.addStudents(student3);
        universityAMG.addStudents(student4);
        universityAMG.addStudents(student5);

        universityAMG.addStudents(student6);
        universityAMG.addStudents(student7);
        universityAMG.addStudents(student8);
        universityAMG.addStudents(student9);
        universityAMG.addStudents(student10);
        universityAMG.addStudents(student11);
        universityAMG.addStudents(student12);

        Teacher teacher1 = new FullTimeTeacher("Roberto", 25, 5);
        Teacher teacher2 = new FullTimeTeacher("Ricardo", 50, 28);
        Teacher teacher3 = new PartTimeTeacher("Zoyla", 65, 5);
        Teacher teacher4 = new PartTimeTeacher("Rigo", 50, 6);

        universityAMG.addTeachers(teacher1);
        universityAMG.addTeachers(teacher2);
        universityAMG.addTeachers(teacher3);
        universityAMG.addTeachers(teacher4);

        ArrayList<Student> studentList1 = new ArrayList<>();
        studentList1.add(student1);
        studentList1.add(student2);
        studentList1.add(student3);

        ArrayList<Student> studentList2 = new ArrayList<>();
        studentList2.add(student4);
        studentList2.add(student5);
        studentList2.add(student6);

        ArrayList<Student> studentList3 = new ArrayList<>();
        studentList3.add(student7);
        studentList3.add(student8);
        studentList3.add(student9);

        ArrayList<Student> studentList4 = new ArrayList<>();
        studentList4.add(student10);
        studentList4.add(student11);
        studentList4.add(student12);

        universityAMG.addCourses(new Course("Cooking", "C202", teacher1, studentList1));
        universityAMG.addCourses(new Course("Drawing", "C102", teacher2, studentList2));
        universityAMG.addCourses(new Course("Music", "C402", teacher3, studentList3));
        universityAMG.addCourses(new Course("Skate", "C302", teacher4, studentList4));

        return universityAMG;
    }

    public static void printStudents(ArrayList<Student> studentsArrayList) {
        for (Student item : studentsArrayList) {
            System.out.println(item);
        }
    }

    public static void printTeachers(ArrayList<Teacher> teachersArrayList) {
        for (Teacher item : teachersArrayList) {
            System.out.println(item);
        }
    }

    public static void printCourses(ArrayList<Course> courseArrayList) {
        for (Course item : courseArrayList) {
            System.out.println(item);
        }
    }

    public static void printCoursesName(ArrayList<Course> courseArrayList) {
        for (int i = 0; i < courseArrayList.size(); i++) {
            System.out.println("N°: " + (i + 1) + "." + courseArrayList.get(i).getCourseName());
        }
    }

    public static void printSubMenuCourseInfo(Course course) {
        System.out.println(course);
        printStudents(course.getCourseStudents());
    }

}

