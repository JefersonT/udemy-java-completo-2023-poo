package application;


import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Shape> list = new ArrayList<>();

        System.out.printf("Enter the number of shapes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Shape #" + i + " data:");
            sc.nextLine();
            System.out.printf("Rectanble or Circle (r/c)? ");
            char shape = sc.next().charAt(0);
            System.out.printf("Color (BLACK/BLUE/RED): ");
            Color color = Color.valueOf(sc.next());

            if (shape == 'c' ) {

                System.out.printf("Radius: ");
                Double radius = sc.nextDouble();

                list.add(new Circle(color, radius));

            } else {
                System.out.printf("Width: ");
                Double width = sc.nextDouble();

                System.out.printf("Heigth: ");
                Double heigth = sc.nextDouble();

                list.add(new Rectangle(color, width, heigth));

            }

        }

        System.out.println();
        System.out.println("SHAPE AREAS: ");
        list.forEach(shape -> System.out.println(String.format("%.2f", shape.area())));

        sc.close();

    }
}