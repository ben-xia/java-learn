package com.ben.java.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/28
 */
public class Slf4jTest {
   private static final Logger log = LoggerFactory.getLogger(Slf4jTest.class);
    @Test
    public void test01(){
        log.info("hello slf4j info");
        log.error("hello slf4j error");
    }

}
