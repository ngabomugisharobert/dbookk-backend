package com.example.dbookk.controller;

import com.example.dbookk.entity.Visitor;
import com.example.dbookk.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@EnableCaching
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @GetMapping("/visitors")
    @Cacheable("visitors")
    public Visitor[] getVisitor() throws Exception {
        Visitor[] visitors = visitorService.getVisitors();
        return visitors;
    }
}
