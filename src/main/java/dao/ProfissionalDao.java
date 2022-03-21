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

import model.Profissional;


public class ProfissionalDao implements CRUD {
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	public static void create(Profissional profissional) {
		sql = "INSERT INTO profissionais VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			/*setar variáveis*/
			preparedStatement.setString(1, profissional.getNome());
			preparedStatement.setString(2, profissional.getArea());
			preparedStatement.setString(3, profissional.getCpf());
			preparedStatement.setString(4, profissional.getNascimento());
			preparedStatement.setString(5, profissional.getEmail());
			preparedStatement.setString(6, profissional.getTelefone());
			preparedStatement.setString(7, profissional.getAjuda());
			preparedStatement.setString(8, profissional.getSituacao());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Inserção correta na base de dados");
			
			
		
		} catch (SQLException e) {
			
			System.out.println("Inserção incorreta na base de dados" + e.getMessage());
		}
	}
	public static void delete(int profissionalId) {
		sql = "DELETE FROM profissionais WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, profissionalId);
			preparedStatement.executeUpdate();
			
			System.out.println("Deletado");
		} catch (SQLException e) {
			System.out.println("Não deletado corretamente" + e.getMessage());
		}
		
	}
	
	public static List<Profissional>	find(String pesquisa){
		
		sql = String.format("SELECT * FROM profissionais WHERE nome LIKE '%s%%' OR cpf LIKE '%s%%' ", pesquisa, pesquisa);
		List<Profissional> profissionais = new ArrayList<Profissional>();
		
		try {
			Statement statement= connection.createStatement();
			ResultSet resultSet =statement.executeQuery(sql);
			
			while (resultSet.next()) {
				Profissional profissional = new Profissional();
				profissional.setId(resultSet.getInt("id"));
				profissional.setNome(resultSet.getString("nome"));
				profissional.setArea(resultSet.getString("area"));
				profissional.setNascimento(resultSet.getString("nascimento"));
				profissional.setEmail(resultSet.getString("email"));
				profissional.setTelefone(resultSet.getString("telefone"));
				profissional.setAjuda(resultSet.getString("ajuda"));
				profissional.setSituacao(resultSet.getString("situacao"));
				
				profissionais.add(profissional);
			}
			
			System.out.println("Correct find profissionais");
			return profissionais;
			
		} catch (SQLException e) {
			System.out.println("Incorrect find profissionais" + e.getMessage());
			return null;
		}
		
		}
	public static Profissional findByPk(int profissionalId) {
		sql = String.format("SELECT * FROM profissionais WHERE id = %d ", profissionalId);
		
		
		try {
			Statement statement= connection.createStatement();
			ResultSet resultSet =statement.executeQuery(sql);
			Profissional profissional = new Profissional();
			
			while (resultSet.next()) {
				
				profissional.setId(resultSet.getInt("id"));
				profissional.setNome(resultSet.getString("nome"));
				profissional.setArea(resultSet.getString("area"));
				profissional.setNascimento(resultSet.getString("nascimento"));
				profissional.setEmail(resultSet.getString("email"));
				profissional.setTelefone(resultSet.getString("telefone"));
				profissional.setAjuda(resultSet.getString("ajuda"));
				profissional.setSituacao(resultSet.getString("situacao"));
				
				
			}
			
			System.out.println("Correct find by pk profissionais");
			return profissional;
			
		
		}
		 catch (SQLException e) {
				System.out.println("Incorrect find by pk profissionais" + e.getMessage());
				return null;
			}
	}
	public static void update(Profissional profissional) {
		sql = "UPDATE profissionais SET nome=?, area=?, cpf=?, nascimento=?, email=?, telefone=?, ajuda=?, situacao=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			/*setar variáveis*/
			preparedStatement.setString(1, profissional.getNome());
			preparedStatement.setString(2, profissional.getArea());
			preparedStatement.setString(3, profissional.getCpf());
			preparedStatement.setString(4, profissional.getNascimento());
			preparedStatement.setString(5, profissional.getEmail());
			preparedStatement.setString(6, profissional.getTelefone());
			preparedStatement.setString(7, profissional.getAjuda());
			preparedStatement.setString(8, profissional.getSituacao());
			preparedStatement.setInt(8, profissional.getId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Atualização correta na base de dados");
			
			
		
		} catch (SQLException e) {
			
			System.out.println("Atualização incorreta na base de dados" + e.getMessage());
		}
		
	}
	}
	
	/*Connection connection = createConnection();
	
	public ProfissionalDao() {
		
	}

	private Connection createConnection() {
		
		return null;
	}

	@Override
	public void insert(Profissional obj) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(
					"INSERT INTO profissional "
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
	public void update(Profissional obj) {
		
		
	}

	@Override
	public void deleteById(Integer id) {
		
		
	}

	@Override
	public Profissional findById(Integer id) {
		
		return null;
	}

	@Override
	public List<Profissional> findAll() {
		
		return null;
	}

}*/
