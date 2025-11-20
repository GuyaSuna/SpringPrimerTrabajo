package com.example.demo.Entity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class PeliculaEntity {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name = "Titulo" , nullable = false , length = 100)
private String nombre;


@ManyToOne
@JoinColumn(name = "autor_id")
private AutorEntity autor;

@OneToOne(mappedBy = "peliculaEntity")
private Elenco elenco;

@ManyToMany(mappedBy = "listaPeliculas")
private List<CineEntity> listaCine = new ArrayList<>();








public PeliculaEntity(){};


public PeliculaEntity(int id, String nombre, AutorEntity autor, Elenco elenco, List<CineEntity> listaCine) {
    this.id = id;
    this.nombre = nombre;
    this.autor = autor;
    this.elenco = elenco;
    this.listaCine = listaCine;
}

public AutorEntity getAutor() {
    return autor;
}

public void setAutor(AutorEntity autor) {
    this.autor = autor;
}

public Elenco getElenco() {
    return elenco;
}

public void setElenco(Elenco elenco) {
    this.elenco = elenco;
}

public List<CineEntity> getListaCine() {
    return listaCine;
}

public void setListaCine(List<CineEntity> listaCine) {
    this.listaCine = listaCine;
}

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

}
