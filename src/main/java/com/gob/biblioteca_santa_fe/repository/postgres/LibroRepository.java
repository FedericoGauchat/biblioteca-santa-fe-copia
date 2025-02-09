package com.gob.biblioteca_santa_fe.repository.postgres;

import com.gob.biblioteca_santa_fe.model.Libro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface LibroRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> findByNombre(String nombre);

    List<Libro> findByAutor(String autor);

    Optional<Libro> findByIsbn(String isbn);

    //List<Libro> findByParameters();

    @Procedure(name = "listarLibros")
    List<Libro> listarLibros();
}
