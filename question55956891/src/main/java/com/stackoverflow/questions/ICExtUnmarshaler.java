package com.stackoverflow.questions55956891;

import javax.xml.bind.JAXBContext;
import java.io.StringReader;

public class ICExtUnmarshaler {

    public ICExt unmarshal(String xmlContent) throws Exception {
        JAXBContext context = JAXBContext.newInstance(ICExt.class);
        return (ICExt) context.createUnmarshaller().unmarshal((new StringReader(xmlContent)));
    }
}
