package com.studying.axenixdemo.AlgoritmTasks;

public class TaskOne {
    public static void main(String[] args) {
        //Напиши функцию, которая проверяет, является ли строка палиндромом.
        //Палиндром — это слово, фраза или последовательность символов, которая читается одинаково слева направо и справа налево.

        //Требования:
        //•	Игнорируй регистр букв (например, "А роза упала на лапу Азора" — палиндром)
        //•	Игнорируй пробелы и знаки препинания (.,!?- и т.д.)
        //•	Функция должна возвращать true/false или аналогичный булевый результат
        //Вариант 1. Через for сравнить каждый индекс через ignorecase

    }

    public boolean isPalindrome(String s){
        String cleanedStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = cleanedStr.length() - 1;

        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
