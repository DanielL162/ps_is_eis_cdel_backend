package com.senadi.pasantes.intranet.repository;

import org.springframework.stereotype.Repository;

import com.senadi.pasantes.intranet.repository.modelo.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UsuarioRepositoryImpl implements IUsuarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Usuario usuario) {
		this.entityManager.persist(usuario);
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		return this.entityManager.find(Usuario.class, id);
	}

	@Override
	public void actualizar(Usuario usuario) {
		this.entityManager.merge(usuario);

	}

	@Override
	public void eliminar(Integer id) {
		Usuario usuario = this.buscarPorId(id);
		this.entityManager.remove(usuario);
	}

}
