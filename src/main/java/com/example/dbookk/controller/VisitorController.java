package com.example.dbookk.controller;

import com.example.dbookk.entity.Visitor;
import com.example.dbookk.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @GetMapping("/visitors")
    public Visitor[] getVisitor() throws Exception {
        Visitor[] visitors = visitorService.getVisitors();
        return visitors;
    }
}
