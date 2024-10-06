package com.lld.cache.storage;

import com.lld.cache.exception.NotFoundException;
import com.lld.cache.exception.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<K,V> implements Storage<K,V> {
    Map<K,V> storage;
    final int capacity;
    public HashMapStorage(int capacity){
        storage = new HashMap<>();
        this.capacity = capacity;
    }
    @Override
    public void put(K key, V value) {
        if(storage.containsKey(key)){
            System.out.println("Key found replacing with new value : "+key);
            storage.put(key, value);
        }
        else {
            if (isStorageFull()) {
                throw new StorageFullException("Exception in Adding the element, Storage is Full");
            }
            System.out.println("Inserting key to storage "+key);
            storage.put(key, value);
        }
    }

    @Override
    public V get(K key) {
        if(!storage.containsKey(key)){
            throw new NotFoundException("Element not found for key : "+key);
        }
        return storage.get(key);
    }

    @Override
    public void remove(K key) {
        if(!storage.containsKey(key)){
            throw new NotFoundException("Element not found for key : "+key);
        }
        storage.remove(key);
    }
    private boolean isStorageFull(){
        return storage.size()>=capacity;
    }
}
