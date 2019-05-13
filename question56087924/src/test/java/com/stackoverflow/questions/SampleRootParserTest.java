package com.stackoverflow.questions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SampleRootParserTest {

    private SampleRootParser testIntance = new SampleRootParser();

    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/sample.xml"})
    void parser(Path sampleXMLPath) throws IOException {
        String sampleXMLContent =  new String ( Files.readAllBytes(sampleXMLPath) );
        Root actual = testIntance.parse(sampleXMLContent);
        assertEquals(5, actual.listC.size());
    }
}