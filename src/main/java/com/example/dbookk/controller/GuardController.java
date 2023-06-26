package com.example.dbookk.controller;

import com.example.dbookk.entity.Guard;
import com.example.dbookk.service.GuardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@EnableCaching
public class GuardController {

    @Autowired
    private GuardService guardService;

    @GetMapping("/guards")
    @Cacheable("guards")
    public Guard[] getGuards() throws Exception
    {
        Guard[] guards = guardService.getGuards();
        return guards;
    }
}
