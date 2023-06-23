package ru.skypro.homework.springfiles.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.springfiles.pojo.Report;
import ru.skypro.homework.springfiles.service.EmployeeService;
import ru.skypro.homework.springfiles.service.ReportService;

@RestController
//@RequestMapping("/report")
public class ReportController {
    private final ReportService reportService;
    private final EmployeeService employeeService;

    public ReportController(ReportService reportService, EmployeeService employeeService) {
        this.reportService = reportService;
        this.employeeService = employeeService;
    }
    @PostMapping("/report")
    public Integer createAndSaveJsonReport(@RequestParam("jsonFileName") String jsonFileName) {
        return reportService.createAndSaveReport(jsonFileName);
    }
    @GetMapping(value = "/report/{id}")
    public String getReportById(@PathVariable Integer id) {
        Report report = reportService.getReportById(id);
        return report.getFileContent();
    }
}
