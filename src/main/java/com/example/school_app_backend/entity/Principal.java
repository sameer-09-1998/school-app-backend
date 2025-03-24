package com.example.school_app_backend.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "principals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Principal extends User{

    private String name;
    private String email;
}
