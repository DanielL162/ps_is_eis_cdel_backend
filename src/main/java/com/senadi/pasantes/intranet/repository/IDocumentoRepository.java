package com.senadi.pasantes.intranet.repository;

import com.senadi.pasantes.intranet.repository.modelo.Documento;

public interface IDocumentoRepository {
	
	//CRUD
	
	void insertar(Documento documento);
	Documento buscar(Integer id);
	void actualizar(Documento documento);
	void eliminar(Integer id);
	

}
