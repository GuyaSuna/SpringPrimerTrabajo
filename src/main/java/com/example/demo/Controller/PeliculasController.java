package com.example.demo.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.PeliculaEntity;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("Pelicula")
public class PeliculasController {
    

    static ArrayList<PeliculaEntity> listaPeliculas = new ArrayList<>();


    @GetMapping("getPelicula/{id}")
    public PeliculaEntity getPelicula(@PathVariable int id) {

        PeliculaEntity peliculaResp = null;

        for(PeliculaEntity pelicula : listaPeliculas){
            if(pelicula.getId() == id){
                peliculaResp = pelicula;
            }
        }
        return  peliculaResp;
    }
    
    @GetMapping()
    public String getMethodName() {
        return "Api Funcional";
    }

    @GetMapping("altaPelicula/{id}/{nombre}")
    public ArrayList<PeliculaEntity> altaPelicula(@PathVariable int id , @PathVariable String nombre) {
        PeliculaEntity pelicula = new PeliculaEntity(id, nombre);
        listaPeliculas.add(pelicula);
        return listaPeliculas;
    }
    
    @GetMapping("getUsuario/{id}")
    public String getMethodName(@RequestParam String param , @PathVariable int id) {
        return "Si funciona: " + param + " " + id;
    }
    

    @PostMapping("updatePelicula/{id}")
    public ResponseEntity<?> postPelicula(@RequestBody PeliculaEntity pelicula, @PathVariable int id) {
        if(pelicula.getId() == 2){
           return new ResponseEntity<>("El id es 2",HttpStatus.valueOf(400)); 
        }else{
            return ResponseEntity.ok().body(pelicula);
        }
    }


    @PutMapping("updatePelicula/{id}")
    public ResponseEntity<?> updatePelicula(@PathVariable int id, @RequestBody PeliculaEntity pelicula) {
        
        return new ResponseEntity<>(pelicula,HttpStatus.valueOf(200));

    }




    
}
