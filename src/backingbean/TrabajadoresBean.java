package backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Trabajador;

@ManagedBean
@RequestScoped
public class TrabajadoresBean {
	private String nombre;
	private int rol;
	private int tipo;
	private List<Trabajador> trabajadores;
	
	public TrabajadoresBean() {
		this.nombre = "";
		this.rol = 0;
		this.tipo = 0;
		this.trabajadores = new ArrayList<Trabajador>();
	}
	
	public TrabajadoresBean(String nombre, int rol, int tipo) {
		this.nombre = nombre;
		this.rol = rol;
		this.tipo = tipo;
		this.trabajadores = new ArrayList<Trabajador>();
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
	
	public String guardar() {
		return "";
	}

	public List<Trabajador> getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(List<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}
	
}
