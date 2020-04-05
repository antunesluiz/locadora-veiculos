package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Luiz Antunes
 *
 */
public class Conexao {
	private String dbName = "jdbc:mysql://localhost/locadora?useTimezone=true&serverTimezone=UTC";
	private String dbUser = "root";
	private String dbPassword = "";
	
	private Connection connection;
	
	public Conexao() {

	}
	
	public boolean abreConexao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(dbName, dbUser, dbPassword);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
			return false;
		}
		
		return true;
	}
	
	public void fechaConexao() {
		try {
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}