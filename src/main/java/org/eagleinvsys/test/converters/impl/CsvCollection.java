package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.ConvertibleMessage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class CsvCollection implements ConvertibleCollection {
    private final Collection<CsvDataItem> csvDataItems;

    public CsvCollection(Collection<CsvDataItem> csvDataItems) {
        this.csvDataItems = csvDataItems;
    }

    @Override
    public Collection<String> getHeaders() {
        return csvDataItems.stream()
                .findAny()
                .orElse(new CsvDataItem(new HashMap<>()))
                .getHeaders();
    }

    @Override
    public Iterable<ConvertibleMessage> getRecords() {
        return new ArrayList<>(csvDataItems);
    }
}
