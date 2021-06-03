package com.test.telda.controller;

import com.test.telda.domain.Region;
import com.test.telda.exception.RegionException;
import com.test.telda.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/region")
public class RegionController {
    private final RegionService service;

    @GetMapping("/id/{id}")
    public String findById(@PathVariable long id) {
        try {
            return service.findById(id).toString();
        } catch (RegionException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/name/{name}")
    public String findByName(@PathVariable String name) {
        try {
            return service.findByName(name).toString();
        } catch (RegionException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/abbreviatedName/{abbreviatedName}")
    public String findByAbbreviatedName(@PathVariable String abbreviatedName) {
        try {
            return service.findByAbbreviatedName(abbreviatedName).toString();
        } catch (RegionException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/all")
    public String findAll() {
        try {
            return service.findAll().toString();
        } catch (RegionException e) {
            return e.getMessage();
        }
    }

    @PostMapping("/add")
    private String add(Region region) {
        try {
            service.add(region);
        } catch (RegionException e) {
            return e.getMessage();
        }
        return findAll();
    }

    @DeleteMapping("/delete")
    public String deleteById(int id) {
        try {
            service.deleteById(id);
        } catch (RegionException e) {
            return e.getMessage();
        }
        return findAll();
    }

    @DeleteMapping("/delete/all")
    public String deleteAll() {
        try {
            service.deleteAll();
        } catch (RegionException e) {
            return e.getMessage();
        }
        return findAll();
    }

    @PostMapping("/update")
    public String update(Region region, long regId) {
        try {
            service.update(region, regId);
        } catch (RegionException e) {
            return e.getMessage();
        }
        return findAll();
    }
}
