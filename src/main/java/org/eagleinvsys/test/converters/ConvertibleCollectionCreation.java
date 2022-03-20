package org.eagleinvsys.test.converters;

import org.eagleinvsys.test.converters.impl.CsvCollection;

import java.util.List;
import java.util.Map;

public interface ConvertibleCollectionCreation {
    CsvCollection create(List<Map<String, String>> collectionToConvert);
}
