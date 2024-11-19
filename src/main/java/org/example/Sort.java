package org.example;

import java.util.Comparator;

class Sort<T> {
    /**
     * Comparator
     */
    private final Comparator<? super T> comparator;
    /**
     * Constructor that requires a valid comparator.
     * @param comparator - a valid comparator for the elements of the collection.
     */
    public Sort(Comparator<? super  T> comparator) {
        this.comparator = comparator;
    }

    public void sort(MyArrayList<T> arrList) {
        quickSort(arrList, 0, arrList.size() - 1);
    }

    /*Быстрая сортировка
     */
    public void quickSort(MyArrayList<T> sortArr, int low, int high) {
        //завершить,если массив пуст или уже нечего делить
        if (sortArr.size() == 0) return;
        if (low >= high) return;
        //выбираем опорный элемент (посередине массива)
        int border = low + (high - low) / 2;
     //   int border = //sortArr.get(middle)];
        //разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            while (comparator.compare(sortArr.get(i), sortArr.get(border))<0) i++;
            while (comparator.compare(sortArr.get(j), sortArr.get(border))>0) j--;

            // 10 b 10 = 0
            // 10 b 30 = -1
            // 30 b 10 = 1
            if (comparator.compare(sortArr.get(i), sortArr.get(j))>=0) {
                T swap = sortArr.get(i);
                sortArr.add(sortArr.get(j),i);
                sortArr.add(swap,j);
                i++;
                j--;
            }
        }
        //рекурсия для сортировки левой и правой части
        if (low < j) quickSort(sortArr, low, j);
        if (high > i) quickSort(sortArr, i, high);
    }
}