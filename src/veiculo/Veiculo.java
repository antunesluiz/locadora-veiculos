package veiculo;

import java.sql.Date;

public class Veiculo {

    private int id;
    private int statusVeiculo;
    private int carroceriaVeiculo;
    private int categoriaVeiculo;
    private int combustivelVeiculo;
    private String renavam;
    private String chassi;
    private String marca;
    private String placa;
    private String ano;
    private String cor;
    private String modelo;

    public Veiculo(int id, int statusVeiculo, int carroceriaVeiculo,
            int categoriaVeiculo, int combustivelVeiculo, String renavam, String chassi,
            String marca, String placa, String ano, String cor, String modelo) {
        super();

        this.id = id;
        this.statusVeiculo = statusVeiculo;
        this.carroceriaVeiculo = carroceriaVeiculo;
        this.categoriaVeiculo = categoriaVeiculo;
        this.combustivelVeiculo = combustivelVeiculo;
        this.renavam = renavam;
        this.chassi = chassi;
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatusVeiculo() {
        return statusVeiculo;
    }

    public void setStatusVeiculo(int statusVeiculo) {
        this.statusVeiculo = statusVeiculo;
    }

    public int getCarroceriaVeiculo() {
        return carroceriaVeiculo;
    }

    public void setCarroceriaVeiculo(int carroceriaVeiculo) {
        this.carroceriaVeiculo = carroceriaVeiculo;
    }

    public int getCategoriaVeiculo() {
        return categoriaVeiculo;
    }

    public void setCategoriaVeiculo(int categoriaVeiculo) {
        this.categoriaVeiculo = categoriaVeiculo;
    }

    public int getCombustivelVeiculo() {
        return combustivelVeiculo;
    }

    public void setCombustivelVeiculo(int combustivelVeiculo) {
        this.combustivelVeiculo = combustivelVeiculo;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Veiculo [id=" + id + ", statusVeiculo=" + statusVeiculo + ", carroceriaVeiculo=" + carroceriaVeiculo
                + ", categoriaVeiculo=" + categoriaVeiculo + ", combustivelVeiculo=" + combustivelVeiculo + ", renavam="
                + renavam + ", chassi=" + chassi + ", marca=" + marca + ", placa=" + placa + ", ano=" + ano + ", cor="
                + cor + ", modelo=" + modelo + "]";
    }
}
