package com.company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // write your code here
        LOG.debug("test");
        LOG.error("error");
        LOG.info("info");
        LOG.trace("trace");
        LOG.warn("warn");
    }
}
