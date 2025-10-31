package com.example;

import java.util.HashMap;
import java.util.Map;

public class Category {
    private static Map<String, Category> cache = new HashMap<>();
    private String name;

    private Category(String name) {
        this.name = name;
    }

    public static Category of(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Category name can't be null");
        }
        String trimmed = name.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("Category name can't be blank");
        }
        String normalized = trimmed.substring(0,1).toUpperCase() + trimmed.substring(1).toLowerCase();
        if (cache.containsKey(normalized)) {
            return cache.get(normalized);
        } else {
            Category cat = new Category(normalized);
            cache.put(normalized, cat);
            return cat;
        }
    }

    public String getName() {
        return name;
    }
}
