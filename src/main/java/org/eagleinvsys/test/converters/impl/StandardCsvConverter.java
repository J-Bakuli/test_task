package org.eagleinvsys.test.converters.impl;

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

    private final CsvConverter csvConverter;
    private final CsvConvertibleCollectionCreation csvConvertibleCollectionCreation;

    public StandardCsvConverter(CsvConverter csvConverter, CsvConvertibleCollectionCreation csvConvertibleCollectionCreation) {
        this.csvConverter = csvConverter;
        this.csvConvertibleCollectionCreation = csvConvertibleCollectionCreation;
    }

    @Override
    public void convert(List<Map<String, String>> collectionToConvert, OutputStream outputStream) {
        CsvCollection csvCollection = csvConvertibleCollectionCreation.create(collectionToConvert);
        csvConverter.convert(csvCollection, outputStream);
/*        for (Map<String, String> map : collectionToConvert) {
          //  Set<String> keys = map.keySet();
            csvConvertibleCollectionCreation.create(collectionToConvert);*/
        // csvConverter.convertHeaders(keys, outputStream);

/*            List<String> values = new ArrayList<String>(map.values());
            Iterator<String> iterator = values.iterator();*/
        // csvConverter.convertMessage(iterator, outputStream);
    }
}
