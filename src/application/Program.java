package application;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Pessoa> list = new ArrayList<>();

        System.out.printf("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            sc.nextLine();
            System.out.printf("Individual or company (i/c)? ");
            char tipo = sc.next().charAt(0);
            System.out.printf("Name: ");
            String nome = sc.next();
            System.out.printf("Anual income: ");
            Double rendaAnual = sc.nextDouble();

            if (tipo == 'i') {
                System.out.printf("Health expenditures: ");
                Double gs = sc.nextDouble();

                list.add(new PessoaFisica(nome, rendaAnual, gs));
            } else {
                System.out.printf("Number of employees: ");
                Integer nf = sc.nextInt();

                list.add(new PessoaJuridica(nome, rendaAnual, nf));
            }
        }
        System.out.println();
        System.out.println("TAXES PAID:");
        Double ti = 0.0;
        for (Pessoa p : list) {
            System.out.println(p.getNome() + ": $ " + String.format("%.2f", p.calcularImposto()));
            ti += p.calcularImposto();
        }

        System.out.println();
        System.out.println("TOTAL TAXES: $ " + ti);



        sc.close();

    }
}