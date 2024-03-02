package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Departamento;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		
		Departamento depat = new Departamento("Desing");
		System.out.println("Nome; " + depat.getNome());
		
		
		
		sc.close();
	}

}
