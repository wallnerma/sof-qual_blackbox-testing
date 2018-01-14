package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends AbstractLoginTest {

    @Test
    public void testLoginUsername_valid() {

        boolean test = service.login("homer", "4upbmy83qy");
        Assert.assertTrue(test);

    }

}
