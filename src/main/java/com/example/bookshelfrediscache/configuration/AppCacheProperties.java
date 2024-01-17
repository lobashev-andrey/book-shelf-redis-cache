package com.example.bookshelfrediscache.configuration;


import lombok.Data;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "app.cache")
public class AppCacheProperties {

    private String cacheType;
    private List<String> cacheNames = new ArrayList<>();
    private final Map<String, CacheProperties> caches = new HashMap<>();
    @Data
    public static class CacheProperties {
        private Duration lifeTime = Duration.ZERO;
    }

    public static enum CacheType {
        IN_MEMORY, REDIS
    }



}
