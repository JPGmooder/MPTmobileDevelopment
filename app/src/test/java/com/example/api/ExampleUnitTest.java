package com.example.api;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleUnitTest {
    @Test
    public void checkLogin_lengthSmall() {
        Checkers t = new Checkers();
        assertTrue(t.checkLogin("sm"));
    }

    @Test
    public void checkLogin_lengthNormal() {
        Checkers t = new Checkers();
        Assert.assertEquals(true,t.checkLogin("normal"));
    }

    @Test
    public void validateEmail_False() {
        Checkers t = new Checkers();
        Assert.assertEquals(true,t.validateEmail("notTrueEmail@lol"));
    }

    @Test
    public void validateEmail_True() {
        Checkers t = new Checkers();
        Assert.assertEquals(true,t.validateEmail("TrueEmail@lol.ru"));
    }

    @Test
    public void validatePassword_False() {
        Checkers t = new Checkers();
        Assert.assertEquals(true,t.checkPassword("password"));
    }

    @Test
    public void validatePassword_True() {
        Checkers t = new Checkers();
        Assert.assertEquals(true,t.checkPassword("P@ssw0rd"));
    }

    @Test
    public void chekAPI_true() {
        ApiClass t = new ApiClass();
        Assert.assertEquals(true,t.postData("https://cakeapi.trinitytuts.com/api/add", "login","email@mail.ru","P@$$W0rd"));
    }

    @Test
    public void chekAPI_false() {
        ApiClass t = new ApiClass();
        Assert.assertEquals(true,t.postData("https://check.ru", "login","email@mail.ru","P@$$W0rd"));
    }
}