package ru.skypro.homework.springfiles.dto;

import ru.skypro.homework.springfiles.service.EmployeeView;

public class EmployeeViewDTO {
    private String name;
    private Integer salary;
    private String role;

    public EmployeeViewDTO() {
    }
    public static EmployeeViewDTO fromEmployeeView(EmployeeView employeeView) {
        EmployeeViewDTO viewDto = new EmployeeViewDTO();
        viewDto.setName(employeeView.getName());
        viewDto.setSalary(employeeView.getSalary());
        viewDto.setRole(employeeView.getPosition().getRole());
        return viewDto;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
