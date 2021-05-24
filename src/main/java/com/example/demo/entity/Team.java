package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Team {

    @Id
    private String team_key;
    private String team_name;
}
