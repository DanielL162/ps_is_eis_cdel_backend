package com.senadi.pasantes.intranet.repository;

import org.springframework.stereotype.Repository;

import com.senadi.pasantes.intranet.repository.modelo.Notificacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class NotificacionRepositoryImpl implements INotificacionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Notificacion notificacion) {
		this.entityManager.merge(notificacion);
	}

	@Override
	public Notificacion buscarPorId(Integer id) {
		return this.entityManager.find(Notificacion.class, id);
	}

	@Override
	public void actualizar(Notificacion notificacion) {
		this.entityManager.merge(notificacion);
	}

	@Override
	public void eliminar(Integer id) {
		Notificacion notificacion = this.buscarPorId(id);
		this.entityManager.remove(notificacion);
	}

}
