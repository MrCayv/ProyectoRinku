package model;

import java.sql.Timestamp;

public class Trabajador {
	private int id;
	private String nombre;
	private int rol;
	private int tipo;
	private int usu_creador;
	private Timestamp creado;
	private int usu_modificador;
	private Timestamp modificado;
	private int status;
	
	public Trabajador() {}
	
	public Trabajador(String nombre, int rol, int tipo, int usu_creador, int usu_modificador, int status) {
		super();
		this.nombre = nombre;
		this.rol = rol;
		this.tipo = tipo;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
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
