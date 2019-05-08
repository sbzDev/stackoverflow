package com.stackoverflow.question56028130;


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
        assertEquals(3, actualResult.size());

        Map<String, String> line = actualResult.get(0);
        assertEquals(27, line.size());

        assertEquals("5703", line.get("id"));
        assertEquals("9e849f81-56c4-4415-b36e-b0fd370b3986", line.get("apptoolUUID"));
        assertEquals("3 Way ChProduct", line.get("accountName"));
        assertEquals("3 Way ChProduct - CHSH2112601DSHCL - Showroom", line.get("description"));
        assertEquals("ChProduct,ALL,SHOP-SPECIFIC", line.get("oemTagList"));
        assertEquals("{\"oemCode\":\"222923\"}", line.get("userCode"));

        assertEquals("false", line.get("clearLocalStorage"));
        assertEquals("2019-02-18 20:57:53", line.get("created_at"));
        assertEquals("[{\"id\":46,\"name\":\"AX_AGRP_SIRIUSXM_BAC_AXP_GROUP\",\"description\":\"Shops that can play the AX created\\/provided Sirius XM creative.\",\"numberOfPlayers\":4494},{\"id\":33,\"name\":\"AX_ZYX_CUSTOMER\",\"numberOfPlayers\":4532},{\"id\":11,\"name\":\"PST Update\",\"numberOfPlayers\":604},{\"id\":2,\"name\":\"Customer Players\",\"numberOfPlayers\":5711},{\"id\":41,\"name\":\"AX_AGRP_EXTRA_PRICING_PLAN_BAC_AXP_GROUP\",\"description\":\"AX auto-group Extra Pricing Plan  BAC Group\",\"numberOfPlayers\":2215},{\"id\":39,\"name\":\"AX_AGRP_MY_REWARDS_NATIONAL_GROUP\",\"description\":\"AX auto-group My Rewards (National) BAC List\",\"numberOfPlayers\":2130}]", line.get("pGroups"));
    }
}
