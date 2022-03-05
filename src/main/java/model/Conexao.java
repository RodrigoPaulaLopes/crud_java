package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	 	private static final String DRIVER = "com.mysql.jdbc.Driver";
	    private static final String URL = "jdbc:mysql://localhost:3306/cadastro";
	    private static final String USER = "root";
	    private static final String PASS = "root";

	    public static Connection criarConexao() {
	        try {
	            Class.forName(DRIVER);
	            return DriverManager.getConnection(URL, USER, PASS);
	        } catch (ClassNotFoundException | SQLException ex) {
	            throw new RuntimeException("Erro na conexão: ", ex);
	        }
	    }

}
