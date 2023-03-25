package com.egg.biblioteca.services;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.repositorio.RepoAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutorServicio {
    @Autowired
    RepoAutor autorRepositorio;

    @Transactional
    public void crearAutor(String nombre){
        Autor autor = new Autor();
        autor.setNombre(nombre);


        autorRepositorio.save(autor);
    }

    public List<Autor> listarAutores(){
        List<Autor> autores = new ArrayList<Autor>();
        autores= autorRepositorio.findAll();
        return autores;
    }
    public void modificarAutor(String nombre, String id){
        Optional<Autor> respuestaAutor= autorRepositorio.findById(id);
        if(respuestaAutor.isPresent()) {
            Autor autor= respuestaAutor.get();
            autor.setNombre(nombre);
            autorRepositorio.save(autor);
        }
    }
}
