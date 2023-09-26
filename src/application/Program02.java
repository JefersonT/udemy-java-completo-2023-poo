
package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

import java.util.Locale;
import java.util.Scanner;

public class Program02 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        sc.close();

        // polimorfismo
        Account acc = new Account(1001, "Alex", 1000.0);
        Account acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
        acc.withdraw(200.00);
        acc2.withdraw(200.00);

        System.out.println(acc.getBalance());
        System.out.println(acc2.getBalance());
    }
}