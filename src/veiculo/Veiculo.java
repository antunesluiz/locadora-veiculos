package veiculo;

import java.sql.Date;

public class Veiculo {
	private int id;
	private StatusVeiculo statusVeiculo;
	private CarroceriaVeiculo carroceriaVeiculo;
	private CategoriaVeiculo categoriaVeiculo;
	private CombustivelVeiculo combustivelVeiculo;
	private String renavam;
	private String chassi;
	private String marca;
	private String placa;
	private Date ano;
	private String cor;
	private String modelo;
	
	public Veiculo(int id, StatusVeiculo statusVeiculo, CarroceriaVeiculo carroceriaVeiculo,
			CategoriaVeiculo categoriaVeiculo, CombustivelVeiculo combustivelVeiculo, String renavam, String chassi,
			String marca, String placa, Date ano, String cor, String modelo) {
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

	public StatusVeiculo getStatusVeiculo() {
		return statusVeiculo;
	}

	public void setStatusVeiculo(StatusVeiculo statusVeiculo) {
		this.statusVeiculo = statusVeiculo;
	}

	public CarroceriaVeiculo getCarroceriaVeiculo() {
		return carroceriaVeiculo;
	}

	public void setCarroceriaVeiculo(CarroceriaVeiculo carroceriaVeiculo) {
		this.carroceriaVeiculo = carroceriaVeiculo;
	}

	public CategoriaVeiculo getCategoriaVeiculo() {
		return categoriaVeiculo;
	}

	public void setCategoriaVeiculo(CategoriaVeiculo categoriaVeiculo) {
		this.categoriaVeiculo = categoriaVeiculo;
	}

	public CombustivelVeiculo getCombustivelVeiculo() {
		return combustivelVeiculo;
	}

	public void setCombustivelVeiculo(CombustivelVeiculo combustivelVeiculo) {
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

	public Date getAno() {
		return ano;
	}

	public void setAno(Date ano) {
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
