package com.example.demo.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.Entity.PeliculaEntity;
import com.example.demo.Services.peliculaService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("Pelicula")
public class PeliculasController {
    

    @Autowired
    private peliculaService peliculaService;



    @GetMapping("getAll")
    public ResponseEntity<ArrayList<PeliculaEntity>> getAll() {
        return peliculaService.getAll();
    }
    

    
}
