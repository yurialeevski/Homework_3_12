package ru.skypro.homework.springfiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.springfiles.pojo.Report;

public interface ReportRepository extends JpaRepository<Report, Integer> {
}
