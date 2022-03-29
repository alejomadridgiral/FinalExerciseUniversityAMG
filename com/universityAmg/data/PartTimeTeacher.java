package com.universityAmg.data;

public class PartTimeTeacher extends Teacher{

    private int weekActiveHrs;

    public PartTimeTeacher(String teacherName, float baseSalaryHrs, int weekActiveHrs) {
        super(teacherName, baseSalaryHrs);
        this.weekActiveHrs = weekActiveHrs;
    }

    @Override
    public float calculateSalary() {
        return super.baseSalaryHrs*weekActiveHrs;
    }
}
