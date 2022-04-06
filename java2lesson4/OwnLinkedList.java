package java2lesson4;


import java.util.ArrayList;
import java.util.LinkedList;

public class OwnLinkedList<T> {
    private long size;
    private Node head;
    private Node tail;

    public OwnLinkedList(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void addNode(T data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void addNodeForIndex(int index, T data){
        Node newNode = new Node(data);
        // Обычная проверка размерности
        if(index<0&&index>size){
            throw new indexOutOfBoundException("Индекс больше или меньше размерности коллекции");
        }
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        // Если уже есть начало
        if (head != null) {
            // Индекс первый будет началом, и ссылка на следующую будет началом
            if (index == 0){
                newNode.next = head;
                head = newNode;
            }
            // Если же индекс, то есть и текущая нода не ноль, заполняем все следующие элементы как в display(int index)
            else {
                Node current = head;
                for(int i = 1; i<index; i++){
                    current = current.next;
                }
                // ссылка на след будет следующая текущая
                newNode.next = current.next;
                // а следующая текущая будет тоже ссылкой логично
                current.next = newNode;
            }
        }

        size++;

    }

    public void deleteNodeForIndex(int index) {
        // Обычная проверка размерности
        if (index < 0 && index > size) {
            throw new indexOutOfBoundException("Индекс больше или меньше размерности коллекции");
        } else {
            Node current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            // ссылка на след будет следующая текущая
            Node indexNode = current.next;
            // а следующая текущая будет тоже ссылкой логично
            current.next = indexNode.next;

            if (head == null) {
                throw new lastElementException("При удалении элементов должен быть head!=null");
            }
            indexNode = null;

            size--;

        }
    }


    public void display(){
        Node current = head;

        if(head == null){
            System.out.println("Односвязный список не заполнен");
            return;
        }
        while (current != null){
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void display(int index){
        if(index > size){
            System.out.println("Размер меньше количества индексов односвязного списка");
            return;
        }
        Node current = head;
        for(int i = 1; i<=index; i++){
            current = current.next;
        }

        System.out.println(current.data);
    }


    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
