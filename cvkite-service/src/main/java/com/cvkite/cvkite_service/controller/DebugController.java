package com.cvkite.cvkite_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebugController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/debug/db")
    public String dbName() {
        return mongoTemplate.getDb().getName();
    }
}

