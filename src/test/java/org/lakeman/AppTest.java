package org.lakeman;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    @Test
    void testGetTimestamp() throws Exception {
        String xmlString = "<aprs><timestamp>2023-01-05T12:34:56Z</timestamp></aprs>";
        MusherPositionParser parser;
            parser = new MusherPositionParser(xmlString);
        assertEquals("2023-01-05T12:34:56Z", parser.getTimestamp());
    }
}
