package com.senadi.pasantes.intranet.repository;

import org.springframework.stereotype.Repository;

import com.senadi.pasantes.intranet.repository.modelo.Documento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DocumentoRepositoryImpl implements IDocumentoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Documento documento) {
		this.entityManager.merge(documento);
	}

	@Override
	public Documento buscarPorId(Integer id) {
		return this.entityManager.find(Documento.class, id);
	}

	@Override
	public void actualizar(Documento documento) {
		this.entityManager.merge(documento);
	}

	@Override
	public void eliminar(Integer id) {
		Documento doc = this.buscarPorId(id);
		this.entityManager.remove(doc);
	}

}
