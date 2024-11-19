package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    public void add() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(3);
        Assert.assertEquals(3, myArrayList.get(myArrayList.size()-1).intValue());
    }

    @Test
    public void testAdd() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(3);
        myArrayList.add(3);
        myArrayList.add(5,0);
        Assert.assertEquals(5, myArrayList.get(0).intValue());
    }

    @Test
    public void CreateNew(){
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        Assert.assertEquals(0, myArrayList.size());
    }

    @Test
    void sort() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(0);
        myArrayList.add(-1);
        myArrayList.add(-2);
        myArrayList.add(-3);
        Sort<Integer> sorted = new Sort<>(Comparator.naturalOrder());
        sorted.sort(myArrayList);
        assertAll("Проверка сортировки массива",
                () -> assertEquals(-3,myArrayList.get(0).intValue()),
                () -> assertEquals(-2,myArrayList.get(1).intValue()),
                () -> assertEquals(-1,myArrayList.get(2).intValue()),
                () -> assertEquals(0,myArrayList.get(3).intValue()),
                () -> assertEquals(1,myArrayList.get(4).intValue()),
                () -> assertEquals(2,myArrayList.get(5).intValue()),
                () -> assertEquals(3,myArrayList.get(6).intValue()));

    }

    @Test
    void get() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(5,0);
        Assert.assertEquals(5, myArrayList.get(0).intValue());
        Assert.assertEquals(3, myArrayList.get(1).intValue());
    }

    @Test
    void removeAll() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.removeAll();
        Assert.assertEquals(0, myArrayList.size());
    }

    @Test
    void remove() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(5);
        myArrayList.add(7);
        myArrayList.remove(2);
        Assert.assertEquals(7, myArrayList.get(2).intValue());
    }

    @Test
    void size() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(3);
        Assert.assertEquals(2, myArrayList.size());
    }
}