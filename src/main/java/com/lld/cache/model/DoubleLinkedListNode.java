package com.lld.cache.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoubleLinkedListNode<E> {
    DoubleLinkedListNode<E> prev;
    DoubleLinkedListNode<E> next;
    E element;
    public DoubleLinkedListNode(E element){
        this.element = element;
        prev = null;
        next = null;
    }
}
