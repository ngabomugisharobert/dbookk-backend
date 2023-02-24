package com.example.dbookk.controller;

import com.example.dbookk.entity.Guard;
import com.example.dbookk.service.GuardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GuardController {

    @Autowired
    private GuardService guardService;

    @GetMapping("/guards")
    public Guard[] getGuards() throws Exception
    {
        Guard[] guards = guardService.getGuards();
        return guards;
    }
}
