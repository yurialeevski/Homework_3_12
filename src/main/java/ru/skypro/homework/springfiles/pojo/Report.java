package ru.skypro.homework.springfiles.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Integer reportId;
    @Lob
    @Column(name = "file_content", columnDefinition="TEXT")
    private String fileContent;

    public Report() {
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportId=" + reportId +
                ", fileContent='" + fileContent + '\'' +
                '}';
    }
}
