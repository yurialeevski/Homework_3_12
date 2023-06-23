package ru.skypro.homework.springfiles.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.springfiles.pojo.Report;
import ru.skypro.homework.springfiles.pojo.ReportWithPath;
import ru.skypro.homework.springfiles.service.EmployeeService;
import ru.skypro.homework.springfiles.service.FileService;
import ru.skypro.homework.springfiles.service.ReportService;
import ru.skypro.homework.springfiles.service.ReportWithPathService;
@RestController
public class ReportWithPathController {
    private final ReportWithPathService reportWithPathService;

    public ReportWithPathController(ReportWithPathService reportWithPathService) {
        this.reportWithPathService = reportWithPathService;
    }
    @GetMapping(value = "/report-path/{id}")
    public String getReportById(@PathVariable Integer id) {
        ReportWithPath reportPath = reportWithPathService.getReportById(id);
        return FileService.readJsonFromFileStringPath(reportPath.getPathContent());
        //return reportPath.getPathContent();
    }
    @PostMapping("/report-path")
    public Integer saveReportPath(@RequestParam("jsonFileName") String jsonFileName) {
        return reportWithPathService.savePath(jsonFileName);
    }
}
