package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.horaPorContrato;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date n = sdf.parse("24/03/2002");
		
		horaPorContrato hor = new horaPorContrato(n, 5.0, 5);
		
		System.out.println(hor.valorTotal());
		
		
		
		
		sc.close();
	}

}
