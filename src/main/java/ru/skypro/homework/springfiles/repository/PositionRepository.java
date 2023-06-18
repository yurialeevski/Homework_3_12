package ru.skypro.homework.springfiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.springfiles.pojo.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
