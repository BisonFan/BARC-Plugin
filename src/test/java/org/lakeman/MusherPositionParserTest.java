package org.lakeman;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for MusherPositionParser.
 */
class TestMusherPositionParser {

    @Test
    void testGetTimestamp() throws Exception {
        String xmlString = "<aprs><timestamp>2023-01-05T12:34:56Z</timestamp></aprs>";
        MusherPositionParser parser;
            parser = new MusherPositionParser(xmlString);
        assertEquals("2023-01-05T12:34:56Z", parser.getTimestamp());
    }

    @Test
    void testGetSource() throws Exception {
        String xmlString = "<aprs><source>VE7ABC</source></aprs>";
        MusherPositionParser parser = new MusherPositionParser(xmlString);
        assertEquals("VE7ABC", parser.getSource());
    }

    @Test
    void testGetPath() throws Exception {
        String xmlString = "<aprs><path>WIDE1-1,WIDE2-1</path></aprs>";
        MusherPositionParser parser = new MusherPositionParser(xmlString);
        assertEquals("WIDE1-1,WIDE2-1", parser.getPath());
    }

    @Test
    void testGetLatitude() throws Exception {
        String xmlString = "<aprs><latitude>49.2827</latitude></aprs>";
        MusherPositionParser parser = new MusherPositionParser(xmlString);
        assertEquals("49.2827", parser.getLatitude());
    }

    @Test
    void testGetLongitude() throws Exception {
        String xmlString = "<aprs><longitude>-123.1207</longitude></aprs>";
        MusherPositionParser parser = new MusherPositionParser(xmlString);
        assertEquals("-123.1207", parser.getLongitude());
    }

    @Test
    void testGetCourseSpeed() throws Exception {
        String xmlString = "<aprs><course_speed>180/50</course_speed></aprs>";
        MusherPositionParser parser = new MusherPositionParser(xmlString);
        assertEquals("180/50", parser.getCourseSpeed());
    }

}
