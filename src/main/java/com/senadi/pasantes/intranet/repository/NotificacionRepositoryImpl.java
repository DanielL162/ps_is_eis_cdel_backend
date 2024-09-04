package com.senadi.pasantes.intranet.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.senadi.pasantes.intranet.repository.modelo.Notificacion;
import com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoListaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class NotificacionRepositoryImpl implements INotificacionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Notificacion notificacion) {
		this.entityManager.persist(notificacion);
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

	@Override
	public List<Notificacion> buscarTodos() {
		TypedQuery<Notificacion> myQuery=this.entityManager.createQuery(""
				+ "select d from Notificacion d", Notificacion.class);
	
		return myQuery.getResultList();
	}


	
	

}
