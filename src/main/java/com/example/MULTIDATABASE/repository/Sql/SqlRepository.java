package com.example.MULTIDATABASE.repository.Sql;

import com.example.MULTIDATABASE.model.City;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlRepository  extends JpaRepository<City, Integer> {

}
