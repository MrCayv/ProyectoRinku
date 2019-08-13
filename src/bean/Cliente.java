/**
 * 
 */
package bean;

import java.util.List;

/**
 * @author cesar
 *
 */
public class Cliente {
	private String nombre;
	private String apellido;
	private List<String> valor;
	
	public Cliente() {
		this.nombre = "Cesar";
		this.apellido = "Yamaguchi";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<String> getValor() {
		return valor;
	}

	public void setValor(List<String> valor) {
		this.valor = valor;
	}
	
}
