package org.example;

public class LinkedList<T> {
    /**
     * Внутренний класс для нодов(узлов)
     */
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     *
     * Добавление элемента в конец списка
     * Если список пуст, нода становится головой и хвостом
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     *
     * Добавление элемента по индексу
     * Новая нода становится предыдущей для текущей и следующей для предыдущей
     */
    public void add(int index, T data) {
        checkIndex(index);
        Node<T> newNode = new Node<>(data);

        if (index == size) {
            add(data);
        } else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        } else {
            Node<T> current = getNode(index);
            Node<T> prevNode = current.prev;

            newNode.prev = prevNode;
            newNode.next = current;

            prevNode.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    /**
     *
     * Получение элемента по индексу
     */
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    /**
     *
     * Изменение элемента по индексу
     */
    public void set(int index, T data) {
        checkIndex(index);
        getNode(index).data = data;
    }

    /**
     *
     * Удаление элемента по индексу
     */
    public void remove(int index) {
        checkIndex(index);
        Node<T> current = getNode(index);

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        size--;
    }

    /**
     *
     * Получение размера списка
     */
    public int size() {
        return size;
    }

    /**
     *
     * Получение ноды по индексу
     * Данный алгоритм оптимизирован на поиск с головы или хвоста (в зависимости от того, откуда ближе)
     */
    private Node<T> getNode(int index) {
        Node<T> current;

        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    /**
     *
     * Проверка индекса на выход за рамки
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

}
