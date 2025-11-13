package com.example.demo.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.PeliculaEntity;

public interface peliculaRepository extends JpaRepository<PeliculaEntity , Integer> {
    public ArrayList<PeliculaEntity> findAllById(int id);
    public ArrayList<PeliculaEntity> findAll();

    public PeliculaEntity findById(int id);


}
