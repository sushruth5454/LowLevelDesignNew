package com.lld.cache.storage;

public interface Storage<K,V> {
    void put(K key, V value);
    V get(K key);
    void remove(K key);
}
