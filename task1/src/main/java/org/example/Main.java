package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        calc(a, b, c);
    }

    public static String calc(int a, int b, int c) {
        if (a == 0) {
            System.out.println("Это не квадратное уравнение (a = 0)");
            return "Это не квадратное уравнение (a = 0)";
        }

        int D = b * b - 4 * a * c;
        System.out.println("a: " + a + " b: " + b + " c: " + c + " D: " + D);

        if (D > 0) {
            double x1, x2;
            x1 = (-b + Math.sqrt(D)) / (2 * a);
            x2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.println("Корни уравнения: x1 = " + x1 + ", x2 = " + x2);
            return "x1 = " + x1 + ", x2 = " + x2;
        } else if (D == 0) {
            double x;
            x = -b / (2 * a);
            System.out.println("Уравнение имеет единственный корень: x = " + x);
            return "x1=x2=" + x;
        }

        System.out.println("Уравнение не имеет действительных корней!");
        return "Уравнение не имеет действительных корней!";
    }
}