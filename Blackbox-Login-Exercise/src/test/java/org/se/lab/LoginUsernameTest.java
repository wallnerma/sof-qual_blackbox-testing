package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LoginUsernameTest extends AbstractLoginTest {

    @Test
    public void testUsername() {

        Map<String, Object> testCases_username = new HashMap<String, Object>();

        testCases_username.put("aaaa", false);
        testCases_username.put("zzzz", false);
        testCases_username.put("aaaaaaaa", false);
        testCases_username.put("zzzzzzzz", false);

        testCases_username.put("aaa", new IllegalArgumentException());
        testCases_username.put("zzz", new IllegalArgumentException());
        testCases_username.put("aaaaaaaaa", new IllegalArgumentException());
        testCases_username.put("zzzzzzzzz", new IllegalArgumentException());
        testCases_username.put("`````", new IllegalArgumentException());
        testCases_username.put("{{{{{", new IllegalArgumentException());

        runTestWithMap_username(testCases_username);

    }

    void runTestWithMap_username(Map<String, Object> testCases) {

        for (String username : testCases.keySet()) {

            System.out.println("test value (username): " + username);

            try {
                boolean actual = service.login(username, "aaaaaaaaaa");

                if (testCases.get(username) instanceof IllegalArgumentException) {
                    Assert.fail();
                } else if (testCases.get(username) instanceof Boolean) {
                    Boolean expected = (Boolean) testCases.get(username);
                    Assert.assertEquals(expected.booleanValue(), actual);
                } else {
                    Assert.fail();
                }

            } catch (IllegalArgumentException e) {}
        }
    }

}
