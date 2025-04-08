package org.example;

import com.sun.jdi.ObjectReference;

public class LinkedList {
    /**
     *
     * Создание элемента списка
     */
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<Object> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     *
     * Добавление нового элемента в конец
     * Если head == null - head'ом становится текущий элемент
     * Иначе текущий элемент становится следующим за последним
     */
    public void add(Object data) {
        Node<Object> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<Object> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     *
     * Если элемент является первым, head'ом становится следующий элемент
     * Иначе элементом по индексу становится следующий элемент
     */
    public void remove(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node<Object> prev = getNode(index - 1);
            prev.next = prev.next.next;
        }
        size--;
    }

    /**
     *
     * Получение данных из элемента по индексу
     */

    public Object get(int index) {
        return getNode(index).data;
    }

    /**
     *
     * Установка нового значения в элемент по индексу
     */
    public void set(int index, Object data) {
        getNode(index).data = data;
    }

    /**
     *
     * Установка в current первого элемента и последовательное добавление элементов до последнего в новый список
     */
    public LinkedList subList(int fromIndex, int toIndex) {
        LinkedList subList = new LinkedList();
        Node<Object> current = getNode(fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(current);
            current = current.next;
        }
        return subList;
    }

    public int size() {
        return size;
    }

    /**
     *
     * Получение элемента по индексу
     */

    private Node<Object> getNode(int index) {
        Node<Object> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}

