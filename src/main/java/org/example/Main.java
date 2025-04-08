package org.example;



public class Main {
    public static void main(String[] args) {
        System.out.println("ArrayList");
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.get(1));
        list.remove(2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.set(1, 4);
        System.out.println(list.get(1));
        System.out.println("LinkedList");
        LinkedList list1 = new LinkedList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println(list1.get(1));
        list1.remove(2);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        list1.set(1, 4);
        System.out.println(list1.get(1));
    }
}