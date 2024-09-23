package com.senadi.pasantes.intranet.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.senadi.pasantes.intranet.repository.modelo.Documento;
import com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoDTO;
import com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoInstructivoDTO;
import com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoListaDTO;
import com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoNormativaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
	public List<DocumentoDTO> consultarTodoDTO() {
		Query q = this.entityManager.createQuery(
				"SELECT NEW com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoDTO(d.id, d.nombre, d.categoria, d.estado) FROM Documento d");
		return q.getResultList();
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
	public Integer eliminar(Integer id) {
		Documento doc = this.buscarPorId(id);
		System.out.println("dentro eliminar");
		try {
			this.entityManager.remove(doc);
			return 1;
		} catch (Exception e) {
			return 0;

		}
	}

	@Override
	public List<DocumentoListaDTO> consultarTodosDocumentoListaDTO() {
		TypedQuery<DocumentoListaDTO> myQuery = this.entityManager.createQuery(""
				+ "select new com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoListaDTO(d.id, d.nombre, d.categoria, d.documento, d.documentoURL, d.tipo, d.estado) "
				+ "from Documento d", DocumentoListaDTO.class);

		return myQuery.getResultList();
	}

	@Override
	public List<DocumentoNormativaDTO> consultarNormativasDTO() {
		TypedQuery<DocumentoNormativaDTO> myQuery = this.entityManager.createQuery(""
				+ "select new com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoNormativaDTO(d.id, d.nombre,d.fechaCreacion,d.fechaActualizacion, d.documento, d.tipo) "
				+ "from Documento d " + "where d.estado='A' and  d.categoria='normativa'", DocumentoNormativaDTO.class);

		return myQuery.getResultList();
	}

	@Override
	public List<DocumentoInstructivoDTO> consultarInstructivosDTO() {
		TypedQuery<DocumentoInstructivoDTO> myQuery = this.entityManager.createQuery(""
				+ "select new com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoInstructivoDTO(d.id, d.nombre,d.fechaCreacion,d.fechaActualizacion, d.documento, d.tipo) "
				+ "from Documento d " + "where d.estado='A' and d.categoria='instructivo'",
				DocumentoInstructivoDTO.class);

		return myQuery.getResultList();
	}

}
