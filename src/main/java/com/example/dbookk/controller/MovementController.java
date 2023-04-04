package com.example.dbookk.controller;

import com.example.dbookk.entity.Movement;
import com.example.dbookk.entity.Movements;
import com.example.dbookk.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovementController {

    @Autowired
    private MovementService movementService;

    @GetMapping("/movements")
    public List<Movements> getMovements() throws Exception
    {
        List<Movements> movements = movementService.getMovements();
        return movements;
    }

    @GetMapping("/movementsDuration")
    public List<Movements> getMovementDuration() throws Exception
    {
        List<Movements> movements = movementService.getMovementDuration();
        return movements;
    }


}
