/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculo;

import java.util.ArrayList;

/**
 *
 * @author Luiz Antunes
 */
public interface iVeiculoDao {

    public ArrayList<Veiculo> getVeiculos();

    public ArrayList<Veiculo> getVeiculosDisponiveis();

    public ArrayList<Veiculo> getVeiculosPelaCarroceria(String carroceria);

    public CombustivelVeiculo getCombustivelPeloId(int id);

    public CategoriaVeiculo getCategoriaPeloId(int id);

    public CarroceriaVeiculo getCarroceriaById(int id);
}
