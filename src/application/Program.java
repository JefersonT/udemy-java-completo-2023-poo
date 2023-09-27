package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter the number of employees: ");
        int qtd = sc.nextInt();
        List<Employee> employees = new ArrayList<>();
        for (int i = 1; i <= qtd; i++) {
            System.out.println("Employee #" + i + " data:");
            System.out.printf("Outsourced (y/n)? ");
            char ch = sc.next().charAt(0);
            System.out.printf("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.printf("Hours: ");
            Integer hours = sc.nextInt();
            System.out.printf("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            if (ch == 'y') {
                System.out.printf("Additional charge: ");
                Double additionalCharge = sc.nextDouble();
                employees.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            } else {
                employees.add(new Employee(name, hours, valuePerHour));
            }
        }

        System.out.println();
        System.out.println("PAYMENTS:");
        employees.stream().forEach(employee -> System.out.println(employee));

        sc.close();
    }
}