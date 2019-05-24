package com.stackoverflow.questions;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

class RssMergerTest {

    private RssMerger testIntance = new RssMerger();

    RssMergerTest() throws ParserConfigurationException {
    }

    @Test
    void shouldMerge() throws TransformerException, SAXException, IOException {
        String baseXml = "src/test/resources/blank.xml";

        String[] inputXmls = {"src/test/resources/input1.xml","src/test/resources/input2.xml"};

        String resultXml = "src/test/resources/Result.xml";

        testIntance.merge(baseXml, inputXmls, resultXml);
    }
}