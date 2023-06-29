package ru.skypro.homework.springfiles.pojo;

import jakarta.persistence.*;
@Entity
@Table(name = "path")
public class ReportWithPath {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "path_id")
    private Integer pathId;
    @Lob
    @Column(name = "path_content", columnDefinition="TEXT")
    private String pathContent;

    public ReportWithPath() {
    }

    public ReportWithPath(Integer pathId, String pathContent) {
        this.pathId = pathId;
        this.pathContent = pathContent;
    }

    public Integer getPathId() {
        return pathId;
    }

    public void setPathId(Integer pathId) {
        this.pathId = pathId;
    }

    public String getPathContent() {
        return pathContent;
    }

    public void setPathContent(String pathContent) {
        this.pathContent = pathContent;
    }

    @Override
    public String toString() {
        return "ReportWithPath{" +
                "pathId=" + pathId +
                ", pathContent='" + pathContent + '\'' +
                '}';
    }
}
