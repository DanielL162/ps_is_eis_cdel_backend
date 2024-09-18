package com.senadi.pasantes.intranet.repository;

import org.springframework.stereotype.Repository;

import com.senadi.pasantes.intranet.repository.modelo.Usuario;
import com.senadi.pasantes.intranet.repository.modelo.dto.UsuarioLoginDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UsuarioRepositoryImpl implements IUsuarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Usuario usuario) {
		this.entityManager.persist(usuario);
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		return this.entityManager.find(Usuario.class, id);
	}

	@Override
	public void actualizar(Usuario usuario) {
		this.entityManager.merge(usuario);

	}

	@Override
	public void eliminar(Integer id) {
		Usuario usuario = this.buscarPorId(id);
		this.entityManager.remove(usuario);
	}

	@Override
	public UsuarioLoginDTO seleccionarPorCedulaUsuarioLoginDTO(String cedula) {
		TypedQuery<UsuarioLoginDTO> myQuery=this.entityManager.createQuery(""
				+ "select new com.senadi.pasantes.intranet.repository.modelo.dto.UsuarioLoginDTO(u.id, u.cedula, u.password, u.rol) "
				+ "from Usuario u where u.cedula=:datoCedula", UsuarioLoginDTO.class);
		myQuery.setParameter("datoCedula", cedula);
		
		UsuarioLoginDTO ulDTO=null;
		try {
			ulDTO=myQuery.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return ulDTO;
	}

	@Override
	public UsuarioLoginDTO seleccionarPorCorreoUsuarioLoginDTO(String email) {
		TypedQuery<UsuarioLoginDTO> myQuery=this.entityManager.createQuery(""
				+ "select new com.senadi.pasantes.intranet.repository.modelo.dto.UsuarioLoginDTO(u.id, u.cedula, u.password, u.rol) "
				+ "from Usuario u where u.email=:datoEmail", UsuarioLoginDTO.class);
		myQuery.setParameter("datoEmail", email);
		
		
		return myQuery.getSingleResult();
	}
	
	
	
	

}
