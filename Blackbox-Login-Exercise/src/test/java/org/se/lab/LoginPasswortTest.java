package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LoginPasswortTest extends AbstractLoginTest {

    @Test
    public void testLoginPassword() {
        Map<String, Object> testCases_password = new HashMap<String, Object>();

        testCases_password.put(TestHelper.buildLongString('0', 10), false);
        testCases_password.put(TestHelper.buildLongString('9', 10), false);
        testCases_password.put(TestHelper.buildLongString('0', 100), false);
        testCases_password.put(TestHelper.buildLongString('9', 100), false);

        testCases_password.put(TestHelper.buildLongString('a', 10), false);
        testCases_password.put(TestHelper.buildLongString('z', 10), false);
        testCases_password.put(TestHelper.buildLongString('a', 100), false);
        testCases_password.put(TestHelper.buildLongString('z', 100), false);

        testCases_password.put(TestHelper.buildLongString('0', 9), new IllegalArgumentException());
        testCases_password.put(TestHelper.buildLongString('9', 9), new IllegalArgumentException());
        testCases_password.put(TestHelper.buildLongString('/', 10), new IllegalArgumentException());
        testCases_password.put(TestHelper.buildLongString(':', 10), new IllegalArgumentException());

        testCases_password.put(TestHelper.buildLongString('a', 9), new IllegalArgumentException());
        testCases_password.put(TestHelper.buildLongString('z', 9), new IllegalArgumentException());
        testCases_password.put(TestHelper.buildLongString('`', 10), new IllegalArgumentException());
        testCases_password.put(TestHelper.buildLongString('{', 10), new IllegalArgumentException());

        testCases_password.put(TestHelper.buildLongString('A', 10), new IllegalArgumentException());
        testCases_password.put(TestHelper.buildLongString('Z', 10), new IllegalArgumentException());

        runTestWithMap_password(testCases_password);
    }


    void runTestWithMap_password(Map<String, Object> testCases) {

        for (String password : testCases.keySet()) {
            System.out.println("test value (password): " + password);

            try {
                boolean actual = service.login("aaaa", password);

                if (testCases.get(password) instanceof IllegalArgumentException) {
                    Assert.fail();
                } else if (testCases.get(password) instanceof Boolean) {
                    Boolean expected = (Boolean) testCases.get(password);
                    Assert.assertEquals(expected.booleanValue(), actual);
                } else {
                    Assert.fail();
                }
            } catch (IllegalArgumentException e) { }
        }
    }

}
