package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
	
	
	public Connection conn;
	PreparedStatement stmt = null;
	Statement st = null;
    ResultSet rs = null;
	
	public ClienteDAO() {
		
		this.conn = Conexao.criarConexao(); 
	}
	
	public List<Cliente> listar(){
		
		List<Cliente> clientes = new ArrayList<>();
		
		try {
			st = conn.createStatement();
			rs= st.executeQuery("SELECT * FROM cliente");
			
			while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("numero"));
                clientes.add(cliente);
            }
		}catch(SQLException e) {
			System.out.println("ERRROR" + e.getMessage());
		}
		return clientes;
	}
	public void inserir(Cliente cliente) {
		try {
			stmt = conn.prepareStatement("INSERT INTO cliente (nome, email, numero) VALUES (?,?,?)");
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getTelefone());
			
			int row = stmt.executeUpdate();
			
			if(row > 0) {
				System.out.println("Inserido com sucesso!");
			}
		} catch (SQLException e) {
			
			e.getMessage();
		}
	}
	public void excluir(int id) {
		
		try {
			
			stmt = conn.prepareStatement("DELETE FROM cliente WHERE id = ?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("error: "+ e.getMessage());
		}
	}
	public Cliente listarID(int id){
		
		Cliente cliente = new Cliente();
		
		try {
			stmt = conn.prepareStatement("SELECT * FROM cliente WHERE id = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefone(rs.getString("numero"));
				
			}

		}catch(SQLException e) {
			System.out.println("ERRROR" + e.getMessage());
		}
		return cliente;
	}
	public void update(Cliente cliente) {
		try {
			stmt = conn.prepareStatement("UPDATE cliente SET nome = ?, email = ?, numero = ? WHERE id = ?");
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getTelefone());
			
			stmt.setInt(4, cliente.getId());
			
			int row = stmt.executeUpdate();
			
			if(row > 0) {
				System.out.println("Alterado com sucesso!");
			}
		} catch (SQLException e) {
			
			e.getMessage();
		}
	}
	
		
}

