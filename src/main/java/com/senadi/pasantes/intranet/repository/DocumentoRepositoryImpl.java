package com.senadi.pasantes.intranet.repository;

import org.springframework.stereotype.Repository;

import com.senadi.pasantes.intranet.repository.modelo.Documento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class DocumentoRepositoryImpl implements IDocumentoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Documento documento) {
		// TODO Auto-generated method stub
		this.entityManager.persist(documento);
	}

	@Override
	public Documento buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Documento.class, id);
	}

	@Override
	public void actualizar(Documento documento) {
		// TODO Auto-generated method stub
		
		this.entityManager.merge(documento);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Documento doc = this.buscar(id);
		this.entityManager.remove(doc);
		
	}

}
