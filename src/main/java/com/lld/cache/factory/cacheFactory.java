package com.lld.cache.factory;

import com.lld.cache.Cache;
import com.lld.cache.policies.LRUEvictionPolicy;
import com.lld.cache.storage.HashMapStorage;

public class cacheFactory<Key,Value> {

    public Cache<Key,Value> defaultCache(final int capacity){
        return new Cache<>(new LRUEvictionPolicy<>(), new HashMapStorage<>(capacity));
    }
}
