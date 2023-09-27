package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();
        System.out.printf("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.printf("Common, used or imported (c/u/i)? ");
            char cui = sc.next().charAt(0);
            System.out.printf("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.printf("Price: ");
            Double price = sc.nextDouble();

            if (cui == 'i') {
                System.out.printf("Customs fee: ");
                Double cf = sc.nextDouble();
                list.add(new ImportedProduct(name,price, cf));
            } else if (cui == 'u') {
                System.out.printf("Manufacture date (DD/MM/YYYY): ");
                LocalDate md = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                list.add(new UsedProduct(name, price, md));
            } else {
                list.add(new Product(name, price));
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");
        list.stream().forEach(product -> System.out.println(product.priceTag()));

        sc.close();
    }
}