package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import controller.JPAUtil;
import model.Usuario;

public class UsuarioDAO {	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	
	
	public void guardar(Usuario usuario) {
		entity.getTransaction().begin();
		entity.persist(usuario);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	public void editar(Usuario usuario) {
		entity.getTransaction().begin();
		entity.merge(usuario);
		entity.getTransaction().commit();
		/// JPAUtil.shutdown();
	}
	
	public Usuario buscar(Long id) {
		Usuario u = new Usuario();
		u = entity.find(Usuario.class, id);
		// JPAUtil.shutdown();
		return u;
	}
	
	public void eliminar(Long id) {
		Usuario u = new Usuario();
		u = entity.find(Usuario.class, id);
		entity.getTransaction().begin();
		entity.remove(u);
		entity.getTransaction().commit();
	}
	
	public List<Usuario> obtenerUsuarios() {
		List<Usuario> listaClientes = new ArrayList<>();
		Query q = entity.createQuery("SELECT * FROM usuarios WHERE status = 1");
		listaClientes = q.getResultList();
		return listaClientes;
	}
}