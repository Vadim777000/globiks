package org.example;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
    }

    // 1. Метод sum
    public static int sum(int a, int b) {
        return a + b;
    }

    // 2. Метод разности
    public static int diff(int a, int b) {
        return a - b;
    }

    // 3. Метод произведения
    public static int mul(int a, int b) {
        return a * b;
    }

    // 4. Метод проверки чётности
    public static boolean isEven(int x) {
        return x % 2 == 0;
    }

    // 5. Метод разворота строки
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
