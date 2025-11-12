package com.example.demo.Services;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;

import com.example.demo.Entity.PeliculaEntity;


public interface peliculaService {
    
    public ResponseEntity<ArrayList<PeliculaEntity>> getAll();

    public ResponseEntity<?> postPelicula(PeliculaEntity pelicula);

    public ResponseEntity<PeliculaEntity> getPelicula(int id);

    public ResponseEntity<?> modificarPelicula(int id, PeliculaEntity pelicula);

    public ResponseEntity<String> eliminarPelicula(int id);
}
