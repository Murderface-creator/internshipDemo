package com.studying.axenixdemo.AlgoritmTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskThree {
    //Реализуй один из алгоритмов сортировки на выбор:
    //•	Сортировка пузырьком (Bubble Sort)
    //•	Сортировка выбором (Selection Sort)
    //•	Сортировка вставками (Insertion Sort)
    //•	Быстрая сортировка (Quick Sort)
    //•	Сортировка слиянием (Merge Sort)
    //Требования:
    //•	Функция принимает массив/список чисел
    //•	Возвращает отсортированный массив/список по возрастанию
    //•	Алгоритм должен быть реализован самостоятельно (не использовать встроенные функции сортировки)
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(5, 2, 8, 9, 22, 0, 1, 4, 7, 3, 2, 9));
        List<Integer> list2 = new ArrayList<>(list);
        System.out.println(bubleSort(list));
        System.out.println(selectionSort(list2));
    }
    //Сортировка пузырьком
    public static List<Integer> bubleSort (List<Integer> list) {
        for(int i = 0; i<list.size(); i++){
            for(int j = i+1; j<list.size(); j++){
                if(list.get(i)>list.get(j)){
                    int x = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, x);
                }
            }
        }
        return list;
    }

    public static List<Integer> selectionSort(List<Integer> list) {
        for(int i = 0; i<list.size(); i++){
            int min = list.get(i);
            for(int j = i+1; j<list.size(); j++){
                if(min>list.get(j)){
                    list.set(i, list.get(j));
                    list.set(j, min);
                    min = list.get(i);
                }
            }
        }
        return list;
    }
}
