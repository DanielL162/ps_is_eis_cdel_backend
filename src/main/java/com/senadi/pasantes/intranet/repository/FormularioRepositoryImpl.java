package com.senadi.pasantes.intranet.repository;

import org.springframework.stereotype.Repository;

import com.senadi.pasantes.intranet.repository.modelo.Formulario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class FormularioRepositoryImpl implements IFormularioRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Formulario formulario) {
		this.entityManager.persist(formulario);

	}

	@Override
	public Formulario seleccionar(Integer id) {
		
		return this.entityManager.find(Formulario.class, id);
	}

	@Override
	public void actualizar(Formulario formulario) {
		this.entityManager.merge(formulario);

	}

	@Override
	public void eliminar(Integer id) {
		Formulario formulario=this.seleccionar(id);
		this.entityManager.remove(formulario);

	}

}
