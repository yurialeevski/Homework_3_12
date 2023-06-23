package ru.skypro.homework.springfiles.dto;

import java.io.Serializable;

public class EmployeeReport implements Serializable {
    private int department;
    private Long countOfEmployees;
    private int minSalary;
    private int maxSalary;
    private double averageSalary;

    public EmployeeReport() {
    }

    public EmployeeReport(int department, Long countOfEmployees, int minSalary, int maxSalary, double averageSalary) {
        this.department = department;
        this.countOfEmployees = countOfEmployees;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.averageSalary = averageSalary;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public Long getCountOfEmployees() {
        return countOfEmployees;
    }

    public void setCountOfEmployees(Long countOfEmployees) {
        this.countOfEmployees = countOfEmployees;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    @Override
    public String toString() {
        return "EmployeeReport{" +
                "department=" + department +
                ", countOfEmployees=" + countOfEmployees +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                ", averageSalary=" + averageSalary +
                '}';
    }
}
