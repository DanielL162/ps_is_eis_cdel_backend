package com.senadi.pasantes.intranet.repository;

import org.springframework.stereotype.Repository;

import com.senadi.pasantes.intranet.repository.modelo.Log;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LogRepositotyImpl implements ILogRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Log log) {
		this.entityManager.merge(log);
	}

	@Override
	public Log buscarPorId(Integer id) {
		return this.entityManager.find(Log.class, id);
	}

	@Override
	public void actualizar(Log log) {
		this.entityManager.merge(log);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscarPorId(id));
	}

}
