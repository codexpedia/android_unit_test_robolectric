package com.example.unittest;


import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JUnitTest {
    @Test
    public void checkJUnitWork() {
        // We fail this test on purpose
        assertThat(true, is(false));
    }
}