package application;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Program07 {
    public static void main(String[] args) {


        LocalDate d04 = LocalDate.parse("2023-09-13");
        LocalDateTime d05 = LocalDateTime.parse("2023-09-13T18:20:30");
        Instant d06 = Instant.parse("2023-09-13T20:25:30Z");

        LocalDate pastWeekLocalDate = d04.minusDays(7);
        LocalDate nextWeekLocalDate = d04.plusDays(7);
        LocalDate nextYearsLocalDate = d04.plusYears(7);

        System.out.println("Past Week Local Date = " + pastWeekLocalDate);
        System.out.println("Next Week Local Date = " + nextWeekLocalDate);
        System.out.println("Next Years Local Date = " + nextYearsLocalDate);

        LocalDateTime pastWeekLocalDateTime = d05.minusDays(7);
        LocalDateTime nextWeekLocalDateTime = d05.plusDays(7);
        LocalDateTime nextYearsLocalDateTime = d05.plusYears(7);

        System.out.println("Past Week Local Date Time = " + pastWeekLocalDateTime);
        System.out.println("Next Week Local Date Time = " + nextWeekLocalDateTime);
        System.out.println("Next Years Local Date Time = " + nextYearsLocalDateTime);

        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);

        System.out.println("Past Week Local Date Time = " + pastWeekInstant);
        System.out.println("Next Week Local Date Time = " + nextWeekInstant);

        Duration t1 = Duration.between(pastWeekLocalDateTime, d05);
        Duration t2 = Duration.between(pastWeekLocalDate.atTime(0,0), d04.atTime(0,0));
        Duration t3 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atStartOfDay());
        Duration t4 = Duration.between(pastWeekInstant, d06);
        Duration t5 = Duration.between(d06, pastWeekInstant);

        System.out.println("t1 dias = " + t1.toDays());
        System.out.println("t2 dias = " + t2.toDays());
        System.out.println("t3 dias = " + t3.toDays());
        System.out.println("t4 dias = " + t4.toDays());
        System.out.println("t5 dias = " + t5.toDays());
    }
}