package com.example.MULTIDATABASE.repository.H2;

import com.example.MULTIDATABASE.model.City;

import org.springframework.data.jpa.repository.JpaRepository;



public interface H2Repository  extends JpaRepository<City, Integer> {

}
