package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class League {

    @Id
    private Integer league_id;
    private String league_name;
    private String country_name;
    private Integer country_id;
}
