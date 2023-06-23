package ru.skypro.homework.springfiles.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.skypro.homework.springfiles.dto.EmployeeReport;
import ru.skypro.homework.springfiles.pojo.Report;
import ru.skypro.homework.springfiles.repository.ReportRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }
    public Report getReportById(Integer id) {
        Optional<Report> report = reportRepository.findById(id);
        System.out.println(report);
        return report.orElseThrow(()-> new RuntimeException("id: " + id));
    }
    public Integer createAndSaveReport(String jsonFileName) {
        EmployeeReport employeeReport = formEmployeeReport();
        try (OutputStream outputStream = new FileOutputStream(jsonFileName)) {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonEmployeeReport = objectMapper.writeValueAsString(employeeReport);
            outputStream.write(jsonEmployeeReport.getBytes());
            outputStream.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Report report = new Report();
        String jsonString = FileService.readJsonFromFileStringPath(jsonFileName);
        report.setFileContent(jsonString);
        Report returnReport = reportRepository.save(report);
        return returnReport.getReportId();
    }
    public static EmployeeReport formEmployeeReport() {
        EmployeeReport employeeReport = new EmployeeReport();
        employeeReport.setDepartment(1);
        employeeReport.setCountOfEmployees(3L);
        employeeReport.setMinSalary(100);
        employeeReport.setMaxSalary(500);
        employeeReport.setAverageSalary(300);
        return employeeReport;
    }
}
