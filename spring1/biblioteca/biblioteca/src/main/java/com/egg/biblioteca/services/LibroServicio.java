package com.egg.biblioteca.services;


import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.excepciones.MiExcepcion;
import com.egg.biblioteca.repositorio.RepoAutor;
import com.egg.biblioteca.repositorio.RepoEditorial;
import com.egg.biblioteca.repositorio.RepoLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//lleva la logica de la manipulacion de la enntidad libro
@Service
public class LibroServicio {

    @Autowired // esta variable sera inicializada por el servidor de aplicaciones
    private RepoLibro libroRepositorio;

    @Autowired
    private RepoAutor autorRepositorio;

    @Autowired
    private RepoEditorial editorialRepositorio;
    @Transactional // se hace commit o rollback
    public void crearLibro(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiExcepcion {

        validar(isbn,titulo,ejemplares,idAutor,idEditorial);

        Autor autor= autorRepositorio.findById(idAutor).get();
        Libro libro = new Libro();
        Editorial editorial=editorialRepositorio.findById(idEditorial).get();

        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setAlta(new Date());
        libro.setAutor(autor);

        libroRepositorio.save(libro);
    }
    public List<Libro> listarLibros(){ // esto es una busqueda, no hace falta que sea transaccion
        List<Libro> libros = new ArrayList<Libro>();
        libros= libroRepositorio.findAll();
        return libros;
    }


    public void modificarLibro(Long isbn, String titulo, String idAutor, String idEditorial, Integer ejemplares) throws MiExcepcion{
        validar(isbn,titulo,ejemplares,idAutor,idEditorial);
        
        Optional<Libro> respuesta= libroRepositorio.findById(isbn);
        Optional<Autor> respuestaAutor= autorRepositorio.findById(idAutor);
        Optional<Editorial> respuestaEditorial= editorialRepositorio.findById(idEditorial);
        Autor autor= new Autor() ;
        Editorial editorial= new Editorial();
        if(respuestaAutor.isPresent()){
            autor=respuestaAutor.get();
        }
        if(respuestaEditorial.isPresent()){
            editorial=respuestaEditorial.get();
        }
        if(respuesta.isPresent()){
            Libro libro = respuesta.get();
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setEjemplares(ejemplares);

            libroRepositorio.save(libro);
        }

    }

    private  void validar(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiExcepcion {

            if (isbn == null) throw new MiExcepcion("el isb no puede ser nulo");
            if (titulo.isEmpty()) throw new MiExcepcion("el titulo no puede ser nulo o vacio ");
            if (ejemplares == null) throw new MiExcepcion("los ejemplares no pueden ser nulos");
            if (idAutor == null) throw new MiExcepcion("el idAutor no puede ser nulo");
            if (idEditorial == null) throw new MiExcepcion("el idEditorial no puede ser nulo");
    }
}
