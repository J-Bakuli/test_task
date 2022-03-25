package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.Converter;
import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.StandardConverter;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class StandardCsvConverter implements StandardConverter {
    /**
     * Converts given {@link List<Map>} to CSV and outputs result as a text to the provided {@link OutputStream}
     *
     * @param collectionToConvert collection to convert to CSV format. All maps must have the same set of keys
     * @param outputStream        output stream to write CSV conversion result as text to
     */

    private final Converter converter;
    private final CsvConvertibleCollectionCreation csvConvertibleCollectionCreation;

    public StandardCsvConverter(Converter converter, CsvConvertibleCollectionCreation convertibleCollection) {
        this.converter = converter;
        this.csvConvertibleCollectionCreation = convertibleCollection;
    }

    @Override
    public void convert(List<Map<String, String>> collectionToConvert, OutputStream outputStream) {
        ConvertibleCollection convertibleCollection = csvConvertibleCollectionCreation.create(collectionToConvert);
        converter.convert(convertibleCollection, outputStream);
    }
}