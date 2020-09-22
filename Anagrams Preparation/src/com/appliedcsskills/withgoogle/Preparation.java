package com.appliedcsskills.withgoogle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Preparation {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            HashMap<String, String> dictionary = new HashMap<>();
            Document document = Jsoup.connect("https://unstats.un.org/unsd/methodology/m49/").get();
            for (int i = 2, n = document.select("#ENG_COUNTRIES > table > tbody > tr").size(); i <= n; i++) {
                String country = "#ENG_COUNTRIES > table > tbody > tr:nth-child("+i+") > td:nth-child(1)";
                country = document.select(country).text();
                String code = "#ENG_COUNTRIES > table > tbody > tr:nth-child("+i+") > td:nth-child(3)";
                code = document.select(code).text();
                dictionary.put(code,country);
            }
            while (true) {
                System.out.println(dictionary.getOrDefault(scanner.nextLine(),"Invalid code!"));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
