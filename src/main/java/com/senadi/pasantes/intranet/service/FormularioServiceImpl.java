package com.senadi.pasantes.intranet.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senadi.pasantes.intranet.repository.IFormularioRepository;
import com.senadi.pasantes.intranet.repository.modelo.Formulario;
import com.senadi.pasantes.intranet.service.to.FormularioTO;

@Service
public class FormularioServiceImpl implements IFormularioService {

	private final ModelMapper modelMapper = new ModelMapper();

	private FormularioTO convertirATO(Formulario formulario) {
		return modelMapper.map(formulario, FormularioTO.class);
	}

	private Formulario convertirAFormulario(FormularioTO formularioTO) {
		return modelMapper.map(formularioTO, Formulario.class);
	}

	@Autowired
	private IFormularioRepository iFormularioRepo;

	@Override
	public void insertar(FormularioTO formularioTO) {
		this.iFormularioRepo.insertar(this.convertirAFormulario(formularioTO));
	}

	@Override
	public FormularioTO buscarPorId(Integer id) {
		return this.convertirATO(this.iFormularioRepo.buscarPorId(id));
	}

	@Override
	public void actualizar(FormularioTO formularioTO) {
		this.iFormularioRepo.actualizar(this.convertirAFormulario(formularioTO));
	}

	@Override
	public void eliminar(Integer id) {
		this.iFormularioRepo.eliminar(id);
	}

}