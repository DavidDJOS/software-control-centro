package consultas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

import conexion.ConexionDB;

public class Materiales {
	private static Logger LOG = Logger.getLogger("Materiales.class");
	ConexionDB conexionDB = new ConexionDB();
	Connection conexion = conexionDB.getConexion();
	Statement sentencia = conexionDB.getSentencia();

	
	public void JalarMateriales() {
		String consulta = "";
		try {
			consulta += "select * from materiales";
			ResultSet resultado = sentencia.executeQuery(consulta);
		} catch (Exception e) {
			LOG.info("Error " + e);
		}
	}
}
