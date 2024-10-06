package com.lld.cache.policies;

public interface EvictionPolicy<K> {
    void keyAccessed(K key);
    K evictKey();
}
