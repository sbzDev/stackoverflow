package com.stackoverflow.questions;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "web-request-form")
public class WebRequestForm {

    public Attachments attachments;

    public static class Attachments {

        @JacksonXmlElementWrapper(useWrapping = false)
        public List<Attachment> attachment = new ArrayList<>();

    }

    public static class Attachment {

        @JacksonXmlProperty(localName = "filename")
        public String fileName;

        public String desc;

        public String size;

    }
}
