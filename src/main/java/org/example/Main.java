package org.example;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> marrList = new MyArrayList<>();
        marrList.add(10);
        marrList.add(0);
        marrList.add(30);
        marrList.add(20);
        marrList.add(33);


        Sort<Integer> sorted = new Sort<>(Comparator.naturalOrder());
        sorted.sort(marrList);
        marrList.get(0);
        marrList.get(1);
        marrList.get(2);
    }
}