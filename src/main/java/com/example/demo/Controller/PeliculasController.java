package com.example.demo.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.PeliculaEntity;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
    

}
