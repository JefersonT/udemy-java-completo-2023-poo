package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.printf("Number: ");
        Integer number = sc.nextInt();
        System.out.printf("Holder: ");
        String holder = sc.next();
        sc.nextLine();
        System.out.printf("Initial balance: ");
        Double balance = sc.nextDouble();
        System.out.printf("Withdraw limit: ");
        Double withdrawLimit = sc.nextDouble();

        Account account = new Account(number, holder, balance, withdrawLimit);

        System.out.println();
        try {
            System.out.printf("Enter amount for withdraw: ");
            account.withdraw(sc.nextDouble());
            System.out.println("new balance: " + account.getBalance());
        } catch (DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error, message: " + e.getMessage());
        }


        sc.close();
    }
}