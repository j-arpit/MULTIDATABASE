package com.example.MULTIDATABASE.controller;

import java.util.List;

import com.example.MULTIDATABASE.model.City;
import com.example.MULTIDATABASE.model.ErrorMessage;
import com.example.MULTIDATABASE.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    CityService cityservice;

    @GetMapping("/Cities/H2")
    public ResponseEntity<?> getAllCitiesH2() {
        List<City> cities = cityservice.findAllH2();
        if(cities != null && !cities.isEmpty()) {
            return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<ErrorMessage>(new ErrorMessage("resource not found"),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/Cities/Sql")
    public ResponseEntity<?> getAllCitiesSql() {
        List<City> cities = cityservice.findAllSql();
        if(cities != null && !cities.isEmpty()) {
            return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<ErrorMessage>(new ErrorMessage("resource not found"),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/Cities")
    public ResponseEntity<?> getAllCities() {
        List<City> cities = cityservice.findAll();
        if(cities != null && !cities.isEmpty()) {
            return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<ErrorMessage>(new ErrorMessage("resource not found"),HttpStatus.NOT_FOUND);
        }
    }
}
