package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.ConvertibleCollectionCreation;
import org.eagleinvsys.test.converters.Validation.Validation;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvDataItemCreation implements ConvertibleCollectionCreation {
    @Override
    public CsvCollection create(List<Map<String, String>> collectionToConvert) {
        if (Validation.checkIfCollectionToConvertIsEmpty(collectionToConvert)) {
            return new CsvCollection(Collections.emptyList());
        }
        return new CsvCollection(collectionToConvert.stream()
                .map(dataItem -> new CsvDataItem(new HashMap<>(dataItem)))
                .collect(Collectors.toList())
        );
    }
}
