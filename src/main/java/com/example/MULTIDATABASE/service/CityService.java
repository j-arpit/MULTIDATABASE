package com.example.MULTIDATABASE.service;


import com.example.MULTIDATABASE.model.City;
import com.example.MULTIDATABASE.repository.H2.H2Repository;
import com.example.MULTIDATABASE.repository.Sql.SqlRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CityService {

    @Autowired
    private  H2Repository h2Repository;

    @Autowired
    private  SqlRepository sqlRepository;

    public List<City> findAllH2() {
        return h2Repository.findAll();
    }

    public List<City> findAllSql() {
        return sqlRepository.findAll();
    }

    public List<City> findAll() {
        List<City> h2 =  h2Repository.findAll();
        List<City> sql = sqlRepository.findAll();
        List<City> union = Stream.concat( h2.stream(), sql.stream())
            .collect( Collectors.toList());
        return union;
    } 

}
