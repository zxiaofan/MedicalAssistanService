package com.zxiaofan.MedicalAssistanService.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * 日志记录
 * 
 * @author xiaofan
 */
@Component("logging")
public class Logging {

    public static Log log = LogFactory.getLog(Logging.class);
}
