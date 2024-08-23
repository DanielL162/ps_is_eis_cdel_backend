package com.senadi.pasantes.intranet.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senadi.pasantes.intranet.repository.IUsuarioRepository;
import com.senadi.pasantes.intranet.repository.modelo.Usuario;
import com.senadi.pasantes.intranet.service.to.UsuarioTO;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	private final ModelMapper modelMapper = new ModelMapper();

	private UsuarioTO convertirATO(Usuario usuario) {
		return modelMapper.map(usuario, UsuarioTO.class);
	}

	private Usuario convertirAUsuario(UsuarioTO usuarioTO) {
		return modelMapper.map(usuarioTO, Usuario.class);
	}

	@Autowired
	private IUsuarioRepository iUsuarioRepo;

	@Override
	public void insertar(UsuarioTO usuarioTO) {
		this.iUsuarioRepo.insertar(this.convertirAUsuario(usuarioTO));
	}

	@Override
	public UsuarioTO buscarPorId(Integer id) {
		return this.convertirATO(this.iUsuarioRepo.buscarPorId(id));
	}

	@Override
	public void actualizar(UsuarioTO usuarioTO) {
		this.iUsuarioRepo.actualizar(this.convertirAUsuario(usuarioTO));
	}

	@Override
	public void eliminar(Integer id) {
		this.iUsuarioRepo.eliminar(id);
	}

}