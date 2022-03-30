package com.universityAmg.data;

public class FullTimeTeacher extends Teacher {

    private int yearsOfExpirience;

    public FullTimeTeacher(String teacherName, float baseSalary, int yearsOfExpirience) {
        super(teacherName, baseSalary);
        this.yearsOfExpirience = yearsOfExpirience;
    }

    @Override
    public float calculateSalary() {
        return super.baseSalaryHrs*(yearsOfExpirience*1.10F);
    }
}
