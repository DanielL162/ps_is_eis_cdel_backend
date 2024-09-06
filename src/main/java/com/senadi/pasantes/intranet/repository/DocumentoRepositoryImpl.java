package com.senadi.pasantes.intranet.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.senadi.pasantes.intranet.repository.modelo.Documento;
import com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoListaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DocumentoRepositoryImpl implements IDocumentoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Documento documento) {
		this.entityManager.persist(documento);
	}

	@Override
	public Documento buscarPorId(Integer id) {
		return this.entityManager.find(Documento.class, id);
	}

	@Override
	public Integer actualizar(Documento documento) {
		try {
			this.entityManager.merge(documento);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public void eliminar(Integer id) {
		Documento doc = this.buscarPorId(id);
		this.entityManager.remove(doc);
	}

	@Override
	public List<DocumentoListaDTO> consultarTodosDocumentoListaDTO() {
		TypedQuery<DocumentoListaDTO> myQuery = this.entityManager.createQuery(""
				+ "select new com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoListaDTO(d.id, d.nombre, d.categoria, d.documento, d.documentoURL, d.tipo, d.estado) "
				+ "from Documento d", DocumentoListaDTO.class);

		return myQuery.getResultList();
	}

}
