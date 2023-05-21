package ru.grigorevvn.testClasses;

import ru.grigorevvn.annotations.After;
import ru.grigorevvn.annotations.Before;
import ru.grigorevvn.annotations.Test;

import java.util.concurrent.TimeoutException;

public class SecondTestClass {
    @Before
    public void before() {
        throw new ClassCastException("all cats are animals but not all animals are cats");
    }

    @Test
    public void testOne() {
    }

    @Test
    public void testTwo() {
    }

    @Test
    public void testThree() throws TimeoutException {
        throw new TimeoutException("It's too long");
    }

    @After
    public void after() {
    }
}
