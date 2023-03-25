package com.egg.biblioteca.repositorio;

import com.egg.biblioteca.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoAutor  extends JpaRepository<Autor,String> {

}
