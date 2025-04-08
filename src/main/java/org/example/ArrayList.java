package org.example;

public class ArrayList{
    private Object[] data;
    private int size;
    private int capacity = 10;

    public ArrayList() {
        data = new Object[capacity];
        size = 0;
    }

    /**
     * Расширение массива при заполненности
     */
    private void expand() {
        if (capacity == size) {
            capacity = (int)(capacity * 1.5);
            Object[] data1 = new Object[capacity];
            for (int i = 0; i < size; i++) {
                data1[i] = data[i];
            }
            data = data1;
        }
    }

    public void add(Object o) {
        expand();
        data[size++] = o;
    }

    /**
     *
     * Смещение после индекса для удаления
     */
    public void remove(int index) {
        for (int i = index; i < (size - 1); i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
    }

    public Object get(int index) {
        return data[index];
    }

    public void set(int index, Object o) {
        data[index] = o;
    }

    /**
     *
     * Присвоение новому массиву значений от start до end старого массива
     */
    public Object[] subList(int start, int end) {
        Object[] data1 = new Object[end - start];
        for (int i = start; i < end; i++) {
            data1[i] = data[i];
        }
        return data1;
    }

    public int size() {
        return size;
    }
}
