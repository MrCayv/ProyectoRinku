package model;

import utilidades.Formatos;

public class Reporte {
	private int id_empleado;
	private String nombre;
	private String rol;
	private String tipo;
	private int dias;
	private int entregas;
	private int horas_cubrir;
	private int importe_dias;
	private int importe_entregas;
	private int importe_bonos;
	
	private double subtotal;
	private double isr;
	private double total;
	private double vale;
	
	
	public int getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	public int getEntregas() {
		return entregas;
	}
	public void setEntregas(int entregas) {
		this.entregas = entregas;
	}
	public int getHoras_cubrir() {
		return horas_cubrir;
	}
	public void setHoras_cubrir(int horas_cubrir) {
		this.horas_cubrir = horas_cubrir;
	}
	public int getImporte_dias() {
		return importe_dias;
	}
	public void setImporte_dias(int importe_dias) {
		this.importe_dias = importe_dias;
	}
	public int getImporte_entregas() {
		return importe_entregas;
	}
	public void setImporte_entregas(int importe_entregas) {
		this.importe_entregas = importe_entregas;
	}
	public int getImporte_bonos() {
		return importe_bonos;
	}
	public void setImporte_bonos(int importe_bonos) {
		this.importe_bonos = importe_bonos;
	}
	
	public double getSubtotal() {
		subtotal = importe_dias + importe_entregas + importe_bonos;
		return subtotal;
	}
	public double getIsr() {
		isr = subtotal<=16000?subtotal*0.09:subtotal*0.11;
		return isr;
	}
	public double getTotal() {
		total = subtotal - isr;
		return total;
	}
	public double getVale() {
		vale = 0;
		if(tipo.equals("Interno"))
			vale = subtotal*0.04;
		return vale;
	}
	
	
	
	public String getImporte_diasStr() {
		return Formatos.formatoDouble(importe_dias, "$#,###,##0.00");
	}
	public String getImporte_entregasStr() {
		return Formatos.formatoDouble(importe_entregas, "$#,###,##0.00");
	}
	public String getImporte_bonosStr() {
		return Formatos.formatoDouble(importe_bonos, "$#,###,##0.00");
	}
	public String getSubtotalStr() {
		subtotal = importe_dias + importe_entregas + importe_bonos;
		return Formatos.formatoDouble(subtotal, "$#,###,##0.00");
	}
	public String getIsrStr() {
		isr = subtotal<=16000?subtotal*0.09:subtotal*0.11;
		return Formatos.formatoDouble(isr, "$#,###,##0.00");
	}
	public String getTotalStr() {
		total = subtotal - isr;
		return Formatos.formatoDouble(total, "$#,###,##0.00");
	}
	public String getValeStr() {
		vale = 0;
		if(tipo.equals("Interno"))
			vale = subtotal*0.04;
		return Formatos.formatoDouble(vale, "$#,###,##0.00");
	}
}
