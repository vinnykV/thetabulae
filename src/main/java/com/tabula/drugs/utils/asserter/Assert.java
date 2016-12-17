package com.tabula.drugs.utils.asserter;

import java.util.Map;

/**
 * @author Vladyslav_Vinnyk on 12/16/2016.
 */
public class Assert {
    private Assert() {
        throw new RuntimeException("Class not supposed to be instantiated");
    }

    public static void notNull(Object object) {
        if (object == null) {
            throw new RuntimeException("Assert failed, object is null");
        }
    }

    public static void assertMapContains(Object object, Map<? extends Object, ? extends Object> map) {
        if (!map.containsKey(object)) {
            throw new RuntimeException("Assertion failed, Map does not contains specified object " + object);
        }
    }
}
