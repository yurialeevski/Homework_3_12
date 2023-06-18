package ru.skypro.homework.springfiles.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.springfiles.dto.EmployeeDTO;
import ru.skypro.homework.springfiles.dto.EmployeeViewDTO;
import ru.skypro.homework.springfiles.pojo.Employee;
import ru.skypro.homework.springfiles.service.EmployeeService;
import ru.skypro.homework.springfiles.service.EmployeeView;

import java.util.List;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/with-greatest-salary")
    public List<EmployeeDTO> getAllEmployeesWithMaxSalary() {
        return employeeService.getAllWithMaxSalary();
    }

    @GetMapping("/all-with-position")
    public List<EmployeeDTO> getAllEmployeesByPosition(@RequestParam("position") String position) {
        return employeeService.findAllWithPosition(position);
    }
    @GetMapping("/{id}/fullInfo")
    public EmployeeView getEmployeeFullInfoById(@PathVariable Integer id) {
        return employeeService.findFullInfoById(id);
    }
    @GetMapping({"/{id}/fullViewInfo"})
    public EmployeeViewDTO getViewInfoById(@PathVariable Integer id) {
        return employeeService.findViewInfo(id);
    }
    @GetMapping("/pages")
    public List<Employee> getAllEmployeesByPageNumber(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "employeeId") String sortBy) {
        List<Employee> list = employeeService.getAllByPageNumber(pageNo, pageSize, sortBy);

        return list;
    }
}
