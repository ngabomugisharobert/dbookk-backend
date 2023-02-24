package com.example.dbookk.controller;

import com.example.dbookk.entity.Movement;
import com.example.dbookk.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MovementController {

    @Autowired
    private MovementService movementService;

    @GetMapping("/movements")
    public Movement[] getMovements() throws Exception
    {
        Movement[] movements = movementService.getMovements();
        return movements;
    }
}
