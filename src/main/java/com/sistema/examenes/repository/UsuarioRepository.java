package com.sistema.examenes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenes.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Usuario findByUsername(String username);
}
