import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCliente(Cliente cliente) {
		String sql = "INSERT INTO cliente (id, status_client_id, nome, cpf, rg, sexo, telefone, logradouro, cep, numero, bairro, cidade, estado, pais, cnh, email, senha, is_admin)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			preparedStatement = conexao.getConnection().prepareStatement(sql);
			
			preparedStatement.setNull(1, Types.INTEGER);
			preparedStatement.setInt(1, cliente.getStatusClientId());
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(1, cliente.getCpf());
			preparedStatement.setString(1, cliente.getRg());
			preparedStatement.setString(1, cliente.getSexo());
			preparedStatement.setString(1, cliente.getTelefone());
			preparedStatement.setString(1, cliente.getLogradouro());
			preparedStatement.setString(1, cliente.getCep());
			preparedStatement.setInt(1, cliente.getNumerp());
			preparedStatement.setString(1, cliente.getBairro());
			preparedStatement.setString(1, cliente.getCidade());
			preparedStatement.setString(1, cliente.getEstado());
			preparedStatement.setString(1, cliente.getPais());
			preparedStatement.setString(1, cliente.getCnh());
			preparedStatement.setString(1, cliente.getEmail());
			preparedStatement.setString(1, cliente.getSenha());
			preparedStatement.setInt(1, cliente.getIsAdmin());
			
			boolean resultado = preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}