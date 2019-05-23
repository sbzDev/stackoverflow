package com.stackoverflow.questions;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleCSVParserTest {

    private SampleCSVParser testInstance = new SampleCSVParser();

    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/sample.csv"})
    void shouldParse(Path sampleCSVPath) throws Exception {
        List<Map<String, String>> actualResult = testInstance.parse(sampleCSVPath);
        assertEquals(1, actualResult.size());

        Map<String, String> line = actualResult.get(0);
        assertEquals(7, line.size());

        assertEquals("", line.get("Col 1"));
        assertEquals("", line.get("Col 2"));
        assertEquals("Yes", line.get("Col 3"));
        assertEquals("D,E,F", line.get("Col 4"));
        assertEquals("12345", line.get("Col 5"));
        assertEquals("1", line.get("Col 6"));
        assertEquals("XYZ 20190523 10:46:00 PM", line.get("Col 80"));
    }
}
