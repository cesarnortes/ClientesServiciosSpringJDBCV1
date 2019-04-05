package modelo;

import java.util.List;

import dominio.Cliente;
import dominio.Servicio;

public class Modelo implements ModeloInterface{
	
	/*private ServicioDAOInterface servicioDAO;
	private ClienteDAOInterface clienteDAO;
	 
	 
	 
	public Modelo(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.clienteDAO= (ClienteDAOInterface) context.getBean("clienteDAO");
		this.servicioDAO=(ServicioDAOInterface)context.getBean("servicioDAO");
	}
	*/

	public boolean alta(Cliente c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void bajaCliente(int idCliente) {
		// TODO Auto-generated method stub
		
	}

	public void modificacion(Cliente c) {
		// TODO Auto-generated method stub
		
	}

	public Cliente consultaCliente(int idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cliente> consultaClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean alta(Servicio s) {
		// TODO Auto-generated method stub
		return false;
	}

	public void bajaServicio(int idServicio) {
		// TODO Auto-generated method stub
		
	}

	public void modificacion(Servicio s) {
		// TODO Auto-generated method stub
		
	}

	public Servicio consultaServicio(int idServicio) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Servicio> consultaServicios() {
		// TODO Auto-generated method stub
		return null;
	}

}
