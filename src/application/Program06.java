package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Program06 {
    public static void main(String[] args) {


        LocalDate d04 = LocalDate.parse("2023-09-13");
        LocalDateTime d05 = LocalDateTime.parse("2023-09-13T18:20:30");
        Instant d06 = Instant.parse("2023-09-13T20:25:30Z");

//        ZoneId.getAvailableZoneIds().stream().forEach(s -> System.out.println(s));

        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
        LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);
        System.out.println("r4 = " + r4);

        System.out.println("d04 dia = " + d04.getDayOfMonth());
        System.out.println("d04 mês = " + d04.getMonthValue());
        System.out.println("d04 dia = " + d04.getYear());

        System.out.println("d05 dia = " + d05.getDayOfMonth());
        System.out.println("d05 mês = " + d05.getMonthValue());
        System.out.println("d05 dia = " + d05.getYear());
        System.out.println("d05 dia = " + d05.getHour());
        System.out.println("d05 dia = " + d05.getMinute());
        System.out.println("d05 dia = " + d05.getSecond());
    }
}