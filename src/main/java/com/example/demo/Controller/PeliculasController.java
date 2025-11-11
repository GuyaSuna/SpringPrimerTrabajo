package com.example.demo.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.Entity.PeliculaEntity;
import com.example.demo.Services.peliculaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("Pelicula")
public class PeliculasController {
    

    @Autowired
    private peliculaService peliculaService;



    @GetMapping("getAll")
    public ResponseEntity<ArrayList<PeliculaEntity>> getAll() {
        return peliculaService.getAll();
    }

    @GetMapping("getPelicula/{id}")
    public ResponseEntity<PeliculaEntity> getPelicula(@PathVariable int id) {
        return peliculaService.getPelicula(id);
    }
    
    
    @PostMapping("postPelicula")
    public ResponseEntity<?> postPelicula(@RequestBody PeliculaEntity pelicula) {
      
        return peliculaService.postPelicula(pelicula);
    }
    
    @PutMapping("updatePelicula/{id}")
    public ResponseEntity<?> modificarPelicula(@PathVariable int id, @RequestBody PeliculaEntity pelicula) {
        return peliculaService.modificarPelicula(id , pelicula);
    }
    

    @DeleteMapping("deletePelicula/{id}")
    public ResponseEntity<String> eliminarPelicula(@PathVariable int id){
        return peliculaService.eliminarPelicula(id);
    }
    
}
