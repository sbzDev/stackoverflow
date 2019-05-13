package com.stackoverflow.questions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HtmlParserTest {
    private HtmlParser testIntance = new HtmlParser();

    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/sample.html"})
    void shouldUnmarshal(Path sampleHTMLPath) throws Exception {
        String sampleHTMLContent =  new String ( Files.readAllBytes(sampleHTMLPath) );
        String actual = testIntance.parse(sampleHTMLContent);

        assertEquals("<div>\n" +
                " questions to improve formatting and clarity.\n" +
                "</div> \n" +
                "<h3>Guided Mode</h3> some sample raw/floating text", actual);
    }
}
