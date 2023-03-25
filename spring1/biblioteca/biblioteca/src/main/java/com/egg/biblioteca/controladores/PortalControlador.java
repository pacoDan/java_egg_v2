package com.egg.biblioteca.controladores;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/") // esta clase se activa cuando aparece primero una barra /
public class PortalControlador {

    @GetMapping("/")
    public String index(){
        return "index.html";
    }


}
