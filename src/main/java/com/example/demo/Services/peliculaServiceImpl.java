package com.example.demo.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.PeliculaEntity;
import com.example.demo.Repository.peliculaRepository;

@Service
public class peliculaServiceImpl implements peliculaService {
    

    @Autowired
    private peliculaRepository repo; 

    static ArrayList<PeliculaEntity> listaPeliculas = new ArrayList<>();


    @Override
    public ResponseEntity<ArrayList<PeliculaEntity>> getAll() {
       return ResponseEntity.ok().body(repo.findAll()); 
    }


    @Override
    public ResponseEntity<?> postPelicula(PeliculaEntity pelicula) {
        return new ResponseEntity<>(repo.save(pelicula) , HttpStatus.valueOf(201));
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



    @Override
    public ResponseEntity<?> modificarPelicula(int id, PeliculaEntity pelicula) {
        boolean modifico = false;
        for(PeliculaEntity peliculaEntity : listaPeliculas){
            if(peliculaEntity.getId() == id){
                peliculaEntity.setNombre(pelicula.getNombre());
                modifico = true;
                break;
            }
        }
        if(modifico){
            return new ResponseEntity<>("Modfiicado con exito" , HttpStatus.valueOf(200));
        }else{
            return new ResponseEntity<>("Pelicula no encontrada" , HttpStatus.valueOf(404));
        }
    }



    @Override
    public ResponseEntity<String> eliminarPelicula(int id) {
       boolean eliminado = false;

       for(PeliculaEntity peliculaEntity : listaPeliculas){
        if(peliculaEntity.getId() == id){
            listaPeliculas.remove(peliculaEntity);
            eliminado = true;
            break;
        }
       }

       if(eliminado){
        return new ResponseEntity<>("Eliminado con exito" , HttpStatus.ACCEPTED);
       }else{
        return new ResponseEntity<>("No encontrado" , HttpStatus.NOT_FOUND);
       }
    }

    

}
