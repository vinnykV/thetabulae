package com.tabula.drugs.utils.asserter;

import com.tabula.drugs.model.medicines.Medicine;

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

    public static void assertAdultDosesNotNull(Medicine medicine) {
        assertDosingAndUsingNotNull(medicine);
        if (medicine.getDosingAndUsing().getAdult() == null) {
            throw new RuntimeException("Cant get Adult doses. Because of null");
        }
    }

    public static void assertPediatricDosesNotNull(Medicine medicine) {
        assertDosingAndUsingNotNull(medicine);
        if (medicine.getDosingAndUsing().getPediatric() == null) {
            throw new RuntimeException("Cant get Pediatric doses. Because of null");
        }
    }

    public static void assertDosingAndUsingNotNull(Medicine medicine) {
        if (medicine == null || medicine.getDosingAndUsing() == null) {
            throw new RuntimeException("Dosing and using is null");
        }
    }
}
