package com.example.demo.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PeliculaEntity {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name = "Titulo" , nullable = false , length = 100)
private String nombre;


public int getId(){
    return this.id;
}

public String getNombre(){
    return this.nombre;
}

public void setId(int id){
    this.id = id;
} 

public void setNombre(String nombre){
    this.nombre = nombre;
}


@Override
public String toString(){
    return "Pelicula: "+ this.id  + " " + this.nombre;
}

public PeliculaEntity(int id , String nombre){
    this.id = id;
    this.nombre = nombre;
}

public PeliculaEntity(){};

    
}
