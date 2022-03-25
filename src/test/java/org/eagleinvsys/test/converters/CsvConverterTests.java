package org.eagleinvsys.test.converters;

import org.eagleinvsys.test.converters.impl.CsvConverter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

class CsvConverterTests {
    private CsvConverter csvConverter;
    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    void setup() {
        csvConverter = new CsvConverter();
        ConvertibleCollection convertibleCollection = new ConvertibleCollection() {
            @Override
            public Collection<String> getHeaders() {
                return Collections.emptyList();
            }

            @Override
            public Iterable<ConvertibleMessage> getRecords() {
                return Collections.emptyList();
            }
        };
        byteArrayOutputStream = new ByteArrayOutputStream();
    }

    @AfterEach
    void end() throws IOException {
        byteArrayOutputStream.close();
    }

    @Test
    void test_converter_success() throws UnsupportedEncodingException {
        String expectedResult = "header1,header2\r\nbook1,book1\r\nbook2,book2\r\n";
        csvConverter.convert(getConvertibleCollection(), byteArrayOutputStream);

        Assertions.assertEquals(
                expectedResult,
                byteArrayOutputStream.toString(StandardCharsets.UTF_8.name()),
                "CsvConverter returns the wrong result");
    }

    @Test
    void test_converter_empty_collectionToConvert() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> csvConverter.convert(null, byteArrayOutputStream),
                "IllegalArgumentException is thrown due to null collectionToConvert");
    }

    @Test
    void test_converter_empty_output() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> csvConverter.convert(getConvertibleCollection(), null),
                "IllegalArgumentException is thrown due to null byteArrayOutputStream");
    }

    private ConvertibleCollection getConvertibleCollection() {
        return new ConvertibleCollection() {
            @Override
            public Collection<String> getHeaders() {
                return Arrays.asList("header1", "header2");
            }

            @Override
            public Iterable<ConvertibleMessage> getRecords() {
                return Arrays.asList(
                        elementId -> "book1",
                        elementId -> "book2"
                );
            }
        };
    }
}