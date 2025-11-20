package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Optional;

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
        
        Optional<PeliculaEntity> peliculaRetorno = repo.findById(id);

        if(peliculaRetorno.isPresent()){
           return new ResponseEntity<>(peliculaRetorno.get() , HttpStatus.valueOf(200));
        }else{
            return new ResponseEntity<>(null , HttpStatus.valueOf(404));
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
