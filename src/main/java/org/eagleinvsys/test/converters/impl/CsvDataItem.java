package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.ConvertibleMessage;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvDataItem implements ConvertibleMessage {
    private final Map<String, String> mapDataItem;

    public CsvDataItem(Map<String, String> mapDataItem) {
        this.mapDataItem = mapDataItem;
    }

    @Override
    public String getElement(String elementId) {
        return mapDataItem.keySet().stream()
                .map(mapDataItem::get)
                .collect(Collectors.joining(" "));
    }

    Collection<String> getHeaders() {
        return Arrays.asList("header1", "header2");
    }
}
