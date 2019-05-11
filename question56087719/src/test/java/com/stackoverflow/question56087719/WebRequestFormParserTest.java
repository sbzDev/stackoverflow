package com.stackoverflow.question56087719;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class WebRequestFormParserTest {
    private WebRequestFormParser testIntance = new WebRequestFormParser();

    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/sample.xml"})
    void shouldParse(Path sampleXMLPath) throws Exception {
        String sampleXMLContent =  new String ( Files.readAllBytes(sampleXMLPath) );
        WebRequestForm actual = testIntance.parse(sampleXMLContent);
        assertEquals(1, actual.attachments.attachment.size());
        WebRequestForm.Attachment attachment = actual.attachments.attachment.get(0);
        assertEquals("test", attachment.fileName);
        assertNull(attachment.desc);
        assertEquals("2089.801", attachment.size);
    }
}
