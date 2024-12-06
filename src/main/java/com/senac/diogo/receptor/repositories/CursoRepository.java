package com.senac.diogo.receptor.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.diogo.receptor.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
	List<Curso> findByStatus(int status);

}