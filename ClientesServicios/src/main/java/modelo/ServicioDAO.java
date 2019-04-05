package modelo;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import dominio.Servicio;

public class ServicioDAO implements ServicioDAOInterface{
	
	JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbctemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbctemplate) {
		this.jdbcTemplate = jdbctemplate;
	}


	public boolean alta(Servicio s) {
		// TODO Auto-generated method stub
		return false;
	}

	public void baja(int idServicio) {
		// TODO Auto-generated method stub
		
	}

	public void modificacion(Servicio s) {
		// TODO Auto-generated method stub
		
	}

	public Servicio consulta(int idServicio) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Servicio> consulta() {
		// TODO Auto-generated method stub
		return null;
	}

}
