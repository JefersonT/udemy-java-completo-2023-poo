package application;

import entities.*;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program10 {
    public static void main(String[] args) {
        LocalDateTime moment1 = LocalDateTime.parse("2018-06-21T13:05:44");
        Post post01 = new Post(moment1,
                "Traveling to New Zealand",
                "I'm going to visit this wonderful country!",
                12);

        post01.addComent(new Comment("Have a nice trip"));
        post01.addComent(new Comment("Wow that's awesome!"));

        LocalDateTime moment2 = LocalDateTime.parse("2018-07-28T23:14:19");
        Post post02 = new Post(moment2,
                "Good night guys",
                "See you tommorrow",
                5);

        post02.addComent(new Comment("Good night"));
        post02.addComent(new Comment("May the Force be with you"));

        System.out.println(post01);
        System.out.println(post02);
    }
}