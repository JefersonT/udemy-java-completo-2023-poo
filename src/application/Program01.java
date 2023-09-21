package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program01 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Client client = new Client();


        System.out.println("Enter cliente data:");
        System.out.printf("Name: ");
        client.setName(sc.nextLine());
        System.out.printf("Email: ");
        client.setEmail(sc.next());
        System.out.printf("Birth date (DD/MM/YYYY): ");
        client.setBirthDate(LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        System.out.println("Enter order data: ");
        System.out.printf("Status: ");
        Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(sc.next()), client);
        System.out.printf("How many items to this order? ");
        int items = sc.nextInt();

        for (int i = 1; i <= items ; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.printf("Product name: ");
            String name = sc.next();
            System.out.printf("Product price: ");
            Double price = sc.nextDouble();
            System.out.printf("Quantity: ");
            Integer qtd = sc.nextInt();

            order.addItem(new OrderItem(qtd, price, new Product(name, price)));
        }

        System.out.println(order);

        sc.close();
    }
}