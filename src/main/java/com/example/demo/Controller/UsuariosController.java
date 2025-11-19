package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@CrossOrigin(origins = "http://localhost:3000" )
@RequestMapping("Usuarios")
public class UsuariosController {
    
    @GetMapping()
    public String TestUsuario() {
        return "Api Funcional";
    }
    
    
}
