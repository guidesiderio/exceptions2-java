package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data ");

		System.out.print("Number: ");
		int number = sc.nextInt();

		sc.nextLine();

		System.out.print("Holder: ");
		String holder = sc.nextLine();

		System.out.print("Initial balance: ");
		double initialBalance = sc.nextDouble();

		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();

		Account account = new Account(number, holder, initialBalance, withdrawLimit);

		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		
		try {
			account.withdraw(amount);
			System.out.printf("New balance: %.2f\n", account.getBalance());
		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		sc.close();
	}
}
