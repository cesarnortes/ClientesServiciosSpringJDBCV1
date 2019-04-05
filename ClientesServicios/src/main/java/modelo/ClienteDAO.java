package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//LAS IMPORTACIONES SE HACEN AUTOMATICAMENTE SIEMPRE QUE EL PROYECTO TENGA LA LIBRERIA NECESARIA CARGADA
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import dominio.Cliente;
import dominio.Servicio;

public class ClienteDAO implements ClienteDAOInterface {

	////////////////////////////////////////////////////////////////
//Esta clase será un bean que creara spring desde si archivo de configuración
//todo clase que pueda tratarse como un bean (Clase POJO de java) y para ello es 
//necesario tener obviamente sus atributos (Variables) y los getter y setter para la obtencion y establecimiento 
//de las variables de dicha clase y un contructor sin parametros
//por defecto todas las clases heredan un contructor o puedes crearlo
	///////////////////////////////////////////////////////////////
	
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbctemplate) {
		this.jdbcTemplate = jdbctemplate;
	}

	///////////////////////////////////////////////////////////////////

	public boolean alta(Cliente c) {

		// En SpringJDBC debemos encerrar la ejecucion de jdbcTemplate en try cath
		try {

			// creamos la sentencia sql que ejecurara jdbctemplate
			// el ? ocupará el valor de la variable que especifiquemos como parametro en
			// jdbcTemplate.update
			// el metodo .update se usa para ejecutar sentencias SQL que modifiquen datos de
			// una tabla ya sea
			// borrar, insertar o modificar
			//String sentenciaSQL = "INSERT INTO tclientes VALUES";

			// pasamos como parametro el valor de ?
			jdbcTemplate.update(sentenciaSQL, c.getIdCliente());

		} catch (DataAccessException e) {
			// usamos DataAccessException como clase a la hora de capturar las excepciones
			// de acceso a datos en este caso
			// y se una excepción salta devolvemos el false para indicar el error del metodo
			return false;

		}
		// devolvemos true si todo sucede satisfactoriamente
		return true;

	}

	public void baja(int idCliente) {
 
		
		

			// DE IGUAL MANERA CREAMOS UNA SENTENCIA SQL PARA DAR DE BAJA UN CLIENTE
			//ANTONIO DIJO QUE AL BORRAR UN CLIENTE HAY QUE DAR PRIMERO DE BAJA LOS REGISTRO DE LAS TABLAS DEPENDIENTES 
			//DE LA ENTIDAD FUERTE EN ESTE CASO AL CREAR UN SERVICIO (ENTIDAD DEBIL) ES OBLIGATORIO QUE TENGA UN CLIENTE YA QUE EN LA TABLA
			//LOS SERVICIOS TIENEN UNA CLAVE FORANEA (UN ID DE CLIENTE) Y PARA EVITAR ERRORES EN LA BASE DE DATOS DE LA INTEGRIDAD REFERENCIAL
			//HAY QUE DAR DE BAJA PRIMERO LAS ENTIDADES DEBILES PERO YO HE PREFERIDO DEJAS QUE ESO SE HAGA EN LA CLASE MODELO
			//Y QUE LOS DAO DE LAS ENTIDADES TANSOLO MANEJEN LOS METODOS CRUD DE LA ENTIDAD Y EN MODELO.JAVA AHI DESARROLLO LA LOGIGA DE LOS METODOS
			//QUE OPERAN EN LA BASE DE DATOS
			String sentenciaSQL = "DELETE * FROM tclientes WHERE IdCliente=?";

			// pasamos como parametro el valor de ?
			jdbcTemplate.update(sentenciaSQL, idCliente);

 
 
	}

	public void modificacion(Cliente c) {
		// TODO Auto-generated method stub

	}

	public Cliente consulta(int idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cliente> consulta() {
		// TODO Auto-generated method stub
		return null;
	}

	///////////////////////////////////////////////////////////////////////

	class ClienteMapper implements RowMapper<Cliente> {
		public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cliente cliente = new Cliente();
			cliente.setIdCliente(rs.getInt("IdCliente"));
			cliente.setNombre(rs.getString("Nombre"));
			cliente.setEmail("Email");
			cliente.setTelefono("Telefono");

			String sql = "Select * from TServicios where idCliente=?";
			List<Servicio> servicio = jdbcTemplate.query(sql, new Object[] { cliente.getIdCliente() },
					new ServicioMapper());

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
			servicio.setConcepto(rs.getString("Concepto"));
			servicio.setFecha(rs.getDate("Fecha"));
			servicio.setImporte(rs.getDouble("Importe"));
			servicio.setCliente(jdbcTemplate.queryForObject(sql, new Object[] { idCliente }, new ClienteMapper()));

			return servicio;

		}
	}

}
