package org.eagleinvsys.test.converters;

import org.eagleinvsys.test.converters.impl.CsvConverter;
import org.eagleinvsys.test.converters.impl.CsvConvertibleCollectionCreation;
import org.eagleinvsys.test.converters.impl.StandardCsvConverter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StandardCsvConverterTests {

    private StandardCsvConverter standardCsvConverter;
    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    void setup() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        Converter converter = new CsvConverter();
        CsvConvertibleCollectionCreation csvConvertibleCollectionCreation = new CsvConvertibleCollectionCreation();
        standardCsvConverter = new StandardCsvConverter(converter, csvConvertibleCollectionCreation);
    }

    @AfterEach
    void end() throws IOException {
        byteArrayOutputStream.close();
    }

    @Test
    void test_standardCsvConverter_success() throws UnsupportedEncodingException {
        String expectedResult = "header1,header2\r\nbook1 book2,book1 book2\r\nbook3 book4,book3 book4\r\n";
        standardCsvConverter.convert(getCollectionToConvert(), byteArrayOutputStream);

        Assertions.assertEquals(
                expectedResult,
                byteArrayOutputStream.toString("UTF-8"),
                ("StandardCsvConverter does not work properly")
        );
    }

    private List<Map<String, String>> getCollectionToConvert() {
        Map<String, String> testMap1 = new HashMap<String, String>() {{
            put("key1", "book1");
            put("key2", "book2");
        }};
        Map<String, String> testMap2 = new HashMap<String, String>() {{
            put("key1", "book3");
            put("key2", "book4");
        }};
        List<Map<String, String>> testCollectionToConvert = new ArrayList<>();
        testCollectionToConvert.add(testMap1);
        testCollectionToConvert.add(testMap2);
        return testCollectionToConvert;
    }
}