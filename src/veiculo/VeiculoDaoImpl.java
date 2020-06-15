/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculo;

import conexao.Conexao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Luiz Antunes
 */
public class VeiculoDaoImpl implements iVeiculoDao {

    private PreparedStatement preparedStatement;

    private final Conexao conexao;

    public VeiculoDaoImpl() {
        conexao = new Conexao();

        conexao.abreConexao();
    }

    @Override
    public ArrayList<Veiculo> getVeiculos() {
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        String sql = "SELECT veiculo.*, status_veiculo.id as status_id, carroceria_veiculo.id as carroceira_id, carroceria_veiculo.id as categoria_id, combustivel_veiculo.id as combustivel_id "
                + "FROM `veiculo` as veiculo JOIN carroceria_veiculo as carroceria_veiculo JOIN status_veiculo as status_veiculo JOIN categoria_veiculo JOIN combustivel_veiculo "
                + "ON veiculo.status_veiculo_id = status_veiculo.id AND veiculo.carroceria_veiculo_id = carroceria_veiculo.id AND veiculo.categoria_veiculo_id = categoria_veiculo.id AND veiculo.combustivel_veiculo_id = combustivel_veiculo.id";

        try {
            Veiculo veiculo;

            preparedStatement = conexao.getConnection().prepareStatement(sql);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                veiculo = new Veiculo(resultSet.getInt("id"), resultSet.getInt("status_id"),
                        resultSet.getInt("carroceira_id"), resultSet.getInt("categoria_id"), resultSet.getInt("combustivel_id"),
                        resultSet.getString("renavam"), resultSet.getString("chassi"), resultSet.getString("marca"), resultSet.getString("placa"),
                        resultSet.getString("ano"), resultSet.getString("cor"), resultSet.getString("modelo"));

                veiculos.add(veiculo);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Erro ao capturar veiculos");
        }

        return veiculos;
    }

    @Override
    public ArrayList<Veiculo> getVeiculosDisponiveis() {
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        String sql = "SELECT * FROM veiculo WHERE status_veiculo_id = 1";

        try {
            Veiculo veiculo;

            preparedStatement = conexao.getConnection().prepareStatement(sql);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                veiculo = new Veiculo(resultSet.getInt("id"), resultSet.getInt("status_veiculo_id"),
                        resultSet.getInt("carroceria_veiculo_id"), resultSet.getInt("categoria_veiculo_id"), resultSet.getInt("combustivel_veiculo_id"),
                        resultSet.getString("renavam"), resultSet.getString("chassi"), resultSet.getString("marca"), resultSet.getString("placa"),
                        resultSet.getString("ano"), resultSet.getString("cor"), resultSet.getString("modelo"));

                veiculos.add(veiculo);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao capturar veiculos");
        }

        return veiculos;
    }

    @Override
    public ArrayList<Veiculo> getVeiculosPelaCarroceria(String carroceria) {
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        String sql = "SELECT veiculo.*, carroceria_veiculo.id as carroceria_id, carroceria_veiculo.nome as carroceria_nome "
                + "FROM `veiculo` JOIN carroceria_veiculo  "
                + "ON veiculo.carroceria_veiculo_id = carroceria_veiculo.id "
                + "WHERE carroceria_veiculo.nome like ?";

        try {
            Veiculo veiculo;

            preparedStatement = conexao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, carroceria);

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                veiculo = new Veiculo(resultSet.getInt("id"), resultSet.getInt("status_veiculo_id"),
                        resultSet.getInt("carroceria_veiculo_id"), resultSet.getInt("categoria_veiculo_id"),
                        resultSet.getInt("combustivel_veiculo_id"), resultSet.getString("renavam"),
                        resultSet.getString("chassi"), resultSet.getString("marca"), resultSet.getString("placa"),
                        resultSet.getString("ano"), resultSet.getString("cor"), resultSet.getString("modelo"));

                veiculos.add(veiculo);
            }

            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
            System.err.println("wewr");
        }

        return veiculos;
    }

    @Override
    public CombustivelVeiculo getCombustivelPeloId(int id) {
        String sql = "SELECT * FROM combustivel_veiculo WHERE id = ?";

        try {
            preparedStatement = conexao.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            if (resultSet.next()) {
                return new CombustivelVeiculo(resultSet.getInt("id"), resultSet.getString("nome"));
            }

            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public CategoriaVeiculo getCategoriaPeloId(int id) {
        String sql = "SELECT * FROM categoria_veiculo WHERE id = ?";

        try {
            preparedStatement = conexao.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                return new CategoriaVeiculo(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getDouble("preco"));
            }

            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public CarroceriaVeiculo getCarroceriaById(int id) {
        String sql = "SELECT * FROM carroceria_veiculo WHERE id = ?";

        try {
            preparedStatement = conexao.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                return new CarroceriaVeiculo(resultSet.getInt("id"), resultSet.getString("nome"));
            }

            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public boolean reservaVeiculo(int idVeiculo, int idCliente) {
        Calendar calendar = Calendar.getInstance();

        String sql = "INSERT INTO cliente_has_veiculo (id, cliente_id, veiculo_id, data_inicio, data_fim) "
                + "VALUES(?, ? ,? ,? ,?)";

        try {
            preparedStatement = conexao.getConnection().prepareStatement(sql);

            preparedStatement.setNull(1, Types.INTEGER);
            preparedStatement.setInt(2, idCliente);
            preparedStatement.setInt(3, idVeiculo);
            preparedStatement.setDate(4, new Date(calendar.getTimeInMillis()));

            calendar.add(Calendar.DAY_OF_YEAR, 7);
            preparedStatement.setDate(5, new Date(calendar.getTimeInMillis()));

            preparedStatement.execute();

            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();

            return false;
        }
    }

    public boolean updateStatusVeiculo(int id, int status) {
        String sql = "UPDATE veiculo SET status_veiculo_id = ? where id = ?";

        try {
            preparedStatement = conexao.getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, status);
            preparedStatement.setInt(2, id);

            preparedStatement.execute();

            preparedStatement.close();

            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();

            return false;
        }
    }

    public Veiculo getVeiculoById(int id) {
        String sql = "SELECT * FROM veiculo WHERE id = ?";

        try {
            preparedStatement = conexao.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                return new Veiculo(resultSet.getInt("id"), resultSet.getInt("status_veiculo_id"),
                        resultSet.getInt("carroceria_veiculo_id"), resultSet.getInt("categoria_veiculo_id"),
                        resultSet.getInt("combustivel_veiculo_id"), resultSet.getString("renavam"),
                        resultSet.getString("chassi"), resultSet.getString("marca"), resultSet.getString("placa"),
                        resultSet.getString("ano"), resultSet.getString("cor"), resultSet.getString("modelo"));
            }

            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public ArrayList<ClienteHasVeiculo> getVeiculosAlugadosByCliente(int id) {
        ArrayList<ClienteHasVeiculo> clienteHasVeiculos = new ArrayList<>();

        String sql = "SELECT * FROM cliente_has_veiculo WHERE cliente_id = ?";

        try {
            preparedStatement = conexao.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                clienteHasVeiculos.add(new ClienteHasVeiculo(resultSet.getInt("id"), resultSet.getInt("cliente_id"), resultSet.getInt("veiculo_id"),
                        resultSet.getDate("data_inicio"), resultSet.getDate("data_fim")));
            }

            preparedStatement.close();

            return clienteHasVeiculos;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public boolean naoReservaVeiculo(int id) {
        String sql = "DELETE FROM cliente_has_veiculo WHERE id = ?";

        try {
            preparedStatement = conexao.getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao deletar relação veículo cliente");
        }

        return false;
    }
    
        public boolean naoReservaVeiculoByVeiculoId(int id) {
        String sql = "DELETE FROM cliente_has_veiculo WHERE veiculo_id = ?";

        try {
            preparedStatement = conexao.getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao deletar relação veículo cliente");
        }

        return false;
    }
        
    public String getStatusById(int id) {
        String sql = "SELECT * FROM status_veiculo WHERE id = ?";

        try {
            preparedStatement = conexao.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                return resultSet.getString("nome");
            }

            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public void fechaConexao() {
        conexao.fechaConexao();
    }
}
