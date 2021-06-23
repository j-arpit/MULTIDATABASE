package com.example.MULTIDATABASE.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="cities")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public @Data class City {
    @Id
    private Integer id;
    private String name;
    private int population;

    @Override
    public String toString() {
        return "City[id=" + id + ",name=" + name + ",population=" + population + "]";
    }
    
}
