package com.lld.cache.model;

public class DoubleLinkedList<E> {
    DoubleLinkedListNode<E> head;
    DoubleLinkedListNode<E> tail;

    public DoubleLinkedList(){
        head = new DoubleLinkedListNode<>(null);
        tail = new DoubleLinkedListNode<>(null);
        head.next = tail;
        tail.prev = head;
    }

    public void addAtHead(DoubleLinkedListNode<E> node){
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    public DoubleLinkedListNode<E> removeAtTail(){
        DoubleLinkedListNode<E> node = tail.prev;
        DoubleLinkedListNode<E> prev = tail.prev.prev;
        DoubleLinkedListNode<E> next = tail;
        prev.next = next;
        next.prev = prev;
        return node;
    }

    public void detachNode(DoubleLinkedListNode<E> node){
        DoubleLinkedListNode<E> prev = node.prev;
        DoubleLinkedListNode<E> next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void moveToHead(DoubleLinkedListNode<E> node){
        detachNode(node);
        addAtHead(node);
    }

}
