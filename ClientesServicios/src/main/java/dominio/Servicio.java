package dominio;

import java.sql.Date;

public class Servicio {

	private int idServicio; 
	private Cliente cliente;
    private String descripcion;
	private Date fecha;
	
	
	public Servicio() {}

	public Servicio(Cliente cliente, String descripcion,Date fecha, Double importe) {
		super();
		
		this.cliente = cliente;
		this.fecha = fecha;
 		
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

   

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", idCliente=" + cliente + ", Fecha=" + fecha +"]";
	}
	
	
}