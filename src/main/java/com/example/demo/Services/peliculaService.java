package com.example.demo.Services;

import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.PeliculaEntity;


public interface peliculaService {
    
    public ResponseEntity<ArrayList<PeliculaEntity>> getAll();

}
