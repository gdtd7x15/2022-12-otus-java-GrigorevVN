package ru.grigorevvn.testClasses;

import ru.grigorevvn.annotations.After;
import ru.grigorevvn.annotations.Before;
import ru.grigorevvn.annotations.Test;

public class FirstTestClass {
    @Before
    public void before() {
    }
    @Test
    public void testOne() {
    }

    @Test
    public void testTwo() {
        throw new NullPointerException("failed method with NPE");
    }

    @Test
    public void testThree(){
        int oops = 1 / 0;
    }

    @After
    public void afterOne() {
        Integer.valueOf("I want to be an integer");
    }

    @After
    public void afterTwo() {
    }
}
