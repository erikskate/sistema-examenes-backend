package com.sistema.examenes.service.Impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.examenes.entity.Usuario;
import com.sistema.examenes.entity.UsuarioRol;
import com.sistema.examenes.repository.RolReposiroty;
import com.sistema.examenes.repository.UsuarioRepository;
import com.sistema.examenes.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository; 
	
	@Autowired
	private RolReposiroty rolReposiroty;

	@Override
	public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
		Usuario usuariolocal = usuarioRepository.findByUserName(usuario.getUsername());
		
		if(usuariolocal != null) {
			System.out.println("El usuario ya existe");
			throw new Exception("El usuario ya esta presente");
		}else {
			for(UsuarioRol usuarioRol: usuarioRoles) {
				rolReposiroty.save(usuarioRol.getRol());
			}
			
			usuario.getUsuarioRoles().addAll(usuarioRoles);
			usuariolocal = usuarioRepository.save(usuario);
		}
		
		return usuariolocal;
	}

	@Override
	public Usuario obtenerUsuario(String userName) {
		return usuarioRepository.findByUserName(userName);
	}

	@Override
	public void eliminarUsuario(Long usuarioId) {
		usuarioRepository.deleteById(usuarioId);
	}
	
	
}
