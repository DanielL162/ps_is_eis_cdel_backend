package com.senadi.pasantes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senadi.pasantes.intranet.repository.ILogRepositoty;
import com.senadi.pasantes.intranet.repository.modelo.Log;

@Service
public class LogServiceImpl implements ILogService{

	@Autowired
	private ILogRepositoty iLogRepositoty;
	
	@Override
	public Log buscar(Integer id) {
		// TODO Auto-generated method stub
		return iLogRepositoty.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		iLogRepositoty.eliminar(id);
	}

	@Override
	public void actualizar(Log log) {
		// TODO Auto-generated method stub
		iLogRepositoty.actualizar(log);
	}

	@Override
	public void guardar(Log log) {
		// TODO Auto-generated method stub
		iLogRepositoty.insertar(log);
	}

}
