package com.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * slf logger test 2018-09-24 17:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1() {
        logger.info("info...");
        logger.debug("debug...");
        logger.error("error...");
    }

    /**
     * 使用注解后的log
     */
    @Test
    public void test2() {
        log.info("log info...");
        log.debug("log debug...");
        log.error("log error...");
    }
}
