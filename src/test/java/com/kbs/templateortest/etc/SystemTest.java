package com.kbs.templateortest.etc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Enumeration;
import java.util.Properties;

public class SystemTest {

    @Test
    @DisplayName("system property 확인")
    void testSystemGetProperty() {

        System.out.println("[[[java.version = "         + System.getProperty("java.version"));
        System.out.println("[[[java.vendor = "          + System.getProperty("java.vendor"));
        System.out.println("[[[java.vendor.url = "      + System.getProperty("java.vendor.url"));
        System.out.println("[[[java.home = "            + System.getProperty("java.home"));
        System.out.println("[[[java.class.version = "   + System.getProperty("java.class.version"));
        System.out.println("[[[java.class.path = "      + System.getProperty("java.class.path"));
        System.out.println("[[[java.ext.dir = "         + System.getProperty("java.ext.dir"));
        System.out.println("[[[os.name = "              + System.getProperty("os.name"));
        System.out.println("[[[os.arch = "              + System.getProperty("os.arch"));
        System.out.println("[[[os.version = "           + System.getProperty("os.version"));
        System.out.println("[[[file.separator = "       + System.getProperty("file.separator"));
        System.out.println("[[[path.separator = "       + System.getProperty("path.separator"));
        System.out.println("[[[line.separator = "       + System.getProperty("line.separator"));
        System.out.println("[[[user.name = "            + System.getProperty("user.name"));
        System.out.println("[[[user.home = "            + System.getProperty("user.home"));
        System.out.println("[[[user.dir = "             + System.getProperty("user.dir"));
    }

    @Test
    @DisplayName("전체 Property 확인")
    void testAllProperties() {
        Properties props = System.getProperties();
        for(Enumeration<?> en = props.propertyNames(); en.hasMoreElements();) {
            String key = (String)en.nextElement();
            String value = props.getProperty(key);
            System.out.println("[[[" + key + " = " + value);
        }
    }
}
