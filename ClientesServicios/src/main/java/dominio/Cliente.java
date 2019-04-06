package dominio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private int idCliente; 
	private String nombre;
	private String telefono;
	List<Servicio> listaServicios = new ArrayList<Servicio>();
	
	public Cliente() {}

	public Cliente(String nombre, String telefono, List<Servicio> listaServicios) {

		this.nombre = nombre;
		this.telefono = telefono;
 		this.listaServicios=listaServicios;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	
	public List<Servicio> getListaServicios(){
		return listaServicios;
	}
	
	public void setListaServicios(List<Servicio> listaServicios){
		this.listaServicios=listaServicios;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", telefono=" + telefono +", listaServicios=" + listaServicios + "]";
	}
	
}