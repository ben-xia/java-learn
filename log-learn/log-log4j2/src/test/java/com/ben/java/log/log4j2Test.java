package com.ben.java.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/12/10
 */
public class log4j2Test {
    private static final Logger log = LogManager.getLogger(log4j2Test.class);

    @Test
    public void test01() {
        log.error("log4j2 日志");
    }
}
