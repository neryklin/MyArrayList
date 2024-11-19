package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T> {
    private final int INIT_SIZE = 16;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    /*
    Comparator
    */

    public void sort(Comparator<? super T> comparator) {
        Sort<T> sorter = new Sort<>(comparator);
        sorter.sort(this);
    }


    /*
    Добавляет новый элемент в список. При гнеобходимости увеличение в два раза.
    */
    public void add(T item) {
        if(pointer == array.length-1)
            resize(array.length*2); // увеличу в 2 раза, если достигли границ
        array[pointer++] = item;
    }


    /*
    Добавляет новый элемент в список по индексу. При гнеобходимости увеличение в два раза.
    */

    public void add(T item, int s) {
        if(pointer == array.length-1)
            resize(array.length*2); // увеличу в 2 раза, если достигли границ
        array[s]=item;
        pointer++;
    }



    /*
    Возвращает элемент списка по индексу.
    */
    public T get(int index) {
        return (T) array[index];
    }


    /*
    Удаляем все.
    */
    public void removeAll() {
        for (int i = pointer-1; i>=1; i--) {
            array[pointer] = null;
        }
        pointer=0;
    }


    /*
    Удаляет элемент списка по индексу. Все элементы справа от удаляемого
    перемещаются на шаг налево.
    */
    public void remove(int index) {
        for (int i = index; i<pointer; i++)
            array[i] = array[i+1];
        array[pointer] = null;
        pointer--;
    }

    /*Возвращает размер*/
    public int size() {
        return pointer;
    }

    /*масштабируем.*/
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}