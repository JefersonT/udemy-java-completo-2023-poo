package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program02 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Account account;
        System.out.print("Enter account number: ");
        int accountNumber = sc.nextInt();
        System.out.print("Enter account holder: ");
        sc.nextLine();
        String accountHolder = sc.nextLine();
        System.out.print("Is there na initial deposit (y/n)? ");
        String initDeposit = sc.nextLine();
        if (initDeposit.equals("y")) {
            System.out.print("Enter initial deposit value: ");
            double deposit = sc.nextDouble();
            account = new Account(accountNumber, accountHolder, deposit);
        } else {
            account = new Account(accountNumber, accountHolder);
        }

        System.out.println("Account data:");
        System.out.println(account);
        System.out.print("Enter a deposit value: ");
        account.deposit(sc.nextDouble());
        System.out.println("Updated account data:");
        System.out.println(account);

        System.out.print("Enter a withdraw value: ");
        account.withdraw(sc.nextDouble());
        System.out.println("Updated account data:");
        System.out.println(account);


        sc.close();
    }
}