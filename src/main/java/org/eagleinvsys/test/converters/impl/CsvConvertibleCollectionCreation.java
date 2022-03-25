package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.ConvertibleCollectionCreation;
import org.eagleinvsys.test.converters.validation.Validation;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvConvertibleCollectionCreation implements ConvertibleCollectionCreation {
    @Override
    public ConvertibleCollection create(List<Map<String, String>> collectionToConvert) {
        if (Validation.checkIfStandardCollectionToConvertIsEmpty(collectionToConvert)) {
            return new CsvCollection(Collections.emptyList());
        }
        return new CsvCollection(collectionToConvert.stream()
                .map(record -> new CsvDataItem(new HashMap<>(record)))
                .collect(Collectors.toList())
        );
    }
}
