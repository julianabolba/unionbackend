package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;

//import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

import model.Cliente;


public class ClienteDao implements CRUD {
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	public static void create(Cliente cliente) {
		sql = "INSERT INTO clientes VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			/*setar variáveis*/
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getGenero());
			preparedStatement.setString(3, cliente.getCpf());
			preparedStatement.setString(4, cliente.getNascimento());
			preparedStatement.setString(5, cliente.getEmail());
			preparedStatement.setString(6, cliente.getTelefone());
			preparedStatement.setString(7, cliente.getBusca());
			preparedStatement.setString(8, cliente.getSituacao());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Inserção correta na base de dados");
			
			
		
		} catch (SQLException e) {
			
			System.out.println("Inserção incorreta na base de dados" + e.getMessage());
		}
	}
	public static void delete(int clienteId) {
		sql = "DELETE FROM clientes WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, clienteId);
			preparedStatement.executeUpdate();
			
			System.out.println("Deletado");
		} catch (SQLException e) {
			System.out.println("Não deletado corretamente" + e.getMessage());
		}
		
	}
	
	public static List<Cliente>	find(String pesquisa){
		
		sql = String.format("SELECT * FROM clientes WHERE nome LIKE '%s%%' OR cpf LIKE '%s%%' ", pesquisa, pesquisa);
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			Statement statement= connection.createStatement();
			ResultSet resultSet =statement.executeQuery(sql);
			
			while (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setGenero(resultSet.getString("genero"));
				cliente.setNascimento(resultSet.getString("nascimento"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setTelefone(resultSet.getString("telefone"));
				cliente.setBusca(resultSet.getString("busca"));
				cliente.setSituacao(resultSet.getString("situacao"));
				
				clientes.add(cliente);
			}
			
			System.out.println("Correct find clientes");
			return clientes;
			
		} catch (SQLException e) {
			System.out.println("Incorrect find clientes" + e.getMessage());
			return null;
		}
		
		}
	public static Cliente findByPk(int clienteId) {
		sql = String.format("SELECT * FROM clientes WHERE id = %d ", clienteId);
		
		
		try {
			Statement statement= connection.createStatement();
			ResultSet resultSet =statement.executeQuery(sql);
			Cliente cliente = new Cliente();
			
			while (resultSet.next()) {
				
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setGenero(resultSet.getString("genero"));
				cliente.setNascimento(resultSet.getString("nascimento"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setTelefone(resultSet.getString("telefone"));
				cliente.setBusca(resultSet.getString("busca"));
				cliente.setSituacao(resultSet.getString("situacao"));
				
				
			}
			
			System.out.println("Correct find by pk clientes");
			return cliente;
			
		
		}
		 catch (SQLException e) {
				System.out.println("Incorrect find by pk clientes" + e.getMessage());
				return null;
			}
	}
	public static void update(Cliente cliente) {
		sql = "UPDATE clientes SET nome=?, genero=?, cpf=?, nascimento=?, email=?, telefone=?, busca=?, situacao=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			/*setar variáveis*/
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getGenero());
			preparedStatement.setString(3, cliente.getCpf());
			preparedStatement.setString(4, cliente.getNascimento());
			preparedStatement.setString(5, cliente.getEmail());
			preparedStatement.setString(6, cliente.getTelefone());
			preparedStatement.setString(7, cliente.getBusca());
			preparedStatement.setString(8, cliente.getSituacao());
			preparedStatement.setInt(8, cliente.getId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Atualização correta na base de dados");
			
			
		
		} catch (SQLException e) {
			
			System.out.println("Atualização incorreta na base de dados" + e.getMessage());
		}
		
	}
	}
	
	/*Connection connection = createConnection();
	
	public ClienteDao() {
		
	}

	private Connection createConnection() {
		
		return null;
	}

	@Override
	public void insert(Cliente obj) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(
					"INSERT INTO cliente "
					+ "(nome, cpf, nascimento, situacao) "
					+ "VALUES "
					+ "(?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getNome());
			st.setString(2, obj.getCpf());
			st.setString(3, obj.getNascimento());
			st.setString(4, obj.getSituacao());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
			}
					else {
						System.out.println("Unexpected error");
					}
			}
			
			catch (Exception e){
				System.out.println("Erro");
			}
			
			
		}
			
	
		
	@Override
	public void update(Cliente obj) {
		
		
	}

	@Override
	public void deleteById(Integer id) {
		
		
	}

	@Override
	public Cliente findById(Integer id) {
		
		return null;
	}

	@Override
	public List<Cliente> findAll() {
		
		return null;
	}

}*/
