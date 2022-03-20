package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.ConvertibleMessage;
import org.eagleinvsys.test.converters.Validation.Validation;

import java.util.Collection;
import java.util.Map;

public class CsvDataItem implements ConvertibleMessage {
    private final Map<String, String> mapDataItem;

    public CsvDataItem(Map<String, String> mapDataItem) {
        this.mapDataItem = mapDataItem;
    }

    @Override
    public String getElement(String elementId) {
        Validation.checkElementId(mapDataItem, elementId);
        return mapDataItem.get(elementId);
    }

    Collection<String> getHeaders() {
        return mapDataItem.keySet();
    }
}
