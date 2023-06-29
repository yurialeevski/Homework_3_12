package ru.skypro.homework.springfiles.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.skypro.homework.springfiles.dto.EmployeeReport;
import ru.skypro.homework.springfiles.pojo.Report;
import ru.skypro.homework.springfiles.pojo.ReportWithPath;
import ru.skypro.homework.springfiles.repository.ReportWithPathRepository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

@Service
public class ReportWithPathService {
    private final ReportWithPathRepository reportWithPathRepository;

    public ReportWithPathService(ReportWithPathRepository reportWithPathRepository) {
        this.reportWithPathRepository = reportWithPathRepository;
    }
    public ReportWithPath getReportById(Integer id) {
        Optional<ReportWithPath> reportPath = reportWithPathRepository.findById(id);
        System.out.println(reportPath);
        return reportPath.orElseThrow(()-> new RuntimeException("id: " + id));
    }
    public Integer savePath(String jsonFileName) {
        EmployeeReport employeeReport = formEmployeeReport();
        try (OutputStream outputStream = new FileOutputStream(jsonFileName)) {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonEmployeeReport = objectMapper.writeValueAsString(employeeReport);
            outputStream.write(jsonEmployeeReport.getBytes());
            outputStream.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        ReportWithPath reportWithPath = new ReportWithPath();
        reportWithPath.setPathContent(jsonFileName);
        ReportWithPath returnReportWithPath = reportWithPathRepository.save(reportWithPath);
        return returnReportWithPath.getPathId();
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
