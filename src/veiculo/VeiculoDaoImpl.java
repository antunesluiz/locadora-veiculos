/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculo;

import cliente.Cliente;
import cliente.StatusCliente;
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
                        resultSet.getDate("ano"), resultSet.getString("cor"), resultSet.getString("modelo"));
                
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
        
        String sql = "SELECT veiculo.*, status_veiculo.id as status_id, carroceria_veiculo.id as carroceira_id, carroceria_veiculo.id as categoria_id, combustivel_veiculo.id as combustivel_id "
                + "FROM `veiculo` as veiculo JOIN carroceria_veiculo as carroceria_veiculo JOIN status_veiculo as status_veiculo JOIN categoria_veiculo JOIN combustivel_veiculo "
                + "ON veiculo.status_veiculo_id = status_veiculo.id AND veiculo.carroceria_veiculo_id = carroceria_veiculo.id AND veiculo.categoria_veiculo_id = categoria_veiculo.id AND veiculo.combustivel_veiculo_id = combustivel_veiculo.id WHERE status_veiculo_id  = 1";

        
        try {
            Veiculo veiculo;

            preparedStatement = conexao.getConnection().prepareStatement(sql);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                veiculo = new Veiculo(resultSet.getInt("id"), resultSet.getInt("status_id"),
                        resultSet.getInt("carroceira_id"), resultSet.getInt("categoria_id"), resultSet.getInt("combustivel_id"),
                        resultSet.getString("renavam"), resultSet.getString("chassi"), resultSet.getString("marca"), resultSet.getString("placa"),
                        resultSet.getDate("ano"), resultSet.getString("cor"), resultSet.getString("modelo"));
                
                veiculos.add(veiculo);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Erro ao capturar veiculos");
        }
        
        return veiculos;    
    }
  
}
