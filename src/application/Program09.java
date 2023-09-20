package application;

import entities.Department;
import entities.HourContract;
import entities.Order;
import entities.Worker;
import entities.enums.OrderStatus;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program09 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter department's name: ");
        String department = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Level: ");
        String level = sc.nextLine();
        System.out.print("Base salary: ");
        Double baseSalary = sc.nextDouble();

        Worker worker = new Worker(name, baseSalary, WorkerLevel.valueOf(level), new Department(department));
        System.out.print("How many contracts to this worker? ");
        int qtd = sc.nextInt();

        for (int i = 1; i <= qtd; i++) {
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            String stringDate = sc.next();
            LocalDate date = LocalDate.parse(stringDate.toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();

            worker.addContract(new HourContract(date, valuePerHour, hours));
        }
        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String stringDate = sc.next();
        int year = Integer.parseInt(stringDate.substring(3));
        int monthValue = Integer.parseInt(stringDate.substring(0, 2));

        System.out.println("Name: " + worker.getName());
        System.out.println(worker.getDepartment());
        System.out.println("Income for " + stringDate + ": " + worker.income(year, monthValue));



    }
}