package com.lld.cache.policies;

import com.lld.cache.model.DoubleLinkedList;
import com.lld.cache.model.DoubleLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{
    DoubleLinkedList<Key> dll;
    Map<Key, DoubleLinkedListNode<Key>> mapper;
    public LRUEvictionPolicy(){
        dll = new DoubleLinkedList<>();
        mapper = new HashMap<>();
    }
    @Override
    public void keyAccessed(Key key) {
        System.out.println("Key accessed in LRU cache : "+key);
        if(mapper.containsKey(key)) {
            DoubleLinkedListNode<Key> doubleLinkedListNode = mapper.get(key);
            dll.moveToHead(doubleLinkedListNode);
        }else{
            DoubleLinkedListNode<Key> node = new DoubleLinkedListNode<>(key);
            mapper.put(key, node);
            dll.addAtHead(node);
        }
    }

    @Override
    public Key evictKey() {
        DoubleLinkedListNode<Key> leastRecentlyUsedNode = dll.removeAtTail();
        mapper.remove(leastRecentlyUsedNode.getElement());
        System.out.println("Key evicted for LRU cache : "+leastRecentlyUsedNode.getElement());
        return leastRecentlyUsedNode.getElement();
    }
}
