package com.egg.biblioteca.services;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.excepciones.MiExcepcion;
import com.egg.biblioteca.repositorio.RepoAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutorServicio {
    @Autowired
    RepoAutor autorRepositorio;

    @Transactional
    public void crearAutor(String nombre) throws MiExcepcion {
        validar(nombre);
        Autor autor = new Autor();
        autor.setNombre(nombre);


        autorRepositorio.save(autor);
    }

    public List<Autor> listarAutores(){
        List<Autor> autores = new ArrayList<Autor>();
        autores= autorRepositorio.findAll();
        return autores;
    }
    public void modificarAutor(String nombre, String id) throws MiExcepcion {
        validar(nombre);
        Optional<Autor> respuestaAutor= autorRepositorio.findById(id);
        if(respuestaAutor.isPresent()) {
            Autor autor= respuestaAutor.get();
            autor.setNombre(nombre);
            autorRepositorio.save(autor);
        }
    }

    @Transactional(readOnly = true)
    public Autor getOne(String id){
        return autorRepositorio.getOne(id);
    }

    @Transactional
    public void eliminar(String id){

        Autor autor = autorRepositorio.getById(id);

        autorRepositorio.delete(autor);

    }

    private void validar(String nombre) throws MiExcepcion{
        if(nombre.isEmpty()){
            throw  new MiExcepcion("no se permite nombre de autor vacio");
        }
    }
}
