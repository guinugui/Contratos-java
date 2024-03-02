package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departamento;
import entities.Funcionario;
import entities.horaPorContrato;
import entities.enums.nivelDoFuncionario;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/yyyy");
		
		
		System.out.println("Qual o nome do departamento: ");
		String nomeDoDepartamento = sc.nextLine();
		
		System.out.println("Dados do Funcionario: ");
		System.out.println("Nome: ");
		String nome = sc.nextLine();
		System.out.println("Qual é o Nivel do funcionario: ");
		String nivelFuncionario = sc.nextLine();
		System.out.println("Qual e a base salario do funcionario: ");
		double salarioBase = sc.nextDouble();
		
		Funcionario fun = new Funcionario(nome, nivelDoFuncionario.valueOf(nivelFuncionario), salarioBase, new Departamento(nomeDoDepartamento));
		
		System.out.println("Informe quantos contratos seram associados: ");
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			System.out.println("Adicione o #" + i + 1 + " contrato : ");
			System.out.println("Data do contrato: ");
			Date data = sdf.parse(sc.next());
			System.out.println("Valor por horas trabalhadas: ");
			double valorPorHora = sc.nextDouble();
			System.out.println("Informe qual foi o total de horas trabalhadas: ");
			int horas = sc.nextInt();
			
			horaPorContrato contratos = new horaPorContrato(data, valorPorHora, horas);
			fun.addContratos(contratos);
		}
		System.out.println("Informe o mes e ano para saber a renda total: (MM/yyyy) ");
		String dataMesEAno = sc.next();
		int mes = Integer.parseInt(dataMesEAno.substring(0, 2));
		int ano = Integer.parseInt(dataMesEAno.substring(3));
		System.out.println("Nome: " + fun.getNome());
		System.out.println("Departamento: " + fun.getDepartamento().getNome());
		System.out.println("A renda do dias " + dataMesEAno + " foram de: " + String.format("%.2f", fun.renda(ano, mes)));
		
		
		
		
		sc.close();
	}

}
