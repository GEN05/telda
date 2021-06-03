package com.test.telda.controller;

import com.test.telda.domain.Region;
import com.test.telda.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/region")
public class RegionController {
    private final RegionService service;

    @GetMapping("/id/{id}")
    public String findById(@PathVariable long id) {
        return service.findById(id).toString();
    }

    @GetMapping("/name/{name}")
    public Region findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("/abbreviatedName/{abbreviatedName}")
    public String findByAbbreviatedName(@PathVariable String abbreviatedName) {
        return service.findByAbbreviatedName(abbreviatedName).toString();
    }

    @GetMapping("/all")
    public List<Region> findAll() {
        return service.findAll();
    }

    @PostMapping("/add")
    private void create(Region region) {
        service.add(region);
    }

    @GetMapping("../error")
    public String error() {
        return "An error has occurred. Check the entered data";
    }
}
