package com.senadi.pasantes.intranet.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.senadi.pasantes.intranet.repository.modelo.Notificacion;
import com.senadi.pasantes.intranet.repository.modelo.dto.NotificacionDTO;
import com.senadi.pasantes.intranet.repository.modelo.dto.NotificacionImagenDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
	public List<NotificacionDTO> consultarTodoDTO() {
		Query q = this.entityManager.createQuery(
				"SELECT NEW com.senadi.pasantes.intranet.repository.modelo.dto.NotificacionDTO(n.id, n.fechaInicio, n.fechaFin, n.importancia, n.estado) FROM Notificacion n");
		return q.getResultList();
	}

	@Override
	public NotificacionImagenDTO buscarPorIdSoloImagen(Integer id) {
		Query q = this.entityManager.createQuery(
				"SELECT NEW com.senadi.pasantes.intranet.repository.modelo.dto.NotificacionImagenDTO(n.id, n.urlImagen) FROM Notificacion n WHERE n.id =: id");
		q.setParameter("id", id);
		return (NotificacionImagenDTO) q.getSingleResult();
	}

	@Override
	public Integer actualizar(Notificacion notificacion) {
		try {
			this.entityManager.merge(notificacion);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public void eliminar(Integer id) {
		Notificacion notificacion = this.buscarPorId(id);
		this.entityManager.remove(notificacion);
	}

	@Override
	public List<Notificacion> buscarTodos() {
		TypedQuery<Notificacion> myQuery = this.entityManager.createQuery("" + "select d from Notificacion d",
				Notificacion.class);

		return myQuery.getResultList();
	}

	public List<Notificacion> buscarPorfecha(LocalDateTime fechaActual) {
		String jpql = "SELECT d FROM Notificacion d " + "WHERE :fechaActual BETWEEN d.fechaInicio AND d.fechaFin "
				+ "AND d.estado = 'A' " + "ORDER BY CASE " + "    WHEN d.importancia = 'alta' THEN 1 "
				+ "    WHEN d.importancia = 'media' THEN 2 " + "    WHEN d.importancia = 'baja' THEN 3 " + "    ELSE 4 "
				+ "END";

		TypedQuery<Notificacion> myQuery = this.entityManager.createQuery(jpql, Notificacion.class);
		myQuery.setParameter("fechaActual", fechaActual);

		return myQuery.getResultList();
	}

}
