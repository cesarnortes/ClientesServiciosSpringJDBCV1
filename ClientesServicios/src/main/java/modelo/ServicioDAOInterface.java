package modelo;

import java.util.List;

import dominio.Cliente;
import dominio.Servicio;

public interface ServicioDAOInterface {
	public boolean alta(Servicio s);
	public void baja(int idServicio);
	public void modificacion(Servicio s);
	public Servicio consulta(int idServicio);
	public List<Servicio> consulta();
}
