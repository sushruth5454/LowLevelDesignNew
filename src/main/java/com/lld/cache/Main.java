package com.lld.cache;

import com.lld.cache.factory.CacheFactory;

public class Main {
    public static void main(String[] args) {
        CacheFactory<Integer, Integer> cacheFactory = new CacheFactory<>();
        Cache<Integer, Integer> cache = cacheFactory.defaultCache(3);

        cache.put(1, 2);
        cache.put(2, 3);
        cache.put(4, 6);
        cache.put(6, 6);
        cache.put(9, 8);
        System.out.println(cache.get(2));
        System.out.println(cache.get(4));
        System.out.println(cache.get(1));
        cache.put(9, 4);
        cache.put(10, 1);

    }
}
