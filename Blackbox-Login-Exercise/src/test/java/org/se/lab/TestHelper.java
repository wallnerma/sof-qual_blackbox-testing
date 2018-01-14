package org.se.lab;

public class TestHelper {

    private TestHelper() {}

    public static String buildLongString(char c, int factor) {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < factor; i++) {
            s.append(c);
        }

        return s.toString();
    }

}
