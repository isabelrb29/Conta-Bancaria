package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//Menu principal
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int accNumber = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String accHolder = sc.nextLine();
		System.out.print("Initial Balance: ");
		double initialBalance = sc.nextDouble();
		System.out.print("Withdraw Limit: ");
		double withdrawLimit = sc.nextDouble();
		
		Account acc = new Account(accNumber, accHolder,initialBalance, withdrawLimit);
		
		//Valor de saque
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		
		//Verificando quantidade para saque e imprimindo valor em conta
		try {
			acc.withdraw(amount);
			System.out.printf("New balance: %.2f", acc.getBalance());
		}
		catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
