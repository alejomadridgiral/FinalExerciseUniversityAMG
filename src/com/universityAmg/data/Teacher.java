package com.universityAmg.data;

public abstract class Teacher {

    protected String teacherName;
    protected float baseSalaryHrs;

       public Teacher(String teacherName, float baseSalaryHrs) {
        this.teacherName = teacherName;
        this.baseSalaryHrs = baseSalaryHrs;
    }

    @Override
    public String toString() {
        return ("Teacher Name:" + this.getTeacherName() +
                " base salary per hr:" + this.getBaseSalaryHrs() +
                " final salary:" + this.calculateSalary());
    }

    public String getTeacherName() {
        return teacherName;
    }

    public float getBaseSalaryHrs() {
        return baseSalaryHrs;
    }


    public abstract float calculateSalary();

}
