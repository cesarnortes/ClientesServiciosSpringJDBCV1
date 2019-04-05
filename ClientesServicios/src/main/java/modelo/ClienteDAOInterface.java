package modelo;
import java.util.List;

import dominio.Cliente;






public interface ClienteDAOInterface {
	
	public boolean alta(Cliente c);
	public void baja(int idCliente);
	public void modificacion(Cliente c);
	public Cliente consulta(int idCliente);
	public List<Cliente> consulta();
	
}

