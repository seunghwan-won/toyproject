package com.company;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogback {
    public static final Logger logger = LoggerFactory.getLogger(TestLogback.class);

    @Test
    public void test() {
        logger.trace("trace");
    }

    @Test
    public void test2() {
        String str = "?hello world!";
        char[] arr = new char[str.length()];
        int a = 0;
        for (int i = str.toCharArray().length - 1; i >= 0; i--) {
            arr[a] = str.toCharArray()[i];
            a++;
        }
        logger.debug(new String(arr));
    }
}
