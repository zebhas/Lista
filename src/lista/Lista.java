/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import java.util.Iterator;

/**
 *
 * @author Guest
 */
public class Lista<Item extends Comparable<? super Item>> implements Iterable<Item> {

    private Node<Item> first;

    private class Node<Item> {

        Item item;
        Node<Item> next;

        public Node(Item item) {
            this.item = item;
            this.next = null;
        }
    }

    public Lista() {
        first = null;
    }

    public boolean search(Item item) {
        if (isEmpty()) {
            return false;
        } else {
            Node<Item> tmp = first;
            while (tmp != null) {
                if (tmp.item instanceof Persona) {
                    Persona personaTmp = (Persona) tmp.item;
                    if (personaTmp.getNombre().equals(((Persona) item).getNombre()) && personaTmp.getEdad() == ((Persona) item).getEdad()) {
                        return true;
                    }
                }
                tmp = tmp.next;
            }
            return false;
        }

    }

    public Item maxItem() {
        if (isEmpty()) {
            return null;
        }
        Node<Item> tmp = first;
        Item candidato = tmp.item;
        while (tmp != null) {
            if (candidato.compareTo(tmp.item) < 0) {
                candidato = tmp.item;
            }
            tmp = tmp.next;
        }
        return candidato;
    }

    public void addFirst(Item item) {
        Node<Item> nuevo = new Node<Item>(item);
        if (isEmpty() || item.compareTo(first.item) <= 0) {
            nuevo.next = first;
            first = nuevo;
        } else {
            Node<Item> current = first;
            while (current.next != null && item.compareTo(current.next.item) > 0) {
                current = current.next;
            }
            nuevo.next = current.next;
            current.next = nuevo;
        }
    }

    public void addLast(Item item) {
         Node<Item> nuevo = new Node<Item>(item);
    if (isEmpty()) {
        first = nuevo;
    } else if (item.compareTo(first.item) >= 0) {
        Node<Item> tmp = first;
        while (tmp.next != null && item.compareTo(tmp.next.item) >= 0) {
            tmp = tmp.next;
        }
        nuevo.next = tmp.next;
        tmp.next = nuevo;
    } else {
        nuevo.next = first;
        first = nuevo;
    }
}

    public void addEnMedio(Item item) {
        Node<Item> newNode = new Node<>(item);
        if (isEmpty() || item.compareTo(first.item) <= 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node<Item> current = first;
            while (current.next != null && item.compareTo(current.next.item) > 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }




    public Item removeLast() {
        if (isEmpty()) {
            return null;
        } else if (first.next == null) {
            Item item = first.item;
            first = null;
            return item;
        } else {
            Node<Item> tmp = first;
            Node<Item> before = null;
            while (tmp.next != null) {
                before = tmp;
                tmp = tmp.next;
            }
            before.next = null;
            return tmp.item;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        Node<Item> tmp = first;
        int i = 0;
        while (tmp != null) {
            tmp = tmp.next;
            i++;
        }
        return i;
    }

    public void showList() {
        Node<Item> tmp = first;
        while (tmp != null) {
            System.out.println(tmp.item);
            tmp = tmp.next;
        }
    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                return null;
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
