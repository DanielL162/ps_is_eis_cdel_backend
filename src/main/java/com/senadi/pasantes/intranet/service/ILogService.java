package com.senadi.pasantes.intranet.service;

import com.senadi.pasantes.intranet.repository.modelo.Log;

public interface ILogService {
	
	public Log buscar (Integer id);
	public void borrar(Integer id);
	public void actualizar(Log log);
	public void guardar(Log log);

}
