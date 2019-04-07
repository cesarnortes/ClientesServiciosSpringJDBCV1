package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import dominio.Cliente;
import dominio.Servicio;
import modelo.ClienteDAO.ClienteMapper;
import modelo.ClienteDAO.ServicioMapper;

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
	///////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////

	//Mapper son necesarios en cada DAO que trabejo con esos objetos
	
	//Los mapper son la clase que hay que desarrollar donde especificamos que columna corresponde con con que variable 
	// del objeto que queremos contruir y finalmente devuelve un objero del tipo especificado
	// siempre que que haga una consulta hay que pasarle por parametro al metodo de consulta de jdbcTemplate
	// un mapper del objeto que deseas consultar
	
	class ClienteMapper implements RowMapper<Cliente> {
		public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			//creamos el objeto 
			Cliente cliente = new Cliente();
			
			//asignamos el valor extraido en el resulset en sus variables con los setter
			cliente.setIdCliente(rs.getInt("IdCliente"));
			cliente.setNombre(rs.getString("Nombre"));
			cliente.setTelefono("Telefono");

			//cuado el objeto tiene un array de otro objeto u otro objeto a secas almacenado en otra tabla
			//hay que hacer una consulta para extraer los registros necesarios
			String sql = "Select * from TServicios where idCliente=?";
			List<Servicio> servicio = jdbcTemplate.query(sql, new Object[] { cliente.getIdCliente() },
					new ServicioMapper());
			//como se puede ver queremos un array de los servicios del cliente entonces al crear un cliente 
			//necesitamos cargar todos los servicios del mismo modo de siempre 

			cliente.setListaServicios((ArrayList<Servicio>) servicio);

			return cliente;
		}
	}

	class ServicioMapper implements RowMapper<Servicio> {
		public Servicio mapRow(ResultSet rs, int rowNum) throws SQLException {
			String sql = "select * from TClientes where IdCliente=? ";
			int idCliente = rs.getInt("IdCliente");
			Servicio servicio = new Servicio();

			servicio.setIdServicio(rs.getInt("IdServicio"));
			servicio.setDescripcion(rs.getString("Concepto"));
			servicio.setFecha(rs.getDate("Fecha"));
			//este maper de servicio es exactamente igual solo que no necesita un array solo un cliente especifico
			//consultamos el cliente con jdbcTemplate.queryForObject para especificar que la busqueda
			//solo trae un objeto o registro, de la mis forma pasamos el mapper del objeto que debe crear
			//y asi ya usaria el codigo la aplicacion de manera recurrente una y otra vez segun objetos y objetos anidados
			//tenga que crear
			servicio.setCliente(jdbcTemplate.queryForObject(sql, new Object[] { idCliente }, new ClienteMapper()));

			return servicio;

		}
	}


}

