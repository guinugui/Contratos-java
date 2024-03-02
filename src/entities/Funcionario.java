package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.nivelDoFuncionario;

public class Funcionario {

	private String nome;
	private nivelDoFuncionario nivel;
	private Double salarioBase;

	private Departamento departamento;
	private List<horaPorContrato> contratos = new ArrayList<>();

	public Funcionario(String nome, nivelDoFuncionario nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public nivelDoFuncionario getNivel() {
		return nivel;
	}

	public void setNivel(nivelDoFuncionario nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<horaPorContrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<horaPorContrato> contratos) {
		this.contratos = contratos;
	}

	public void addContratos(horaPorContrato contrato) {
		contratos.add(contrato);
	}

	public void removeContratos(horaPorContrato contrato) {
		contratos.remove(contrato);
	}

	public Double renda(Integer ano, Integer mes) {
		double sum = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (horaPorContrato c : contratos) {
			cal.setTime(c.getData());
			int ANO = cal.get(Calendar.YEAR);
			int MES = 1 + cal.get(Calendar.MONTH);
			if (ANO == ano && MES == mes) {
				sum += c.valorTotal();
			}
		}
		return sum;
	}

}
