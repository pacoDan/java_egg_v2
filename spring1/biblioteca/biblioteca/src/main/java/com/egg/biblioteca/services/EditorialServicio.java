package com.egg.biblioteca.services;


import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.repositorio.RepoEditorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EditorialServicio {
    @Autowired
    RepoEditorial editorialRepositorio;
    @Transactional
    public void crearEditorial(String nombre){
        Editorial editorial= new Editorial();
        editorial.setNombre(nombre);
        editorialRepositorio.save(editorial);
    }

    public List<Editorial> listarEditoriales(){
        List<Editorial> editoriales= new ArrayList<Editorial>();
        editoriales=editorialRepositorio.findAll();
        return editoriales;
    }


    public void modificarEditorial(String id, String nombre){
        Optional<Editorial> respuestaEditorial= editorialRepositorio.findById(id);
        if(respuestaEditorial.isPresent()){
            Editorial editorial= respuestaEditorial.get();
            editorial.setNombre(nombre);
            editorialRepositorio.save(editorial);
        }

    }
}
