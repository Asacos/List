package org.example;

public class ArrayList<T>{
    private Object[] data;
    private int size;
    private int capacity = 10;

    public ArrayList() {
        data = new Object[capacity];
        size = 0;
    }

    /**
     *
     * Расширение при заполненности и добавление элемента следующим по списку
     */
    public void add(T t) {
        expand();
        data[size++] = t;
    }

    /**
     *
     * Смещение после индекса для удаления
     */
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < (size - 1); i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
    }

    /**
     *
     * Получение элемента по индексу
     */
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    /**
     *
     * Изменение элемента по индексу
     */
    public void set(int index, T t) {
        checkIndex(index);
        data[index] = t;
    }

    /**
     *
     * Получение количества элементов
     */
    public int size() {
        return size;
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

    /**
     *
     * Проверка индекса на выход за рамки
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
