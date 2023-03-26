package com.egg.biblioteca.repositorio;

import com.egg.biblioteca.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEditorial extends JpaRepository<Editorial,String> {

}
