package br.com.connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String dbURl= "jdbc:mysql://localhost:3306/cadastro";
	private static final String username = "root";
	private static final String password = "1234";
	
	
	
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conection = DriverManager.getConnection(dbURl, username, password);
		
		return conection;
	}
	
	public static void main(String[] args) throws Exception {
		
		
		Connection con = createConnectionToMySQL();
		
		
		if(con!=null) {
			System.out.println("conexao obtida com sucesso");
			con.close();
		}
		
	}
}

