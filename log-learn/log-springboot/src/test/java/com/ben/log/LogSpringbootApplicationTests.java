package com.ben.log;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class LogSpringbootApplicationTests {
//	private static final Logger log = LoggerFactory.getLogger(LogSpringbootApplicationTests.class);

	@Test
	void contextLoads() {
	log.info("测试log-springboot项目启动");
	}

}
