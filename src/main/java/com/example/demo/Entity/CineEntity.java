package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class CineEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @ManyToMany
    @JoinTable(name = "cine_pelicula",
    joinColumns = @JoinColumn( name = "Cine_id" ), 
    inverseJoinColumns = @JoinColumn(name = "Pelicula_id")
    )
    private List<PeliculaEntity> listaPeliculas = new ArrayList<>();





    

    @Override
    public String toString() {
        return "CineEntity [id=" + id + ", nombre=" + nombre + ", listaPeliculas=" + listaPeliculas + "]";
    }

    public CineEntity() {
    }

    public CineEntity(int id, String nombre, ArrayList<PeliculaEntity> listaPeliculas) {
        this.id = id;
        this.nombre = nombre;
        this.listaPeliculas = listaPeliculas;
    }

    public CineEntity(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
