package com.senac.diogo.receptor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.diogo.receptor.dtos.UsuarioDTO;

public interface UsuarioRepository extends JpaRepository<UsuarioDTO, Integer> {
}
