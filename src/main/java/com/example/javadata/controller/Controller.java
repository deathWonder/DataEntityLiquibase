package com.example.javadata.controller;

import com.example.javadata.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final PersonService service;

    public Controller(PersonService service) {
        this.service = service;
    }

    @GetMapping("/persons/by-city")
    private String getPersonsByCity(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/create")
    private String createData() {
        return service.create();
    }

}
