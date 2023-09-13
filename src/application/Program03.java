package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program03 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("How many employees will be registered? ");
        int qtd = sc.nextInt();
        System.out.println();

        List<Employee> employeeList = new ArrayList<>();

        for (int i = 1; i <= qtd; i++) {
            System.out.println("Employee #" + i + ":");
            System.out.print("ID: ");
            int id = sc.nextInt();
            while (hasId(employeeList, id)) {
                System.out.print("Id already taken. Try again: ");
                id = sc.nextInt();
            }
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            employeeList.add(new Employee(id, name, salary));
            System.out.println();
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        Employee emp = employeeList.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
        if (emp == null) {
            System.out.println("This id does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }

        System.out.println();
        System.out.println("List of employees: ");
        employeeList.stream().forEach(e -> System.out.println(e));

        sc.close();
    }

    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}