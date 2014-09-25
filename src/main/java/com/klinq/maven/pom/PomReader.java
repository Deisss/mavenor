package com.klinq.maven.pom;

import java.io.File;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * Convert element to POM.xml string
 * 
 * @author Deisss
 */
public class PomReader {
    private static Document parseDocument(File pom) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(pom);
        return document;
    }
    public static PomData read(File pom) {
        PomData data = new PomData();

        Document xml;
        try {
            xml = parseDocument(pom);
        } catch (DocumentException ex) {
            return null;
        }

        // Getting project data
        Node groupId = xml.selectSingleNode("/project/*[name()='groupId']");
        Node artifactId = xml.selectSingleNode("/project/*[name()='artifactId']");
        Node version = xml.selectSingleNode("/project/*[name()='version']");
        Node packaging = xml.selectSingleNode("/project/*[name()='packaging']");

        // Getting data
        try {
            data.setGroupId(groupId.getText());
        } catch(NullPointerException ex) {}
        try {
            data.setArtifactId(artifactId.getText());
        } catch(NullPointerException ex) {}
        try {
            data.setVersion(version.getText());
        } catch(NullPointerException ex) {}
        try {
            data.setPackaging(packaging.getText());
        } catch(NullPointerException ex) {}

        return data;
    }
}
