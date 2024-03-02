package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        long res = countEntries(str1, str2);
        System.out.println(res);
    }

    public static long countEntries(String str1, String str2) {
        Matcher matcher = Pattern.compile(str2).matcher(str1);

        return matcher.results().count();
    }
}