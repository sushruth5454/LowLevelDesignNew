package com.lld.cache;

import com.lld.cache.exception.NotFoundException;
import com.lld.cache.exception.StorageFullException;
import com.lld.cache.policies.EvictionPolicy;
import com.lld.cache.storage.Storage;

public class Cache<K,V> {
    public final EvictionPolicy<K> evictionPolicy;
    public final Storage<K,V> storage;

    public Cache(EvictionPolicy<K>evictionPolicy, Storage<K,V>storage){
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(K key, V value){
        try {
            storage.put(key, value);
            evictionPolicy.keyAccessed(key);
        }catch (StorageFullException exception){
            System.out.println("Got storage full. Will try to evict.");
            K keyToBeEvicted = evictionPolicy.evictKey();
            storage.remove(keyToBeEvicted);
            put(key, value);
        }
    }

    public V get(K key){
        try {
            V value = storage.get(key);
            evictionPolicy.keyAccessed(key);
            return value;
        }catch (NotFoundException exception){
            System.out.println("Element not found in storage : "+key);
            return null;
        }
    }

}
