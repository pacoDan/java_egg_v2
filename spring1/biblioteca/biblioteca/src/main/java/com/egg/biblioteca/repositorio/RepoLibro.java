package com.egg.biblioteca.repositorio;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // el Long del extend es por que la llave proimaria es del tipo long
public interface RepoLibro  extends JpaRepository<Libro,Long> {
    @Query("select l from Libro l where l.titulo=:titulo")
    public Libro buscarPorTitulo(@Param("titulo") String titulo);

    @Query("select l from Libro l where l.autor.nombre=:nombre")
    public List<Autor> buscarPorAutor(@Param("nombre") String nomnbre);
}
