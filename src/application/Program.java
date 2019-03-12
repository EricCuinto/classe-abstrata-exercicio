package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.Payers;

public class Program {

	public static void main(String[] args) {

		Double totalTaxes = 0.0;

		Locale.setDefault(Locale.US);
		List<Payers> payers = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		System.out.print("Quantos pagadores serão cadastrados? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.print("Pessoa física ou Jurídica? f/j ");
			char p = sc.next().charAt(0);
			sc.nextLine();

			System.out.print("Nome: ");
			String name = sc.next();

			System.out.print("Renda anual: ");
			double anualIncome = sc.nextDouble();

			if (p == 'f') {
				System.out.print("Gastos com saúde: ");
				double healthExpenditures = sc.nextDouble();
				payers.add(new Individual(name, anualIncome, healthExpenditures));
			} else if (p == 'j') {
				System.out.print("Número de funcinários: ");
				int numberOfEmployees = sc.nextInt();
				payers.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}

		System.out.println();
		System.out.println("********************************");
		System.out.println("Pagamentos de taxa: ");
		for (Payers p : payers) {
			System.out.println(p.getName() + ": R$" + String.format("%.2f", p.taxesPaid()));
			totalTaxes += p.taxesPaid();
		}

		System.out.print("Total de pagamentos: R$ " + String.format("%.2f", totalTaxes));
		sc.close();
	}
}
