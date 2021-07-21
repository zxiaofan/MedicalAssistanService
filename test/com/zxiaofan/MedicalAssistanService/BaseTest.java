package com.zxiaofan.MedicalAssistanService;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

/**
 * @author yunhai
 */
@RunWith(SpringJUnit4ClassRunner.class)
/*
 * @TransactionConfiguration(transactionManager = "transactionManager")
 * 
 * @Transactional
 */
/**
 * ContextConfiguration spring引用的properties位置需要放在src下。 测试时需要将app-context*.xml中的测试配置文件打开： <value>classpath:com/XXX/config/test-jdbc.properties</value>
 * <value>classpath:com/XXX/config/test-log_config.properties</value> 关闭外部配置文件 <value>/WEB-INF/config/jdbc.properties</value> <value>/WEB-INF/config/log_config.properties</value>
 */
@ContextConfiguration("/com/zxiaofan/config/spring/app-context*.xml")
public class BaseTest {

    /**
     * 添加字段注释.
     */
    protected Logger logger = Logger.getLogger(BaseTest.class);

    static {
        try {
            Log4jConfigurer.initLogging("WebContent/WEB-INF/config/log4j2.properties");
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot Initialize log4j");
        }
    }

}
