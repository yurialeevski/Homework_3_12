package ru.skypro.homework.springfiles.dto;

import ru.skypro.homework.springfiles.pojo.Employee;
import ru.skypro.homework.springfiles.pojo.Position;

public class EmployeeDTO {
    private Integer id;
    private String name;
    private int salary;
    private Position position;

    public EmployeeDTO() {
    }

    public static EmployeeDTO fromEmployeeAllFields(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getEmployeeId());
        dto.setName(employee.getName());
        dto.setSalary(employee.getSalary());
        dto.setPosition(employee.getPosition());
        return dto;
    }

    public Employee toEmployee() {
        Employee employee = new Employee();
        employee.setId(this.getId());
        employee.setName((this.getName()));
        employee.setSalary(this.getSalary());
        employee.setPosition(this.getPosition());
        return employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
