package com.ben.java.core.log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2022/10/30
 */
public class Log4jTest {
    @Test
    public void testLog4j01() {
        //开启Log4j 内置日志记录
        LogLog.setInternalDebugging(true);

//        1.初始化配置信息,在入门案例中暂不使用配置文件
//        BasicConfigurator.configure();
//        2.获取日志记录器对象
        Logger log = Logger.getLogger(Log4jTest.class);
//        3.日志输出
        log.info("hello log4j");

//        日志级别
        log.fatal("fatal");  //严重错误,一般会造成系统崩溃并终止运行

        log.error("error");
        log.warn("warn");
        log.info("info");
        log.debug("debug");

        log.trace("trace"); //追踪信息
    }
}
