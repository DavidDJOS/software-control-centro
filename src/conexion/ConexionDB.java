package conexion;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConexionDB {

	private static Logger LOG = Logger.getLogger("Reciclados.class");
	Connection conexion;
	Statement sentencia;

	public boolean conectarBaseDatos() {

		boolean conectado;
		try {
			String contador = "com.mysql.jdbc.Driver";
			Class.forName(contador).newInstance();
			LOG.info("Controlador cargado");
			conectado = true;
		} catch (Exception e) {
			LOG.info("No se pudo cargar el controlador");
			conectado = false;
		}

		try {
			String DNS = "jdbc:mysql://localhost/RecicladosANDALECI";
			String user = "root";
			String pasword = "root";
			conexion = DriverManager.getConnection(DNS, user, pasword);
			conectado = true;
		} catch (Exception b) {
			LOG.info("No se puede realizar la conexion");
			conectado = false;
		}

		try {
			sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			conectado = true;
		} catch (Exception s) {
			LOG.info("No se puede enlazar la base da datos");
			conectado = false;
		}
		
		setConexion(conexion);
		setSentencia(sentencia);
		
		return conectado;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public Statement getSentencia() {
		return sentencia;
	}

	public void setSentencia(Statement sentencia) {
		this.sentencia = sentencia;
	}
	
	public void setOperacionConexion(int operacion) {
		if (operacion == 0) {
			try {
				conexion.close();
				LOG.info("Conexion cerrada");
			} catch (SQLException e) {
				LOG.info("No se puede cerrar " + e);
			}
		}
	}
	
}
