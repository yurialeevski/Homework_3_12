package ru.skypro.homework.springfiles.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.springfiles.dto.EmployeeDTO;
import ru.skypro.homework.springfiles.dto.EmployeeViewDTO;
import ru.skypro.homework.springfiles.pojo.Employee;
import ru.skypro.homework.springfiles.service.EmployeeService;
import ru.skypro.homework.springfiles.service.EmployeeView;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<Employee> uploadJsonFile(@RequestParam("jsonFileName") MultipartFile jsonFileName) {
        return employeeService.getJsonSaveToDatabase(jsonFileName);
    }
    @PostMapping("/addOne")
    public void postEmployee(EmployeeDTO employeeDTO) {
        employeeService.addEmployee(employeeDTO);
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
    public List<EmployeeDTO> getAllEmployeesByPageNumber(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "employeeId") String sortBy) {
        List<EmployeeDTO> listDTO = employeeService.getAllByPageNumber(pageNo, pageSize, sortBy);
        return listDTO;
    }
}