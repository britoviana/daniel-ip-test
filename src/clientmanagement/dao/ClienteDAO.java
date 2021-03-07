package clientmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clientmanagement.model.Cliente;

// This DAO class provides CRUD database operations for the table cliente in the database.
public class ClienteDAO {
	private static String jdbcURL = "localhost";
	private static String jdbcUsername = "rodrigo";
	private static String jdbcPassword = "hqWxD3FN";
	
	private static final String INSERT_CLIENTES_SQL = "INSERT INTO clientes" + "(cpf, nome, email, dt_nasc, sexo, estado_civil, ativo) VALUES " 
													+ " (?, ?, ?, ?, ?, ?);";
	private static final String SELECT_CLIENTES_BY_CPF = "SELECT * FROM clientes WHERE cpf = ?;";
	private static final String SELECT_CLIENTES_BY_NOME = "SELECT * FROM clientes WHERE nome LIKE ?;";
	private static final String SELECT_ALL_CLIENTES = "SELECT * FROM clientes;";
	private static final String DELETE_CLIENTES_SQL = "DELETE FROM clientes WHERE cpf = ?;";
	private static final String UPDATE_CLIENTES_SQL = "UPDATE clientes SET (nome = ?, email = ?, dt_nasc = ?, sexo = ?, estado_civil = ?, ativo = ?) WHERE cpf = ?;";

	protected static Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	// Create or insert cliente
	public void insertCliente(Cliente cliente) throws SQLException {
		try(Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(INSERT_CLIENTES_SQL);) {
			statement.setString(1, cliente.getCpf());
			statement.setString(2, cliente.getNome());
			statement.setString(3, cliente.getEmail());
			statement.setString(4, cliente.getDtnasc());
			statement.setString(5, cliente.getSexo());
			statement.setString(6, cliente.getEstadoCivil());
			statement.setBoolean(7, cliente.isAtivo());
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	// Update cliente
	public boolean updateCliente(Cliente cliente) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_CLIENTES_SQL);) {
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getEmail());
			statement.setString(3, cliente.getDtnasc());
			statement.setString(4, cliente.getSexo());
			statement.setString(5, cliente.getEstadoCivil());
			statement.setBoolean(6, cliente.isAtivo());
			statement.setString(7, cliente.getCpf());
			
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	// Select cliente by CPF
	public Cliente selectCliente(String cpf) {
		Cliente cliente = null;
		//Step 1 Establish connection
		try (Connection connection = getConnection();
			//Step 2 Create a statement using connection object
			 PreparedStatement statement = connection.prepareStatement(SELECT_CLIENTES_BY_CPF);) {
			statement.setString(1, cpf);
			System.out.println(statement);
			//Step 3 Execute SQL query
			ResultSet rs = statement.executeQuery();
			//Step 4 Process the ResultSet object
			while (rs.next()) {
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String dtNasc = rs.getString("dt_nasc");
				String sexo = rs.getString("sexo");
				String estadoCivil = rs.getNString("estado_civil");
				Boolean ativo = rs.getBoolean("ativo");
				cliente = new Cliente(nome, email, dtNasc, sexo, estadoCivil, ativo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	// Select clientes
	
	public List<Cliente> selectAllClientes() {
		List<Cliente> clientes = new ArrayList<>();
		//Step 1 Establish connection
		try (Connection connection = getConnection();
				//Step 2 Create a statement using connection object
				PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CLIENTES);) {
			System.out.println(statement);
			//Step 3 Execute SQL query
			ResultSet rs = statement.executeQuery();
			
			//Step 4 Process the ResultSet object
			while (rs.next()) {
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String dtNasc = rs.getString("dt_nasc");
				String sexo = rs.getString("sexo");
				String estadoCivil = rs.getNString("estado_civil");
				Boolean ativo = rs.getBoolean("ativo");
				clientes.add(new Cliente(cpf, nome, email, dtNasc, sexo, estadoCivil, ativo));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}
	
	public List<Cliente> selectClientesByNome(String nome) {
		List<Cliente> clientes = new ArrayList<>();
		//Step 1 Establish connection
		try (Connection connection = getConnection();
				//Step 2 Create a statement using connection object
				PreparedStatement statement = connection.prepareStatement(SELECT_CLIENTES_BY_NOME);) {
			statement.setString(1, "%" + nome + "%");
			System.out.println(statement);
			//Step 3 Execute SQL query
			ResultSet rs = statement.executeQuery();
			
			//Step 4 Process the ResultSet object
			while (rs.next()) {
				String cpf = rs.getString("cpf");
				String nome1 = rs.getString("nome");
				String email = rs.getString("email");
				String dtNasc = rs.getString("dt_nasc");
				String sexo = rs.getString("sexo");
				String estadoCivil = rs.getNString("estado_civil");
				Boolean ativo = rs.getBoolean("ativo");
				clientes.add(new Cliente(cpf, nome1, email, dtNasc, sexo, estadoCivil, ativo));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}
	
	// Delete cliente
	public static boolean deleteCliente(String cpf) throws SQLException {
		boolean rowDeleted;
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CLIENTES_SQL);) {
					statement.setString(1, cpf);
					rowDeleted = statement.executeUpdate() > 0;				
					}
		return rowDeleted;
	}
}
