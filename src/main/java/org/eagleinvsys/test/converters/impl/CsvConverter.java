package org.eagleinvsys.test.converters.impl;

import com.opencsv.CSVWriter;
import org.apache.commons.collections.IteratorUtils;
import org.eagleinvsys.test.converters.Converter;
import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.ConvertibleMessage;
import org.eagleinvsys.test.converters.validation.Validation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CsvConverter implements Converter {

    /**
     * Converts given {@link ConvertibleCollection} to CSV and outputs result as a text to the provided {@link OutputStream}
     *
     * @param collectionToConvert collection to convert to CSV format
     * @param outputStream        output stream to write CSV conversion result as text to
     */
    @Override
    public void convert(ConvertibleCollection collectionToConvert, OutputStream outputStream) {
        Validation.checkIfConvertibleCollectionIsEmpty(collectionToConvert);
        Validation.checkOutputStream(outputStream);

        Collection<String> headers = collectionToConvert.getHeaders();
        Iterator<ConvertibleMessage> iterator = collectionToConvert.getRecords().iterator();

/*      convertHeaders(headers, outputStream);
        convertMessage(iterator, outputStream);*/

        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
             CSVWriter csvWriter = new CSVWriter(bufferedWriter)) {
            csvWriter.writeNext(headers.toArray(new String[0]));
            List<?> lines = IteratorUtils.toList(iterator);
            while (iterator.hasNext()) {
                for (Object line : lines) {
                    String element = iterator.next().getElement(line.toString());
                    csvWriter.writeNext(new String[]{element});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*    private void convertHeaders(Collection<String> headers, OutputStream outputStream) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
             CSVWriter csvWriter = new CSVWriter(bufferedWriter)) {
            csvWriter.writeNext(headers.toArray(new String[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void convertMessage(Iterator<? extends ConvertibleMessage> iterator, OutputStream outputStream) {
        List<?> lines = IteratorUtils.toList(iterator);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
             CSVWriter csvWriter = new CSVWriter(bufferedWriter)) {
            while (iterator.hasNext()) {
                for (Object line : lines) {
                    if (iterator instanceof ConvertibleMessage) {
                        String element = iterator.next().getElement(line.toString());
                        csvWriter.writeNext(new String[]{element});
                    } else {
                        csvWriter.writeNext(new String[]{line.toString()});
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}