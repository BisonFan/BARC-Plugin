package org.lakeman;

    import org.w3c.dom.Document;
    import org.w3c.dom.Element;
    import org.w3c.dom.NodeList;
    import javax.xml.parsers.DocumentBuilder;
    import javax.xml.parsers.DocumentBuilderFactory;
    import java.io.ByteArrayInputStream;

    public class MusherPositionParser {
        private final Document document;

        public MusherPositionParser(String xmlString) throws Exception {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            ByteArrayInputStream input = new ByteArrayInputStream(xmlString.getBytes());
            document = builder.parse(input);
        }

        public String getTimestamp() {
            Element timestampElement = (Element) document.getElementsByTagName("timestamp").item(0);
            return timestampElement.getTextContent();
        }

        public String getSource() {
            Element sourceElement = (Element) document.getElementsByTagName("source").item(0);
            return sourceElement.getTextContent();
        }

        public String getPath() {
            Element pathElement = (Element) document.getElementsByTagName("path").item(0);
            return pathElement.getTextContent();
        }

        public String getLatitude() {
            Element latitudeElement = (Element) document.getElementsByTagName("latitude").item(0);
            return latitudeElement.getTextContent();
        }

        public String getLongitude() {
            Element longitudeElement = (Element) document.getElementsByTagName("longitude").item(0);
            return longitudeElement.getTextContent();
        }

        public String getCourseSpeed() {
            Element courseSpeedElement = (Element) document.getElementsByTagName("course_speed").item(0);
            return courseSpeedElement.getTextContent();
        }

    }
