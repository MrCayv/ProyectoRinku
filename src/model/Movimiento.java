package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Movimiento {
	private int id;
	private int id_empleado;
	private Date fecha;
	private int cant_entregas;
	private int cubrio_turno;
	private int usu_creador;
	private Timestamp creado;
	private int usu_modificador;
	private Timestamp modificado;
	private int status;
	
	private String trabajador;
	
	public Movimiento() {}
	
	public Movimiento(int id_empleado, Date fecha, int cant_entregas, int cubrio_turno, int usu_creador, int usu_modificador, int status) {
		super();
		this.id_empleado = id_empleado;
		this.fecha = fecha;
		this.cant_entregas = cant_entregas;
		this.cubrio_turno = cubrio_turno;
		this.usu_creador = usu_creador;
		this.usu_modificador = usu_modificador;
		this.status = status;
		this.trabajador = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCant_entregas() {
		return cant_entregas;
	}

	public void setCant_entregas(int cant_entregas) {
		this.cant_entregas = cant_entregas;
	}

	public int getCubrio_turno() {
		return cubrio_turno;
	}

	public void setCubrio_turno(int cubrio_turno) {
		this.cubrio_turno = cubrio_turno;
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

	public String getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(String trabajador) {
		this.trabajador = trabajador;
	}
	
}
