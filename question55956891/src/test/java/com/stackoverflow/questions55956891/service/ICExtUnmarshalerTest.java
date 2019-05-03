package com.stackoverflow.questions55956891.service;

import com.stackoverflow.questions55956891.model.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ICExtUnmarshalerTest {
    private SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");

    private ICExtUnmarshaler testIntance = new ICExtUnmarshaler();

    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/icext_sample1.xml"})
    void shouldUnmarshal(Path sampleXMLPath) throws Exception {
        String sampleXMLContent =  new String ( Files.readAllBytes(sampleXMLPath) );
        ICExt actual = testIntance.unmarshal(sampleXMLContent);
        ICExt expected = expectedICExt();
        assertEquals(expected, actual);
    }

    private ICExt expectedICExt() throws ParseException {
        return  ICExtBuilder
                .newInstance()
                    .aa()
                        .pa1("20067")
                        .pa2()
                            .ffgag()
                                .kicuc()
                                    .rCatName("testing1234")
                                    .params()
                                        .repCatId("265131")
                                        .reqId("7746318")
                                        .fName("Testing line")
                                        .endDate(sdf.parse("2010-01-01"))
                                        .lDataGroupId("")
                                        .acParamGroupId("")
                                    .emploee(
                                        EmployeeBuilder
                                            .newInstance()
                                                .emplRec()
                                                    .empId("1000")
                                                    .salary("20000")
                                            .build()
                                    )
                                    .emploee(
                                        EmployeeBuilder
                                                .newInstance()
                                                    .emplRec()
                                                        .empId("5600")
                                                        .salary("34000")
                                                .build()
                                    )
                .build();
    }
}
