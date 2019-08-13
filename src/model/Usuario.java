package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String usuario;
	@Column
	private String password;
	@Column
	private String nombre;
	@Column
	private int usu_creador;
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp creado;
	@Column
	private int usu_modificador;
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp modificado;
	@Column
	private int status;
	
	public Usuario() {}
	
	public Usuario(String usuario, String password, String nombre, int usu_creador, int usu_modificador, int status) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.usu_creador = usu_creador;
		this.usu_modificador = usu_modificador;
		this.status = status;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getUsu_creador() {
		return usu_creador;
	}

	public void setUsu_creador(int usu_creador) {
		this.usu_creador = usu_creador;
	}

	public Timestamp getCreado() {
		return creado;
	}

	public void setCreado(Timestamp creado) {
		this.creado = creado;
	}

	public int getUsu_modificador() {
		return usu_modificador;
	}

	public void setUsu_modificador(int usu_modificador) {
		this.usu_modificador = usu_modificador;
	}

	public Timestamp getModificado() {
		return modificado;
	}

	public void setModificado(Timestamp modificado) {
		this.modificado = modificado;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
