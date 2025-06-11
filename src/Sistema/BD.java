package Sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {

	private static String caminho = "jdbc:mysql://localhost/sistemaloja";
	private static String usuario = "root";
	private static String senha = "142536";
	
	public static Connection Faz_conexao() throws SQLException {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			return DriverManager.getConnection(caminho,usuario,senha);
			
			
			
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getException());
			
		}
		
		
		
	}
	
}
