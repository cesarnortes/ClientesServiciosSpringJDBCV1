package modelo;

import java.util.List;

import dominio.Cliente;
import dominio.Servicio;

public interface ModeloInterface {
	public boolean alta(Cliente c);
	public void bajaCliente(int idCliente);
	public void modificacion(Cliente c);
	public Cliente consultaCliente(int idCliente);
	public List<Cliente> consultaClientes();
	public boolean alta(Servicio s);
	public void bajaServicio(int idServicio);
	public void modificacion(Servicio s);
	public Servicio consultaServicio(int idServicio);
	public List<Servicio> consultaServicios();
}
