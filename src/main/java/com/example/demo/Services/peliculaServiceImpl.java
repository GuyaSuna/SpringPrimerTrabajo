package com.example.demo.Services;

import java.util.ArrayList;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.http.HttpStatus;
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



    @Override
    public ResponseEntity<?> postPelicula(PeliculaEntity pelicula) {
        listaPeliculas.add(pelicula);
        return new ResponseEntity<>(pelicula , HttpStatus.valueOf(201));
    }



    @Override
    public ResponseEntity<PeliculaEntity> getPelicula(int id) {
        PeliculaEntity peliculaRetorno = null;

        for(PeliculaEntity pelicula : listaPeliculas){
            if(pelicula.getId() == id){
                peliculaRetorno = pelicula;
            }
        }

        if(peliculaRetorno == null){
            return new ResponseEntity<>(null, HttpStatus.valueOf(404));
        }else{
            return new ResponseEntity<>(peliculaRetorno, HttpStatus.valueOf(200));
        }
    }

    

}
