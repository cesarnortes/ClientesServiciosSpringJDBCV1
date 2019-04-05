package dominio;

import java.sql.Date;

public class Servicio {

	private int idServicio; 
	private Cliente cliente;
    private String concepto;
	private Date fecha;
	private Double importe;
	
	
	public Servicio() {}

	public Servicio(Cliente cliente, String concepto,Date fecha, Double importe) {
		super();
		
		this.cliente = cliente;
        this.concepto = concepto;
		this.fecha = fecha;
		this.importe = importe;
		
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

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", idCliente=" + cliente + ", Fecha=" + fecha + ", Importe="
				+ importe + ", descripcion=" + concepto + "]";
	}
	
	
}