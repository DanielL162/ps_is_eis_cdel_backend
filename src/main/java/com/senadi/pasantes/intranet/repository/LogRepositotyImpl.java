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
		// TODO Auto-generated method stub
		return entityManager.find(Log.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
	entityManager.remove(this.buscar(id));
	}

	@Override
	public void actualizar(Log log) {
		// TODO Auto-generated method stub
		entityManager.merge(log);
	}

	@Override
	public void insertar(Log log) {
		// TODO Auto-generated method stub
		entityManager.persist(log);
	}
	
	
	

}
