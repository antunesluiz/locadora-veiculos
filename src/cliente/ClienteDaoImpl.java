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

    private final Conexao conexao;

    public ClienteDaoImpl() {
        conexao = new Conexao();

        conexao.abreConexao();
    }

    @Override
    public ArrayList<Cliente> getAllClientes() {
        clientes = new ArrayList<>();

        String sql = "SELECT cliente.*, status_cliente.id as status_id, status_cliente.nome as status_nome "
                + "FROM cliente AS cliente JOIN status_cliente AS status_cliente "
                + "ON cliente.status_cliente_id = status_cliente.id";

        try {
            Cliente cliente;

            preparedStatement = conexao.getConnection().prepareStatement(sql);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                cliente = new Cliente(resultSet.getInt("id"), resultSet.getInt("status_id"),
                        resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("rg"), resultSet.getString("sexo"),
                        resultSet.getString("telefone"), resultSet.getString("logradouro"), resultSet.getString("cep"), resultSet.getInt("numero"),
                        resultSet.getString("bairro"), resultSet.getString("cidade"), resultSet.getString("estado"), resultSet.getString("pais"),
                        resultSet.getString("cnh"), resultSet.getString("email"), resultSet.getString("senha"), resultSet.getInt("is_admin"));

                clientes.add(cliente);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Erro ao capturar clientes");
        }

        return clientes;
    }

    @Override
    public long addCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (id, status_cliente_id, nome, cpf, rg, sexo, telefone, logradouro, cep, numero, bairro, cidade, estado, pais, cnh, email, senha, is_admin)"
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        String generatedColumns[] = { "id" };

        try {
            preparedStatement = conexao.getConnection().prepareStatement(sql, generatedColumns);

            preparedStatement.setNull(1, Types.INTEGER);
            preparedStatement.setInt(2, cliente.getStatusClientId());
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
            
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }

            preparedStatement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
        
        return 0;
    }

    public void close() {
        conexao.fechaConexao();
    }

    @Override
    public boolean deletarCliente(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";

        try {
            preparedStatement = conexao.getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao deletar cliente");
        }

        return false;
    }

    @Override
    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET id = ?, status_cliente_id =  ?, nome = ?, cpf = ?, rg = ?, sexo = ?, cnh = ?, "
                + "estado = ?, cidade = ?, pais = ?, logradouro = ?, numero = ?, bairro = ?, telefone = ?, senha = ? "
                + "WHERE id = ?";

        try {
            preparedStatement = conexao.getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, cliente.getId());
            preparedStatement.setInt(2, cliente.getStatusClientId());
            preparedStatement.setString(3, cliente.getNome());
            preparedStatement.setString(4, cliente.getCpf());
            preparedStatement.setString(5, cliente.getRg());
            preparedStatement.setString(6, cliente.getSexo());
            preparedStatement.setString(7, cliente.getCnh());
            preparedStatement.setString(8, cliente.getEstado());
            preparedStatement.setString(9, cliente.getCidade());
            preparedStatement.setString(10, cliente.getPais());
            preparedStatement.setString(11, cliente.getLogradouro());
            preparedStatement.setInt(12, cliente.getNumero());
            preparedStatement.setString(13, cliente.getBairro());
            preparedStatement.setString(14, cliente.getTelefone());
            preparedStatement.setString(15, cliente.getSenha());
            preparedStatement.setInt(16, cliente.getId());

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente getClientById(int id) {
        String sql = "SELECT cliente.*, status_cliente.id as status_id, status_cliente.nome as status_nome "
                + "FROM cliente AS cliente JOIN status_cliente AS status_cliente "
                + "ON cliente.status_cliente_id = status_cliente.id WHERE id = ?";

        Cliente cliente = null;
        try {
            preparedStatement = conexao.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            if (resultSet != null) {
                preparedStatement.close();

                return cliente = new Cliente(resultSet.getInt("id"), resultSet.getInt("status_id"),
                        resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("rg"), resultSet.getString("sexo"),
                        resultSet.getString("telefone"), resultSet.getString("logradouro"), resultSet.getString("cep"), resultSet.getInt("numero"),
                        resultSet.getString("bairro"), resultSet.getString("cidade"), resultSet.getString("estado"), resultSet.getString("pais"),
                        resultSet.getString("cnh"), resultSet.getString("email"), resultSet.getString("senha"), resultSet.getInt("is_admin"));
            }

            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Erro ao capturar clientes");
        }

        return null;
    }

    @Override
    public Cliente checkLogin(String email, String senha) {
        String sql = "SELECT * FROM cliente WHERE email = ? AND senha = ?";

        try {
            preparedStatement = conexao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            if (resultSet.next()) {

                Cliente c = new Cliente(resultSet.getInt("id"), resultSet.getInt("status_cliente_id"),
                        resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("rg"), resultSet.getString("sexo"),
                        resultSet.getString("telefone"), resultSet.getString("logradouro"), resultSet.getString("cep"), resultSet.getInt("numero"),
                        resultSet.getString("bairro"), resultSet.getString("cidade"), resultSet.getString("estado"), resultSet.getString("pais"),
                        resultSet.getString("cnh"), resultSet.getString("email"), resultSet.getString("senha"), resultSet.getInt("is_admin"));

                preparedStatement.close();
                return c;
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
