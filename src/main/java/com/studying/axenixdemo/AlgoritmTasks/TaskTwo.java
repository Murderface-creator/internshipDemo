package com.studying.axenixdemo.AlgoritmTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskTwo {
    //Реализуй функцию поиска элемента в массиве/списке.
    //Можно использовать любой алгоритм поиска (линейный, бинарный и т.д.), но нужно обосновать свой выбор.
    //Требования:
    //•	Функция принимает массив/список и искомый элемент
    //•	Возвращает индекс элемента, если он найден, или -1 (либо другое значение, указывающее на отсутствие)
    //•	Если в массиве несколько одинаковых элементов, верни индекс первого найденного
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<String> list2 = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e", "f"));

        System.out.println(findElement(list, 3));
        System.out.println(findElement(list2, "e"));
    }

        public static <T> int findElement(List<T> list, T element){
            if(list == null&&element == null){
                return -1;
            }
            for(int i = 0; i<list.size(); i++){
                if(list.get(i).equals(element)){
                    return i;
                }
            }
            return -1;
        }
}
