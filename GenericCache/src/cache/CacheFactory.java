package cache;

import java.util.HashMap;
import java.util.Map;

public class CacheFactory {

    private static CacheFactory single_instance = null;
    private final Map<String, CacheImpl> cacheMap;

    private CacheFactory() {
        cacheMap = new HashMap<>();
    }
    public static CacheFactory getInstance() {
        if (single_instance == null) {
            single_instance = new CacheFactory();

        }
        return single_instance;
    }

    public CacheImpl createCache(String cacheName) {
        cacheMap.put(cacheName + "cache.CacheImpl", new CacheImpl());
        return cacheMap.get(cacheName + "cache.CacheImpl");
    }

    public CacheImpl getCache(String cacheName) {
        return cacheMap.get(cacheName + "cache.CacheImpl");
    }
}
