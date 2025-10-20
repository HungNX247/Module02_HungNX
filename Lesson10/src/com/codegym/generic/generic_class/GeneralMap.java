package com.codegym.generic.generic_class;

import java.util.HashMap;

public class GeneralMap<K, V> {

    void addIntoMap(HashMap map, K k, V v) {
        map.put(k, v);
    }

    String printMap(HashMap map) {
        return map.toString();
    }
}
