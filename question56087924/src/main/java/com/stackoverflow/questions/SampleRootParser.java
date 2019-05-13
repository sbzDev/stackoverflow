package com.stackoverflow.questions;

import com.thoughtworks.xstream.XStream;

public class SampleRootParser {

    public Root parse(String xmlContent){
        XStream xstream = new XStream();
        xstream.processAnnotations(Root.class);
        return  (Root)xstream.fromXML(xmlContent);
    }
}
