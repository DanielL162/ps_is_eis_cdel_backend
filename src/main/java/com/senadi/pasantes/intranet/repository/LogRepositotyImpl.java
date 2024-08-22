package com.senadi.pasantes.intranet.repository;

import org.springframework.stereotype.Repository;

import com.senadi.pasantes.intranet.repository.modelo.Log;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LogRepositotyImpl implements ILogRepositoty {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Log buscar(Integer id) {
		return entityManager.find(Log.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		entityManager.remove(this.buscar(id));
	}

	@Override
	public void actualizar(Log log) {
		entityManager.merge(log);
	}

	@Override
	public void insertar(Log log) {
		entityManager.persist(log);
	}

}
