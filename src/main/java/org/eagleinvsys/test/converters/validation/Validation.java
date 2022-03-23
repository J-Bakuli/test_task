package org.eagleinvsys.test.converters.validation;

import org.eagleinvsys.test.converters.ConvertibleCollection;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class Validation {
    public static void checkIfConvertibleCollectionIsEmpty(ConvertibleCollection convertibleCollection) {
        if (convertibleCollection == null || convertibleCollection.getHeaders().isEmpty()) {
            throw new IllegalArgumentException("ConvertibleCollection should not be null");
        }
    }

    public static boolean checkIfStandardCollectionToConvertIsEmpty(List<Map<String, String>> standardCollectionToConvert) {
        if (standardCollectionToConvert == null || standardCollectionToConvert.isEmpty()) {
            throw new IllegalArgumentException("Collection to convert should not be null");
        }
        return false;
    }

    public static void checkIfStandardCollectionToConvertIsEmptyException(List<Map<String, String>> standardCollectionToConvert) {
        if (standardCollectionToConvert == null || standardCollectionToConvert.isEmpty()) {
            throw new IllegalArgumentException("Collection to convert should not be null");
        }
    }

    public static void checkOutputStream(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("OutputStream should not be null");
        }
    }

    public static void checkElementId(Map<String, String> map, String elementId) {
        if (!map.containsKey(elementId)) {
            throw new IllegalArgumentException("Map does not contain elementId:" + elementId);
        }
    }
}
