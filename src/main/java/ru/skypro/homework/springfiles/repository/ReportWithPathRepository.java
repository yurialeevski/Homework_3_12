package ru.skypro.homework.springfiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.springfiles.pojo.ReportWithPath;

public interface ReportWithPathRepository extends JpaRepository<ReportWithPath, Integer> {

}
