package com.example.demo.Services;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.PeliculaEntity;

@Service
public class peliculaServiceImpl implements peliculaService {
    
    static ArrayList<PeliculaEntity> listaPeliculas = new ArrayList<>();



    @Override
    public ResponseEntity<ArrayList<PeliculaEntity>> getAll() {
       return ResponseEntity.ok().body(listaPeliculas); 
    }

    

}
