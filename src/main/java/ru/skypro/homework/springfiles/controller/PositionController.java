package ru.skypro.homework.springfiles.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.springfiles.pojo.Position;
import ru.skypro.homework.springfiles.service.PositionService;

import java.util.List;
@RestController
@RequestMapping("/position")
public class PositionController {
    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }
    @GetMapping("/all-positions")
    public List<Position> getPositions() {
        return positionService.getPositions();
    }
}
