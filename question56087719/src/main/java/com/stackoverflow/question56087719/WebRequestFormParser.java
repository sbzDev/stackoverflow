package com.stackoverflow.question56087719;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;

public class WebRequestFormParser {

    public WebRequestForm parse(String sampleXMLContent) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        WebRequestForm result = xmlMapper.readValue(sampleXMLContent, WebRequestForm.class);
        return result;
    }
}
