package org.example;

import java.util.Random;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {

    public static String calculate(String expression) {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("nashorn");
            Object result = engine.eval(expression);

            System.out.println("Результат выражения " + expression + " равен: " + result);
            return result.toString();
        } catch (ScriptException e) {
            System.err.println("Ошибка при вычислении выражения: " + e.getMessage());
            return "fail";
        }
    }
//    нагрузочное тестирование
//    public static void main(String[] args) {
//        int numberOfExpressions = 100; // Количество выражений для вычисления
//        Random random = new Random();
//
//        long startTime = System.nanoTime();
//
//        for (int i = 0; i < numberOfExpressions; i++) {
//            int num1 = random.nextInt(100); // Генерируем случайные числа от 0 до 99
//            int num2 = random.nextInt(100);
//            char operator = randomOperator();
//
//            String expression = num1 + " " + operator + " " + num2;
//            String result = Main.calculate(expression);
//        }
//
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime) / 1000000; // Преобразуем наносекунды в миллисекунды
//
//        System.out.println("Нагрузочное тестирование выполнено за " + duration + " мс");
//    }

    public static char randomOperator() {
        char[] operators = {'+', '-', '*', '/'};
        Random random = new Random();
        return operators[random.nextInt(operators.length)];
    }


    public static void main(String[] args) {
        int numberOfThreads = 100000; // Количество потоков для параллельного выполнения
        int numberOfExpressionsPerThread = 16; // Количество выражений для вычисления в каждом потоке
        Random random = new Random();

        long startTime = System.nanoTime();

        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < numberOfExpressionsPerThread; j++) {
                    int num1 = random.nextInt(100);
                    int num2 = random.nextInt(100);
                    char operator = randomOperator();

                    String expression = num1 + " " + operator + " " + num2;
                    String result = Main.calculate(expression);
                }
            });
            threads[i].start();
        }

        // Ждем завершения всех потоков
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("Нагрузочное тестирование с параллельными запросами выполнено за " + duration + " мс");
    }

}