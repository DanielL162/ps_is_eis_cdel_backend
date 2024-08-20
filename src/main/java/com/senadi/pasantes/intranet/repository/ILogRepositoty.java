package com.senadi.pasantes.intranet.repository;

import com.senadi.pasantes.intranet.repository.modelo.Log;

public interface ILogRepositoty {
	
	public Log buscar (Integer id);
	public void eliminar(Integer id);
	public void actualizar(Log log);
	public void insertar(Log log);

}
