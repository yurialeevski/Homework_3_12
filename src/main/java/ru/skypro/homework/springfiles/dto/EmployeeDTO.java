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

    public EmployeeDTO(Integer id, String name, int salary, Position position) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.position = position;
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

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", position=" + position +
                '}';
    }
}
/*###########################################################################
public class EmployeeDTO implements Serializable {
    private Integer id;
    private String name;
    private int salary;
    private Integer department;
    private Position position;


    public static EmployeeDTO fromEmployee(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setPosition(employee.getPosition());
        employeeDTO.setDepartment(employee.getDepartment());
        return employeeDTO;
    }

    public Employee toEmployee() {
        Employee employee = new Employee();
        employee.setId(this.getId());
        employee.setName(this.getName());
        employee.setSalary(this.getSalary());
        employee.setPosition(this.getPosition());
        employee.setDepartment(this.getDepartment());
        return employee;
    }
 #############################################################################*/