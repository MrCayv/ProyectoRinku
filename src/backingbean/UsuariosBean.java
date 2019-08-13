package backingbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDAO;
import model.Usuario;

@ManagedBean(name = "usuariosBean")
@RequestScoped
public class UsuariosBean implements Serializable {
	private String usuario;
	private String password;
	private String nombre;
	private List<Usuario> usuarios;
	
	public UsuariosBean() {
		this.usuario = "";
		this.password = "";
		this.nombre = "";
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public UsuariosBean(String usuario, String password, String nombre) {
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public String guardar(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.guardar(usuario);
		return "/pages/catalogo/usuarios.jsp";
	}

	public List<Usuario> getUsuarios() {
		//UsuarioDAO usuarioDAO = new UsuarioDAO();
		//usuarios = usuarioDAO.obtenerUsuarios();
	
		
		 List<Usuario> listaUsuarios = new ArrayList<>(); 
		 Usuario c1 = new Usuario();
		 c1.setId(1); 
		 c1.setNombre("Cesar"); 
		 c1.setUsuario("cesar");
		 c1.setPassword("1234");
		 listaUsuarios.add(c1);
		 
		 Usuario c2 = new Usuario();
		 c2.setId(2); 
		 c2.setNombre("Cesar"); 
		 c2.setUsuario("cesar");
		 c2.setPassword("1234");
		 listaUsuarios.add(c2);
		 
		 return listaUsuarios;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
