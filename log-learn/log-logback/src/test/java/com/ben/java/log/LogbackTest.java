package com.ben.java.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/12/10
 */
public class LogbackTest {
    private static final Logger log = LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void test(){
        log.info("打印日志,{}",log.toString());
    }
}
