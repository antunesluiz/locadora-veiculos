package cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import conexao.Conexao;

/**
 * @author Luiz Antunes
 *
 */
public class ClienteDaoImpl implements iClienteDao {
	
	private ArrayList<Cliente> clientes;
	private PreparedStatement preparedStatement;
	
	private Conexao conexao;
	
	public ClienteDaoImpl() {
		conexao = new Conexao();
		
		conexao.abreConexao();
	}

	@Override
	public ArrayList<Cliente> getAllClientes() {
		clientes = new ArrayList<Cliente>();
		
		String sql = "SELECT cliente.*, status_cliente.id as status_id, status_cliente.nome as status_nome "
				+ "FROM cliente AS cliente JOIN status_cliente AS status_cliente "
				+ "ON cliente.status_cliente_id = status_cliente.id";
		
		try {
			Cliente cliente;
			
			preparedStatement = conexao.getConnection().prepareStatement(sql);
			preparedStatement.execute();
			
			ResultSet resultSet = preparedStatement.getResultSet();
			
			while (resultSet.next()) {
				cliente = new Cliente(resultSet.getInt("id"), new StatusCliente(resultSet.getInt("status_id"), resultSet.getString("status_nome")),
						resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("rg"), resultSet.getString("sexo"), 
						resultSet.getString("telefone"), resultSet.getString("logradouro"), resultSet.getString("cep"), resultSet.getInt("numero"), 
						resultSet.getString("bairro"), resultSet.getString("cidade"), resultSet.getString("estado"), resultSet.getString("pais"), 
						resultSet.getString("cnh"), resultSet.getString("email"), resultSet.getString("senha"), resultSet.getInt("is_admin"));
				
				clientes.add(cliente);
			}
			
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clientes;
	}

	@Override
	public void addCliente(Cliente cliente) {
		String sql = "INSERT INTO cliente (id, status_client_id, nome, cpf, rg, sexo, telefone, logradouro, cep, numero, bairro, cidade, estado, pais, cnh, email, senha, is_admin)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			preparedStatement = conexao.getConnection().prepareStatement(sql);
			
			preparedStatement.setNull(1, Types.INTEGER);
			preparedStatement.setInt(2, cliente.getStatusClientId().getId());
			preparedStatement.setString(3, cliente.getNome());
			preparedStatement.setString(4, cliente.getCpf());
			preparedStatement.setString(5, cliente.getRg());
			preparedStatement.setString(6, cliente.getSexo());
			preparedStatement.setString(7, cliente.getTelefone());
			preparedStatement.setString(8, cliente.getLogradouro());
			preparedStatement.setString(9, cliente.getCep());
			preparedStatement.setInt(10, cliente.getNumero());
			preparedStatement.setString(11, cliente.getBairro());
			preparedStatement.setString(12, cliente.getCidade());
			preparedStatement.setString(13, cliente.getEstado());
			preparedStatement.setString(14, cliente.getPais());
			preparedStatement.setString(15, cliente.getCnh());
			preparedStatement.setString(16, cliente.getEmail());
			preparedStatement.setString(17, cliente.getSenha());
			preparedStatement.setInt(18, cliente.getIsAdmin());
			
			preparedStatement.execute();
			
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		conexao.fechaConexao();
	}
}