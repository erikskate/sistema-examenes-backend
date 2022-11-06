package com.sistema.examenes.service;

import java.util.Set;

import com.sistema.examenes.entity.Usuario;
import com.sistema.examenes.entity.UsuarioRol;

public interface UsuarioService {
	
	public Usuario guardarUsuario(Usuario usurio, Set<UsuarioRol> usuarioRoles) throws Exception;
	
	public Usuario obtenerUsuario(String userName);
	
	public void eliminarUsuario(Long usuarioId);
	
}
