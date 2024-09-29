package ua.lis.mvc4.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class test1 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("specify");
        list.add("Fil");
        list.add("Prada");

        List<String> list1 = new ArrayList<>(list);
 //       list1.addAll(list);

        for (String string: list1){
            System.out.println(string);

        }


    }
    private static void test2(){
        //Метод test2 с методами List
        StringBuilder sb1 = new StringBuilder("A");
        StringBuilder sb2 = new StringBuilder("B");
        StringBuilder sb3 = new StringBuilder("C");
        StringBuilder sb4 = new StringBuilder("D");
        StringBuilder[] array = {sb1, sb2, sb3, sb4};

        List<StringBuilder> list = Arrays.asList(array);  // делает из массива лист
        System.out.println(list);
        array[0].append("!!!");
        System.out.println(list);

        List<Integer> list1 = List.of(2,4,44,54);  //заполняет лист значениями
        System.out.println(list1);
//        list1.add(100); -- но его нельзя модифицировать

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Mariya");
        arrayList1.add("Anna");
        arrayList1.add("Eva");

        List<String> arrayList2 = List.copyOf(arrayList1); //он так-же не изменяемый, и не может содержать null
        System.out.println(arrayList2);
        System.out.println(arrayList1 == arrayList2);

        /* Iterator - бежит по arrayList1 */
        Iterator<String> iterator = arrayList1.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
