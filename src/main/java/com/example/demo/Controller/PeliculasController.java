package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PeliculasController {
    
    static ArrayList<String> peliculas = new ArrayList<String>();

    @GetMapping()
    public String getMethodName() {
        return "Api Funcional";
    }
    


}
