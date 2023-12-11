package com.ben.java.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * @author: ben.xia
 * @desc:  日志门面, 提供统一的API[目前已淘汰]
 * @date: 2023/5/28
 */
public class JCLTest {

    @Test
    public void test(){
        Log log = LogFactory.getLog(JCLTest.class);
        log.info("JCLTest-------------");
    }
}
