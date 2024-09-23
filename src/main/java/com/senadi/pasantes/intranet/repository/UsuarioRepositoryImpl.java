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
		try {
			return this.entityManager.find(Usuario.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
		System.out.println("REPO USUARIO");
		TypedQuery<UsuarioLoginDTO> myQuery=this.entityManager.createQuery(""
				+ "select new com.senadi.pasantes.intranet.repository.modelo.dto.UsuarioLoginDTO(u.id, u.cedula, u.password, u.rol) "
				+ "from Usuario u where u.cedula=:datoCedula", UsuarioLoginDTO.class);
		myQuery.setParameter("datoCedula", cedula);
		
		UsuarioLoginDTO dto=null;
		
		try {
			dto=myQuery.getSingleResult();

			return dto;
		} catch (Exception e) {
			
			//e.printStackTrace();
		}
		return dto;
		
	}

	@Override
	public UsuarioLoginDTO seleccionarPorCorreoUsuarioLoginDTO(String email) {
		TypedQuery<UsuarioLoginDTO> myQuery=this.entityManager.createQuery(""
				+ "select new com.senadi.pasantes.intranet.repository.modelo.dto.UsuarioLoginDTO(u.id, u.cedula, u.password, u.rol) "
				+ "from Usuario u where u.email=:datoEmail", UsuarioLoginDTO.class);
		myQuery.setParameter("datoEmail", email);
		
		
		UsuarioLoginDTO dto=null;
		
		try {
			dto=myQuery.getSingleResult();

			return dto;
		} catch (Exception e) {
			
			//e.printStackTrace();
		}
		return dto;
	}
	
	
	
	

}
