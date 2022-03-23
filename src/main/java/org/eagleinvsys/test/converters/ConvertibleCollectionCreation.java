package org.eagleinvsys.test.converters;

import java.util.List;
import java.util.Map;

public interface ConvertibleCollectionCreation {
    ConvertibleCollection create(List<Map<String, String>> collectionToConvert);
}
