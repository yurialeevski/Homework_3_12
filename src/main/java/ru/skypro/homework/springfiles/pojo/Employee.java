package ru.skypro.homework.springfiles.pojo;

import jakarta.persistence.*;
@Entity
@Table(name = "employee_spring")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;
    private String name;
    private Integer salary;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    private Position position;

    public Employee() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
